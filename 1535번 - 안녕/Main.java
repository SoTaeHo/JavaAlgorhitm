
/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 1535                              :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: thxogh1 <boj.kr/u/thxogh1>                  +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/1535                           #+#        #+#      #+#    */
/*   Solved: 2025/04/07 16:29:24 by thxogh1       ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        int[] hp = new int[n];
        int[] joy = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            hp[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            joy[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[101];
        for (int i = 0; i < n; i++) {
            for (int w = 100; w > hp[i]; w--) {
                dp[w] = Math.max(dp[w], dp[w - hp[i]] + joy[i]);
            }
        }
        System.out.println(dp[100]);
    }
}