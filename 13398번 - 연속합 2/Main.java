
/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 13398                             :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: thxogh1 <boj.kr/u/thxogh1>                  +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/13398                          #+#        #+#      #+#    */
/*   Solved: 2026/03/08 11:19:13 by thxogh1       ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[][] dp = new int[n][2];

        dp[0][0] = arr[0];
        dp[0][1] = arr[0];

        int answer = arr[0];

        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.max(arr[i], dp[i - 1][0] + arr[i]);
            dp[i][1] = Math.max(dp[i - 1][1] + arr[i], dp[i - 1][0]);
            answer = Math.max(answer, Math.max(dp[i][0], dp[i][1]));
        }
        System.out.println(answer);
    }
}