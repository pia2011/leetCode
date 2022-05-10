class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        // 정렬 사용 불가
        
        HashMap<Integer, List<Integer>> hm = new HashMap<>();
        for(int i = 0; i<nums.length; i++){
            hm.putIfAbsent(nums[i], new LinkedList<>());
            hm.get(nums[i]).add(i);
        }
        
        for(int num : hm.keySet()){
            List<Integer> list = hm.get(num);
            Collections.sort(list);
            for(int i = 1; i<list.size(); i++){
                int dist = list.get(i) - list.get(i - 1);
                if(dist <= k) return true;
            }
        }
        
        return false;
    }
}