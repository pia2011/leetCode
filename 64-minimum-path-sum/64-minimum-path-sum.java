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
        
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(0,0));
        dist[0][0] = cost[0][0];
        
        while(!q.isEmpty()){
            Point now = q.poll();
            for(int i = 0; i<2; i++){
                int nx = dx[i] + now.x;
                int ny = dy[i] + now.y;
                
                if(nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
                if(dist[now.x][now.y] + cost[nx][ny] >= dist[nx][ny]) continue;
                
                dist[nx][ny] = dist[now.x][now.y] + cost[nx][ny];
                q.add(new Point(nx,ny));
            }
        }
        
        return dist[n - 1][m - 1];
    }
    
    
    static class Point{
        int x,y;
        Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}

