class Solution {
    private int lo, maxLen;
    public String longestPalindrome(String s) {
        
        for(int i = 0; i<s.length(); i++){
            extendPalin(s,i,i);
            extendPalin(s,i,i+1);
        }
        
        return s.substring(lo, lo + maxLen);
    }
    private void extendPalin(String s ,int left, int right){
        while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)){
            left--; right++;
        }
        
        if(maxLen < right - left - 1){
            lo = left + 1;
            maxLen = right - left - 1; 
        }
    }
}