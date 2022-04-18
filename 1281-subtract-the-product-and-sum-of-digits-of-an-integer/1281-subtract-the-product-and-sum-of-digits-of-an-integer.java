class Solution {
    public int subtractProductAndSum(int n) {
        
        int ans = 0;
        
        // 각 자리수의 곱 - 각 자리수의 합
        int mul = 1;
        int sum = 0;
        String s = String.valueOf(n);
        for(int i = 0; i<s.length(); i++){
            mul *= s.charAt(i) - '0';
            sum += s.charAt(i) - '0';
        }
        
        ans = mul - sum;
        
        return ans;
        
    }
}