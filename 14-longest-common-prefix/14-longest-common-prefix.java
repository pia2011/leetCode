class Solution {
    public String longestCommonPrefix(String[] strs) {
        
        if(strs.length == 1) return strs[0];
        
        StringBuilder sb = new StringBuilder();
        
        int min = Integer.MAX_VALUE;
        for(String s : strs){
            min = Math.min(min, s.length());
        }
        
        int len = Integer.MAX_VALUE;
        for(int i = 1; i<strs.length; i++){
            int cl = 0;
            for(int j = 0; j<min; j++){
                if(strs[i].charAt(j) != strs[i - 1].charAt(j)) break;
                cl++;
            }
            len = Math.min(len, cl);
        }
        
        for(int i = 0; i<len; i++){
            sb.append(strs[0].charAt(i));
        }
        
        return sb.toString();
    }
}