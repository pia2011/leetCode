class Solution {
    static int n,m;
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        n = grid1.length;
        m = grid1[0].length;
        int ans = 0;
        // 조건 : 모든 부분이 겹쳐야함
        for(int i = 0; i<n; i++){
            for(int j = 0; j<m; j++){
                if(grid2[i][j] == 1) 
                    ans += dfs(grid1, grid2, i, j);
            }
        }
        
        return ans;
    }
    static int dfs(int[][] grid1, int[][] grid2, int x, int y){
            int ret = 1;
            if(x < 0 || x >= n || y < 0 || y >= m || grid2[x][y] == 0) return 1;
            grid2[x][y] = 0;
            
            ret &= dfs(grid1, grid2, x + 1, y);
            ret &= dfs(grid1, grid2, x - 1, y);
            ret &= dfs(grid1, grid2, x, y + 1);
            ret &= dfs(grid1, grid2, x, y - 1);
            
            return ret & grid1[x][y]; // 0이 발생할 수 있음
        }
}