
/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 2294                              :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: thxogh1 <boj.kr/u/thxogh1>                  +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/2294                           #+#        #+#      #+#    */
/*   Solved: 2025/07/21 08:22:26 by thxogh1       ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] value = new int[n];

        int[] dp = new int[k + 1];
        for (int i = 0; i < n; i++) {
            value[i] = Integer.parseInt(br.readLine());
        }

        Arrays.fill(dp, 100001);
        dp[0] = 0;

        for (int i = 0; i < n; i++) {
            for (int j = value[i]; j < k + 1; j++) {
                dp[j] = Math.min(dp[j], dp[j - value[i]] + 1);
            }
        }
        System.out.println(dp[k] == 100001 ? -1 : dp[k]);
    }
}