class Solution {
    private int n,m;
    public int maxAreaOfIsland(int[][] grid) {
        n = grid.length;
        m = grid[0].length;
        int ans = 0;
        for(int i = 0; i<n; i++){
            for(int j = 0; j<m; j++){
                if(grid[i][j] == 0) continue;
                ans = Math.max(ans, dfs(grid, i, j));
            }
        }
        
        return ans;
    }
    
    private int dfs(int grid[][], int x, int y){
        if(x < 0 || y < 0 || x >= n || y >= m || grid[x][y] == 0) return 0;
        grid[x][y] = 0;
        
        int ret = 1;
        for(int i = 0; i<4; i++){
            ret += dfs(grid, x + dx[i], y + dy[i]);
        }
        
        return ret;
    }
    private static final int dx[] = {0,1,0,-1};
    private static final int dy[] = {1,0,-1,0};
}