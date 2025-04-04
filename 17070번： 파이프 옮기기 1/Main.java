
/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 17070                             :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: thxogh1 <boj.kr/u/thxogh1>                  +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/17070                          #+#        #+#      #+#    */
/*   Solved: 2025/04/04 15:19:28 by thxogh1       ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int[][] map = new int[n + 1][n + 1];
        int[][][] dp = new int[n + 1][n + 1][3];

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dp[1][2][0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 3; j <= n; j++) {
                if (map[i][j] == 1)
                    continue;

                dp[i][j][0] = dp[i][j - 1][0] + dp[i][j - 1][2];
                if (i == 1)
                    continue;
                dp[i][j][1] = dp[i - 1][j][1] + dp[i - 1][j][2];
                if (map[i - 1][j] == 1 || map[i][j - 1] == 1)
                    continue;
                dp[i][j][2] = dp[i - 1][j - 1][0] + dp[i - 1][j - 1][1] + dp[i - 1][j - 1][2];
            }
        }
        System.out.println(dp[n][n][0] + dp[n][n][1] + dp[n][n][2]);
    }
}