package `20`

import java.util.*

//20. Valid Parentheses

class Solution {
    fun isValid(s: String): Boolean {
        // Prefilter
        if (s.length % 2 != 0) return false
        // Payload
        val openStack = LinkedList<Char>()
        for (c in s) {
            when {
                isOpen(c) -> openStack.push(c)
                isClose(c) -> {
                    if (openStack.isEmpty()) return false
                    val lastOpen = openStack.pop()
                    if (!areSameType(lastOpen, c)) return false
                }
                else -> return false
            }
        }
        return openStack.isEmpty()
    }

    fun isOpen(c: Char): Boolean {
        return c == '(' || c == '{' || c == '['
    }

    fun isClose(c: Char): Boolean {
        return c == ')' || c == '}' || c == ']'
    }

    fun areSameType(left: Char, right: Char): Boolean {
        return (left == '(' && right == ')') ||
                (left == '{' && right == '}') ||
                (left == '[' && right == ']')
    }
}

class AnotherSolution() {
    val openClose: Map<Char, Char> = mapOf(
        '(' to ')',
        '[' to ']',
        '{' to '}'
    )

    fun isValid(s: String): Boolean {
        val openStack = Stack<Char>()
        for (c in s) {
            when {
                openClose.containsKey(c) -> openStack.push(c)
                openClose.containsValue(c) -> {
                    if (openStack.isEmpty()) return false
                    val lastOpen = openStack.pop()
                    if (openClose[lastOpen] != c) return false
                }
                else -> return false
            }
        }
        return openStack.isEmpty()
    }
}
