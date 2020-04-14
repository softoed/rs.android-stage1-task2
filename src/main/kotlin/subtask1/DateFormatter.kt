package subtask1

import java.time.DateTimeException
import java.time.LocalDate

class DateFormatter {

    // TODO: Complete the following function
    fun toTextDay(day: String, month: String, year: String): String {

        var a = LocalDate.now()

        try {
            a = LocalDate.of(year.toInt(), month.toInt(), day.toInt())
        }
        catch (e: DateTimeException)
        {
            return "Такого дня не существует"
        }

        val months = arrayOf("января", "февраля", "марта", "апреля", "мая", "июня", "июля", "августа", "сентября", "октября", "ноября", "декабря")
        val daysOfW = arrayOf("понедельник", "вторник", "среда", "четверг", "пятница", "суббота", "воскресенье")

        return "$day ${months[month.toInt() - 1]}, ${daysOfW[a.dayOfWeek.value - 1]}"
    }
}
