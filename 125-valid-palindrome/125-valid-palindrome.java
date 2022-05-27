class Solution {
    public boolean isPalindrome(String s) {
        
        StringBuilder sb = new StringBuilder(s.toLowerCase().replaceAll("[^a-z0-9]", ""));
        
        return sb.toString().equals(sb.reverse().toString());
    }
}