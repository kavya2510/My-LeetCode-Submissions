class Solution {
    public int[] smallestSubarrays(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        
        int[] lastPos = new int[30];
        Arrays.fill(lastPos, -1);
        
        for (int i = n - 1; i >= 0; i--) {
            for (int bit = 0; bit < 30; bit++) {
                if ((nums[i] & (1 << bit)) != 0) {
                    lastPos[bit] = i;
                }
            }
            
            int maxReach = i;
            for (int bit = 0; bit < 30; bit++) {
                if (lastPos[bit] != -1) {
                    maxReach = Math.max(maxReach, lastPos[bit]);
                }
            }
            
            result[i] = maxReach - i + 1;
        }
        
        return result;

    }
}