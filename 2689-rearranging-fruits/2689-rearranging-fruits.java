public class Solution 
{
    public long minCost(int[] basket1, int[] basket2) 
    {
        int n = basket1.length;
        HashMap<Integer, Integer> count = new HashMap<>();
        int globalMin = Integer.MAX_VALUE;

        for (int x : basket1) 
        {
            count.merge(x, 1, Integer::sum);
            globalMin = Math.min(globalMin, x);
        }

        for (int x : basket2) 
        {
            count.merge(x, -1, Integer::sum);
            globalMin = Math.min(globalMin, x);
        }

        long total = 0;

        for (int v : count.values()) 
        {
            if ((v & 1) != 0)
            {
                return -1; 
            } 
            total += Math.abs(v);
        }

       int m = (int)(total / 2);
        int[] im = new int[m];
        int idx = 0;
        for (Map.Entry<Integer, Integer> e : count.entrySet()) 
        {
            int num = e.getKey();
            int v = e.getValue() / 2;
            for (int i = 0; i < Math.abs(v); i++) 
            {
                im[idx++] = num;
            }
        }

        Arrays.sort(im);

        long ans = 0;
        long doubleMin = 2L * globalMin;
        for (int i = 0; i < m / 2; i++) 
        {
            ans += Math.min(im[i], doubleMin);
        }

        return ans;
    }
}