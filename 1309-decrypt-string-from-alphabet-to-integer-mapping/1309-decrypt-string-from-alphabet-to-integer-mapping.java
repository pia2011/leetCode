class Solution {
    public String freqAlphabets(String s) {
        // 번역 문제
        
        StringBuilder sb = new StringBuilder();
        for(int i = s.length() - 1; i>=0; i--){
            if(s.charAt(i) == '#'){
                int x = Integer.parseInt(s.substring(i - 2, i));
                sb.insert(0, (char)(x + 'a' - 1));
                i -= 2;
            }else{
                sb.insert(0 ,(char)(s.charAt(i) - '0' + 'a' - 1));
            }
           
        }
        
        return sb.toString();
    }
}