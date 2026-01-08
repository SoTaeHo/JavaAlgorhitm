
/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 2157                              :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: thxogh1 <boj.kr/u/thxogh1>                  +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/2157                           #+#        #+#      #+#    */
/*   Solved: 2026/01/08 13:27:43 by thxogh1       ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static class Node {
        int dest;
        int score;

        Node(int dest, int score) {
            this.dest = dest;
            this.score = score;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        List<Node>[] li = new List[N + 1];

        for (int i = 0; i < N + 1; i++) {
            li[i] = new ArrayList<>();
        }

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int dest = Integer.parseInt(st.nextToken());
            int score = Integer.parseInt(st.nextToken());
            if (start > dest) {
                continue;
            }
            li[start].add(new Node(dest, score));
        }

        int[][] dp = new int[N + 1][M + 1];

        for (int i = 0; i <= N; i++) {
            for (int j = 0; j <= M; j++) {
                dp[i][j] = -1;
            }
        }
        dp[1][1] = 0;

        for (int k = 2; k <= M; k++) {
            for (int i = 1; i < N + 1; i++) {
                if (dp[i][k - 1] == -1) {
                    continue;
                }
                for (int j = 0; j < li[i].size(); j++) {
                    // start = i, dest = li[i].get(j).dest, score = li[i].get(j).score
                    int start = i;
                    int dest = li[i].get(j).dest;
                    int score = li[i].get(j).score;
                    dp[dest][k] = Math.max(dp[dest][k],
                            dp[start][k - 1] + score);
                }
            }
        }

        int ans = 0;
        for (int i = 0; i < M + 1; i++) {
            ans = Math.max(ans, dp[N][i]);
        }
        System.out.println(ans);
    }
}