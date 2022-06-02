class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        int l = strs.length;
        int d[][] = new int[m+1][n+1]; // 최대 0과 1의 개수 대비 요소 수
        int cnt[] = new int[2];
        
        for(String s : strs){
            
            cnt = countNum(s);
            
            for(int i = m; i>=cnt[0]; i--){
                for(int j = n; j>=cnt[1]; j--){
                    if(i >= cnt[0] && j >= cnt[1])
                        d[i][j] = Math.max(d[i][j], d[i-cnt[0]][j-cnt[1]] + 1);
                }
            }
        }
        
        return d[m][n];
    }
    
    private int[] countNum(String s){
        int res[] = new int[2];
        for(char c : s.toCharArray()){
            if(c == '0'){
                res[0]++;
            }else if(c == '1'){
                res[1]++;
            }
        }
        
        return res;
    }
}