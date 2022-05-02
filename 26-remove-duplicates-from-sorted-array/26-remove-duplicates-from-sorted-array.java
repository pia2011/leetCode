class Solution {
    public int removeDuplicates(int[] nums) {
        // 유일한 값으로 오름차순
        
        int ans = 0;
               
        HashSet<Integer> hs = new HashSet<>();
        LinkedList<Integer> list = new LinkedList<>(); 
        for(int x : nums){
            if(!hs.contains(x)){
                ans++;
                list.add(x);
                hs.add(x);
            }
        }

        Collections.sort(list);

        for(int i = 0; i<ans; i++){
            nums[i] = list.get(i);
        }
        
        return ans;
    }
}