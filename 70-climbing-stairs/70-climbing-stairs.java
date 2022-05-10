class Solution {
    public int climbStairs(int n) {
        // n높이의 계단을 오르는 방법(1,2 칸 올라갈 수 있음) 
        
        int d[] = new int[n + 1];
        d[1] = 1;
        if(n > 1) d[2] = 2;
        for(int i = 3; i<=n; i++){
            d[i] = d[i - 2] + d[i - 1];
        }
        
        return d[n];
    }
}