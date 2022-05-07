class Solution {
    private static int n,m;
    private static int[][] dist;
    public int minPathSum(int[][] grid) {
        n = grid.length;
        m = grid[0].length;
        
        dist = new int[n][m];
        for(int i = 0; i<n; i++){
            Arrays.fill(dist[i],Integer.MAX_VALUE);
        }
        
        return bfs(grid);
        
    }
    
    static final int dx[] = {0,1};
    static final int dy[] = {1,0};
    
    private static int bfs(int cost[][]){
        
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0,0});
        dist[0][0] = cost[0][0];
        
        while(!q.isEmpty()){
            int[] now = q.poll();
            for(int i = 0; i<2; i++){
                int nx = dx[i] + now[0];
                int ny = dy[i] + now[1];
                
                if(nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
                if(dist[now[0]][now[1]] + cost[nx][ny] >= dist[nx][ny]) continue;
                
                dist[nx][ny] = dist[now[0]][now[1]] + cost[nx][ny];
                q.add(new int[]{nx,ny});
            }
        }
        
        return dist[n - 1][m - 1];
    }

}

