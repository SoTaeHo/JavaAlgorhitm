
/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 17404                             :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: thxogh1 <boj.kr/u/thxogh1>                  +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/17404                          #+#        #+#      #+#    */
/*   Solved: 2025/05/06 02:09:21 by thxogh1       ###          ###   ##.kr    */
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

        int[][] arr = new int[n + 2][3];
        int[][] dp = new int[n + 2][3];
        for (int i = 1; i < n + 1; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int g = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            arr[i][0] = r;
            arr[i][1] = g;
            arr[i][2] = b;
        }
        int ans = Integer.MAX_VALUE;
        for (int k = 0; k < 3; k++) {
            for (int i = 0; i < 3; i++) {
                if (k == i)
                    dp[1][i] = arr[1][i];
                else
                    dp[1][i] = 1001;
            }

            for (int i = 2; i < n + 1; i++) {
                dp[i][0] = arr[i][0] + Math.min(dp[i - 1][1], dp[i - 1][2]);
                dp[i][1] = arr[i][1] + Math.min(dp[i - 1][0], dp[i - 1][2]);
                dp[i][2] = arr[i][2] + Math.min(dp[i - 1][0], dp[i - 1][1]);
            }

            for (int i = 0; i < 3; i++) {
                if (i != k)
                    ans = Math.min(ans, dp[n][i]);
            }
        }
        System.out.println(ans);

    }
}
