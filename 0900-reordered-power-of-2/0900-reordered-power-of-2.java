class Solution {
    
    private String sortHelper(int x) {
        char[] arr = String.valueOf(x).toCharArray();
        Arrays.sort(arr);
        return new String(arr);
    }
    
    public boolean reorderedPowerOf2(int n) {
        String res = sortHelper(n);
        for (int i = 0; i < 31; i++) {
            if (sortHelper(1 << i).equals(res)) return true;
        }
        return false;
    }
}