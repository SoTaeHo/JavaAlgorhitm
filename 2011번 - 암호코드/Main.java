
/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 2011                              :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: thxogh1 <boj.kr/u/thxogh1>                  +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/2011                           #+#        #+#      #+#    */
/*   Solved: 2026/01/07 16:49:04 by thxogh1       ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        if (str.charAt(0) == '0') {
            System.out.println(0);
            return;
        }

        int[] dp = new int[str.length() + 1];

        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i < str.length() + 1; i++) {
            int one = str.charAt(i - 1) - '0';
            int two = (str.charAt(i - 2) - '0') * 10 + one;

            if (one >= 1 && one <= 9) {
                dp[i] = dp[i - 1];
            }

            if (two >= 10 && two <= 26) {
                dp[i] = (dp[i] + dp[i - 2]) % 1000000;

            }
        }
        System.out.println(dp[str.length()] % 1000000);
    }
}