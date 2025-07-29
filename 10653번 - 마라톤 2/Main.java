
/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 10653                             :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: thxogh1 <boj.kr/u/thxogh1>                  +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/10653                          #+#        #+#      #+#    */
/*   Solved: 2025/07/23 23:28:50 by thxogh1       ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] xPos = new int[n];
        int[] yPos = new int[n];
        int total = 0;
        int[][] dp = new int[500][500];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            xPos[i] = Integer.parseInt(st.nextToken());
            yPos[i] = Integer.parseInt(st.nextToken());

        }

        for (int i = 1; i < n; i++) {
            total += Math.abs(xPos[i] - xPos[i - 1]) + Math.abs(yPos[i] - yPos[i - 1]);
        }

        for (int i = 0; i < n; i++) {
            dp[0][i] = total;
        }

        for (int i = 1; i <= k; i++) {
            for (int j = 1; j < n - 1; j++) {
                for (int l = 1; l < n - 1; l++) {
                    int dist = 
                    dp[i][j] = Math.min(dp[i - 1][l], )
                }
            }
        }
    }
}
