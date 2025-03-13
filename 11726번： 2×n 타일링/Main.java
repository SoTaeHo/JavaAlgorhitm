/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 11726                             :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: thxogh1 <boj.kr/u/thxogh1>                  +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/11726                          #+#        #+#      #+#    */
/*   Solved: 2025/03/12 10:59:57 by thxogh1       ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[1001];

        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= N; i++) {
            dp[i] = (dp[i - 2] + dp[i - 1]) % 10007;
        }
        System.out.println(dp[N]);
    }
}
// n = n-1 + n-2
// 1. |
// 2. =, ||
// 3. |=, =|, |||
// 4. ||=, |=|, =||, ==, ||||
// 5. |||||, |||= * 4, |== * 3 = 8
