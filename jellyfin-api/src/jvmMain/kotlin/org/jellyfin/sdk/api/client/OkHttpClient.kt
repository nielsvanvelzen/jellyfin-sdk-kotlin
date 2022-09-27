package org.jellyfin.sdk.api.client

import io.ktor.utils.io.ByteReadChannel
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody.Companion.toRequestBody
import org.jellyfin.sdk.api.client.exception.InvalidStatusException
import org.jellyfin.sdk.api.client.util.ApiSerializer
import org.jellyfin.sdk.api.client.util.AuthorizationHeaderBuilder
import org.jellyfin.sdk.api.sockets.SocketConnectionFactory
import org.jellyfin.sdk.api.sockets.SocketInstance
import org.jellyfin.sdk.model.ClientInfo
import org.jellyfin.sdk.model.DeviceInfo
import org.jellyfin.sdk.model.UUID
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine
import kotlin.time.Duration.Companion.milliseconds
import kotlin.time.toJavaDuration

@Suppress("LongParameterList")
public class OkHttpClient(
	override var baseUrl: String?,
	override var accessToken: String?,
	override var userId: UUID?,
	override var clientInfo: ClientInfo,
	override var deviceInfo: DeviceInfo,
	override val httpClientOptions: HttpClientOptions,
	private val socketConnectionFactory: SocketConnectionFactory,
) : ApiClient() {
	private val client by lazy {
		OkHttpClient.Builder()
			.followRedirects(httpClientOptions.followRedirects)
			.connectTimeout(httpClientOptions.connectTimeout.milliseconds.toJavaDuration())
			.callTimeout(httpClientOptions.requestTimeout.milliseconds.toJavaDuration())
			.readTimeout(httpClientOptions.socketTimeout.milliseconds.toJavaDuration())
			.writeTimeout(httpClientOptions.socketTimeout.milliseconds.toJavaDuration())
			.build()
	}

	@Suppress("ThrowsCount")
	override suspend fun request(
		method: HttpMethod,
		pathTemplate: String,
		pathParameters: Map<String, Any?>,
		queryParameters: Map<String, Any?>,
		requestBody: Any?,
	): RawResponse {
		val url = createUrl(pathTemplate, pathParameters, queryParameters)
		val body = when (requestBody) {
			// String content
			is String -> requestBody.toRequestBody("text/plain".toMediaType())
			// Binary content
			is ByteArray -> requestBody.toRequestBody("application/octet-stream".toMediaType())
			// Json content
			else -> ApiSerializer.encodeRequestBody(requestBody)?.toRequestBody("application/json".toMediaType())
		}

		val request = Request.Builder()
			.method(method.name, body)
			.url(url)
			.header("Authorization", AuthorizationHeaderBuilder.buildHeader(
				clientName = clientInfo.name,
				clientVersion = clientInfo.version,
				deviceId = deviceInfo.id,
				deviceName = deviceInfo.name,
				accessToken = accessToken
			))
			.build()

		val response = suspendCoroutine { continuation ->
			val response = client.newCall(request).execute()
			continuation.resume(response)
		}
		if (!response.isSuccessful) throw InvalidStatusException(response.code)

		return RawResponse(ByteReadChannel(response.body!!.bytes()), response.code, response.headers.toMultimap())
	}

	override fun ws(): SocketInstance = SocketInstance(this, socketConnectionFactory)
}
