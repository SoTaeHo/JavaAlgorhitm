/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 11658                             :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: thxogh1 <boj.kr/u/thxogh1>                  +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/11658                          #+#        #+#      #+#    */
/*   Solved: 2025/03/06 14:22:32 by thxogh1       ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static void init(int[][] tree, int[][] arr, int row, int node, int start, int end) {
        if (start == end) {
            tree[row][node] = arr[row][start];
        } else {
            init(tree, arr, row, node * 2, start, (start + end) / 2);
            init(tree, arr, row, node * 2 + 1, (start + end) / 2 + 1, end);
            tree[row][node] = tree[row][node * 2] + tree[row][node * 2 + 1];
        }
    }

    public static void update(int[][] tree, int[][] arr, int row, int node, int index, int start, int end, int val) {
        if (index > end || index < start) {
            return;
        }
        if (start == end) {
            arr[row][index] = val;
            tree[row][node] = val;
            return;
        }
        update(tree, arr, row, node * 2, index, start, (start + end) / 2, val);
        update(tree, arr, row, node * 2 + 1, index, (start + end) / 2 + 1, end, val);
        tree[row][node] = tree[row][node * 2] + tree[row][node * 2 + 1];
    }

    public static int query(int[][] tree, int row, int node, int start, int end, int left,
            int right) {
        if (left > end || right < start) {
            return 0;
        }
        if (left <= start && end <= right) {
            return tree[row][node];
        }
        int lsum = query(tree, row, node * 2, start, (start + end) / 2, left, right);
        int rsum = query(tree, row, node * 2 + 1, (start + end) / 2 + 1, end, left, right);
        return lsum + rsum;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] arr = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int h = (int) Math.ceil(Math.log(N) / Math.log(2));
        int treeSize = (1 << (h + 1));
        int[][] tree = new int[N][treeSize];

        for (int i = 0; i < N; i++) {
            init(tree, arr, i, 1, 0, N - 1);
        }

        // for (int i = 0; i < N; i++) {
        // System.out.println(Arrays.toString(tree[i]));
        // }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int type = Integer.parseInt(st.nextToken());

            if (type == 1) {
                int startX = Integer.parseInt(st.nextToken());
                int startY = Integer.parseInt(st.nextToken());
                int endX = Integer.parseInt(st.nextToken());
                int endY = Integer.parseInt(st.nextToken());
                long result = 0;
                for (int j = 0; j <= endX - startX; j++) {
                    result += query(tree, startX - 1 + j, 1, 0, N - 1, startY - 1, endY - 1);
                }
                System.out.println(result);
            } else {
                int row = Integer.parseInt(st.nextToken());
                int col = Integer.parseInt(st.nextToken());
                int val = Integer.parseInt(st.nextToken());

                update(tree, arr, row - 1, 1, col - 1, 0, N - 1, val);
            }
        }

    }
}