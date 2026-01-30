/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 2228                              :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: thxogh1 <boj.kr/u/thxogh1>                  +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/2228                           #+#        #+#      #+#    */
/*   Solved: 2026/01/30 19:51:11 by thxogh1       ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static final int INF = 1_000_000_000;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] arr = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        // prefix sum
        int[] sum = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            sum[i] = sum[i - 1] + arr[i];
        }

        // dp
        int[][] dp = new int[N + 1][M + 1];
        for (int i = 0; i <= N; i++)
            Arrays.fill(dp[i], -INF);

        dp[0][0] = 0;

        for (int i = 1; i <= N; i++) {
            for (int j = 0; j <= M; j++) {
                dp[i][j] = Math.max(dp[i][j], dp[i - 1][j]);

                if (j > 0) {
                    for (int k = 1; k <= i; k++) {
                        int prev = k - 2 >= 0 ? dp[k - 2][j - 1] : (j - 1 == 0 ? 0 : -INF);
                        dp[i][j] = Math.max(
                            dp[i][j],
                            prev + (sum[i] - sum[k - 1])
                        );
                    }
                }
            }
        }

        System.out.println(dp[N][M]);
    }
}