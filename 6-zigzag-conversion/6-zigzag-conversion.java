class Solution {
    public String convert(String s, int numRows) {
        // 1 ... numRows ... 1 ... numRows
        
        // 초기화
        StringBuilder sb[] = new StringBuilder[numRows];
        for(int i = 0; i<numRows; i++){
            sb[i] = new StringBuilder();
        }
        
        // 로직
        int idx = 0;
        while(idx < s.length()){
            for(int i = 0; i<numRows && idx<s.length(); i++){
                sb[i].append(s.charAt(idx++));
            }    
            for(int i = numRows - 2; i>=1 && idx<s.length(); i--){
                sb[i].append(s.charAt(idx++));
            }
        }
        
        // 정답
        StringBuilder ans = new StringBuilder();
        for(int i = 0; i<sb.length; i++){
            ans.append(sb[i]);
        }
        
        return ans.toString();
    }
}