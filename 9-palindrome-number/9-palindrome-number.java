class Solution {
    public boolean isPalindrome(int x) {
        String s = Integer.toString(x);
        int left = 0;
        int right = s.length() - 1;
        while(left < right){
            if(s.charAt(left++) != s.charAt(right--)) return false;
        }
        
        return true;
    }
}