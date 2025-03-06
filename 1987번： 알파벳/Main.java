/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 1987                              :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: thxogh1 <boj.kr/u/thxogh1>                  +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/1987                           #+#        #+#      #+#    */
/*   Solved: 2025/03/06 14:33:12 by thxogh1       ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static boolean[] alphabet;
    static boolean[][] visited;
    static char[][] map;
    static int output;

    static int[] dx = { -1, 1, 0, 0 };
    static int[] dy = { 0, 0, -1, 1 };

    static int R;
    static int C;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new char[R][C];
        alphabet = new boolean[26];
        visited = new boolean[R][C];
        for (int i = 0; i < R; i++) {
            String str = br.readLine();
            for (int j = 0; j < C; j++) {
                map[i][j] = str.charAt(j);
            }
        }
        dfs(0, 0, 1);
        System.out.println(output);
    }

    static int temp = 0;

    public static void dfs(int r, int c, int cnt) {
        // System.out.println(++temp);
        // System.out.printf("%d %d\n", r, c);
        // System.out.println(map[r][c]);
        if (output < cnt)
            output = cnt;
        alphabet[map[r][c] - 'A'] = true;
        visited[r][c] = true;

        for (int i = 0; i < 4; i++) {
            int nr = r + dx[i];
            int nc = c + dy[i];
            if (nr < 0 || nr >= R || nc < 0 || nc >= C || alphabet[map[nr][nc] - 'A'] || visited[nr][nc])
                continue;

            dfs(nr, nc, cnt + 1);
            alphabet[map[nr][nc] - 'A'] = false;
            visited[nr][nc] = false;
        }
    }

}