class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        
        Arrays.sort(nums);
        HashSet<List<Integer>> ans = new HashSet<>(); // 중복 경우 제외 
        
        for(int i = 0; i<nums.length - 2; i++){
            int left = i + 1;
            int right = nums.length - 1;
            while(left < right){
                int sum = nums[i] + nums[left] + nums[right];
                if(sum == 0) ans.add(Arrays.asList(nums[i], nums[left++], nums[right--]));
                else if(sum < 0) left++;
                else if(sum > 0) right--;
            }
        }

        return new ArrayList<>(ans);
    }
}