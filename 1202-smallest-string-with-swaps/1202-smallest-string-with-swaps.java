class Solution {
    
    static int parent[];
    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        // 가능한 오름차순에 근접하도록 재배치하여 반환
        
        init(s.length());
        
        for(int i = 0; i<pairs.size(); i++){
            List<Integer> p = pairs.get(i);
            int a = p.get(0);
            int b = p.get(1);
            
            union(a,b);
        }
        
        HashMap<Integer, List<Integer>> groups = new HashMap<>();
        for(int i = 0; i<s.length(); i++){
            int root = find(i);
            groups.putIfAbsent(root, new ArrayList<>());
            groups.get(root).add(i);
        }
        
        char ans[] = new char[s.length()];
        for(List<Integer> values : groups.values()){
            List<Character> tmpList = new ArrayList<>();
            for(int idx : values){
                tmpList.add(s.charAt(idx));
            }
            
            Collections.sort(tmpList);
            
            for(int i = 0; i<values.size(); i++){
                ans[values.get(i)] = tmpList.get(i);
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
        
        if(a == b) return; // already in same group
        
        // compare height (둘 다 음수 -> 높이가 클 수록 작음)
        if(parent[a] < parent[b]){
            parent[a] += parent[b]; 
            parent[b] = a;
        }else{
            parent[b] += parent[a];
            parent[a] = b;
        }
    }
    
    static int find(int x){
        if(parent[x] < 0) return x;
        else {
            int p = find(parent[x]);
            parent[x] = p;
            return p;
        }
    }
}