
/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 14442                             :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: thxogh1 <boj.kr/u/thxogh1>                  +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/14442                          #+#        #+#      #+#    */
/*   Solved: 2026/04/02 16:47:51 by thxogh1       ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */
import java.io.*;
import java.util.*;

public class Main {

    static int N, M, K;
    static int[][] graph;
    static boolean[][][] visited;
    static int[] dx = { -1, 1, 0, 0 };
    static int[] dy = { 0, 0, -1, 1 };

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        graph = new int[N + 1][M + 1];
        visited = new boolean[N + 1][M + 1][K + 1];

        for (int i = 1; i < N + 1; i++) {
            String str = br.readLine();
            for (int j = 1; j < M + 1; j++) {
                graph[i][j] = str.charAt(j - 1) - '0';
            }
        }

        System.out.println(bfs());
    }

    static class State {
        int x;
        int y;
        int cnt;
        int w;

        State(int x, int y, int cnt, int w) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
            this.w = w;
        }
    }

    static int bfs() {
        Queue<State> q = new ArrayDeque<>();

        q.add(new State(1, 1, 0, 0));

        visited[1][1][0] = true;

        while (!q.isEmpty()) {
            State next = q.poll();

            if (next.x == N && next.y == M) {
                return next.w + 1;
            }

            for (int i = 0; i < 4; i++) {
                int nx = next.x + dx[i];
                int ny = next.y + dy[i];

                if (nx < 1 || nx >= N + 1 || ny < 1 || ny >= M + 1) {
                    continue;
                }

                if (visited[nx][ny][next.cnt]) {
                    continue;
                }

                if (graph[nx][ny] == 1) {
                    if (next.cnt < K && !visited[nx][ny][next.cnt + 1]) {
                        visited[nx][ny][next.cnt + 1] = true;
                        q.add(new State(nx, ny, next.cnt + 1, next.w + 1));
                    }
                } else if (graph[nx][ny] == 0) {
                    visited[nx][ny][next.cnt] = true;
                    q.add(new State(nx, ny, next.cnt, next.w + 1));
                }
            }
        }
        return -1;
    }
}