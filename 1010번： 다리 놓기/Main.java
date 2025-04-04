
/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 1010                              :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: thxogh1 <boj.kr/u/thxogh1>                  +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/1010                           #+#        #+#      #+#    */
/*   Solved: 2025/04/04 14:33:59 by thxogh1       ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int ans = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int tcase = Integer.parseInt(br.readLine());
        while (tcase-- > 0) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int[][] dp = new int[m + 1][n + 1];

            for (int i = 0; i <= m; i++) {
                dp[i][0] = 1;
            }

            for (int i = 1; i <= m; i++) {
                for (int j = 1; j <= Math.min(i, n); j++) {
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                }
            }
            // for (int i = 1; i <= n; i++) {
            // for (int j = 1; j <= m; j++) {
            // System.out.print(dp[i][j] + " ");
            // }
            // System.out.println();
            // }
            System.out.println(dp[m][n]);
        }
    }

}

// nCm = (n - 1) C (m - 1) + (n - 1) C m
