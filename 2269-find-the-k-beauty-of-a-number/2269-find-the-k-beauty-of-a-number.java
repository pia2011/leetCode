class Solution {
    public int divisorSubstrings(int num, int k) {
        int ret = 0;
        String str = String.valueOf(num);
        
        for(int i = 0; i<str.length() - k + 1; i++){
            int sub = Integer.parseInt(str.substring(i, i+k));
            if(sub == 0) continue;
            if(num%sub == 0) ret++;
        }
        
        return ret;
    }
}