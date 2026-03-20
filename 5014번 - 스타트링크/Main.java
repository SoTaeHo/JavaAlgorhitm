/* ************************************************************************** */
 /*                                                                            */
 /*                                                      :::    :::    :::     */
 /*   Problem Number: 5014                              :+:    :+:      :+:    */
 /*                                                    +:+    +:+        +:+   */
 /*   By: thxogh1 <boj.kr/u/thxogh1>                  +#+    +#+          +#+  */
 /*                                                  +#+      +#+        +#+   */
 /*   https://boj.kr/5014                           #+#        #+#      #+#    */
 /*   Solved: 2026/03/18 23:00:45 by thxogh1       ###          ###   ##.kr    */
 /*                                                                            */
 /* ************************************************************************** */
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int F = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int G = Integer.parseInt(st.nextToken());
        int U = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());

        int[] dist = new int[F + 1];
        Arrays.fill(dist, -1);

        Queue<Integer> q = new LinkedList<>();
        q.add(S);
        dist[S] = 0;

        while (!q.isEmpty()) {
            int now = q.poll();

            if (now == G) {
                System.out.println(dist[now]);
                return;
            }

            int up = now + U;
            int down = now - D;

            if (up <= F && dist[up] == -1) {
                dist[up] = dist[now] + 1;
                q.add(up);
            }

            if (down >= 1 && dist[down] == -1) {
                dist[down] = dist[now] + 1;
                q.add(down);
            }
        }

        System.out.println("use the stairs");
    }
}
