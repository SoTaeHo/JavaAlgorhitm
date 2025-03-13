/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 1306                              :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: thxogh1 <boj.kr/u/thxogh1>                  +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/1306                           #+#        #+#      #+#    */
/*   Solved: 2025/03/12 10:05:44 by thxogh1       ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static void init(int[] tree, int[] arr, int node, int start, int end) {
        if (start == end) {
            tree[node] = arr[start];
        } else {
            int mid = (start + end) / 2;
            init(tree, arr, node * 2, start, mid);
            init(tree, arr, node * 2 + 1, mid + 1, end);
            tree[node] = Math.max(tree[node * 2], tree[node * 2 + 1]);
        }
    }

    static int query(int[] tree, int node, int start, int end, int left, int right) {
        if (left > end || right < start) {
            return 0;
        }
        if (left <= start && end <= right) {
            return tree[node];
        }
        int mid = (start + end) / 2;
        int lmax = query(tree, node * 2, start, mid, left, right);
        int rmax = query(tree, node * 2 + 1, mid + 1, end, left, right);
        return Math.max(lmax, rmax);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int h = (int) Math.ceil(Math.log(N) / Math.log(2));
        int treeSize = (1 << (h + 1));

        int[] tree = new int[treeSize];
        init(tree, arr, 1, 0, N - 1);
        // System.out.println(Arrays.toString(tree));
        for (int i = M - 1; i < N - M + 1; i++) {
            sb.append(query(tree, 1, 0, N - 1, i - M + 1, i + M - 1)).append(" ");
        }
        System.out.println(sb.toString());
    }
}