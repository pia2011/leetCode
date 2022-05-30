class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // 같은 요소로 이루어진 단어들끼리 List로 묶어서 반환
        HashMap<String, List<String>> hm = new HashMap<>();
        for(String s : strs){
            char c[] = s.toCharArray();
            Arrays.sort(c);
            String key = String.valueOf(c);
            hm.putIfAbsent(key, new ArrayList<>());
            hm.get(key).add(s);
        }
        
        return new ArrayList<>(hm.values()); 
    }
}