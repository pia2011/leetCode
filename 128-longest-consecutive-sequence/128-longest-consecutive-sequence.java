class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0) return 0;
        
        int ans = 1;
        
        Arrays.sort(nums);
        int temp = 1;
        int prev = nums[0];
        
        for(int i = 1; i<nums.length; i++){
            if(nums[i] == prev + 1){
                ans = Math.max(ans, ++temp);
            }else if(nums[i] != prev){
                temp = 1;        
            }
            prev = nums[i];
            System.out.println(prev);
            
        }
        
        
        return ans;
    }
}