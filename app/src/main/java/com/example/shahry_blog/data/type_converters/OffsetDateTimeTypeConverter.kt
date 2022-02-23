package com.example.shahry_blog.data.type_converters

import androidx.room.TypeConverter
import java.time.Instant
import java.time.LocalDateTime
import java.time.OffsetDateTime
import java.time.ZoneOffset
import java.time.format.DateTimeFormatter

object OffsetDateTimeTypeConverter {
    @TypeConverter
    @JvmStatic
    fun toOffsetDateTime(value: String?): OffsetDateTime? {
        return DateTimeFormatter.ISO_OFFSET_DATE_TIME.parse(value, OffsetDateTime::from)
    }

    @TypeConverter
    @JvmStatic
    fun toString(date: OffsetDateTime?): String? {
        return date?.format(DateTimeFormatter.ISO_OFFSET_DATE_TIME)

    }
}