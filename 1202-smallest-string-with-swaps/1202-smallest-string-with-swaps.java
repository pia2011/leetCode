class Solution {
    static int parent[];
    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
     
        parent = new int[s.length()];
        for(int i = 0; i<s.length(); i++){
            parent[i] = -1;
        }
        
        for(List<Integer> pair : pairs){
            int a = pair.get(0);
            int b = pair.get(1);
            union(a,b);
        }
        
        HashMap<Integer, List<Integer>> groups = new HashMap<>();
        for(int i = 0; i<s.length(); i++){
            int root = find(i);
            groups.putIfAbsent(root , new ArrayList<>());
            groups.get(root).add(i);
        }    
        
        char ans[] = new char[s.length()];
        for(List<Integer> idxGroup : groups.values()){
            List<Character> tempList = new ArrayList<>();
            for(int idx : idxGroup){
                tempList.add(s.charAt(idx));
            }
            
            Collections.sort(tempList);
            
            for(int i = 0; i<tempList.size(); i++){
                ans[idxGroup.get(i)] = tempList.get(i);
            }
        }
        
        return new String(ans);
    }
    
    private static void union(int a, int b){
        a = find(a);
        b = find(b);
        
        if(a == b) return; // 이미 같은 그룹임
        
        if(parent[a] > parent[b]){ // 높이 비교(음수)
            parent[b] += parent[a];
            parent[a] = b;
        }else{
            parent[a] += parent[b];
            parent[b] = a;
        }
    }
    
    private static int find(int x){
        if(parent[x] < 0) return x; // 이미 루트인 상태
        else{
            return parent[x] = find(parent[x]);
        }
    } 
}