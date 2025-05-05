
/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 16236                             :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: thxogh1 <boj.kr/u/thxogh1>                  +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/16236                          #+#        #+#      #+#    */
/*   Solved: 2025/05/05 17:35:25 by thxogh1       ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[][] map;
    static int size = 2;
    static int sizeCnt = 0;
    static int time = 0;
    static int[] dx = { -1, 1, 0, 0 };
    static int[] dy = { 0, 0, -1, 1 };
    static int[][] visited;
    static Point now;
    static int n;

    static class Point {
        int x, y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static boolean bfs() {
        Queue<Point> q = new ArrayDeque<>();
        List<Point> fish = new ArrayList<>();
        q.offer(now);
        while (!q.isEmpty()) {
            Point p = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];

                if (nx < 0 || nx >= n || ny < 0 || ny >= n) {
                    continue;
                }
                if (visited[nx][ny] != 0) {
                    continue;
                }
                if (map[nx][ny] > size) {
                    continue;
                }
                visited[nx][ny] = visited[p.x][p.y] + 1;
                Point next = new Point(nx, ny);
                if (map[nx][ny] < size && map[nx][ny] != 0) {
                    fish.add(next);
                }
                q.offer(next);
            }
        }

        if (fish.size() == 0) {
            return false;
        } else {
            int minLength = Integer.MAX_VALUE;
            int minX = 0;
            int minY = 0;
            for (int i = 0; i < fish.size(); i++) {
                // int length = Math.abs(now.x - fish.get(i).x) + Math.abs(now.y -
                // fish.get(i).y);
                int length = visited[fish.get(i).x][fish.get(i).y];
                if (minLength > length) {
                    minLength = length;
                    minX = fish.get(i).x;
                    minY = fish.get(i).y;
                } else if (minLength == length) {
                    if (minX > fish.get(i).x) {
                        minX = fish.get(i).x;
                        minY = fish.get(i).y;
                    } else if (minX == fish.get(i).x && minY > fish.get(i).y) {
                        minX = fish.get(i).x;
                        minY = fish.get(i).y;
                    }
                }
            }
            map[now.x][now.y] = 0;
            now = new Point(minX, minY);
            time += visited[minX][minY] - 1;
            sizeCnt += 1;
            if (size == sizeCnt) {
                size += 1;
                sizeCnt = 0;
            }
            map[minX][minY] = 9;
        }
        return true;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 9) {
                    now = new Point(i, j);
                }
            }
        }
        boolean help = true;
        while (help) {
            visited = new int[n][n];
            visited[now.x][now.y] = 1;
            help = bfs();

            // for (int j = 0; j < n; j++) {
            // for (int k = 0; k < n; k++) {
            // System.out.print(map[j][k] + " ");
            // }
            // System.out.println();
            // }
            // System.out.println(time);
            // System.out.println();
        }
        System.out.println(time);
    }
}
