class Solution {
    private static int n;
    public int rob(int[] nums) {
        n = nums.length;
        
        // d[k] = k 번째 집까지 털었을 때 최대 금액
        // 점화식 : d[n] = max(d[n - 1], d[n - 2] + nums[k])
        
        int d[] = new int[n + 1];
        d[0] = nums[0];
        if(n == 1) return d[0];
        d[1] = Math.max(nums[0], nums[1]);
        for(int i = 2; i<n; i++){
            d[i] = Math.max(d[i - 1], d[i - 2] + nums[i]);    
        }
        
        return d[n - 1];
    }
}