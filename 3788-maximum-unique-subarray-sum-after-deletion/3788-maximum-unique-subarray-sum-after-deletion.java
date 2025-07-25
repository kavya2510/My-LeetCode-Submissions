class Solution {
    public int maxSum(int[] nums) {
        int sum = 0;
        HashSet<Integer> set = new HashSet<>();
        int minsum = Integer.MIN_VALUE;

        for(int i = 0 ; i < nums.length ; i++){
            if(nums[i] <= 0){
                minsum = Math.max(minsum , nums[i]);
                continue;
            }
            if(set.contains(nums[i])){
                continue;
            }
            else{
                sum += nums[i];
                set.add(nums[i]);
            }
        }
        
        return sum == 0 ? minsum : sum;
    }
}