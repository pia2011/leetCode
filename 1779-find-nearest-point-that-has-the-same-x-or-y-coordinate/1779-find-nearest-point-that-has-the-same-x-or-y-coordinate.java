class Solution {
    public int nearestValidPoint(int x, int y, int[][] points) {
        int ans = -1;
        
        int min = Integer.MAX_VALUE;
        for(int i = 0; i<points.length; i++){
            int a = points[i][0];
            int b = points[i][1];
            
            int dx = Math.abs(x - a);
            int dy = Math.abs(y - b);
            
            if(dx * dy == 0 && dx + dy < min) {
                min = dx + dy;
                ans = i;
            } 
        }
        
        return ans;
    }
    
}