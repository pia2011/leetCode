class Solution {
    public void moveZeroes(int[] nums) {
        // 0을 모두 오른쪽으로 옮긴다.
        
        int prev = 0;
        for(int i = 0; i<nums.length; i++){
            if(nums[i] != 0){
                nums[prev++] = nums[i];
                if(i != prev - 1) nums[i] = 0;
            }
        }
        
    }
}