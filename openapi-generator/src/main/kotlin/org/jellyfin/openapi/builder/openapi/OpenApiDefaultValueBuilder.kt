package org.jellyfin.openapi.builder.openapi

import com.squareup.kotlinpoet.ClassName
import io.swagger.v3.oas.models.media.ComposedSchema
import io.swagger.v3.oas.models.media.Schema
import net.pearx.kasechange.CaseFormat
import net.pearx.kasechange.toScreamingSnakeCase
import org.jellyfin.openapi.OpenApiGeneratorError
import org.jellyfin.openapi.builder.ContextBuilder
import org.jellyfin.openapi.constants.Packages
import org.jellyfin.openapi.model.DefaultValue
import org.jellyfin.openapi.model.GeneratorContext

@Suppress("TooManyFunctions")
class OpenApiDefaultValueBuilder : ContextBuilder<Schema<Any>, DefaultValue?> {
	override fun build(context: GeneratorContext, data: Schema<Any>): DefaultValue? {
		val reference = getSchemaReference(data)?.let(context::getSchema)
		val schemaDefault = data.default

		return when {
			!reference?.enum.isNullOrEmpty() -> getDefaultEnumMember(context, data)
			schemaDefault is String -> DefaultValue.String(schemaDefault)
			schemaDefault is Int -> DefaultValue.Int(schemaDefault)
			schemaDefault is Boolean -> DefaultValue.Boolean(schemaDefault)
			schemaDefault == null -> null
			else -> throw OpenApiGeneratorError("""Unsupported default value "$schemaDefault".""")
		}
	}

	private fun getDefaultEnumMember(context: GeneratorContext, schema: Schema<Any>): DefaultValue.EnumMember? {
		val schemaDefault = schema.default as? String
			?: "Unknown".takeIf { schema.nullable != true }
			?: return null

		if (schema.enum.isNullOrEmpty()) return null
		if (schema.enum.none { it.toString().equals(schemaDefault, ignoreCase = true) }) return null

		return DefaultValue.EnumMember(
			enumType = ClassName(Packages.MODEL, getSchemaReference(schema)!!.let(context::getSchema)!!.name),
			memberName = schemaDefault.toScreamingSnakeCase(from = CaseFormat.CAPITALIZED_CAMEL),
			serialName = schemaDefault,
		)
	}

	private fun getSchemaReference(schema: Schema<Any>): String? = when {
		schema is ComposedSchema -> when {
			// Limited support for anyOf / allOf containing a single item
			schema.anyOf?.size == 1 -> getSchemaReference(schema.anyOf.first())
			schema.allOf?.size == 1 -> getSchemaReference(schema.allOf.first())
			else -> throw OpenApiTypeBuilder.UnknownTypeError(schema.type, schema.format)
		}

		schema.`$ref` != null -> schema.`$ref`

		else -> null
	}
}
