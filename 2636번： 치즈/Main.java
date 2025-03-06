/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 2636                              :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: thxogh1 <boj.kr/u/thxogh1>                  +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/2636                           #+#        #+#      #+#    */
/*   Solved: 2025/03/06 15:29:12 by thxogh1       ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[][] map;
    static boolean[][] visited;
    static int time;
    static int cnt;

    static int[] dx = { -1, 1, 0, 0 };
    static int[] dy = { 0, 0, -1, 1 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        map = new int[R][C];
        int now = 0;
        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < C; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 1) {
                    cnt++;
                }
            }
        }

        Queue<int[]> q = new ArrayDeque<>();
        Queue<int[]> delete = new ArrayDeque<>();
        while (cnt != 0) {
            now = cnt;
            q.offer(new int[] { 0, 0 });
            visited = new boolean[R][C];
            while (!q.isEmpty()) {
                int[] p = q.poll();

                visited[p[0]][p[1]] = true;

                for (int i = 0; i < 4; i++) {
                    int nx = p[0] + dx[i];
                    int ny = p[1] + dy[i];

                    if (nx < 0 || nx >= R || ny < 0 || ny >= C || visited[nx][ny]) {
                        continue;
                    }
                    if (map[nx][ny] == 1) {
                        visited[nx][ny] = true;
                        delete.offer(new int[] { nx, ny });
                        continue;
                    }

                    visited[nx][ny] = true;
                    q.offer(new int[] { nx, ny });
                }

            }

            cnt = delete.size();
            if (cnt == 0)
                break;
            while (!delete.isEmpty()) {
                int[] p = delete.poll();
                map[p[0]][p[1]] = 0;
            }

            time++;
        }
        System.out.printf("%d\n%d", time, now);
    }
}