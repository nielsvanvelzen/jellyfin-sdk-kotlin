package org.jellyfin.openapi.compare.reporter

import org.jellyfin.openapi.compare.model.CompareResult
import org.jellyfin.openapi.compare.model.CompareValueDiff
import kotlin.math.max

/**
 * @todo This reporter is incomplete
 */
class MarkdownCompareReporter : CompareReporter {
	override val name = "markdown"

	companion object {
		const val EMOJI_ADDED = "🆕"
		const val EMOJI_CHANGED = "⚠"
		const val EMOJI_REMOVED = "❌"
	}

	override fun format(result: CompareResult) = buildString {
		appendHeading("Difference")

		if (result.info.isNotEmpty()) {
			appendHeading("Document info", depth = 2)
			appendValueTable(result.info)
		}

		if (result.api.isChanged()) {
			appendHeading("Operations", depth = 2)

			if (result.api.added.isNotEmpty()) {
				appendList(result.api.added) { operation ->
					appendLine("$EMOJI_ADDED ${operation.name.escape()} `${operation.method} ${operation.path.escape()}`")
				}
			}

			if (result.api.modified.isNotEmpty()) {
				appendHeading("Changed", depth = 3)
				appendList(result.api.modified) { operation ->
					appendLine("$EMOJI_CHANGED ${operation.name.escape()} `${operation.method} ${operation.path.escape()}`")
					appendLine()
					appendTable(
						listOf("key", "before", "after"),
						operation.changes.map { listOf(it.name, it.from, it.to) }
					)
					appendLine("TODO: Add parameters".italic())
				}
			}

			if (result.api.removed.isNotEmpty()) {
				appendList(result.api.removed) { operation ->
					appendLine("$EMOJI_REMOVED ${operation.name.escape()} `${operation.method} ${operation.path.escape()}`")
				}
			}
		}

		if (result.model.isChanged()) {
			appendHeading("Models", depth = 2)

			if (result.model.added.isNotEmpty()) {
				appendList(result.model.added) { model ->
					appendLine("$EMOJI_ADDED ${model.name.escape().bold()}")

					if (!model.description.isNullOrEmpty()) {
						appendLine()
						append(model.description.orEmpty().escape())
					}
				}
			}

			if (result.model.modified.isNotEmpty()) {
				appendList(result.model.modified) { model ->
					appendLine("$EMOJI_CHANGED ${model.name.escape().bold()}")
					appendLine()
					if (model.changes.isNotEmpty()) {
						appendTable(
							listOf("key", "before", "after"),
							model.changes.map { listOf(it.name, it.from, it.to) }
						)
					}

					// Constants
					val constantChanges = mutableListOf<String>()
					constantChanges += model.constants.added.map { constant -> "$EMOJI_ADDED ${constant.name}" }
					constantChanges += model.constants.removed.map { constant -> "$EMOJI_REMOVED ${constant.name}" }
					appendList(constantChanges) { appendLine(it) }

					// Constants
					val propertyChanges = mutableListOf<String>()
					propertyChanges += model.properties.added.map { property -> "$EMOJI_ADDED ${property.name}" }
					propertyChanges += model.properties.modified.map { property ->
						buildString {
							appendLine("$EMOJI_CHANGED ${property.name}")
							appendLine()
							appendValueTable(property.changes)
						}
					}
					propertyChanges += model.properties.removed.map { property -> "$EMOJI_REMOVED ${property.name}" }
					appendList(propertyChanges) { appendLine(it) }
				}
			}

			if (result.model.removed.isNotEmpty()) {
				appendList(result.model.removed) { model ->
					appendLine("$EMOJI_REMOVED ${model.name.escape()}")
					if (!model.description.isNullOrEmpty()) {
						appendLine()
						append(model.description.orEmpty().escape())
					}
				}
			}
		}
	}

	private fun StringBuilder.appendHeading(text: String, depth: Int = 1) {
		append("#".repeat(depth))
		append(" ")
		append(text.escape())
		appendLine()
		appendLine()
	}

	private fun StringBuilder.appendValueTable(values: Iterable<CompareValueDiff>) {
		appendTable(
			columns = listOf("Value", "Before", "After"),
			data = values.map { value -> listOf(value.name.escape(), value.from.escape(), value.to.escape()) }
		)
	}

	private fun StringBuilder.appendTable(columns: List<String>, data: List<List<String>>) {
		val columnWidths = MutableList(columns.size) { columns[it].length }
		for (row in data) {
			for (column in row.indices) {
				columnWidths[column] =
					max(columnWidths[column], row[column].length)
			}
		}

		appendTableLine(columns, columnWidths)
		appendTableLine(List(columns.size) { "" }, columnWidths, padding = '-')
		for (row in data) appendTableLine(row, columnWidths)
		appendLine()
	}

	private fun StringBuilder.appendTableLine(columns: List<String>, columnWidths: List<Int>, padding: Char = ' ') {
		require(columns.size == columnWidths.size)

		append("|")
		for (column in columns.indices) {
			val width = columnWidths[column]
			val text = columns[column]
			append(padding)
			append(text)
			append(padding.toString().repeat(width - text.length))
			append(padding)
			append("|")
		}
		appendLine()
	}

	private fun <T> StringBuilder.appendList(items: Collection<T>, map: StringBuilder.(T) -> Unit) {
		for (item in items) {
			append("- ")
			val content = StringBuilder().apply { map(item) }.toString().prependIndent("  ").trim()
			append(content)
			// Multi-line items should have an additional new line
			if (content.lines().size > 1) appendLine()
			appendLine()
		}
		appendLine()
	}

	private fun String.escape(): String =
		replace(Regex("[\\\\`*_{}\\[\\]<>()#+-\\.!\\|@]")) { "\\${it.groups[0]!!.value}" }
			.replace(Regex("\\r\\n|\\r|\\n"), "<br/>")

	private fun String.bold(): String = "**${trim()}**"
	private fun String.italic(): String = "_${trim()}_"
}
