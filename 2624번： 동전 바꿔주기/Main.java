
/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 2624                              :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: thxogh1 <boj.kr/u/thxogh1>                  +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/2624                           #+#        #+#      #+#    */
/*   Solved: 2025/04/07 11:54:34 by thxogh1       ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());

        int[][] coin = new int[k][2];
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            coin[i][0] = Integer.parseInt(st.nextToken());
            coin[i][1] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[t + 1];
        dp[0] = 1;
        Arrays.sort(coin, Comparator.comparingInt((int[] a) -> a[0]).reversed());
        for (int i = 0; i < k; i++) {
            for (int j = t; j >= 0; j--) {
                for (int l = 1; l <= coin[i][1]; l++) {
                    if (coin[i][0] * l <= j) {
                        dp[j] += dp[j - coin[i][0] * l];
                    }
                }
            }
            // System.out.println(Arrays.toString(dp));
        }
        System.out.println(dp[t]);
    }
}