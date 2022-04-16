class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        // 3개의 합이 0을 이루는 조합을 뱉어내자. 중복 경우는 제외
        HashSet<List<Integer>> ans = new HashSet<>();
        Arrays.sort(nums);
 
        // 0 0 0 0 0 0 | 0 0
        for(int i = 0; i<nums.length - 2; i++){
            // idx
            int j = i + 1;
            int k = nums.length - 1;
            while(j < k){
                int sum = nums[i] + nums[j] + nums[k];
                if(sum == 0) ans.add(Arrays.asList(nums[i], nums[j++], nums[k--]));
                else if(sum < 0) j++;
                else if(sum > 0) k--;
            }
        }
        
        return new ArrayList<>(ans);
    }
}