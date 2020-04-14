package subtask2

class TimeConverter {

    // TODO: Complete the following function
    fun toTextFormat(hour: String, minute: String): String {
        val arrOfTime = arrayOf("one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten", "eleven", "twelve", "thirteen", "fourteen","fifteen",
                            "sixteen", "seventeen", "eighteen", "nineteen", "twenty")

        val min = minute.toInt()
        val hours = hour.toInt()

        val strForPast = "past ${arrOfTime[hours - 1]}"
        val strForTo = "to ${arrOfTime[hours]}"

        return when (min) {
            0 -> "${arrOfTime[hours - 1]} o' clock"
            1 -> "one minute $strForPast"
            15 -> "quarter $strForPast"
            30 -> "half $strForPast"
            in 2..29 -> "${"${if (min <= 20) arrOfTime[min - 1] else "twenty ${arrOfTime[(min - 1) % 10]}"} minutes $strForPast"}"
            45 -> "quarter $strForTo"
            in 31..59 -> "${"${if (60 - min <= 20) arrOfTime[60 - min - 1] else "twenty ${arrOfTime[(60 - min - 1) % 10]}"} minutes $strForTo"}"
            else -> ""
        }
    }
}
