/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 16975                             :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: thxogh1 <boj.kr/u/thxogh1>                  +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/16975                          #+#        #+#      #+#    */
/*   Solved: 2025/03/11 09:31:46 by thxogh1       ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static void updateLazy(long[] tree, long[] lazy, int node, int start, int end) {
        if (lazy[node] != 0) {
            tree[node] += (end - start + 1) * lazy[node];
            if (start != end) {
                lazy[node * 2] += lazy[node];
                lazy[node * 2 + 1] += lazy[node];
            }
            lazy[node] = 0;
        }
    }

    static void updateRange(long[] tree, long[] lazy, long[] arr, int node, int left, int right, int start, int end,
            long diff) {
        updateLazy(tree, lazy, node, start, end);
        if (right < start || end < left) {
            return;
        }
        if (left <= start && end <= right) {
            tree[node] += (end - start + 1) * diff;
            if (start == end) {
                arr[start] = tree[node];
            }
            if (start != end) {
                lazy[node * 2] += diff;
                lazy[node * 2 + 1] += diff;
            }
        } else {
            updateRange(tree, lazy, arr, node * 2, left, right, start, (start + end) / 2, diff);
            updateRange(tree, lazy, arr, node * 2 + 1, left, right, (start + end) / 2 + 1, end, diff);
            tree[node] = tree[node * 2] + tree[node * 2 + 1];
        }
    }

    static long query(long[] tree, long[] lazy, long[] arr, int node, int left, int right, int start, int end) {
        updateLazy(tree, lazy, node, start, end);
        if (right < start || end < left) {
            return 0;
        }
        if (left <= start && end <= right) {
            if (start == end) {
                arr[start] = tree[node];
            }
            return tree[node];
        }
        long lsum = query(tree, lazy, arr, node * 2, left, right, start, (start + end) / 2);
        long rsum = query(tree, lazy, arr, node * 2 + 1, left, right, (start + end) / 2 + 1, end);
        return lsum + rsum;
    }

    static void init(long[] tree, long[] arr, int node, int start, int end) {
        if (start == end) {
            tree[node] = arr[start];
        } else {
            init(tree, arr, node * 2, start, (start + end) / 2);
            init(tree, arr, node * 2 + 1, (start + end) / 2 + 1, end);
            tree[node] = tree[node * 2] + tree[node * 2 + 1];
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        long[] arr = new long[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int h = (int) Math.ceil(Math.log(N) / Math.log(2));
        int treeSize = (1 << (h + 1));
        long[] tree = new long[treeSize];
        long[] lazy = new long[treeSize];
        init(tree, arr, 1, 0, N - 1);
        int M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int type = Integer.parseInt(st.nextToken());

            if (type == 1) {
                System.out.println("=========update===========");
                int left = Integer.parseInt(st.nextToken());
                int right = Integer.parseInt(st.nextToken());
                long diff = Long.parseLong(st.nextToken());
                updateRange(tree, lazy, arr, 1, left - 1, right - 1, 0, N - 1, diff);
                System.out.println(Arrays.toString(tree));
                System.out.println(Arrays.toString(lazy));
            } else {
                int index = Integer.parseInt(st.nextToken());
                System.out.println("=========query===========");

                query(tree, lazy, arr, 1, index - 1, index - 1, 0, N - 1);
                System.out.println(Arrays.toString(tree));
                System.out.println(Arrays.toString(lazy));
                System.out.println(Arrays.toString(arr));
                System.out.println(arr[index - 1]);
            }
        }
    }
}