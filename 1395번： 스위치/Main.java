/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 1395                              :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: thxogh1 <boj.kr/u/thxogh1>                  +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/1395                           #+#        #+#      #+#    */
/*   Solved: 2025/03/13 16:53:11 by thxogh1       ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static void updateRange(int[] tree, int[] lazy, int node, int s, int e, int l, int r) {
        updateLazy(tree, lazy, node, s, e);
        if (e < l || r < s) {
            return;
        }
        if (l <= s && e <= r) {
            if (lazy[node] != 0) {
                tree[node] += (e - s + 1);
                if (s != e) {
                    // 딸깍 횟수 +1
                    lazy[node * 2] += 1;
                    lazy[node * 2 + 1] += 1;
                }
                lazy[node] = 0;
            }
            return;
        }
        int m = (s + e) / 2;
        updateRange(tree, lazy, node * 2, s, m, l, r);
        updateRange(tree, lazy, node * 2 + 1, m + 1, e, l, r);
        tree[node] = tree[node * 2] + tree[node * 2 + 1];
    }

    static int query(int[] tree, int node, int s, int e, int l, int r) {
        if (e < l || r < s) {
            return 0;
        }
        if (l <= s && e <= r) {]
            return 
        }
    }

    static void updateLazy(int[] tree, int[] lazy, int node, int s, int e) {
        if (lazy[node] != 0) {
            tree[node] += (e - s + 1) * lazy[node];
            if (s != e) {
                // 딸깍 횟수 +1
                lazy[node * 2] += 1;
                lazy[node * 2 + 1] += 1;
            }
            lazy[node] = 0;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] arr = new int[N + 1];
        int[] tree = new int[4 * (N + 1)];
        int[] lazy = new int[4 * (N + 1)];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int O = Integer.parseInt(st.nextToken());

            if (O == 1) {
                int S = Integer.parseInt(st.nextToken());
                int T = Integer.parseInt(st.nextToken());

                query();
            } else {
                int S = Integer.parseInt(st.nextToken());
                int T = Integer.parseInt(st.nextToken());

                update();
            }
        }

    }
}