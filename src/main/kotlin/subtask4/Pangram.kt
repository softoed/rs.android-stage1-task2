package subtask4

import jdk.nashorn.internal.runtime.regexp.joni.EncodingHelper.toUpperCase

class Pangram {

    // TODO: Complete the following function
    fun getResult(inputString: String): String {
        if (inputString.trim().isEmpty()) {
            return ""
        }
        val a = inputString.toLowerCase().toSortedSet().toCharArray()
        var b = ""
        for (item in a) {
            if (item.isLetter()) {
                b += item
            }
        }

        val noVow: (Char) -> Boolean = { it in "BCDFGHJKLMNPQRSTVWXZbcdfghjklmnpqrstvwxz"}

        var res = ""
        val mas = arrayOfNulls<String>(10)
        val vow: (Char) -> Boolean = { it in "aeiouy" }
        val seq = inputString.splitToSequence(" ", ignoreCase = true)

        for (item in seq) {
            val kol = if (b.length == 26) {
                item.count(vow)
            } else {
                item.count(noVow)
            }

            val newItem = "$kol$item "
            if (mas[kol].isNullOrEmpty()) {
                mas[kol] = newItem
            } else mas[kol] += newItem

        }

        for (item in mas) {
            if (item.isNullOrEmpty()) {
                continue
            }
            else {
                for (cha in item) {
                    res += when (b.length) {
                        26 -> {
                            if (cha in "aeiouy") cha.toUpperCase()
                            else cha
                        }
                        else -> {
                            if (cha !in "AEIOUYaeiouy") cha.toUpperCase()
                            else cha
                        }
                    }

                }

            }
        }

        res = res.replace("\n","").replace("0 ", "").trim()

        return res
    }
}
