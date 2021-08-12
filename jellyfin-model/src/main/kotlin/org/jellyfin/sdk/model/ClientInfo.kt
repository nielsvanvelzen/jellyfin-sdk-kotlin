package org.jellyfin.sdk.model

import kotlin.js.JsExport

/**
 * The client information is used to identify the client.
 */
@JsExport
public data class ClientInfo(
	/**
	 * Name of the client, this should normally not change.
	 */
	val name: String,

	/**
	 * The version of the client.
	 */
	val version: String,
)
