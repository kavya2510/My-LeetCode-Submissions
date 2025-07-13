class Solution {
    public int gettime(int[] arr,int n){
        int timetaken =0;
        for(int i=0;i<arr.length;i++){
            timetaken+=Math.ceil((double)arr[i]/(double)n);
        }
        return timetaken;
    }
    public int minEatingSpeed(int[] piles, int h) {
        int maximum = -1;
        for(int i=0;i<piles.length;i++){
            if(piles[i]>=maximum){
                maximum = piles[i];
            }
        }
        int low = 1, high = maximum;
        while(low<=high){
            int mid =(low+high)/2;
            int ans = gettime(piles,mid);
            if(ans<=h){
                high = mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return low;
    }
}