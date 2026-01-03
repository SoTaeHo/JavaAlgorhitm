
/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 14939                             :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: thxogh1 <boj.kr/u/thxogh1>                  +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/14939                          #+#        #+#      #+#    */
/*   Solved: 2026/01/03 15:40:18 by thxogh1       ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static final int[] dx = { 0, 0, 0, -1, 1 };
    static final int[] dy = { 0, -1, 1, 0, 0 };

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        boolean[][] graph = new boolean[10][10];
        for (int i = 0; i < 10; i++) {
            String str = br.readLine();
            for (int j = 0; j < 10; j++) {
                if (str.charAt(j) == '#') {
                    graph[i][j] = false;
                } else {
                    graph[i][j] = true;
                }
            }
        }

        int ans = Integer.MAX_VALUE;
        for (int mask = 0; mask < (1 << 10); mask++) {
            boolean[][] board = copy(graph);
            int cnt = 0;
            for (int j = 0; j < 10; j++) {
                if ((mask & (1 << j)) != 0) {
                    toggle(board, 0, j);
                    cnt++;
                }
            }

            for (int i = 1; i < 10; i++) {
                for (int j = 0; j < 10; j++) {
                    if (board[i - 1][j]) {
                        toggle(board, i, j);
                        cnt++;
                    }
                }
            }

            boolean ok = true;
            for (int i = 0; i < 10; i++) {
                for (int j = 0; j < 10; j++) {
                    if (board[i][j]) {
                        ok = false;
                        break;
                    }
                }
            }

            if (ok) {
                ans = Math.min(ans, cnt);
            }
        }
        System.out.println(ans == Integer.MAX_VALUE ? -1 : ans);
    }

    static boolean[][] copy(boolean[][] graph) {
        boolean[][] dst = new boolean[10][10];
        for (int i = 0; i < 10; i++) {
            System.arraycopy(graph[i], 0, dst[i], 0, 10);
        }
        return dst;
    }

    static void toggle(boolean[][] board, int x, int y) {
        for (int i = 0; i < 5; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 10 || nx < 0 || ny >= 10 || ny < 0) {
                continue;
            }

            board[nx][ny] = !board[nx][ny];
        }
    }
}