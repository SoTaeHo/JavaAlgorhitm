
/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 2342                              :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: thxogh1 <boj.kr/u/thxogh1>                  +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/2342                           #+#        #+#      #+#    */
/*   Solved: 2026/01/21 17:21:39 by thxogh1       ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int cost(int from, int to) {
        if (from == to)
            return 1;
        if (from == 0)
            return 2;
        if (Math.abs(from - to) == 2)
            return 4;
        return 3;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[][] dp = new int[5][5];
        for (int i = 0; i < 5; i++)
            Arrays.fill(dp[i], Integer.MAX_VALUE);

        dp[0][0] = 0;

        while (true) {
            int next = Integer.parseInt(st.nextToken());
            if (next == 0)
                break;

            int[][] nextDp = new int[5][5];
            for (int i = 0; i < 5; i++) {
                Arrays.fill(nextDp[i], Integer.MAX_VALUE);
            }

            for (int l = 0; l < 5; l++) {
                for (int r = 0; r < 5; r++) {
                    if (dp[l][r] == Integer.MAX_VALUE)
                        continue;

                    nextDp[next][r] = Math.min(
                            nextDp[next][r],
                            dp[l][r] + cost(l, next));

                    nextDp[l][next] = Math.min(
                            nextDp[l][next],
                            dp[l][r] + cost(r, next));
                }
            }
            dp = nextDp;
        }

        int ans = Integer.MAX_VALUE;
        for (int l = 0; l < 5; l++) {
            for (int r = 0; r < 5; r++) {
                ans = Math.min(ans, dp[l][r]);
            }
        }

        System.out.println(ans);
    }
}