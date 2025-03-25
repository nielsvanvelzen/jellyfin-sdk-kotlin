// !!        WARNING
// !! DO NOT EDIT THIS FILE
//
// This file is generated by the openapi-generator module and is not meant for manual changes.
// Please read the README.md file in the openapi-generator module for additional information.
package org.jellyfin.sdk.api.operations

import kotlin.Any
import kotlin.Deprecated
import kotlin.String
import kotlin.Unit
import kotlin.collections.List
import kotlin.collections.buildMap
import kotlin.collections.emptyMap
import org.jellyfin.sdk.api.client.ApiClient
import org.jellyfin.sdk.api.client.Response
import org.jellyfin.sdk.api.client.extensions.`get`
import org.jellyfin.sdk.api.client.extensions.post
import org.jellyfin.sdk.model.api.EndPointInfo
import org.jellyfin.sdk.model.api.LogFile
import org.jellyfin.sdk.model.api.PublicSystemInfo
import org.jellyfin.sdk.model.api.SystemInfo
import org.jellyfin.sdk.model.api.WakeOnLanInfo

public class SystemApi(
	private val api: ApiClient,
) : Api {
	/**
	 * Gets information about the request endpoint.
	 */
	public suspend fun getEndpointInfo(): Response<EndPointInfo> {
		val pathParameters = emptyMap<String, Any?>()
		val queryParameters = emptyMap<String, Any?>()
		val data = null
		val response = api.`get`<EndPointInfo>("/System/Endpoint", pathParameters, queryParameters, data)
		return response
	}

	/**
	 * Gets a log file.
	 *
	 * @param name The name of the log file to get.
	 */
	public suspend fun getLogFile(name: String): Response<String> {
		val pathParameters = emptyMap<String, Any?>()
		val queryParameters = buildMap<String, Any?>(1) {
			put("name", name)
		}
		val data = null
		val response = api.`get`<String>("/System/Logs/Log", pathParameters, queryParameters, data)
		return response
	}

	/**
	 * Pings the system.
	 */
	public suspend fun getPingSystem(): Response<String> {
		val pathParameters = emptyMap<String, Any?>()
		val queryParameters = emptyMap<String, Any?>()
		val data = null
		val response = api.`get`<String>("/System/Ping", pathParameters, queryParameters, data)
		return response
	}

	/**
	 * Gets public information about the server.
	 */
	public suspend fun getPublicSystemInfo(): Response<PublicSystemInfo> {
		val pathParameters = emptyMap<String, Any?>()
		val queryParameters = emptyMap<String, Any?>()
		val data = null
		val response = api.`get`<PublicSystemInfo>("/System/Info/Public", pathParameters, queryParameters, data)
		return response
	}

	/**
	 * Gets a list of available server log files.
	 */
	public suspend fun getServerLogs(): Response<List<LogFile>> {
		val pathParameters = emptyMap<String, Any?>()
		val queryParameters = emptyMap<String, Any?>()
		val data = null
		val response = api.`get`<List<LogFile>>("/System/Logs", pathParameters, queryParameters, data)
		return response
	}

	/**
	 * Gets information about the server.
	 */
	public suspend fun getSystemInfo(): Response<SystemInfo> {
		val pathParameters = emptyMap<String, Any?>()
		val queryParameters = emptyMap<String, Any?>()
		val data = null
		val response = api.`get`<SystemInfo>("/System/Info", pathParameters, queryParameters, data)
		return response
	}

	/**
	 * Gets wake on lan information.
	 */
	@Deprecated("This member is deprecated and may be removed in the future")
	public suspend fun getWakeOnLanInfo(): Response<List<WakeOnLanInfo>> {
		val pathParameters = emptyMap<String, Any?>()
		val queryParameters = emptyMap<String, Any?>()
		val data = null
		val response = api.`get`<List<WakeOnLanInfo>>("/System/WakeOnLanInfo", pathParameters, queryParameters, data)
		return response
	}

	/**
	 * Pings the system.
	 */
	public suspend fun postPingSystem(): Response<String> {
		val pathParameters = emptyMap<String, Any?>()
		val queryParameters = emptyMap<String, Any?>()
		val data = null
		val response = api.post<String>("/System/Ping", pathParameters, queryParameters, data)
		return response
	}

	/**
	 * Restarts the application.
	 */
	public suspend fun restartApplication(): Response<Unit> {
		val pathParameters = emptyMap<String, Any?>()
		val queryParameters = emptyMap<String, Any?>()
		val data = null
		val response = api.post<Unit>("/System/Restart", pathParameters, queryParameters, data)
		return response
	}

	/**
	 * Shuts down the application.
	 */
	public suspend fun shutdownApplication(): Response<Unit> {
		val pathParameters = emptyMap<String, Any?>()
		val queryParameters = emptyMap<String, Any?>()
		val data = null
		val response = api.post<Unit>("/System/Shutdown", pathParameters, queryParameters, data)
		return response
	}
}
