
/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 1103                              :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: thxogh1 <boj.kr/u/thxogh1>                  +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/1103                           #+#        #+#      #+#    */
/*   Solved: 2025/12/16 12:55:20 by thxogh1       ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int M;
    static int[] dx = { -1, 1, 0, 0 };
    static int[] dy = { 0, 0, -1, 1 };

    static int[][] graph;
    static int[][] dp;
    static boolean[][] visited;
    static boolean cycle = false;

    static int dfs(int x, int y) {

        if (dp[x][y] != 0) {
            return dp[x][y];
        }

        dp[x][y] = 1;
        visited[x][y] = true;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i] * graph[x][y];
            int ny = y + dy[i] * graph[x][y];

            if (nx < 0 || nx >= N || ny < 0 || ny >= M) {
                continue;
            }

            if (graph[nx][ny] == -1) {
                continue;
            }

            if (visited[nx][ny]) {
                cycle = true;
                return 0;
            }

            dp[x][y] = Math.max(dp[x][y], dfs(nx, ny) + 1);
        }

        visited[x][y] = false;
        return dp[x][y];
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new int[N][M];
        dp = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                if (str.charAt(j) == 'H') {
                    graph[i][j] = -1;
                } else {
                    graph[i][j] = str.charAt(j) - '0';
                }
            }
        }

        dfs(0, 0);

        if (cycle) {
            System.out.println(-1);
            return;
        }

        int ans = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                ans = Math.max(ans, dp[i][j]);
            }
        }
        System.out.println(ans);
    }

}