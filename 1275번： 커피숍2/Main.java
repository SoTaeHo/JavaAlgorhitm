/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 1275                              :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: thxogh1 <boj.kr/u/thxogh1>                  +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/1275                           #+#        #+#      #+#    */
/*   Solved: 2025/03/12 09:15:13 by thxogh1       ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static void init(long[] tree, int[] arr, int node, int start, int end) {
        if (start == end) {
            tree[node] = arr[start];
        } else {
            init(tree, arr, node * 2, start, (start + end) / 2);
            init(tree, arr, node * 2 + 1, (start + end) / 2 + 1, end);
            tree[node] = tree[node * 2] + tree[node * 2 + 1];
        }
    }

    static void update(long[] tree, int[] arr, int node, int start, int end, int index, int val) {
        if (start > index || end < index) {
            return;
        }
        if (start == end) {
            tree[node] = val;
            arr[index] = val;
            return;
        }
        update(tree, arr, node * 2, start, (start + end) / 2, index, val);
        update(tree, arr, node * 2 + 1, (start + end) / 2 + 1, end, index, val);
        tree[node] = tree[node * 2] + tree[node * 2 + 1];
    }

    static long query(long[] tree, int node, int start, int end, int left, int right) {
        // System.out.printf("%d %d\n", left, right);
        // System.out.printf("%d %d\n", start, end);

        if (left > end || right < start) {
            return 0;
        }
        if (left <= start && end <= right) {
            return tree[node];
        }
        long lsum = query(tree, node * 2, start, (start + end) / 2, left, right);
        long rsum = query(tree, node * 2 + 1, (start + end) / 2 + 1, end, left, right);
        return lsum + rsum;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // init
        int h = (int) Math.ceil(Math.log(N) / Math.log(2));
        int treeSize = (1 << (h + 1));
        long[] tree = new long[treeSize];

        init(tree, arr, 1, 0, N - 1);

        for (int i = 0; i < Q; i++) {
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int maxNum = Math.max(x - 1, y - 1);
            int minNum = Math.min(x - 1, y - 1);
            System.out.println(query(tree, 1, 0, N - 1, minNum, maxNum));
            update(tree, arr, 1, 0, N - 1, a - 1, b);
            // System.out.println(Arrays.toString(arr));
            // System.out.println(Arrays.toString(tree));
        }

    }
}