class Solution {
    static final int n = 9;
    static final int m = 9;
    public boolean isValidSudoku(char[][] board) {
        // 9*9로 구성되어 있는 수도쿠를 분석해서 유효한지 판단
        HashSet<String> hs = new HashSet<>();        
        for(int i = 0; i<n; i++){
            for(int j = 0; j<m; j++){
                if(board[i][j] == '.') continue;
                String s = String.valueOf(board[i][j]+" ");
                if(!hs.add(i +" "+ s) || 
                   !hs.add(s +" "+ j ) || 
                   !hs.add(s+" " + i/3 +" "+ j/3)) 
                    return false;
                
                
            }
        }
        
        return true;
    }
}