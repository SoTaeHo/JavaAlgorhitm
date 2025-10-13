
/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 16946                             :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: thxogh1 <boj.kr/u/thxogh1>                  +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/16946                          #+#        #+#      #+#    */
/*   Solved: 2025/10/10 08:32:19 by thxogh1       ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

    static int[] dx = { -1, 1, 0, 0 };
    static int[] dy = { 0, 0, -1, 1 };

    static class Point {
        int x;
        int y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int CELL_COUNT = 0;
    static int N;
    static int M;
    static boolean[][] visited;

    static void bfs(int[][] arr, int[][] groupId, int idx, int r, int c) {
        Queue<Point> q = new ArrayDeque<>();

        q.offer(new Point(r, c));
        visited[r][c] = true;
        groupId[r][c] = idx;
        CELL_COUNT += 1;
        while (!q.isEmpty()) {
            Point now = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];

                if (nx >= N || nx < 0 || ny >= M || ny < 0) {
                    continue;
                }

                if (visited[nx][ny]) {
                    continue;
                }

                if (arr[nx][ny] != 0) {
                    continue;
                }
                q.offer(new Point(nx, ny));
                visited[nx][ny] = true;
                groupId[nx][ny] = idx;
                CELL_COUNT += 1;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int[][] arr = new int[N][M];
        int[][] groupId = new int[N][M];
        visited = new boolean[N][M];
        List<Integer> value = new ArrayList<>();

        int idx = 0;

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                arr[i][j] = str.charAt(j) - '0';
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (arr[i][j] == 0 && !visited[i][j]) {
                    bfs(arr, groupId, idx++, i, j);
                    value.add(CELL_COUNT);
                    CELL_COUNT = 0;
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (arr[i][j] == 1) {
                    Set<Integer> isChecked = new HashSet<>();
                    for (int k = 0; k < 4; k++) {
                        int nx = i + dx[k];
                        int ny = j + dy[k];

                        if (nx >= N || nx < 0 || ny >= M || ny < 0) {
                            continue;
                        }
                        if (arr[nx][ny] != 0) {
                            continue;
                        }
                        if (isChecked.contains(groupId[nx][ny])) {
                            continue;
                        }
                        arr[i][j] += value.get(groupId[nx][ny]);
                        isChecked.add(groupId[nx][ny]);
                    }
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                sb.append(arr[i][j] % 10);
            }
            sb.append('\n');
        }
        System.out.println(sb);
        // System.out.println(value);
    }
}