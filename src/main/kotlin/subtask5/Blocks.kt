package subtask5

import java.time.LocalDate
import java.util.*
import kotlin.reflect.KClass
import java.time.format.DateTimeFormatter


class Blocks {

    // TODO: Complete the following function
    fun getData(blockA: Array<Any>, blockB: KClass<*>): Any {
        if (blockB == String::class) {
            var res = ""
            for (item in blockA) {
                if (item::class == blockB) {
                    res += item
                }
            }
            return res
        } else if (blockB == Int::class) {
            var res = 0
            for (item in blockA) {
                if (item::class == blockB) {
                    res += item.toString().toInt()
                }
            }

            return res
        } else {
            var resu = LocalDate.of(1,1,1)
            val locale = Locale("ru", "RU")
            val formatter = DateTimeFormatter.ofPattern("d.MM.yyyy", locale)
            for (item in blockA) {
                if (item::class == blockB) {

                    if (resu < LocalDate.parse(item.toString())) {
                        resu = LocalDate.parse(item.toString())
                    }
                }
            }
            return LocalDate.parse(resu.toString()).format(formatter)
        }

        return "hello"
    }
}
