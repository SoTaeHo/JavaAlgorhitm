
/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 2186                              :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: thxogh1 <boj.kr/u/thxogh1>                  +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/2186                           #+#        #+#      #+#    */
/*   Solved: 2025/12/31 11:26:22 by thxogh1       ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int N, M, K;
    static int[] dx = { -1, 1, 0, 0 };
    static int[] dy = { 0, 0, -1, 1 };
    static String example;
    static int ans = 0;
    static char[][] graph;
    static int[][][] dp;

    static int dfs(int x, int y, int idx) {

        if (idx == example.length()) {
            return 1;
        }

        if (dp[x][y][idx] != -1) {
            return dp[x][y][idx];
        }

        int temp = 0;
        for (int i = 0; i < 4; i++) {
            for (int j = 1; j <= K; j++) {
                int nx = x + dx[i] * j;
                int ny = y + dy[i] * j;

                if (nx >= N || nx < 0 || ny >= M || ny < 0) {
                    continue;
                }

                if (graph[nx][ny] != example.charAt(idx)) {
                    continue;
                }

                temp += dfs(nx, ny, idx + 1);
            }
        }
        dp[x][y][idx] = temp;
        return dp[x][y][idx];
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        graph = new char[N][M];

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                graph[i][j] = str.charAt(j);
            }
        }
        example = br.readLine();
        dp = new int[N][M][example.length()];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (graph[i][j] == example.charAt(0)) {
                    ans += dfs(i, j, 1);
                }
            }
        }

        System.out.println(ans);
    }
}