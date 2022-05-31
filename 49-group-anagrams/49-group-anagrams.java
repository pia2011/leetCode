class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // 같은 요소로 이루어진 단어들끼리 List로 묶어서 반환
        HashMap<String, List<String>> groups = new HashMap<>();
        
        for(String s : strs){
            char c[] = s.toCharArray();
            Arrays.sort(c);
            String str = String.valueOf(c); // 공통
            groups.putIfAbsent(str, new ArrayList<>());
            groups.get(str).add(s);
        }
        
        return new ArrayList<>(groups.values());
    }
}