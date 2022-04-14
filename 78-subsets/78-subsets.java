class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        
        List<List<Integer>> ans = new LinkedList<>();
        Arrays.sort(nums);

        // LinkedList : 데이터의 추가,삭제에 유리하며, 검색은 ArrayList가 더 유리하다.
        
        backtrack(ans, new LinkedList<>(), nums, 0);
        
        return ans;
        
    }
    
    static void backtrack(List<List<Integer>> ans, List<Integer> temp, int[] nums, int start){
        ans.add(new LinkedList(temp));
        for(int i = start; i<nums.length; i++){
            temp.add(nums[i]);
            backtrack(ans, temp, nums, i + 1);
            temp.remove(temp.size() - 1);
        }
    }
}