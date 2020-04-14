package subtask6

class Fibonacci {

    // TODO: Complete the following function
    fun productFibonacciSequenceFor(n: Int): IntArray {
        var res = 0
        var a = 0
        var b = 1
        for (i in 1..n) {
            if (a * b == n)
                return intArrayOf(a, b, 1)
            else if (a * b > n)
                return intArrayOf(a, b, 0)
            else {
                var c = a
                a = b
                b += c
            }
        }

        return intArrayOf(1,1,1)
    }
}
