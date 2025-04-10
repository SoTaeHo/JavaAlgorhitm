
/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 17472                             :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: thxogh1 <boj.kr/u/thxogh1>                  +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/17472                          #+#        #+#      #+#    */
/*   Solved: 2025/04/10 13:49:09 by thxogh1       ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] map = new int[n + 2][m + 2];
        for (int i = 1; i < n + 1; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j < m + 1; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        PriorityQueue<Edge> q = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.weight, o2.weight));
        // 간선 찾기 : 가로
        for (int i = 1; i < n + 1; i++) {
            int start = 1;
            while (start < m) {
                while (start < m + 1 && map[i][start] == 1) {
                    start++;
                }
                int end = start;

                while (end < m + 1 && map[i][end] == 0) {
                    end++;
                }

                if (start - 1 == 0 || end + 1 == 0 || start == m + 1 || end == m + 1) {
                    start = end;
                    continue;
                } else if (end - start == 1) {
                    start = end;
                    continue;
                } else {
                    q.offer(new Edge(new Point(i, start), new Point(i, end), end - start));
                    System.out.printf("i : %d / start : %d, end : %d\n", i, start, end);
                    start = end;
                }
            }
        }
        System.out.println(q.size());

        for (int i = 1; i < m + 1; i++) {
            int start = 1;
            while (start < n) {
                while (start < n + 1 && map[start][i] == 1) {
                    start++;
                }
                int end = start;

                while (end < n + 1 && map[end][i] == 0) {
                    end++;
                }

                if (start - 1 == 0 || end + 1 == 0 || start == n + 1 || end == n + 1) {
                    start = end;
                    continue;
                } else if (end - start == 1) {
                    start = end;
                    continue;
                } else {
                    q.offer(new Edge(new Point(i, start), new Point(i, end), end - start));
                    start = end;
                }
            }
        }
        System.out.println(q.size());
        int ans = 0;
        do {
            System.out.println("bfs");
            Edge e = q.poll();
            ans += e.weight;
            if (e.start.x == e.end.x) { // 가로
                for (int i = e.start.y; i < e.end.y; i++) {
                    map[e.end.x][i] = 2;
                }
            } else {
                for (int i = e.start.x; i < e.end.x; i++) {
                    map[i][e.end.y] = 2;
                }
            }
        } while (!bfs(map));
        System.out.println(ans != 0 ? ans : -1);
    }

    static boolean bfs(int[][] map) {
        Queue<Point> q = new ArrayDeque<>();
        boolean[][] visisted = new boolean[map.length][map[0].length];
        int[] dx = { -1, 1, 0, 0 };
        int[] dy = { 0, 0, -1, 1 };
        boolean check = false;
        for (int i = 1; i < map.length; i++) {
            for (int j = 1; j < map[0].length; j++) {
                if (map[i][j] == 1 && !visisted[i][j]) {
                    System.out.println("check");
                    q.offer(new Point(i, j));
                    visisted[i][j] = true;
                    while (!q.isEmpty()) {
                        Point p = q.poll();

                        for (int k = 0; i < 4; i++) {
                            int nx = p.x + dx[k];
                            int ny = p.y + dy[k];

                            if (map[nx][ny] == 0 || visisted[nx][ny]) {
                                continue;
                            }
                            visisted[nx][ny] = true;
                            q.offer(new Point(nx, ny));
                        }
                    }
                    check = true;
                } else if (check && map[i][j] == 1 && !visisted[i][j]) {
                    return false;
                }

            }
        }
        return true;
    }

    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static class Edge {
        Point start;
        Point end;
        int weight;

        public Edge(Point start, Point end, int weight) {
            this.start = start;
            this.end = end;
            this.weight = weight;
        }
    }
}
