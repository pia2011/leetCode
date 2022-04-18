class Solution {
    static int n,m;
    public int maxAreaOfIsland(int[][] grid) {
        int ans = 0;
        n = grid.length;
        m = grid[0].length;
        for(int i = 0; i<n; i++){
            for(int j = 0; j<m; j++){
                if(grid[i][j] == 1){ 
                    // System.out.println(dfs(grid, i, j));
                    ans = Math.max(ans, dfs(grid, i, j));
                }
                
            }
        }
        return ans;
        
    }
    static int dfs(int grid[][], int x, int y){
        if(x < 0 || y < 0 || x >= n || y >= m || grid[x][y] != 1) return 0;
        
        grid[x][y] = 0;
        
        int sum = 1;
        
        sum += dfs(grid, x + 1, y);
        sum += dfs(grid, x, y + 1);
        sum += dfs(grid, x - 1, y);
        sum += dfs(grid, x, y - 1);
        
        return sum;
    }
}