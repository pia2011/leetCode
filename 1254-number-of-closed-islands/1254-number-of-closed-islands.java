class Solution {
    static int n,m;
    public int closedIsland(int[][] grid) {
        // 4방향이 모두 1로 둘러쌓인 0의 영역의 개수
        int ans = 0;
        n = grid.length;
        m = grid[0].length;
        
        for(int i = 0; i<n; i++){
            for(int j = 0; j<m; j++){
                if(grid[i][j] == 0 && isIsland(grid, i, j)) {
                    ans++;
                }
            }
        }
        
        return ans;
    }
    static boolean isIsland(int[][] grid, int x, int y){
        if(x < 0 || x >= n || y < 0 || y >= m) {
            return false;
        }
        if(grid[x][y] == 1) return true;
        
        grid[x][y] = 1;
        
        boolean down = isIsland(grid, x + 1, y);
        boolean right = isIsland(grid, x, y + 1);
        boolean up = isIsland(grid, x - 1, y);
        boolean left = isIsland(grid, x, y - 1);
        
        // 하나라도 범위 밖으로 넘어가면 false를 반환
        return up && down && left && right;
    }
}