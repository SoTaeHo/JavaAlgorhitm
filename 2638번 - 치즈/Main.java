
/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 2638                              :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: thxogh1 <boj.kr/u/thxogh1>                  +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/2638                           #+#        #+#      #+#    */
/*   Solved: 2025/11/27 08:53:43 by thxogh1       ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static boolean[][] visited;
    static int[][] graph;
    static int answer = 0;
    static int[] dx = { -1, 1, 0, 0 };
    static int[] dy = { 0, 0, -1, 1 };
    static int N;
    static int M;

    static void dfs(int r, int c) {

        visited[r][c] = true;
        for (int i = 0; i < 4; i++) {
            int nx = r + dx[i];
            int ny = c + dy[i];

            if (nx < 0 || nx >= N || ny < 0 || ny >= M) {
                continue;
            }
            if (graph[nx][ny] == 1) {
                continue;
            }
            if (visited[nx][ny]) {
                continue;
            }
            dfs(nx, ny);
        }
    }

    static boolean check() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (graph[i][j] == 1) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        while (check()) {
            visited = new boolean[N][M];
            dfs(0, 0);
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (graph[i][j] == 0) {
                        continue;
                    }
                    int cnt = 0;
                    for (int k = 0; k < 4; k++) {
                        if (visited[i + dx[k]][j + dy[k]]) {
                            cnt += 1;
                        }
                    }
                    if (cnt >= 2) {
                        graph[i][j] = 0;
                    }
                }
            }
            answer += 1;
        }
        System.out.println(answer);
    }
}