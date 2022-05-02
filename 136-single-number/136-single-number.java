class Solution {
    public int singleNumber(int[] nums) {
        // 유일한 것을 찾아라
        HashMap<Integer, Integer> hm = new HashMap<>();
        for(int x : nums){
            hm.compute(x, (k,v) -> v == null ? 1 : ++v);
        }
        
        int ans = 0;
        for(int key : hm.keySet()){
            if(hm.get(key) == 1){
                ans = key;
                break;
            }
                
        }
        
        return ans;
    }
}