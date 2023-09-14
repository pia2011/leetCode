import java.util.*;

class Solution {
    private int n;
    public boolean wordBreak(String s, List<String> wordDict) {
        // 나눌 수 있는가
        n = s.length();
        Set<String> set = new HashSet<>(wordDict);
        boolean can[] = new boolean[n + 1];
        can[0] = true;
        for(int i = 0; i<n; i++){ // 시작점
            for(int j = i + 1; j<=n; j++){ // 끝점
                if(can[i] && wordDict.contains(s.substring(i,j))){
                    can[j] = true;
                }
            }
        }

        return can[n];
    }
}