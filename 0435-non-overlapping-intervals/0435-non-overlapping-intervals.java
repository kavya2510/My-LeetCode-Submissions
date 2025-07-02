class Solution {
    public static int comparator(int[] val1, int[] val2) {
        return Integer.compare(val1[1], val2[1]);
    }

    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, Solution::comparator);
        int n = intervals.length;
        int res = 1;
        int last = intervals[0][1];
        for (int i = 1; i < n; i++) {
            if (intervals[i][0] >= last) {
                res += 1;
                last = intervals[i][1];
            }
        }
        return n - res;
    }
}