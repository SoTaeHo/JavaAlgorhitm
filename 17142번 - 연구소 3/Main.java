
/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 17142                             :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: thxogh1 <boj.kr/u/thxogh1>                  +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/17142                          #+#        #+#      #+#    */
/*   Solved: 2025/10/23 08:47:32 by thxogh1       ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static class Point {
        int x;
        int y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int bfs() {
        Queue<Point> q = new ArrayDeque<>();

        visited = new int[N][N];
        for (int i = 0; i < N; i++) {
            Arrays.fill(visited[i], -1);
        }
        for (Point p : checked) {
            q.offer(p);
            visited[p.x][p.y] = 0;
        }

        while (!q.isEmpty()) {
            Point p = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];

                if (nx < 0 || nx >= N || ny < 0 || ny >= N) {
                    continue;
                }

                if (graph[nx][ny] == 1) {
                    continue;
                }

                if (visited[nx][ny] != -1) {
                    continue;
                }

                visited[nx][ny] = visited[p.x][p.y] + 1;

                q.offer(new Point(nx, ny));
            }
        }

        int ans = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (graph[i][j] == 0) {
                    if (visited[i][j] == -1) {
                        return Integer.MAX_VALUE;
                    }
                    ans = Math.max(ans, visited[i][j]);
                }
            }
        }
        return ans;
    }

    static void combination(int depth, int cnt) {

        if (cnt == M) {
            int bfsTime = bfs();
            minTime = Math.min(minTime, bfsTime);

            return;
        }

        for (int i = depth; i < li.size(); i++) {
            checked[cnt] = li.get(i);
            combination(i + 1, cnt + 1);
        }
    }

    static int[][] visited;
    static int N, M;
    static List<Point> li;
    static int[][] graph;
    static Point[] checked;
    static int minTime = Integer.MAX_VALUE;
    static int[] dx = { -1, 1, 0, 0 };
    static int[] dy = { 0, 0, -1, 1 };

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        li = new ArrayList<>();
        checked = new Point[M];
        graph = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
                if (graph[i][j] == 2) {
                    li.add(new Point(i, j));
                }
            }
        }
        combination(0, 0);
        System.out.println(minTime == Integer.MAX_VALUE ? -1 : minTime);
    }
}