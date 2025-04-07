/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 12920                             :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: thxogh1 <boj.kr/u/thxogh1>                  +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/12920                          #+#        #+#      #+#    */
/*   Solved: 2025/04/07 23:22:42 by thxogh1       ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        List<Integer> weight = new ArrayList<>();
        List<Integer> value = new ArrayList<>();
        int[] dp = new int[m + 1];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            for (int j = k; j > 0; j >>= 1) {
                int temp = j - (j >> 1);
                weight.add(v * temp);
                value.add(c * temp);
            }
        }

        for (int i = 0; i < weight.size(); i++) {
            for (int w = m; w >= weight.get(i); w--) {
                dp[w] = Math.max(dp[w], dp[w - weight.get(i)] + value.get(i));
            }
        }
        System.out.println(dp[m]);
    }
}