import java.util.*;

class Solution {
    
    private static final String[] mapping= {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    public List<String> letterCombinations(String digits) {
        // 백트래킹
        // 2&3 -> 3 * 3개의 경우의 수
        List<String> ans = new LinkedList<>();
        if(digits.length() == 0) return ans;
        
        combination(digits, ans, 0, new StringBuilder());
        return ans;
    }
    private void combination(String digits, List<String> ans, int order, StringBuilder sb){
        if(order == digits.length()){
            ans.add(sb.toString());
            return;
        }
        String letter = mapping[digits.charAt(order) - '0'];
        for(int i = 0; i<letter.length(); i++){
            sb.append(letter.charAt(i));
            combination(digits, ans, order + 1, sb);            
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}