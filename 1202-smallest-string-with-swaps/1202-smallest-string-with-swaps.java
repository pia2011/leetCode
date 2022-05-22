class Solution {
    static int parent[];
    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        
        // 스왑을 사용해서 S를 사전순으로 가장 작은 단어로 만든다. 스왑의 횟수는 무제한이다.
        // 같은 그룹 사이에서는 어떻게든 이동할 수 있다. -> 분리집합을 사용해서 묶어준다.
        
        // step1. 자기 자신을 route로 만들어준다.
        parent = new int[s.length()];
        for(int i = 0; i<s.length(); i++){
            parent[i] = -1;
        }        
        
        // step2. 
        for(int i = 0; i<pairs.size(); i++){
            List<Integer> temp = pairs.get(i);
            int a = temp.get(0);
            int b = temp.get(1);
            union(a,b);
        }
        
        // step3. 그룹별로 묶어주기
        HashMap<Integer, List<Integer>> groups = new HashMap<>();
        for(int i = 0; i<s.length();i++){
            int root = find(i);
            groups.putIfAbsent(root, new ArrayList<>());
            groups.get(root).add(i);
        }
        
        char ans[] = new char[s.length()];
        for(List<Integer> values : groups.values()){
            List<Character> tempList = new ArrayList<>();
            for(int x : values){
                tempList.add(s.charAt(x));
            }
           
            Collections.sort(tempList);
            
            for(int i = 0; i<values.size(); i++){
                ans[values.get(i)] = tempList.get(i);
            }
        }
        
        return new String(ans);
    }
    
    static void union(int a, int b){
        a = find(a);
        b = find(b);
        if(a == b) return;
            
        
        if(parent[a] < parent[b]){
            parent[a] += parent[b]; // 개수 추가
            parent[b] = a; // 부모 변경 
        }else{
            parent[b] += parent[a];
            parent[a] = b;
        }
        
    }
    static int find(int x){
        if(parent[x] < 0) return x;
        else{
            return parent[x] = find(parent[x]);
        }
    }
}