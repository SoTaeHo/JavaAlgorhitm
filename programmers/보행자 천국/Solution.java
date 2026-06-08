import java.util.*;

class Solution {
    int MOD = 20170805;
    public int solution(int m, int n, int[][] cityMap) {
        int answer = 0;
        int[][][] dp = new int[m][n][2];
        
        dp[0][0][0] = 1;
        
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                
                if(i == 0 && j == 0) {
                    continue;
                }
                
                if (j > 0) {
                    int prev = cityMap[i][j-1];
                    if (prev == 0) {
                        dp[i][j][0] = (dp[i][j-1][0] + dp[i][j-1][1]) % MOD;
                    } else if (prev == 2) {
                        dp[i][j][0] = dp[i][j-1][0] % MOD;
                    }
                }
                
                if (i > 0) {
                    int prev = cityMap[i-1][j];
                    if (prev == 0) {
                        dp[i][j][1] = (dp[i-1][j][0] + dp[i-1][j][1]) % MOD;
                    } else if (prev == 2) {
                        dp[i][j][1] = dp[i-1][j][1] % MOD;
                    }
                }
            }
        }
        
        return (dp[m - 1][n - 1][0] + dp[m - 1][n - 1][1]) % MOD;
    }
    
}