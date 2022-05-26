class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        // 길이가 10인 반복되는 시퀀스들 반환
        HashSet<String> repeat = new HashSet<>();
        HashSet<String> check = new HashSet<>();
        for(int i = 0; i<s.length() - 9; i++){
            String temp = s.substring(i, i + 10);
            if(!check.add(temp)){
                repeat.add(temp);
            }
        }
        
        return new LinkedList<>(repeat);
    }
}