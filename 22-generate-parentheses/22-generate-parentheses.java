class Solution {
    
    public List<String> generateParenthesis(int n) {
        List<String> ans = new LinkedList<>();
        
        combination(ans, n, new StringBuilder(), 0, 0);
        
        return ans;
    }
    
    static void combination(List<String> ans, int n, StringBuilder sb, int open, int close){
        
        if(sb.length() == n * 2){
            ans.add(sb.toString());
            // System.out.println(sb.toString());
            return;
        }
        if(open < n){
            sb.append("(");
            combination(ans, n, sb, open + 1, close);
            sb.deleteCharAt(sb.length() - 1);
        }
        if(close < open){
            sb.append(")");
            combination(ans, n, sb, open, close + 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}