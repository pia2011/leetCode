public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        
        int ret = 0;
        
        for(int i = 0;i<32; i++){
            ret += n & 1;            
            n = n >>> 1;
            if(i < 31) // 맨 마지막에는 이동하지 않는다.
            ret = ret << 1;
        }
        
        return ret;
    }
}