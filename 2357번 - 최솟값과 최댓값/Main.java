/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 2357                              :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: thxogh1 <boj.kr/u/thxogh1>                  +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/2357                           #+#        #+#      #+#    */
/*   Solved: 2025/04/11 20:15:01 by thxogh1       ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static void init(int[][] tree, int[] arr, int node, int s, int e) {
        if (s == e) {
            tree[node][0] = arr[s];
            tree[node][1] = arr[s];
        } else {
            int m = (s + e) / 2;
            init(tree, arr, node * 2, s, m);
            init(tree, arr, node * 2 + 1, m + 1, e);
            tree[node][0] = Math.min(tree[node * 2][0], tree[node * 2 + 1][0]);
            tree[node][1] = Math.max(tree[node * 2][1], tree[node * 2 + 1][1]);
        }
    }

    static int[] query(int[][] tree, int node, int l, int r, int s, int e) {
        if (e < l || r < s) {
            return new int[] { Integer.MAX_VALUE, 0 };
        }
        if (l <= s && e <= r) {
            return tree[node];
        }
        int m = (s + e) / 2;
        int[] left = query(tree, node * 2, l, r, s, m);
        int[] right = query(tree, node * 2 + 1, l, r, m + 1, e);
        return new int[] { Math.min(left[0], right[0]), Math.max(left[1], right[1]) };
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int[][] tree = new int[4 * n][2]; // 0 = minimum, 1 = maximum

        init(tree, arr, 1, 0, n - 1);
        // for (int i = 0; i < 4 * n; i++) {
        // System.out.println(tree[i][0] + " " + tree[i][1]);
        // }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            int[] ans = query(tree, 1, a - 1, b - 1, 0, n - 1);
            sb.append(ans[0]).append(" ").append(ans[1]).append('\n');
        }
        System.out.println(sb);
    }
}