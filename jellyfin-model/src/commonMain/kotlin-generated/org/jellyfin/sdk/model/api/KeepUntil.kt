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

@Serializable
public enum class KeepUntil(
	public val serialName: String,
) {
	@SerialName("UntilDeleted")
	UNTIL_DELETED("UntilDeleted"),
	@SerialName("UntilSpaceNeeded")
	UNTIL_SPACE_NEEDED("UntilSpaceNeeded"),
	@SerialName("UntilWatched")
	UNTIL_WATCHED("UntilWatched"),
	@SerialName("UntilDate")
	UNTIL_DATE("UntilDate"),
	;

	/**
	 * Get the serial name of the enum member.
	 */
	override fun toString(): String = serialName

	public companion object {
		/**
		 * Find the enum member by the serial name or return null.
		 */
		public fun fromNameOrNull(serialName: String): KeepUntil? = when (serialName) {
			"UntilDeleted" -> UNTIL_DELETED
			"UntilSpaceNeeded" -> UNTIL_SPACE_NEEDED
			"UntilWatched" -> UNTIL_WATCHED
			"UntilDate" -> UNTIL_DATE
			else -> null
		}

		/**
		 * Find the enum member by the serial name or throw.
		 */
		public fun fromName(serialName: String): KeepUntil = requireNotNull(fromNameOrNull(serialName)) { """Unknown value $serialName""" }
	}
}
