class Solution {
    public int countHillValley(int[] nums) {
        int leftVal=0;
        int rightVal=2;
        int currentVal=1;
        int n=nums.length;
        int count=0;
        while(rightVal<n) {
            if(rightVal<n && nums[currentVal]==nums[rightVal]) {
                rightVal++;
                continue;
            }
            if ((nums[currentVal]<nums[leftVal] && nums[currentVal]<nums[rightVal]) || (nums[currentVal]>nums[leftVal] && nums[currentVal]>nums[rightVal])) count++;
            leftVal=currentVal;
            currentVal=rightVal; 
        }
        return count;
    }
}