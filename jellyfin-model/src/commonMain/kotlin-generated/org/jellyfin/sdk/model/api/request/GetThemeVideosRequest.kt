// !!        WARNING
// !! DO NOT EDIT THIS FILE
//
// This file is generated by the openapi-generator module and is not meant for manual changes.
// Please read the README.md file in the openapi-generator module for additional information.
@file:UseSerializers(UUIDSerializer::class)

package org.jellyfin.sdk.model.api.request

import kotlin.Boolean
import kotlin.collections.Collection
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.UseSerializers
import org.jellyfin.sdk.model.UUID
import org.jellyfin.sdk.model.api.ItemSortBy
import org.jellyfin.sdk.model.api.SortOrder
import org.jellyfin.sdk.model.serializer.UUIDSerializer

/**
 * Get theme videos for an item.
 */
@Serializable
public data class GetThemeVideosRequest(
	/**
	 * The item id.
	 */
	@SerialName("itemId")
	public val itemId: UUID,
	/**
	 * Optional. Filter by user id, and attach user data.
	 */
	@SerialName("userId")
	public val userId: UUID? = null,
	/**
	 * Optional. Determines whether or not parent items should be searched for theme media.
	 */
	@SerialName("inheritFromParent")
	public val inheritFromParent: Boolean? = false,
	/**
	 * Optional. Specify one or more sort orders, comma delimited. Options: Album, AlbumArtist, Artist, Budget, CommunityRating, CriticRating, DateCreated, DatePlayed, PlayCount, PremiereDate, ProductionYear, SortName, Random, Revenue, Runtime.
	 */
	@SerialName("sortBy")
	public val sortBy: Collection<ItemSortBy>? = null,
	/**
	 * Optional. Sort Order - Ascending, Descending.
	 */
	@SerialName("sortOrder")
	public val sortOrder: Collection<SortOrder>? = null,
)
