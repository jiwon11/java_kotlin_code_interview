package init.algorithm.stringManipulation

class ReverseString {
    fun reverseString(s: CharArray): Unit {
        var start = 0
        var end = s.size -1

        while (start <= end) {
            s[start] = s[end].also { s[end] = s[start] }
            /*
                also 함수를 이용하면 속성의 변경없이 중괄호 내 명령이 실행
                ex)
                val numbers = mutableListOf(1,2,3)
                numbers
                        .add(4)
                        .also { println("$it")}
                ---------------------
                [1,2,3]
             */

            start++
            end--
        }
    }
}