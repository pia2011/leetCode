class Solution {
    public List<List<Integer>> permute(int[] nums) {
        // 배열을 가능한 모든 순서로 조합해서 반환 - distinct로 주어져 있음
        List<List<Integer>> ansList = new LinkedList<>();
        dfs(ansList, new LinkedList<>(), new boolean[nums.length], nums);   
        
        return ansList;
    }
    private static void dfs(List<List<Integer>> ansList, List<Integer> tempList, boolean checked[], int nums[]){
               
        if(tempList.size() == nums.length){
            ansList.add(new LinkedList(tempList));
            return;
        }
        
        for(int i = 0; i<nums.length; i++){
            if(checked[i]) continue;
            checked[i] = true;
            tempList.add(nums[i]);
            dfs(ansList, tempList, checked, nums);
            tempList.remove(tempList.size() - 1);
            checked[i] = false;
        }
    }
}