class Solution {
    public int romanToInt(String s) {
        
        int ans = 0;
        HashMap<Character, Integer> hm = new HashMap();
        hm.put('I', 1);
        hm.put('V', 5);
        hm.put('X', 10);
        hm.put('L', 50);
        hm.put('C', 100);
        hm.put('D', 500);
        hm.put('M', 1000);
        
        int prev = 0;
        
        for(char c : s.toCharArray()){
            
            int now = hm.get(c);
            
            if(now > prev){
                ans += now - prev;
                ans -= prev;
            }else{
                ans += now;
            }
            
            prev = now;
        }
        
        return ans;
    }
}