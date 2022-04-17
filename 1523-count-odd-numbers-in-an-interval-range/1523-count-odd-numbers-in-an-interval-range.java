class Solution {
    public int countOdds(int low, int high) {
        // 범위 안에 홀수 세기
        int ans = 0;
        
        if(low%2 != 0) {
            ans++;
            low++;
        }
        
        if(high%2 != 0){
            ans++;
            high--;
        }
        
        ans += (high - low)/2;
        
        return ans;
    }
}