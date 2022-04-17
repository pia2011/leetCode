class Solution {
    
    static int n,m;
    public int numIslands(char[][] grid) {
        
        int ans = 0;
        n = grid.length;
        m = grid[0].length;
        
        for(int i = 0; i<n; i++){
            for(int j = 0; j<m; j++){
                if(grid[i][j] != '1') continue;
                dfs(grid, i, j);
                ans++;
            }
        }
        
        return ans;
    }
    
    static void dfs(char grid[][], int x, int y){
        if(x < 0 || x >= n || y < 0 || y >= m || grid[x][y] != '1') return; // 범위에 벗어나거나 조건을 만족시키지 못하면 out
        
        grid[x][y] = '0';
        dfs(grid, x + 1, y);
        dfs(grid, x, y + 1);
        dfs(grid, x - 1, y);
        dfs(grid, x, y - 1);
        
    }
}