
/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 14438                             :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: thxogh1 <boj.kr/u/thxogh1>                  +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/14438                          #+#        #+#      #+#    */
/*   Solved: 2025/05/06 22:07:15 by thxogh1       ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static void init(int[] arr, int[] tree, int node, int s, int e) {
        if (s == e) {
            tree[node] = arr[s];
        } else {
            int m = (s + e) / 2;
            init(arr, tree, node * 2, s, m);
            init(arr, tree, node * 2 + 1, m + 1, e);
            tree[node] = Math.min(tree[node * 2], tree[node * 2 + 1]);
        }
    }

    static void update(int[] arr, int[] tree, int node, int s, int e, int idx, int val) {
        if (e < idx || idx < s) {
            return;
        }
        if (s == e) {

            tree[node] = val;
            return;
        }
        int m = (s + e) / 2;
        update(arr, tree, node * 2, s, m, idx, val);
        update(arr, tree, node * 2 + 1, m + 1, e, idx, val);
        tree[node] = Math.min(tree[node * 2], tree[node * 2 + 1]);

    }

    static int query(int[] tree, int node, int s, int e, int l, int r) {
        if (e < l || r < s) {
            return 1000000001;
        }
        if (l <= s && e <= r) {
            return tree[node];
        }
        int m = (s + e) / 2;
        int lmin = query(tree, node * 2, s, m, l, r);
        int rmin = query(tree, node * 2 + 1, m + 1, e, l, r);
        return Math.min(lmin, rmin);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        st = new StringToken    izer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int m = Integer.parseInt(br.readLine());
        int[] tree = new int[4 * n];
        init(arr, tree, 1, 0, n - 1);
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int type = Integer.parseInt(st.nextToken());
            if (type == 1) {
                int idx = Integer.parseInt(st.nextToken());
                int val = Integer.parseInt(st.nextToken());
                update(arr, tree, 1, 0, n - 1, idx - 1, val);
            } else {
                int s = Integer.parseInt(st.nextToken());
                int e = Integer.parseInt(st.nextToken());
                System.out.println(query(tree, 1, 0, n - 1, s - 1, e - 1));
            }
        }
    }
}