
/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 1912                              :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: thxogh1 <boj.kr/u/thxogh1>                  +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/1912                           #+#        #+#      #+#    */
/*   Solved: 2025/07/28 08:44:30 by thxogh1       ###          ###   ##.kr    */
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
        st = new StringTokenizer(br.readLine());

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[n];
        int ans = arr[0];
        dp[0] = arr[0];
        for (int i = 1; i < n; i++) {
            dp[i] = Math.max(arr[i], dp[i - 1] + arr[i]);
            ans = Math.max(ans, dp[i]);
        }
        System.out.println(ans);
    }
}