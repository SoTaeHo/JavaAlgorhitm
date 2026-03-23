
/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 2585                              :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: thxogh1 <boj.kr/u/thxogh1>                  +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/2585                           #+#        #+#      #+#    */
/*   Solved: 2026/03/23 14:16:21 by thxogh1       ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */
import java.io.*;
import java.util.*;

public class Main {

    static int n, k;
    static int[] x, y;

    static class Edge {
        int v;
        int k;

        Edge(int v, int k) {
            this.v = v;
            this.k = k;
        }

    }

    static int getDist(int i, int j) {
        return (int) Math.ceil(Math.sqrt(Math.pow(x[i] - x[j], 2) + Math.pow(y[i] - y[j], 2)) / 10);
    }

    static boolean can(int maxDist) {
        Queue<Edge> q = new ArrayDeque<>();
        boolean[] visited = new boolean[n + 2];
        visited[0] = true;
        q.add(new Edge(0, 0));

        while (!q.isEmpty()) {
            Edge e = q.poll();

            if (e.k > k) {
                continue;
            }

            for (int i = 1; i < n + 2; i++) {
                if (visited[i]) {
                    continue;
                }

                if (getDist(i, e.v) <= maxDist) {
                    if (i == n + 1) {
                        return true;
                    }
                    visited[i] = true;
                    q.add(new Edge(i, e.k + 1));
                }
            }
        }
        return false;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        x = new int[n + 2];
        y = new int[n + 2];
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            x[i] = Integer.parseInt(st.nextToken());
            y[i] = Integer.parseInt(st.nextToken());
        }

        x[n + 1] = 10000;
        y[n + 1] = 10000;

        int left = 0, right = 1500;
        int answer = right;
        while (left <= right) {
            int mid = (left + right) / 2;

            if (can(mid)) {
                answer = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        System.out.println(answer);
    }
}