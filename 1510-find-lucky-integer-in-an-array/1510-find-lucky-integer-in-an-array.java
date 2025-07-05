class Solution {
    public int findLucky(int[] arr) {
        HashMap<Integer,Integer> mpp = new HashMap<>();
        for(int n: arr){
            mpp.put(n, mpp.getOrDefault(n,0)+1);
        }
        List<Integer> res = new ArrayList<>();
        for(HashMap.Entry<Integer, Integer> entry: mpp.entrySet()){
            if(entry.getValue()==entry.getKey()){
                res.add(entry.getKey());
            }
        }
        if(res.size()==0){
            return -1;
        }
        return res.get(res.size()-1);
    }
}