class Solution {
    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        int[] hash = new int[baskets.length];
        int count =0;
        for(int i=0;i<fruits.length;i++){
            for(int j=0;j<baskets.length;j++){
                if(baskets[j]>=fruits[i] && hash[j]==0){
                    hash[j]=1;
                    count+=1;
                    break;
                }
            }
        }
        return baskets.length-count;
    }
}