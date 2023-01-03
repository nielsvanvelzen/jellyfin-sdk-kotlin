package org.jellyfin.openapi.compare.model

import kotlinx.serialization.Serializable
import org.jellyfin.openapi.model.HttpMethod

@Serializable
data class CompareOperation(
	val name: String,
	val method: HttpMethod,
	val path: String,
	val pathParameters: CompareCollectionDiff<CompareOperationParameter>,
	val queryParameters: CompareCollectionDiff<CompareOperationParameter>,

	val changes: Collection<CompareValueDiff>,
)
