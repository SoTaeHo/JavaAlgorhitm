
/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 14466                             :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: thxogh1 <boj.kr/u/thxogh1>                  +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/14466                          #+#        #+#      #+#    */
/*   Solved: 2025/11/27 18:35:00 by thxogh1       ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int N, K, R;
    static boolean[][][] blocked;
    static int[][] cows;

    // 상하좌우
    static int[] dr = { -1, 1, 0, 0 };
    static int[] dc = { 0, 0, -1, 1 };

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        blocked = new boolean[N][N][4];
        cows = new int[K][2];

        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            int r1 = Integer.parseInt(st.nextToken()) - 1;
            int c1 = Integer.parseInt(st.nextToken()) - 1;
            int r2 = Integer.parseInt(st.nextToken()) - 1;
            int c2 = Integer.parseInt(st.nextToken()) - 1;

            addBlocked(r1, c1, r2, c2);
        }

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            cows[i][0] = Integer.parseInt(st.nextToken()) - 1;
            cows[i][1] = Integer.parseInt(st.nextToken()) - 1;
        }

        int answer = 0;

        for (int i = 0; i < K; i++) {
            for (int j = i + 1; j < K; j++) {
                if (!canReach(i, j)) {
                    answer++;
                }
            }
        }

        System.out.println(answer);
    }

    static void addBlocked(int r1, int c1, int r2, int c2) {
        if (r2 == r1 - 1 && c2 == c1) {
            blocked[r1][c1][0] = true;
            blocked[r2][c2][1] = true;
        } else if (r2 == r1 + 1 && c2 == c1) {
            blocked[r1][c1][1] = true;
            blocked[r2][c2][0] = true;
        } else if (r2 == r1 && c2 == c1 - 1) {
            blocked[r1][c1][2] = true;
            blocked[r2][c2][3] = true;
        } else if (r2 == r1 && c2 == c1 + 1) {
            blocked[r1][c1][3] = true;
            blocked[r2][c2][2] = true;
        }
    }

    static boolean canReach(int i, int j) {
        int sr = cows[i][0];
        int sc = cows[i][1];
        int tr = cows[j][0];
        int tc = cows[j][1];

        boolean[][] visited = new boolean[N][N];
        Queue<int[]> q = new ArrayDeque<>();

        q.add(new int[] { sr, sc });
        visited[sr][sc] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int r = cur[0], c = cur[1];

            if (r == tr && c == tc)
                return true;

            for (int d = 0; d < 4; d++) {
                int nr = r + dr[d];
                int nc = c + dc[d];

                if (nr < 0 || nc < 0 || nr >= N || nc >= N)
                    continue;
                if (visited[nr][nc])
                    continue;

                if (blocked[r][c][d])
                    continue;

                visited[nr][nc] = true;
                q.add(new int[] { nr, nc });
            }
        }

        return false;
    }
}