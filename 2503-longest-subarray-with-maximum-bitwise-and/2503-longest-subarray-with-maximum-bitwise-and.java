class Solution {
    public int longestSubarray(int[] nums) {
        int max_val = -1;
        for(int i =0;i<nums.length;i++){
            max_val = Math.max(max_val, nums[i]);
        }
        int count = 1;
        int max_count = 1;
        for(int i=1;i<nums.length;i++){
            if(nums[i]>=max_val && nums[i-1]==nums[i]){
                count++;
            }
            else{
                count = 1;
            }
            max_count = Math.max(count, max_count);
        }
        return max_count;
    }
}