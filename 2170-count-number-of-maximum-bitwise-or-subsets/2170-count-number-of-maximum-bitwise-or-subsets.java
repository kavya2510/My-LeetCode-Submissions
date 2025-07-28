class Solution {
    private int solve(int[] nums, int curOr, int maxOr, int i) {
        if(curOr == maxOr)
            return 1 << (nums.length - i);
        if(i >= nums.length)
            return curOr == maxOr ? 1 : 0;

        return solve(nums, curOr, maxOr, i+1) +    // skip
            solve(nums, curOr | nums[i], maxOr, i+1);  // take
    }
    public int countMaxOrSubsets(int[] nums) {
        int maxOr = 0;
        for(int x : nums) maxOr |= x;
        return solve(nums, 0, maxOr, 0);
    }
}