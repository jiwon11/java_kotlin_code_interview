package init.algorithm.stringManipulation

class MostCommonWord {
    fun mostCommonWord(s: String, banned: Array<String>): String {

        val counts: MutableMap<String, Int> = mutableMapOf();

        val words = s.replace("\\W+", " ").lowercase().trim().split(" ")

        for(w in words) {
            if(banned.contains(w)) {
                counts[w] = counts.getOrDefault(w, 0) + 1
            }
        }
        return counts.maxBy { it.value }!!.key
    }
}