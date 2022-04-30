class Solution {
    
    static int[] parent;
    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        // 가능한 오름차순에 근접하도록 재배치하여 반환
       
        init(s.length());
        
        for(List<Integer> pair : pairs){
            union(pair.get(0), pair.get(1));
        }
        
        HashMap<Integer, List<Integer>> groups = new HashMap<>();
       
        for(int i = 0; i<s.length(); i++){
            int root = find(i);
            groups.putIfAbsent(root , new ArrayList());
            groups.get(root).add(i);
        }
        
        char ans[] = new char[s.length()];
        for(List<Integer> group : groups.values()){
            List<Character> tempList = new ArrayList<>();
            for(int x : group){
                tempList.add(s.charAt(x));
            }
            Collections.sort(tempList);
            
            for(int i = 0; i<group.size(); i++){
                ans[group.get(i)] = tempList.get(i);
            }
        }
        
        return new String(ans);
    }
    static void init(int len){
        parent = new int[len];
        for(int i = 0; i<len; i++){
            parent[i] = -1;
        }
    }
    static void union(int a, int b){
        a = find(a);
        b = find(b);
        
        if(a == b) return;
        
        if(parent[a] < parent[b]){ // 둘 다 음수
            parent[a] += parent[b];
            parent[b] = a;
        }else{
            parent[b] += parent[a];
            parent[a] = b;
        }
    }
    static int find(int x){
        if(parent[x] < 0) return x;
        else{
            int p = find(parent[x]);
            parent[x] = p;
            return p;
        }
    }
}