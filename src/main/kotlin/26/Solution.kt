package `26`

class Solution {
    fun removeDuplicates(nums: IntArray): Int {
        var j = 0
        for (i in nums.indices) {
            if (nums[i] != nums[j]) nums[++j] = nums[i]
        }
        return ++j
    }
}
