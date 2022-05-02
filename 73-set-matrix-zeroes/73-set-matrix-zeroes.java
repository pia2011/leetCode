class Solution {
    static int n,m;
    public void setZeroes(int[][] matrix) {
        // 0기준 +
        n = matrix.length;
        m = matrix[0].length;
        
        int tmp[][] = new int[n][m];
        for(int i = 0; i<n; i++){
            for(int j = 0; j<m; j++){
                tmp[i][j] = matrix[i][j];
            }
        }
        
        
        for(int i = 0; i<n; i++) {
            for(int j = 0; j<m; j++) {
                if(matrix[i][j] != 0) continue; 
                
                for(int dir = 0; dir<4; dir++)
                    dfs(tmp, dir, i,j);
            }
        }
        
        for(int i = 0; i<n; i++){
            for(int j = 0; j<m; j++){
                matrix[i][j] = tmp[i][j];
            }
        }
    }
    
    static int dx[] = {0,1,0,-1};
    static int dy[] = {1,0,-1,0};
    static void dfs(int[][] arr, int dir, int x, int y){
        if(x < 0 || y < 0 || x >= n || y >= m ) return;
        System.out.println(x+" "+y);
        arr[x][y] = 0;
        
        dfs(arr, dir, x + dx[dir], y + dy[dir]);
    }
}