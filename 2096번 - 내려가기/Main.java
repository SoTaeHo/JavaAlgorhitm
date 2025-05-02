
/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 2096                              :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: thxogh1 <boj.kr/u/thxogh1>                  +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/2096                           #+#        #+#      #+#    */
/*   Solved: 2025/05/02 18:36:13 by thxogh1       ###          ###   ##.kr    */
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
        int[][] arr = new int[n][3];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
            arr[i][2] = Integer.parseInt(st.nextToken());

        }
        int[][][] dp = new int[n][3][2];
        dp[0][0][0] = arr[0][0];
        dp[0][1][0] = arr[0][1];
        dp[0][2][0] = arr[0][2];
        dp[0][0][1] = arr[0][0];
        dp[0][1][1] = arr[0][1];
        dp[0][2][1] = arr[0][2];
        for (int i = 1; i < n; i++) {
            dp[i][0][0] = arr[i][0] + Math.max(dp[i - 1][0][0], dp[i - 1][1][0]);
            dp[i][1][0] = arr[i][1] + Math.max(Math.max(dp[i - 1][0][0], dp[i - 1][1][0]), dp[i - 1][2][0]);
            dp[i][2][0] = arr[i][2] + Math.max(dp[i - 1][1][0], dp[i - 1][2][0]);

            dp[i][0][1] = arr[i][0] + Math.min(dp[i - 1][0][1], dp[i - 1][1][1]);
            dp[i][1][1] = arr[i][1] + Math.min(Math.min(dp[i - 1][0][1], dp[i - 1][1][1]), dp[i - 1][2][1]);
            dp[i][2][1] = arr[i][2] + Math.min(dp[i - 1][1][1], dp[i - 1][2][1]);
        }
        // System.out.println(dp[n - 1][0][0] + " " + dp[n - 1][1][0] + " " + dp[n -
        // 1][2][0] + " ");
        // System.out.println(dp[n - 1][0][1] + " " + dp[n - 1][1][1] + " " + dp[n -
        // 1][2][1] + " ");
        System.out.print(Math.max(Math.max(dp[n - 1][0][0], dp[n - 1][1][0]), dp[n - 1][2][0]) + " ");
        System.out.print(Math.min(Math.min(dp[n - 1][0][1], dp[n - 1][1][1]), dp[n - 1][2][1]));

    }
}