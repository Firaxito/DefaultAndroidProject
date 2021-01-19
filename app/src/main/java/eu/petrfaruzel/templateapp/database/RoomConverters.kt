package eu.petrfaruzel.templateapp.database

import androidx.room.TypeConverter
import eu.petrfaruzel.templateapp.utils.ThemeManager
import eu.petrfaruzel.templateapp.utils.fromJson
import eu.petrfaruzel.templateapp.utils.toJson
import org.threeten.bp.LocalDate
import org.threeten.bp.LocalDateTime
import org.threeten.bp.LocalTime

class RoomConverters {

    // Enum example
    @TypeConverter
    fun toPriorityType(value: String) = if (value == "null") null else enumValueOf<ThemeManager.Theme>(value)
    @TypeConverter
    fun fromPriorityType(value: ThemeManager.Theme?) = value?.name

    // List Example
    @TypeConverter
    fun fromIntList(value : List<Int>?) = toJson(value)
    @TypeConverter
    fun toIntList(value: String) = if (value == "null") null else fromJson<List<Int>>(value)

    // LocalDateTime
    @TypeConverter
    fun datetimeToString(localDateTime : LocalDateTime?): String = localDateTime.toString()
    @TypeConverter
    fun stringToDatetime(stringDateTime : String): LocalDateTime? = if (stringDateTime == "null") null else  LocalDateTime.parse(stringDateTime)

    // LocalDate
    @TypeConverter
    fun dateToString(localDate : LocalDate?): String = localDate.toString()
    @TypeConverter
    fun stringToDate(stringDate : String): LocalDate? = if (stringDate == "null") null else  LocalDate.parse(stringDate)

    // LocalTime
    @TypeConverter
    fun timeToString(localTime: LocalTime?): String = localTime.toString()
    @TypeConverter
    fun stringToTime(localTimeString : String): LocalTime? = if (localTimeString == "null") null else  LocalTime.parse(localTimeString)



}