
/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 2243                              :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: thxogh1 <boj.kr/u/thxogh1>                  +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/2243                           #+#        #+#      #+#    */
/*   Solved: 2025/04/09 09:04:00 by thxogh1       ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static final int SIZE = 1000001;
    // static final int SIZE = 3;

    static int query(int[] tree, int node, int idx, int s, int e) {
        if (s == e) {
            update(tree, 1, s, 0, SIZE - 1, -1);
            return s;
        }
        int m = (s + e) / 2;
        // System.out.println("tree[node] : " + tree[node]);
        if (idx <= tree[node * 2]) {
            return query(tree, node * 2, idx, s, m);
        } else {
            // System.out.println("right");
            // update(tree, node * 2, idx, s, e, m);
            return query(tree, node * 2 + 1, idx - tree[node * 2], m + 1, e);
        }
    }

    static void update(int[] tree, int node, int idx, int s, int e, int cnt) {
        if (idx < s || e < idx) {
            return;
        }
        if (s == e) {
            tree[node] += cnt;
            return;
        }
        int m = (s + e) / 2;
        update(tree, node * 2, idx, s, m, cnt);
        update(tree, node * 2 + 1, idx, m + 1, e, cnt);
        tree[node] = tree[node * 2] + tree[node * 2 + 1];
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        int[] tree = new int[4 * SIZE];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            int type = Integer.parseInt(st.nextToken());

            if (type == 1) {
                int index = Integer.parseInt(st.nextToken());
                System.out.println(query(tree, 1, index, 0, SIZE - 1) + 1);
            } else {
                int candy = Integer.parseInt(st.nextToken());
                int count = Integer.parseInt(st.nextToken());
                update(tree, 1, candy - 1, 0, SIZE - 1, count);
            }
            // System.out.println(Arrays.toString(tree));
        }
    }
}