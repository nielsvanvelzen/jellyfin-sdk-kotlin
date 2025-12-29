package org.jellyfin.openapi.model

data class StringLengthValidation(
	val min: Int?,
	val max: Int?,
) : ParameterValidation
