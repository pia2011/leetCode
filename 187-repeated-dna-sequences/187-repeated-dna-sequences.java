class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        // 반복되는 시퀀스들 반환
        HashSet<String> repeat = new HashSet<>();
        HashSet<String> seen = new HashSet<>(); 
        
        for(int i = 0; i + 9 < s.length(); i++){
            String seq = s.substring(i, i + 10);
            if(!seen.add(seq)){ // 안넣어지는거면(false) 이미 한번 나왔다는 거임
                repeat.add(seq);
            }
            
        }
        
        return new ArrayList(repeat);
    }
}