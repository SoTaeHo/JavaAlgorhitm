
/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 1725                              :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: thxogh1 <boj.kr/u/thxogh1>                  +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/1725                           #+#        #+#      #+#    */
/*   Solved: 2025/03/20 11:32:51 by thxogh1       ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int init(int[] tree, int[] arr, int node, int s, int e) {
        if (s == e) {
            tree[node] = s;
            return s;
        } else {
            int mid = (s + e) / 2;
            int left = init(tree, arr, node * 2, s, mid);
            int right = init(tree, arr, node * 2 + 1, mid + 1, e);

            if (arr[left] > arr[right]) {
                tree[node] = right;
                return right;
            } else {
                tree[node] = left;
                return left;
            }
        }
    }

    static int find(int[] tree, int[] arr, int node, int s, int e, int l, int r) {
        if (e < l || r < s) {
            return 0;
        }
        if (l <= s && e <= r) {
            return tree[node];
        }
        int mid = (s + e) / 2;
        int left = find(tree, arr, node * 2, s, mid, l, r);
        int right = find(tree, arr, node * 2 + 1, mid + 1, e, l, r);

        if (arr[left] > arr[right])
            return right;
        else
            return left;

    }

    static long query(int[] tree, int[] arr, int n, int l, int r) {
        if (l > r) {
            return 0;
        }
        int idx = find(tree, arr, 1, 1, n, l, r);
        long maxNum = (r - l + 1) * (long) arr[idx];
        maxNum = Math.max(maxNum, query(tree, arr, n, l, idx - 1));
        maxNum = Math.max(maxNum, query(tree, arr, n, idx + 1, r));
        return maxNum;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n + 1];
        arr[0] = Integer.MAX_VALUE;
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        int[] tree = new int[4 * n];

        init(tree, arr, 1, 1, n);
        System.out.println(query(tree, arr, n, 1, n));
    }
}