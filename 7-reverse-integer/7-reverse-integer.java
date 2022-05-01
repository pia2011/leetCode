class Solution {
    public int reverse(int x) {
        // 범위를 벗어나면 return 0 
        long ans = 0;
        
        String s = Integer.toString(x);
        StringBuilder sb = new StringBuilder(s);
        
        if(x < 0){
            sb.deleteCharAt(0);
            sb.reverse();
            
            ans = -Long.parseLong(sb.toString());
            
        }else{
            
            sb.reverse();
            ans = Long.parseLong(sb.toString());        
            
        }
        
        
        if(ans > Integer.MAX_VALUE || ans < Integer.MIN_VALUE) return 0;
        
        return (int)ans;
    }
}