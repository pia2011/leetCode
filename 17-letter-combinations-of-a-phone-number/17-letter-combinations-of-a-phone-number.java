import java.util.*;

class Solution {
    static final String[] mapping = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    public List<String> letterCombinations(String digits) {
        List<String> ans = new LinkedList<>();
        if(digits.length() == 0) return ans;
        
        combination(ans, digits, 0, new StringBuilder());
        return ans;
    }
    
    private void combination(List<String> ans,String digits, int order, StringBuilder sb){ // 백트래킹
        if(order == digits.length()){ // 범위를 넘어서면 종료 
            ans.add(new String(sb));
            return;
        }
        
        String letter = mapping[digits.charAt(order) - '0'];
        for(int i = 0; i<letter.length(); i++){
            sb.append(letter.charAt(i));
            combination(ans, digits, order + 1, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}