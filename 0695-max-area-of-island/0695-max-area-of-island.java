class Solution {
    // 가장 큰 섬의 면적을 구하라
    
    private int n,m;
    private boolean visited[][];
    private int board[][];
    public int maxAreaOfIsland(int[][] grid) {
        int ans = 0;
        n = grid.length;
        m = grid[0].length;
        visited = new boolean[n][m];
        board = grid;
        
        for(int i = 0; i<n; i++){
            for(int j = 0; j<m; j++){
                if(visited[i][j] || grid[i][j] == 0) continue;
                ans = Math.max(bfs(i,j), ans);
            }
        }
        
        return ans;
    }
    
    private static final int dx[] = {0,1,0,-1};
    private static final int dy[] = {1,0,-1,0};
    private int bfs(int x, int y){
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(x,y));
        visited[x][y] = true;
        int ret = 1;
        
        while(!q.isEmpty()){
            Point p = q.poll();
            for(int i = 0; i<4; i++){
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];
                if(!isIn(nx,ny)) continue;
                if(board[nx][ny] == 0) continue;
                if(visited[nx][ny]) continue;
                ret++;
                visited[nx][ny] = true;
                q.add(new Point(nx,ny));
            }
        }
        
        return ret;
    }
    
    private boolean isIn(int x, int y){
        return x >= 0 && y >= 0 && x < n && y < m;
    }
    
    private class Point{
        int x, y;
        Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}