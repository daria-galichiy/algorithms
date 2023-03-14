package `202`

// 202. Happy Number

class Solution {
    fun isHappy(n: Int): Boolean {
        val prevs = HashSet<Int>()
        var curr = n; var next = -1
        while(!prevs.contains(curr)) {
            next = getNext(curr)
            prevs.add(curr)
            curr = next
        }
        return next == 1
    }

    fun getNext(n: Int): Int {
        var remaining = n; var digit = 0
        var next = 0
        while (remaining > 0) {
            digit = remaining % 10
            next += digit * digit
            remaining /= 10
        }
        return next
    }
}
