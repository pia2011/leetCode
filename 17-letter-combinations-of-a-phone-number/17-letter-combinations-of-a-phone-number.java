import java.util.*;

class Solution {
    public List<String> letterCombinations(String digits) {
        LinkedList<String> ans = new LinkedList<>();
        if(digits.isEmpty()) return ans;
        
        String mapping[] = new String[]{"0", "1","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        
        ans.add(0,"");
        
        for(int i = 0; i<digits.length(); i++){
            int x = digits.charAt(i) - '0';
            int size = ans.size();
            for(int k = 1; k<=size; k++){ 
                String tmp = ans.remove(0); // 앞 부터 이전 단계의 것들 모조리 
                for(char c : mapping[x].toCharArray()){
                    ans.add(tmp + c); // 뒤에 추가
                }
            }
        }
        
        return ans;
    }
}