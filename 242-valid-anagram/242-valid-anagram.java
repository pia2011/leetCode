class Solution {
    public boolean isAnagram(String s, String t) {
        // 재구성할 수 있으면 true
        int alpha[] = new int[26];
        for(int i = 0; i<s.length(); i++){
            alpha[s.charAt(i) - 'a']++;
        }
        for(int i = 0; i<t.length(); i++){
            alpha[t.charAt(i) - 'a']--;    
        }
        
        for(int i = 0; i<alpha.length; i++){
            if(alpha[i] != 0)return false;
        }
        
        return true;
        
    }
}