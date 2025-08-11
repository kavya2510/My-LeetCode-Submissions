class Solution {

    private static final int mod = (int)1e9 + 7;

    private int power(int a, int b) {
        long res = 1;
        long num = a;
        while (b > 0) {
            if (b % 2 != 0)
                res *= num;
            res %= mod;
            num *= num;
            num %= mod;
            b /= 2;
        }
        return (int)res;
    }

    private int inverse(int a) {
        return power(a, mod - 2);
    }

    private int multiply(int a, int b) {
        long ans = ((long)a * b) % mod;
        return (int)ans;
    }

    public int[] productQueries(int n, int[][] queries) {
        List<Integer> bits = new ArrayList<>();

        for (int pos = 0; pos < 32; pos++) {
            int bit = ((n >> pos) & 1);
            if (bit == 1)
                bits.add(1 << pos);
        }

        int[] nums = bits.stream().mapToInt(x -> (int)x).toArray();
        int k = nums.length;

        for (int i = 1; i < k; i++) {
            nums[i] = multiply(nums[i], nums[i - 1]);
        }

        int q = queries.length;
        int[] ans = new int[q];

        for (int i = 0; i < q; i++) {
            int l = queries[i][0];
            int r = queries[i][1];

            int prod = nums[r];
            if (l > 0) {
                int toDivide = nums[l - 1];
                prod = multiply(prod, inverse(toDivide));
            }

            ans[i] = prod;
        }

        return ans;
    }
}
