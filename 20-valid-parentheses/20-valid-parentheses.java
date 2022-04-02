import java.util.*;

class Solution {
    public boolean isValid(String s) {
        
        Stack<Character> stack = new Stack();
        
        for(int i = 0; i<s.length(); i++){ // 여는 괄호 나왔을 때
            if(s.charAt(i) == '{' || s.charAt(i) == '[' || s.charAt(i) == '('){
                stack.add(s.charAt(i));
            }else{ // 닫는 괄호 나왔을 때
                
                // 비어있다면 false
                if(stack.isEmpty()) return false;
                
                char c = stack.peek();
                
                if(c == '[' && s.charAt(i) == ']') stack.pop();
                else if(c == '{' && s.charAt(i) == '}') stack.pop();
                else if(c == '(' && s.charAt(i) == ')') stack.pop();
                else return false; // 아다리 안맞으면 false
            }
        }
        
        
        // 아다리가 맞았다면 모두 사라져야함
        
        return stack.isEmpty() ? true : false;
    }
}