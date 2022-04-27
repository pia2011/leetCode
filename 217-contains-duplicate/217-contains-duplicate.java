class Solution {
    public boolean containsDuplicate(int[] nums) {
        // 중복이 있으면 true  없으면 false
        HashSet<Integer> hs = new HashSet<>();
        for(int x : nums){
            if(hs.contains(x)) return true;
            hs.add(x);
        }
        return false;
    }
}