
/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 3055                              :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: thxogh1 <boj.kr/u/thxogh1>                  +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/3055                           #+#        #+#      #+#    */
/*   Solved: 2025/04/09 15:20:03 by thxogh1       ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int[] dx = { -1, 1, 0, 0 };
    static int[] dy = { 0, 0, -1, 1 };

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        char[][] map = new char[r][c];
        int[][] visited = new int[r][c];
        Point end = null;
        Queue<Point> water1 = new ArrayDeque<>();
        Queue<Point> water2 = new ArrayDeque<>();
        Queue<Point> q1 = new ArrayDeque<>();
        Queue<Point> q2 = new ArrayDeque<>();
        for (int i = 0; i < r; i++) {
            String str = br.readLine();
            for (int j = 0; j < c; j++) {
                map[i][j] = str.charAt(j);

                if (map[i][j] == 'D') {
                    end = new Point(i, j);
                } else if (map[i][j] == 'S') {
                    q1.offer(new Point(i, j));
                    visited[i][j] = 1;
                } else if (map[i][j] == '*') {
                    water1.offer(new Point(i, j));
                }
            }
        }

        int phase = 0;
        while (true) {
            if (phase % 2 == 0) {
                bfs(water1, water2, map, visited, r, c, 1);
                bfs(q1, q2, map, visited, r, c, 0);
                if (q2.isEmpty()) {
                    break;
                }
            } else {
                bfs(water2, water1, map, visited, r, c, 1);
                bfs(q2, q1, map, visited, r, c, 0);
                if (q1.isEmpty()) {
                    break;
                }
            }
            phase++;
        }
        if (visited[end.x][end.y] != 0) {
            System.out.println(visited[end.x][end.y] - 1);
        } else {
            System.out.println("KAKTUS");

        }
    }

    static boolean isValid(int i, int j, int r, int c) {
        return i >= 0 && i < r && j >= 0 && j < c;
    }

    static void bfs(Queue<Point> src, Queue<Point> dest, char[][] map, int[][] visited, int r, int c, int type) {
        while (!src.isEmpty()) {
            Point p = src.poll();

            for (int i = 0; i < 4; i++) {
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];

                if (!isValid(nx, ny, r, c) || map[nx][ny] == 'X' || visited[nx][ny] != 0) {
                    continue;
                }
                if (type == 1 && map[nx][ny] == 'D') {
                    continue;
                }
                if (type == 0 && map[nx][ny] == 'D') {
                    visited[nx][ny] += visited[p.x][p.y] + 1;
                    return;
                }
                visited[nx][ny] += visited[p.x][p.y] + 1;
                dest.offer(new Point(nx, ny));
            }
        }
    }

    static class Point {
        int x;
        int y;

        public Point(int x, int y) {

            this.x = x;
            this.y = y;
        }
    }
}