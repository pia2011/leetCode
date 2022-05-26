class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        // target을 만드는 모든 조합을 List에 담아 반환
        List<List<Integer>> ansList = new LinkedList<>();
        dfs(ansList,candidates,target, 0, new LinkedList<>(), 0);
        
        return ansList;
    } 
    static void dfs(List<List<Integer>> ansList,int[] candidates,int target, int sum, List<Integer> tempList, int start){
        if(sum > target) return;
        if(sum == target){
            ansList.add(new LinkedList(tempList));
            return;
        }
        for(int i = start; i<candidates.length; i++){
            tempList.add(candidates[i]);
            dfs(ansList, candidates, target, sum + candidates[i], tempList, i);
            tempList.remove(tempList.size() - 1);
        }
        
    }
}