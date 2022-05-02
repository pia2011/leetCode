class Solution {
    public int removeDuplicates(int[] nums) {
        // 유일한 값으로 오름차순 : 이미 오름차순으로 정렬되어 있음
        
        int idx = 1;
        for(int i = 1; i<nums.length; i++){
            if(nums[i] != nums[i - 1]) { // 값이 상승했으면
                nums[idx++] = nums[i];
            }
        }
        
        return idx;
    }
}