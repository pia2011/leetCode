class Solution {
    public boolean isPalindrome(String s) {
        
        StringBuilder sb = new StringBuilder(s.toLowerCase().replaceAll("[^a-z0-9]", ""));
        
        System.out.println(sb.toString());
        System.out.println(sb.reverse().toString());
        
        return sb.toString().equals(sb.reverse().toString());
    }
}