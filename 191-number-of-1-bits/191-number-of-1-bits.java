public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        
        int ans = 0;
    
        String s = Integer.toBinaryString(n);
        
        for(int i = 0; i<s.length(); i++){
            if(s.charAt(i) == '1') {
                ans++;
            }
        }
        
        return ans;
        
    }
}