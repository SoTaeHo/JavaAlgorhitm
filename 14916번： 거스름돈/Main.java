
/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 14916                             :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: thxogh1 <boj.kr/u/thxogh1>                  +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/14916                          #+#        #+#      #+#    */
/*   Solved: 2025/04/07 11:45:40 by thxogh1       ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] dp = new int[100001];
        dp[1] = -1;
        dp[2] = 1;
        dp[3] = -1;
        dp[4] = 2;
        dp[5] = 1;
        for (int i = 6; i < n + 1; i++) {
            if (dp[i - 2] == -1 && dp[i - 5] == -1) {
                dp[i] = -1;
            } else if (dp[i - 2] == -1) {
                dp[i] = dp[i - 5] + 1;
            } else if (dp[i - 5] == -1) {
                dp[i] = dp[i - 2] + 1;
            } else {
                dp[i] = Math.min(dp[i - 2] + 1, dp[i - 5] + 1);
            }
        }
        System.out.println(dp[n]);
    }
}