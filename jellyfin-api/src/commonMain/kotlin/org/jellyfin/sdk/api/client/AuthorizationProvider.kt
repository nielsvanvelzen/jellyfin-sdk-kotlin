package org.jellyfin.sdk.api.client

import org.jellyfin.sdk.model.DeviceInfo
import org.jellyfin.sdk.model.UUID

public interface AuthorizationProvider {
	public suspend fun getAccessToken(): String?
	public suspend fun getUserId(): UUID?
	public suspend fun getDeviceInfo(): DeviceInfo
}

public class NoAuthorizationProvider(
	private val deviceInfo: DeviceInfo,
) : AuthorizationProvider {
	override suspend fun getAccessToken(): String? = null
	override suspend fun getUserId(): UUID? = null

	override suspend fun getDeviceInfo(): DeviceInfo = deviceInfo
}

public class MutableAuthorizationProvider(
	public var deviceInfo: DeviceInfo,
	public var accessToken: String? = null,
	public var userId: UUID? = null,
) : AuthorizationProvider {
	override suspend fun getAccessToken(): String? = accessToken
	override suspend fun getUserId(): UUID? = userId
	override suspend fun getDeviceInfo(): DeviceInfo = deviceInfo
}
