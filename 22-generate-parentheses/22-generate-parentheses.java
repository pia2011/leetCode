class Solution {
    
    static String[] cases = {"(", ")"};
    public List<String> generateParenthesis(int n) {
        List<String> ans = new LinkedList<>();
        
        combination(ans, 2*n, new StringBuilder());
        
        return ans;
    }
    
    static void combination(List<String> ans, int remain, StringBuilder sb){
        if(remain == 0){
            if(isRight(sb.toString())){
                ans.add(sb.toString());
            }
            // System.out.println(sb.toString());
            return;
        }
        
        for(String s : cases){
            sb.append(s);
            combination(ans, remain - 1, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
    
    static boolean isRight(String s){
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i<s.length(); i++){
            if(s.charAt(i) == '('){
                stack.push('(');
            }else if(s.charAt(i) == ')'){
                if(stack.isEmpty() || stack.peek() != '(') return false;
                stack.pop();
            }
        }
        
        if(!stack.isEmpty()) return false;
        
        return true;
    }
}