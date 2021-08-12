package org.jellyfin.sdk.model.serializer

import kotlinx.serialization.KSerializer
import kotlinx.serialization.descriptors.PrimitiveKind
import kotlinx.serialization.descriptors.PrimitiveSerialDescriptor
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder
import org.jellyfin.sdk.model.DateTime
import kotlin.js.Date

public actual class DateTimeSerializer : KSerializer<DateTime> {
	actual override val descriptor: SerialDescriptor = PrimitiveSerialDescriptor("Date", PrimitiveKind.STRING)

	actual override fun deserialize(decoder: Decoder): DateTime = Date(decoder.decodeString())

	actual override fun serialize(encoder: Encoder, value: DateTime): Unit =
		encoder.encodeString(value.toISOString())
}
