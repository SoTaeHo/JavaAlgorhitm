
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
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[] parent;
    static int[] rank;

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
        int cnt = bfs(map);
        // 간선 찾기 : 가로
        for (int i = 1; i < n + 1; i++) {
            int start = 1;
            while (start < m) {
                while (start < m + 1 && map[i][start] >= 1) {
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
                    q.offer(new Edge(new Point(i, start - 1, map[i][start - 1]), new Point(i, end, map[i][end]),
                            end - start));
                    start = end;
                }
            }
        }

        for (int i = 1; i < m + 1; i++) { // 간선 찾기 : 세로로
            int start = 1;
            while (start < n) {
                while (start < n + 1 && map[start][i] >= 1) {
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
                    q.offer(new Edge(new Point(start - 1, i, map[start - 1][i]), new Point(end, i, map[end][i]),
                            end - start));
                    start = end;
                }
            }
        }

        int ans = 0;
        parent = new int[cnt + 1];
        rank = new int[cnt + 1];
        for (int i = 1; i < cnt + 1; i++) {
            parent[i] = i;
            rank[i] = 1;
        }
        cnt = 1;
        while (!q.isEmpty()) {
            Edge e = q.poll();

            if (find(e.start.type) != find(e.end.type)) {
                union(e.start.type, e.end.type);
                cnt++;
                ans += e.weight;
            }
        }
        if (cnt != parent.length - 1) {
            System.out.println(-1);
        } else {
            System.out.println(ans);
        }
        // while (!q.isEmpty()) {
        // Edge e = q.poll();
        // if (connected[e.start.type] && connected[e.end.type]) {
        // continue;
        // } else if (e.start.type == e.end.type) {
        // continue;
        // }
        // ans += e.weight;
        // // System.out.printf("(%d, %d)\n", e.start.x, e.start.y);
        // // System.out.printf("(%d, %d)\n", e.end.x, e.end.y);
        // if (e.start.x == e.end.x) {
        // for (int i = e.start.y + 1; i < e.weight + e.start.y + 1; i++) {
        // map[e.start.x][i] = 9;
        // }
        // } else {
        // for (int i = e.start.x + 1; i < e.weight + e.start.x + 1; i++) {
        // map[i][e.start.y] = 8;
        // }
        // }
        // connected[e.start.type] = true;
        // connected[e.end.type] = true;

        // }
        // cnt = bfs(map);
        // System.out.println();
        // for (int i = 1; i < n + 1; i++) {
        // for (int j = 1; j < m + 1; j++) {
        // System.out.print(map[i][j] + " ");
        // }
        // System.out.println();
        // }
        // System.out.println(cnt == 1 ? ans : -1);
    }

    static int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    static void union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);

        if (rootA != rootB) {
            if (rank[rootA] > rank[rootB]) {
                parent[rootB] = rootA;
            } else if (rank[rootB] > rank[rootA]) {
                parent[rootA] = rootB;
            } else {
                parent[rootB] = rootA;
                rank[rootA]++;
            }
        }
    }

    static int bfs(int[][] map) {
        Queue<Point> q = new ArrayDeque<>();
        boolean[][] visisted = new boolean[map.length][map[0].length];
        int[] dx = { -1, 1, 0, 0 };
        int[] dy = { 0, 0, -1, 1 };
        int cnt = 0;
        for (int i = 1; i < map.length - 1; i++) {
            for (int j = 1; j < map[0].length - 1; j++) {
                if (map[i][j] == 0 || visisted[i][j])
                    continue;
                cnt++;
                q.offer(new Point(i, j, map[i][j]));
                visisted[i][j] = true;
                map[i][j] = cnt;

                while (!q.isEmpty()) {
                    Point p = q.poll();
                    for (int k = 0; k < 4; k++) {
                        int nx = p.x + dx[k];
                        int ny = p.y + dy[k];

                        // if (map[nx][ny] == 9 && nx != p.x) { // 가로
                        // continue;
                        // }
                        // if (map[p.x][p.y] == 9 && nx != p.x) {
                        // continue;
                        // }
                        // if (map[nx][ny] == 8 && ny != p.y) { // 세로
                        // continue;
                        // }
                        // if (map[p.x][p.y] == 8 && ny != p.y) {
                        // continue;
                        // }
                        if (map[nx][ny] == 0 || visisted[nx][ny]) {
                            continue;
                        }
                        visisted[nx][ny] = true;
                        map[nx][ny] = cnt;
                        q.offer(new Point(nx, ny, map[nx][ny]));

                        // if (map[nx][ny] == 8 || map[nx][ny] == 9) {
                        // map[nx][ny] = 17;
                        // q.offer(new Point(nx, ny, map[nx][ny]));
                        // } else {
                        // map[nx][ny] = cnt;
                        // q.offer(new Point(nx, ny, map[nx][ny]));
                        // }
                    }
                    // for (int l = 1; l < map.length - 1; l++) {
                    // for (int a = 1; a < map[0].length - 1; a++) {
                    // if (visisted[l][a])

                    // System.out.print(1 + " ");
                    // else
                    // System.out.print(0 + " ");
                    // }
                    // System.out.println();
                    // }
                    // System.out.println();
                }
            }
        }
        return cnt;
    }

    static class Point {
        int x;
        int y;
        int type;

        public Point(int x, int y, int type) {
            this.x = x;
            this.y = y;
            this.type = type;
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
