class Solution {
    public int solution(int[][] info, int n, int m) {
        boolean[][] dp = new boolean[n][m];
        
        dp[0][0] = true;
        
        for(int[] item : info) {
            int a = item[0];
            int b = item[1];
            boolean[][] next = new boolean[n][m];
                    
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < m; j++) {
                    if(!dp[i][j]) {
                        continue;
                    }
                    
                    if(i + a < n) {
                        next[i + a][j] = true;
                    }
                    
                    if(j + b < m) {
                        next[i][j + b] = true;
                    }
                }
            }
            
            dp = next;
        }
        
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(dp[i][j]) {
                    return i;
                }
            }
        }
        
        return -1;
    }
}