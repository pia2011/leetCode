class Solution {
    public int maxProfit(int[] prices) {
        // 가장 많은 차익
        
        int ans = 0;
        int min = Integer.MAX_VALUE;
        for(int i = 0; i<prices.length; i++){
            min = Math.min(min, prices[i]);
            
            ans = Math.max(ans, prices[i] - min);
        }
        
        return ans;
    }
}