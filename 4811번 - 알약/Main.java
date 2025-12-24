/* ************************************************************************** */
 /*                                                                            */
 /*                                                      :::    :::    :::     */
 /*   Problem Number: 4811                              :+:    :+:      :+:    */
 /*                                                    +:+    +:+        +:+   */
 /*   By: thxogh1 <boj.kr/u/thxogh1>                  +#+    +#+          +#+  */
 /*                                                  +#+      +#+        +#+   */
 /*   https://boj.kr/4811                           #+#        #+#      #+#    */
 /*   Solved: 2025/12/15 22:11:34 by thxogh1       ###          ###   ##.kr    */
 /*                                                                            */
 /* ************************************************************************** */
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long dp[] = new long[31];
        dp[0] = 1;

        for (int n = 1; n <= 30; n++) {
            for (int i = 0; i < n; i++) {
                dp[n] += dp[i] * dp[n - i - 1];
            }
        }

        while (true) {
            int n = Integer.parseInt(br.readLine());
            if (n == 0) {
                break;
            }
            System.out.println(dp[n]);
        }
    }
}
