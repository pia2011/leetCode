class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        
        // target을 만들기 위한 조합(순서 상관 없음)
        
        List<List<Integer>> ansList = new LinkedList<>();
        
        backTracking(candidates, target, ansList,0,0, new boolean[candidates.length], new LinkedList<>());
        
        return ansList; 
        
    }
    
    static void backTracking(int[] candidates,int target,List<List<Integer>> ansList,int start, int sum, boolean visited[], LinkedList<Integer> list){
        
        if(sum > target) return;
        if(sum == target) {
            ansList.add(new LinkedList<>(list));
            return;
        }
        
        
        for(int i = start; i<candidates.length; i++){


            list.add(candidates[i]);
            backTracking(candidates, target, ansList, i,sum + candidates[i], visited, list);
            list.remove(list.size() - 1);
        }
    }
}