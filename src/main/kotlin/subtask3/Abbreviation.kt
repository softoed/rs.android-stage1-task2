package subtask3

class Abbreviation {

    // TODO: Complete the following function
    fun abbreviationFromA(a: String, b: String): String {
        val strForTry = a.toUpperCase()
        var intForSameLet = 0

        var start = 0
        for (item in strForTry) {
            if (b[start].equals(item)) {
                intForSameLet++
                start++
            }

            if (intForSameLet == b.length) return "YES"
        }

        return "NO"
    }
}
