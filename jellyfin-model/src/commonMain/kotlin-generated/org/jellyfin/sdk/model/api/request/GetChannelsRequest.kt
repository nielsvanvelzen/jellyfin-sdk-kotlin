// !!        WARNING
// !! DO NOT EDIT THIS FILE
//
// This file is generated by the openapi-generator module and is not meant for manual changes.
// Please read the README.md file in the openapi-generator module for additional information.
@file:UseSerializers(UUIDSerializer::class)

package org.jellyfin.sdk.model.api.request

import kotlin.Boolean
import kotlin.Int
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.UseSerializers
import org.jellyfin.sdk.model.UUID
import org.jellyfin.sdk.model.serializer.UUIDSerializer

/**
 * Available channels.
 */
@Serializable
public data class GetChannelsRequest(
	/**
	 * User Id to filter by. Use System.Guid.Empty to not filter by user.
	 */
	@SerialName("userId")
	public val userId: UUID? = null,
	/**
	 * Optional. The record index to start at. All items with a lower index will be dropped from the results.
	 */
	@SerialName("startIndex")
	public val startIndex: Int? = null,
	/**
	 * Optional. The maximum number of records to return.
	 */
	@SerialName("limit")
	public val limit: Int? = null,
	/**
	 * Optional. Filter by channels that support getting latest items.
	 */
	@SerialName("supportsLatestItems")
	public val supportsLatestItems: Boolean? = null,
	/**
	 * Optional. Filter by channels that support media deletion.
	 */
	@SerialName("supportsMediaDeletion")
	public val supportsMediaDeletion: Boolean? = null,
	/**
	 * Optional. Filter by channels that are favorite.
	 */
	@SerialName("isFavorite")
	public val isFavorite: Boolean? = null,
)
