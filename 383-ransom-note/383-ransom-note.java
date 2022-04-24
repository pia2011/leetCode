class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> hm =  new HashMap<>();
        
        for(int i = 0; i<ransomNote.length(); i++){
            hm.compute(ransomNote.charAt(i), (k,v) -> v == null ? 0 : ++v);
        }
        
        Map<Character, Integer> hm2 =  new HashMap<>();
        
        for(int i = 0; i<magazine.length(); i++){
            hm2.compute(magazine.charAt(i), (k,v) -> v == null ? 0 : ++v);
        }
        
        for(char c : hm.keySet()){
            if(!hm2.containsKey(c)) return false;
            if(hm.get(c) > hm2.get(c)) return false;
        }
        
        return true;
    }
}