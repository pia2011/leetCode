class Solution {
    public int maxSubArray(int[] nums) {
        // 구간 최대합
        int[] d = new int[nums.length]; // 현 시점에서 가장 큰 구간합
        d[0] = nums[0];
        int ans = d[0];
        for(int i = 1; i<nums.length; i++){
            d[i] = nums[i] + ( d[i-1] < 0 ? 0 : d[i - 1]);
            ans = Math.max(ans, d[i]);
        }
        return ans;
        
    }
}