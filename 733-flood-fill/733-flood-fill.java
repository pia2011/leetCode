class Solution {
    static int n,m;
    static int[][] ans;
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        // (sr, sc) 가 속한 영역의 수를 newColor로 수정 : 영역은 붙어있어야함
        // 너비탐색으로 구현
        n = image.length;
        m = image[0].length;
        ans = new int[n][m];
        
        for(int i = 0; i<n; i++){
            for(int j = 0; j<m; j++){
                ans[i][j] = image[i][j];
            }
        }
        
        visited = new boolean[n][m];
        bfs(image,sr,sc,newColor);
        
        return ans;
    }
    
    static boolean visited[][];
    static int dx[] = {0,1,0,-1};
    static int dy[] = {1,0,-1,0};
    static void bfs(int image[][], int x, int y, int color){
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(x, y));
        visited[x][y] = true;
        ans[x][y] = color;
        
        while(!q.isEmpty()){
            Point now = q.poll();
            for(int i = 0; i<4; i++){
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];
                if(nx >= n || ny >= m || nx < 0 || ny < 0) continue;
                if(visited[nx][ny]) continue;
                if(image[x][y] != image[nx][ny]) continue;
                
                visited[nx][ny] = true;
                ans[nx][ny] = color;
                q.add(new Point(nx,ny));
            }
        }
         
    }
    
    static class Point{
        int x,y;
        Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    } 
}