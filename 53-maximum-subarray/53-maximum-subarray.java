class Solution {
    public int maxSubArray(int[] nums) {
        // 구간 최대합
        int ans = Integer.MIN_VALUE;
        int sum = 0;
        for(int x : nums){
            sum += x;
            if(x > sum) sum = x; 
            
            if(ans < sum)
                ans = sum;
        }
        
        return ans;
        
    }
}