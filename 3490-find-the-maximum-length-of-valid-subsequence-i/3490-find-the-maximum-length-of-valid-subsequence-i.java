class Solution {
    public int maximumLength(int[] nums) {
        int n = nums.length;
        int oddCount = nums[0] % 2 == 1 ? 1 : 0;
        int evenCount = nums[0] % 2 == 0 ? 1 : 0;
        int alternateCount = 1;
        boolean expectingEven = (nums[0] % 2 == 1) ? true : false;

        //    true: expecting EVEN as next number in sequence
        //    false: expecting ODD as next number in sequence

        for (int i = 1; i < n; ++i) {
            if ((expectingEven == true && nums[i] % 2 == 0) || (expectingEven == false && nums[i] % 2 == 1)) {
                alternateCount++;
                expectingEven = !expectingEven;
            }

            if (nums[i] % 2 == 1) {
                oddCount++;
            } else {
                evenCount++;
            }
        }
        return Math.max(Math.max(evenCount, oddCount), alternateCount);
    }
}