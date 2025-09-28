
/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 9657                              :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: thxogh1 <boj.kr/u/thxogh1>                  +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/9657                           #+#        #+#      #+#    */
/*   Solved: 2025/09/29 08:01:31 by thxogh1       ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] dp = new int[n + 1];

        if (n >= 1)
            dp[1] = 1;
        if (n >= 2)
            dp[2] = 2;
        if (n >= 3)
            dp[3] = 1;
        if (n >= 4)
            dp[4] = 1;

        for (int i = 5; i < n + 1; i++) {
            if (dp[i - 1] != 1 || dp[i - 3] != 1 || dp[i - 4] != 1) {
                dp[i] = 1;
            } else {
                dp[i] = 2;
            }
        }

        if (dp[n] == 1) {
            System.out.println("SK");
        } else if (dp[n] == 2) {
            System.out.println("CY");
        }
    }
}