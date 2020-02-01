package com.example.hnandroid.utils

import com.skybase.humanizer.DateHumanizer
import org.threeten.bp.*
import org.threeten.bp.temporal.ChronoUnit
import kotlin.math.absoluteValue

fun hnFormatDate(date: String?): String {
    val year = date?.substring(0,4)?.trim()?.toInt()
    val month = date?.substring(5,7)?.trim()?.toInt()
    val day = date?.substring(8,10)?.trim()?.toInt()
    val hours = date?.substring(11,13)?.trim()?.toInt()
    val minutes = date?.substring(14,16)?.trim()?.toInt()
    val seconds = date?.substring(17, 19)?.trim()?.toInt()
    val textResult: String

    val dateTime = DateHumanizer.humanize(date, DateHumanizer.TYPE_PRETTY_EVERYTHING)

    val storyDate = LocalDateTime.of(year!!, Month.of(month!!), day!!, hours!!, minutes!!, seconds!!)
    val currentDate = LocalDateTime.now()
    textResult = if (dateTime == "Today") {
        diffBetweenTwoLocalDateTimesInHours(storyDate, currentDate)
    } else {
        dateTime
    }
    return textResult
}

fun diffBetweenTwoLocalDateTimesInHours(from: LocalDateTime, to: LocalDateTime): String {

    val tempDate = LocalDateTime.from(from)
    val minutes: Long = tempDate.until(to, ChronoUnit.MINUTES) % 60
    val hours: Long = tempDate.until(to, ChronoUnit.HOURS) % 24
    return if (minutes == 30L && hours > 0L) {
        "${hours.absoluteValue}.5h"
    } else if(hours < 1L) {
         "${minutes.absoluteValue}m"
     } else {
        "${hours.absoluteValue}h"
    }
}