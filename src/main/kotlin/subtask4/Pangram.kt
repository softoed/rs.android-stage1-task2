package subtask4

import jdk.nashorn.internal.runtime.regexp.joni.EncodingHelper.toUpperCase

class Pangram {

    // TODO: Complete the following function
    fun getResult(inputString: String): String {
        val a = inputString.toLowerCase().toSortedSet().toCharArray()
        var b = String(a)
        var res = ""



            val seq = inputString.splitToSequence(" ", ignoreCase = true)

            val vov : (Char) -> Boolean = {it in "aeiouy"}
            for (item in seq) {
                var kol = item.count(vov)
                res += kol.toString() + item.replace("a", "A").replace("e", "E").replace("i", "I").replace("o", "O").replace("u", "U").replace("y", "Y") + " "

            }


        return res
    }
}
