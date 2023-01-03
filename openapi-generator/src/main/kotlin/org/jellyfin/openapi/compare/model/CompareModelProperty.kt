package org.jellyfin.openapi.compare.model

import kotlinx.serialization.Serializable
import org.jellyfin.openapi.model.DefaultValue

@Serializable
data class CompareModelProperty(
	val name: String,
	val nullable: Boolean,
	val defaultValue: DefaultValue?,

	val changes: Collection<CompareValueDiff> = emptyList(),
)
