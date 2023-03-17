package `141`

// 141. Linked List Cycle

/**
 * Example:
 * var li = ListNode(5)
 * var v = li.`val`
 * Definition for singly-linked list.*/
class ListNode(var `val`: Int) {
    var next: ListNode? = null
}


class BetterSolution {
    fun hasCycle(head: ListNode?): Boolean {
        if (head == null) return false
        var slow: ListNode? = head
        var fast: ListNode? = head
        while (fast?.next != null) {
            slow = slow?.next
            fast = fast?.next?.next
            if (slow == fast) return true
        }
        return false
    }
}

class Solution {
    fun hasCycle(head: ListNode?): Boolean {
        if (head == null) return false
        val passed = HashSet<ListNode>()
        var next = head
        while (next != null) {
            if (passed.contains(next)) return true
            passed.add(next)
            next = next.next
        }
        return false
    }
}
