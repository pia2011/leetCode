class Solution {
    private static int n,m;
    private boolean flag;
    private boolean visited[][];
    public boolean exist(char[][] board, String word) {
        n = board.length;
        m = board[0].length;
        visited = new boolean[n][m];
        
        for(int i = 0; i<n; i++){
            for(int j= 0; j<m; j++){
                if(word.charAt(0) == board[i][j]){  
                    visited[i][j] = true;
                    dfs(board, word, 1, i, j);
                    visited[i][j] = false;
                } 
            }
        }
        
        return flag;
    }
    
    private static int dx[] = {0,1,0,-1};
    private static int dy[] = {1,0,-1,0};
    private void dfs(char[][] board, String word, int idx, int x, int y){
        if(word.length() == idx){
            flag = true;
            return;
        }

        for(int i = 0; i<4; i++){
            int nx = dx[i] + x;
            int ny = dy[i] + y;
            if(nx < 0 || ny < 0 || nx >= board.length || ny >= board[0].length) continue;
            if(word.charAt(idx) != board[nx][ny]) continue; 
            if(visited[nx][ny]) continue;
            
            visited[nx][ny] = true;
            dfs(board, word, idx + 1, nx, ny);
            visited[nx][ny] = false;
        }
    }
}