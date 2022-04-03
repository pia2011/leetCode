class Solution {
    public int firstUniqChar(String s) {
        
        HashMap<Character, Integer> hm = new HashMap();
        
        for(char c : s.toCharArray()){
            hm.compute(c,(k,v) -> (v == null) ? 1 : ++v);
        }
        
        for(int i = 0; i<s.length(); i++){
            if(hm.get(s.charAt(i)) == 1) return i;
        }
        
        return -1;
    }
}