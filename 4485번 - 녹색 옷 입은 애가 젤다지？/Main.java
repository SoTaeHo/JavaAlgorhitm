
/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 4485                              :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: thxogh1 <boj.kr/u/thxogh1>                  +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/4485                           #+#        #+#      #+#    */
/*   Solved: 2025/08/26 09:04:58 by thxogh1       ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static class Edge implements Comparable<Edge> {
        int x;
        int y;
        int weight;

        public Edge(int x, int y, int weight) {
            this.x = x;
            this.y = y;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) {
            return Integer.compare(this.weight, o.weight);
        }
    }

    static int[] dx = { -1, 1, 0, 0 };
    static int[] dy = { 0, 0, -1, 1 };

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int idx = 1;
        while (n != 0) {
            int[][] matrix = new int[n][n];
            int[][] dist = new int[n][n];

            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            PriorityQueue<Edge> pq = new PriorityQueue<>();
            for (int i = 0; i < n; i++) {
                Arrays.fill(dist[i], Integer.MAX_VALUE);
            }
            dist[0][0] = matrix[0][0];
            pq.offer(new Edge(0, 0, dist[0][0]));

            while (!pq.isEmpty()) {
                Edge now = pq.poll();

                if (now.weight > dist[now.x][now.y])
                    continue;

                for (int i = 0; i < 4; i++) {
                    int nx = now.x + dx[i];
                    int ny = now.y + dy[i];

                    if (nx >= n || nx < 0 || ny >= n || ny < 0) {
                        continue;
                    }

                    if (dist[nx][ny] > dist[now.x][now.y] + matrix[nx][ny]) {
                        dist[nx][ny] = dist[now.x][now.y] + matrix[nx][ny];
                        pq.offer(new Edge(nx, ny, dist[nx][ny]));
                    }
                }
            }
            System.out.println("Problem " + (idx++) + ": " + dist[n - 1][n - 1]);
            n = Integer.parseInt(br.readLine());
        }
    }
}