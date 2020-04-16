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

        var res = ""
        val mas = arrayOfNulls<String>(10)
        if (b.length == 26) {
            val seq = inputString.trim().splitToSequence(" ", ignoreCase = true)

            val vov: (Char) -> Boolean = { it in "aeiouy" }
            for (item in seq) {
                val kol = item.count(vov)
                val newItem = "$kol$item "
                if (mas[kol].isNullOrEmpty()) {
                    mas[kol] = newItem
                } else mas[kol] += newItem

            }
        }
        else {
            val seq = inputString.splitToSequence(" ", ignoreCase = true)

            val vov: (Char) -> Boolean = { it in "BCDFGHJKLMNPQRSTVWXZbcdfghjklmnpqrstvwxz"}
            for (item in seq) {
                val kol = item.count(vov)
                val newItem = "$kol$item "
                if (mas[kol].isNullOrEmpty()) {
                    mas[kol] = newItem
                } else mas[kol] += newItem

            }
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
