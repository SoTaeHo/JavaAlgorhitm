/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 12844                             :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: thxogh1 <boj.kr/u/thxogh1>                  +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/12844                          #+#        #+#      #+#    */
/*   Solved: 2025/03/14 09:52:25 by thxogh1       ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static void init(int[] tree, int[] arr, int node, int s, int e) {
        if (s == e) {
            tree[node] = arr[s];
        } else {
            int m = (s + e) / 2;
            init(tree, arr, node * 2, s, m);
            init(tree, arr, node * 2 + 1, m + 1, e);
            tree[node] = tree[node * 2] ^ tree[node * 2 + 1];
        }
    }

    static void updateLazy(int[] tree, int[] lazy, int node, int s, int e) {
        if (lazy[node] != 0) {
            if ((e - s + 1) % 2 == 1) {
                tree[node] = tree[node] ^ lazy[node];
            }
            if (s != e) {
                lazy[node * 2] ^= lazy[node];
                lazy[node * 2 + 1] ^= lazy[node];
            }
            lazy[node] = 0;
        }
    }

    static void updateRange(int[] tree, int[] lazy, int node, int s, int e, int l, int r, int operand) {
        updateLazy(tree, lazy, node, s, e);

        if (e < l || r < s)
            return;
        if (l <= s && e <= r) {
            if ((e - s + 1) % 2 == 1) {
                tree[node] = tree[node] ^ operand;
            }
            if (s != e) {
                lazy[node * 2] ^= operand;
                lazy[node * 2 + 1] ^= operand;
            }
            return;
        }
        int m = (s + e) / 2;
        updateRange(tree, lazy, node * 2, s, m, l, r, operand);
        updateRange(tree, lazy, node * 2 + 1, m + 1, e, l, r, operand);
        tree[node] = tree[node * 2] ^ tree[node * 2 + 1];
    }

    static int query(int[] tree, int[] lazy, int node, int s, int e, int l, int r) {
        updateLazy(tree, lazy, node, s, e);
        if (e < l || r < s)
            return 0;
        if (l <= s && e <= r) {
            return tree[node];
        }

        // System.out.printf("query's node : %d\n", node);
        int m = (s + e) / 2;
        int lxor = query(tree, lazy, node * 2, s, m, l, r);
        int rxor = query(tree, lazy, node * 2 + 1, m + 1, e, l, r);
        return lxor ^ rxor;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int M = Integer.parseInt(br.readLine());

        int h = (int) Math.ceil(Math.log(N) / Math.log(2));
        int treeSize = (1 << (h + 1));
        int[] tree = new int[treeSize];
        int[] lazy = new int[treeSize];

        init(tree, arr, 1, 0, N - 1);

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int type = Integer.parseInt(st.nextToken());
            if (type == 1) {
                int left = Integer.parseInt(st.nextToken());
                int right = Integer.parseInt(st.nextToken());
                int operand = Integer.parseInt(st.nextToken());
                updateRange(tree, lazy, 1, 0, N - 1, left, right, operand);
            } else {
                int left = Integer.parseInt(st.nextToken());
                int right = Integer.parseInt(st.nextToken());
                System.out.println(query(tree, lazy, 1, 0, N - 1, left, right));
            }
        }
        br.close();
    }
}