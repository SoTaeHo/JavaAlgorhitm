/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 10999                             :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: thxogh1 <boj.kr/u/thxogh1>                  +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/10999                          #+#        #+#      #+#    */
/*   Solved: 2025/03/10 19:12:15 by thxogh1       ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static void init(long[] arr, long[] tree, int node, int start, int end) {
		if (start == end) {
			tree[node] = arr[start];
		} else {
			init(arr, tree, node * 2, start, (start + end) / 2);
			init(arr, tree, node * 2 + 1, (start + end) / 2 + 1, end);
			tree[node] = tree[node * 2] + tree[node * 2 + 1];
		}
	}

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

	static void updateRange(long[] tree, long[] lazy, int node, int left, int right, int start, int end, long diff) {
		updateLazy(tree, lazy, node, start, end);
		if (left > end || right < start) {
			return;
		}
		if (left <= start && end <= right) {
			tree[node] += (end - start + 1) * diff;
			if (start != end) {
				lazy[node * 2] += diff;
				lazy[node * 2 + 1] += diff;
			}
			return;
		}
		updateRange(tree, lazy, node * 2, left, right, start, (start + end) / 2, diff);
		updateRange(tree, lazy, node * 2 + 1, left, right, (start + end) / 2 + 1, end, diff);
		// tree[node] = tree[node * 2] + tree[node * 2 + 1];
	}

	static long query(long[] tree, long[] lazy, int node, int left, int right, int start, int end) {
		updateLazy(tree, lazy, node, start, end);

		if (left > end || right < start) {
			return 0;
		}
		if (left <= start && end <= right) {
			return tree[node];
		}
		long lsum = query(tree, lazy, node * 2, left, right, start, (start + end) / 2);
		long rsum = query(tree, lazy, node * 2 + 1, left, right, (start + end) / 2 + 1, end);
		return lsum + rsum;

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		long[] arr = new long[N];
		int h = (int) Math.ceil(Math.log(N) / Math.log(2));
		int treeSize = (1 << (h + 1));
		long[] tree = new long[treeSize];
		long[] lazy = new long[treeSize];
		for (int i = 0; i < N; i++) {
			arr[i] = Long.parseLong(br.readLine());
		}
		init(arr, tree, 1, 0, N - 1);

		for (int i = 0; i < M + K; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());

			if (a == 1) {
				int b = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				long d = Long.parseLong(st.nextToken());
				updateRange(tree, lazy, 1, b - 1, c - 1, 0, N - 1, d);
			} else {
				int b = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				System.out.println(query(tree, lazy, 1, b - 1, c - 1, 0, N - 1));
			}
		}
	}
}