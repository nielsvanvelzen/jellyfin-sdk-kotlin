package org.jellyfin.sdk.api.ktor

import org.jellyfin.sdk.api.client.ApiClient
import org.jellyfin.sdk.api.client.AuthorizationProvider
import org.jellyfin.sdk.api.client.HttpClientOptions
import org.jellyfin.sdk.api.client.HttpMethod
import org.jellyfin.sdk.api.client.RawResponse
import org.jellyfin.sdk.api.sockets.SocketConnectionFactory
import org.jellyfin.sdk.api.sockets.SocketInstance
import org.jellyfin.sdk.model.ClientInfo
import org.jellyfin.sdk.model.DeviceInfo
import org.jellyfin.sdk.model.UUID

@Suppress("LongParameterList")
public expect open class KtorClient(
	baseUrl: String? = null,
	clientInfo: ClientInfo,
	authorizationProvider: AuthorizationProvider,
	httpClientOptions: HttpClientOptions,
	socketConnectionFactory: SocketConnectionFactory,
) : ApiClient {
	public override suspend fun request(
		method: HttpMethod,
		pathTemplate: String,
		pathParameters: Map<String, Any?>,
		queryParameters: Map<String, Any?>,
		requestBody: Any?,
	): RawResponse

	public override fun ws(): SocketInstance
}
