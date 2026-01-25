
/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 2637                              :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: thxogh1 <boj.kr/u/thxogh1>                  +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/2637                           #+#        #+#      #+#    */
/*   Solved: 2026/01/25 16:41:53 by thxogh1       ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static class Edge {
        int v, w;

        Edge(int v, int w) {
            this.v = v;
            this.w = w;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        int[][] graph = new int[N + 1][N + 1];
        int[] indegree = new int[N + 1];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int X = Integer.parseInt(st.nextToken());
            int Y = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            // X를 만드는데 Y가 K개 필요
            graph[X][Y] = K;
            indegree[X] += 1;
        }

        int[][] dp = new int[N + 1][N + 1];

        Queue<Integer> q = new ArrayDeque<>();

        for (int i = 1; i < N + 1; i++) {
            if (indegree[i] == 0) {
                q.add(i);
                dp[i][i] = 1;
            }
        }

        while (!q.isEmpty()) {
            int cur = q.poll();

            for (int i = 1; i < N + 1; i++) {
                if (graph[i][cur] > 0) {
                    int k = graph[i][cur];

                    for (int j = 1; j < N + 1; j++) {
                        dp[i][j] += dp[cur][j] * k;
                    }

                    if (--indegree[i] == 0) {
                        q.add(i);
                    }
                }
            }
        }
        for (int i = 1; i <= N; i++) {
            if (dp[N][i] > 0) {
                System.out.println(i + " " + dp[N][i]);
            }
        }

    }
}