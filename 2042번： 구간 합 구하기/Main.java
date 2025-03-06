/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 2042                              :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: thxogh1 <boj.kr/u/thxogh1>                  +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/2042                           #+#        #+#      #+#    */
/*   Solved: 2025/03/06 09:05:47 by thxogh1       ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void init(long[] arr, long[] tree, int node, int start, int end) {
        if (start == end) {
            tree[node] = arr[start];
        } else {
            init(arr, tree, node * 2, start, (start + end) / 2);
            init(arr, tree, node * 2 + 1, (start + end) / 2 + 1, end);
            tree[node] = tree[node * 2] + tree[node * 2 + 1];
        }
    }

    public static long query(long[] tree, int node, int left, int right, int start, int end) {
        if (left > end || right < start) {
            return 0;
        }
        if (left <= start && right >= end) {
            return tree[node];
        }
        long lsum = query(tree, node * 2, left, right, start, (start + end) / 2);
        long rsum = query(tree, node * 2 + 1, left, right, (start + end) / 2 + 1, end);
        return lsum + rsum;
    }

    public static void update(long[] arr, long[] tree, int node, int start, int end, int idx, long val) {
        if (idx < start || idx > end) {
            return;
        }
        if (start == end) {
            arr[idx] = val;
            tree[node] = val;
            return;
        }
        update(arr, tree, node * 2, start, (start + end) / 2, idx, val);
        update(arr, tree, node * 2 + 1, (start + end) / 2 + 1, end, idx, val);
        tree[node] = tree[node * 2] + tree[node * 2 + 1];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        long[] arr = new long[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Long.parseLong(br.readLine());
        }
        int h = (int) Math.ceil(Math.log(N) / Math.log(2));
        int treeSize = (1 << (h + 1)); // 2^(h+1) - 1
        long[] tree = new long[treeSize];
        init(arr, tree, 1, 0, N - 1);
        String[] line;
        for (int i = 0; i < M + K; i++) {
            // st = new StringTokenizer(br.readLine());
            // int a = Integer.parseInt(st.nextToken());
            // int b = Integer.parseInt(st.nextToken());
            // int c = Integer.parseInt(st.nextToken());
            line = br.readLine().split(" ");
            int a = Integer.parseInt(line[0]);
            // a == 1인 경우 수를 변경
            if (a == 1) {
                int index = Integer.parseInt(line[1]);
                long val = Long.parseLong(line[2]);
                update(arr, tree, 1, 0, N - 1, index - 1, val);
            }
            // a == 2인 경우 부분 합 구하기
            else if (a == 2) {
                int left = Integer.parseInt(line[1]);
                int right = Integer.parseInt(line[2]);
                System.out.println(query(tree, 1, left - 1, right - 1, 0, N - 1));
            }
        }
    }
}