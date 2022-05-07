class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        HashSet<List<Integer>> ansList = new HashSet<>();
        Arrays.sort(nums);
        backTracking(ansList, nums, 0, new LinkedList<>());
        
        return new LinkedList(ansList);
    }
    private static void backTracking(HashSet<List<Integer>> ansList, int nums[], int start, List<Integer> list){
        
        ansList.add(new LinkedList(list));
        
        for(int i = start; i<nums.length; i++){
            list.add(nums[i]);
            backTracking(ansList, nums, i + 1, list);
            list.remove(list.size() - 1);
        }
        
    }
}