class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        // 가능한 모든 조합을 반환하면 됨
        // 중복 허용 안함
        
        Arrays.sort(nums);
        HashSet<List<Integer>> groups = new HashSet<>();
        dfs(groups, nums, 0, new LinkedList<>());
        
        return new LinkedList<>(groups);
    }
    private static void dfs(HashSet<List<Integer>> groups ,int nums[], int start, List<Integer> list){
        
        groups.add(new LinkedList<>(list));
        for(int i = start; i<nums.length; i++){
            list.add(nums[i]);
            dfs(groups, nums, i + 1, list);
            list.remove(list.size() - 1);
        }
    }
}