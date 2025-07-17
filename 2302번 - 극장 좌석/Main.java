/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 2302                              :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: thxogh1 <boj.kr/u/thxogh1>                  +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/2302                           #+#        #+#      #+#    */
/*   Solved: 2025/07/17 08:35:22 by thxogh1       ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < m; i++) {
            set.add(Integer.parseInt(br.readLine()));
        }

        int[] dp = new int[41];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;

        for (int i = 4; i < n + 1; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        int cnt = 0;
        int ans = 1;
        for (int i = 1; i < n + 1; i++) {
            if (set.contains(i)) {
                ans *= dp[cnt];
                cnt = 0;
                continue;
            }
            cnt++;
        }
        if (m == 0) {
            System.out.println(dp[cnt]);
        } else {
            System.out.println(ans * dp[cnt]);
        }
    }
}

// 12345

// 21345
// 13245
// 12435
// 12354

// 13254
// 21435
// 21354

// 2개 : 2
// 3개 : 3
// 4개 : 5
// 5개 : 8