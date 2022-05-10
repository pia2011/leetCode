class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        
        Set<Integer> hs = new HashSet<>();
        for(int i = 0; i<nums.length; i++){
            if(i > k) hs.remove(nums[i - k - 1]);
            if(!hs.add(nums[i])) return true; // 없으면 넣고 있으면 return true;
        }
        
        return false;
    }
}