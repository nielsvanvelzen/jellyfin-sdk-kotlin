// !!        WARNING
// !! DO NOT EDIT THIS FILE
//
// This file is generated by the openapi-generator module and is not meant for manual changes.
// Please read the README.md file in the openapi-generator module for additional information.
package org.jellyfin.sdk.model.api

import kotlin.String
import kotlin.requireNotNull
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * The specific media type of an MediaBrowser.Model.Providers.ExternalIdInfo.
 */
@Serializable
public enum class ExternalIdMediaType(
	public val serialName: String,
) {
	@SerialName("Album")
	ALBUM("Album"),
	@SerialName("AlbumArtist")
	ALBUM_ARTIST("AlbumArtist"),
	@SerialName("Artist")
	ARTIST("Artist"),
	@SerialName("BoxSet")
	BOX_SET("BoxSet"),
	@SerialName("Episode")
	EPISODE("Episode"),
	@SerialName("Movie")
	MOVIE("Movie"),
	@SerialName("OtherArtist")
	OTHER_ARTIST("OtherArtist"),
	@SerialName("Person")
	PERSON("Person"),
	@SerialName("ReleaseGroup")
	RELEASE_GROUP("ReleaseGroup"),
	@SerialName("Season")
	SEASON("Season"),
	@SerialName("Series")
	SERIES("Series"),
	@SerialName("Track")
	TRACK("Track"),
	@SerialName("Book")
	BOOK("Book"),
	;

	/**
	 * Get the serial name of the enum member.
	 */
	override fun toString(): String = serialName

	public companion object {
		/**
		 * Find the enum member by the serial name or return null.
		 */
		public fun fromNameOrNull(serialName: String): ExternalIdMediaType? = when (serialName) {
			"Album" -> ALBUM
			"AlbumArtist" -> ALBUM_ARTIST
			"Artist" -> ARTIST
			"BoxSet" -> BOX_SET
			"Episode" -> EPISODE
			"Movie" -> MOVIE
			"OtherArtist" -> OTHER_ARTIST
			"Person" -> PERSON
			"ReleaseGroup" -> RELEASE_GROUP
			"Season" -> SEASON
			"Series" -> SERIES
			"Track" -> TRACK
			"Book" -> BOOK
			else -> null
		}

		/**
		 * Find the enum member by the serial name or throw.
		 */
		public fun fromName(serialName: String): ExternalIdMediaType = requireNotNull(fromNameOrNull(serialName)) { """Unknown value $serialName""" }
	}
}
