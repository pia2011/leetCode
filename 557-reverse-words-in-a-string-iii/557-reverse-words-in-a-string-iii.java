import java.util.*;

class Solution {
    public String reverseWords(String s) {
        StringTokenizer st = new StringTokenizer(s, " ");
        int len = st.countTokens();
        StringBuilder ans = new StringBuilder();

        for(int i = 0; i<len; i++){
            ans.append(new StringBuilder(st.nextToken()).reverse()).append(" ");
        }
        
        ans.deleteCharAt(ans.length() - 1);
        
        return ans.toString();
    }
}