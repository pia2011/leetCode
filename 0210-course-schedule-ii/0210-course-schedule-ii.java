class Solution {
    
    private List<Integer> adj[];
    private int n;
    private int ans[];
    private int degree[];
    public int[] findOrder(int numCourses, int[][] arrs) {
        
        // a 를 듣기 위해서는 b 를 들어야한다.
        // 순환 참조 걸러야함
        
        n = numCourses;
        ans = new int[n];
        degree = new int[n];
        adj = new ArrayList[n];
        for(int i = 0; i<n; i++){
            adj[i] = new ArrayList<>();
        }
        
        for(int arr[] : arrs){
            int a = arr[0];
            int b = arr[1]; // 필요과목
            
            degree[a]++;
            adj[b].add(a);
        }
        
        // 루트를 찾아야함
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i<n; i++){
            if(degree[i] == 0) q.add(i);
        }
        
        int idx = 0;
        while(!q.isEmpty()){
            int course = q.poll();
            
            ans[idx++] = course;
            for(int next : adj[course]){
                degree[next]--;
                if(degree[next] != 0) continue;
                q.add(next);
            }
        }
        
        
        if(idx < n) return new int[]{};
        return ans;
    }
}