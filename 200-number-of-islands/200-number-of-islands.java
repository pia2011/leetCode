class Solution {
    
    static char[][] board;
    static boolean visited[][];
    static int n,m;
    public int numIslands(char[][] grid) {
        // 흔히 볼 수 있는 섬의 개수를 구하는 문제, BFS로 boolean[][] 배열을 통해 체크
        board = grid;
        int ans = 0;
        n = grid.length;
        m = grid[0].length;
        visited = new boolean[n][m];
        
        for(int i = 0; i<n; i++){
            for(int j = 0; j<m; j++){
                if(visited[i][j] || grid[i][j] != '1') continue;
                ans++;
                bfs(i,j);
            }
        }
        
        return ans;
    }
    
    static int dx[] = {0,1,-1,0};
    static int dy[] = {1,0,0,-1};
    static void bfs(int x, int y){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x,y});
        visited[x][y] = true;
        
        while(!q.isEmpty()){
            int[] now = q.poll();
            
            for(int i = 0; i<4; i++){
                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];

                if(nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
                if(visited[nx][ny]) continue;
                if(board[nx][ny] != '1') continue;
                visited[nx][ny] = true;
                q.add(new int[]{nx,ny});
            }
        }
    }
}