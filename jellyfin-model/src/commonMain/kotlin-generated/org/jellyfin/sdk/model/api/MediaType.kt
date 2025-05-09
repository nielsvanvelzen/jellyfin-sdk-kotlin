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
 * Media types.
 */
@Serializable
public enum class MediaType(
	public val serialName: String,
) {
	@SerialName("Unknown")
	UNKNOWN("Unknown"),
	@SerialName("Video")
	VIDEO("Video"),
	@SerialName("Audio")
	AUDIO("Audio"),
	@SerialName("Photo")
	PHOTO("Photo"),
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
		public fun fromNameOrNull(serialName: String): MediaType? = when (serialName) {
			"Unknown" -> UNKNOWN
			"Video" -> VIDEO
			"Audio" -> AUDIO
			"Photo" -> PHOTO
			"Book" -> BOOK
			else -> null
		}

		/**
		 * Find the enum member by the serial name or throw.
		 */
		public fun fromName(serialName: String): MediaType = requireNotNull(fromNameOrNull(serialName)) { """Unknown value $serialName""" }
	}
}
