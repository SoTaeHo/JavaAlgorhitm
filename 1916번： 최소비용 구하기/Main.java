// /* ************************************************************************** */
// /*                                                                            */
// /*                                                      :::    :::    :::     */
// /*   Problem Number: 1916                              :+:    :+:      :+:    */
// /*                                                    +:+    +:+        +:+   */
// /*   By: thxogh1 <boj.kr/u/thxogh1>                  +#+    +#+          +#+  */
// /*                                                  +#+      +#+        +#+   */
// /*   https://boj.kr/1916                           #+#        #+#      #+#    */
// /*   Solved: 2025/02/26 10:56:41 by thxogh1       ###          ###   ##.kr    */
// /*                                                                            */
// /* ************************************************************************** */

import java.io.*;
import java.util.*;

public class Main {
    static int[][] map;
    static long[] d;
    static boolean[] visited;
    static Queue<Integer> q = new ArrayDeque<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        map = new int[n + 1][n + 1];
        d = new long[n + 1];
        visited = new boolean[n + 1];
        Arrays.fill(d, 2147483647);
        for (int i = 0; i < n + 1; i++) {
            Arrays.fill(map[i], Integer.MAX_VALUE);
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int val = Integer.parseInt(st.nextToken());
            if (map[r][c] > val)
                map[r][c] = val;
        }
        // for (int i = 1; i <= n; i++) {
        // for (int j = 1; j <= n; j++) {
        // System.out.print(map[i][j] + " ");
        // }
        // System.out.println();
        // }
        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        d[start] = 0;
        // 2. 출발 노드 저장
        q.add(start);
        int now = 0;
        while (!q.isEmpty()) {

            // 현재 노드 저장
            now = q.poll();

            // System.out.println("idx : " + now);
            // System.out.println(Arrays.toString(d));
            // 현재 노드를 순회하면서 거리 갱신

            for (int i = 1; i <= n; i++) {
                if (!visited[i] && map[now][i] != -1) {
                    d[i] = Math.min(d[i], d[now] + map[now][i]);
                    // sb.append(i + " / d[i] : " + d[i]).append('\n');
                    // sb.append(i + " / d[now] : " + d[now] + map[now][i]).append('\n');
                }
            }
            visited[now] = true;

            long minNum = Long.MAX_VALUE;
            int idx = -1;
            for (int i = 1; i <= n; i++) {

                if (!visited[i] && minNum > d[i] && map[now][i] != -1) {
                    minNum = d[i];
                    idx = i;
                }
            }
            if (idx != -1)
                q.add(idx);

        }
        System.out.println(d[end]);
    }
}