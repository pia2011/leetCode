import java.util.*;

class Solution {
    
    // 전형적인 문제
    // 주의 : 살아있으면 안됨
    private int n,m;
    private int board[][];
    private int time[][];
    private static final int INF = 987654321;
    public int orangesRotting(int[][] grid) {
        n = grid.length;
        m = grid[0].length;
        board = grid;
        time = new int[n][m];
        
        // 기저사례
        if(!isThereAnyFresh()) return 0; // 신선한게 없으면 0초
        if(!isThereAnyRotten()) return -1; // 썩은게 없으면 불가능
        
        for(int i = 0; i<n; i++) Arrays.fill(time[i], INF);
        
        for(int i = 0; i<n; i++){
            for(int j = 0; j<m; j++){
                if(board[i][j] == 2 && time[i][j] == INF){ // 썩은 오렌지 && 최초 방문
                    bfs(i,j);
                }
            }
        }
        
        return isFreshOrangeExists() ? -1 : findMaxTime();
    }
    
    private boolean isThereAnyFresh(){
        for(int i = 0; i<n; i++){
            for(int j = 0; j<m; j++){
                if(board[i][j] == 1) return true;
            }
        }
        
        return false;
    }
    
    
    private boolean isThereAnyRotten(){
        for(int i = 0; i<n; i++){
            for(int j = 0; j<m; j++){
                if(board[i][j] == 2) return true;
            }
        }
        
        return false;
    }
    
    
    private int findMaxTime(){
        int ret = -1;
        for(int i = 0; i<n; i++){
            for(int j = 0; j<m; j++){
                if(time[i][j] == INF) continue;
                ret = Math.max(ret, time[i][j]);
            }
        }
        return ret;
    }
    
    
    private boolean isFreshOrangeExists(){ 
        
        for(int i = 0; i<n; i++){
            for(int j =0; j<m; j++){
                if(time[i][j] == INF && board[i][j] == 1) return true;
            }
        }
        
        return false;
    }
    
    
    private void bfs(int x, int y){
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(x, y, 0));
        time[x][y] = 0;
        while(!q.isEmpty()){
            Point p = q.poll();
            
            for(int i = 0; i<4; i++){
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];
                if(!isIn(nx, ny)) continue;
                if(time[nx][ny] <= p.cnt) continue;
                if(board[nx][ny] == 1){ // 싱싱한 오렌지
                    time[nx][ny] = p.cnt + 1;
                    q.add(new Point(nx, ny, p.cnt + 1));    
                }
                
            }
        }
    }
    
    private boolean isIn(int x, int y){
        return x >= 0 && y >= 0 && x < n && y < m;
    }
    
    private final static int dx[] = {0,1,0,-1};
    private final static int dy[] = {1,0,-1,0};
    
    private class Point{
        int x, y, cnt;
        Point(int x, int y, int cnt){
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
    }
}