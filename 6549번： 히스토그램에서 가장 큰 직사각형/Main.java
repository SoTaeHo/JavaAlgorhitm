
/* ************************************************************************** */
/*                                                                            */
/* ::: ::: ::: */
/* Problem Number: 6549 :+: :+: :+: */
/* +:+ +:+ +:+ */
/* By: thxogh1 <boj.kr/u/thxogh1> +#+ +#+ +#+ */
/* +#+ +#+ +#+ */
/* https://boj.kr/6549 #+# #+# #+# */
/* Solved: 2025/03/19 17:48:05 by thxogh1 ### ### ##.kr */
/*                                                                            */
/* ************************************************************************** */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static void init(long[] tree, long[] low, int[] arr, int node, int s, int e) {
        if(s == e) {
            tree[node] = arr[s];
            low[node] = arr[s];
        } else {
            int mid = (s + e) / 2;
            init(tree, low, arr, node * 2, s, mid);
            init(tree, low, arr, node * 2 + 1, mid + 1, e);
            long small = Math.min(tree[node * 2], tree[node * 2 + 1]);
            long big = Math.max(tree[node * 2], tree[node * 2 + 1]);

            low[node] = Math.min(low[node * 2], low[node * 2 + 1]);
            tree[node] = Math.max(low[node] * (e - s + 1), big);
        }
    }

    static long query(long[] tree, int node, int s, int e, int l, int r) {
        if(e < l || r < s) {
            return 0;
        }
        if(l <= s && e <= r) {
            return tree[node];
        }
        int mid = (s + e) >>> 2;
        long left = query(tree, node * 2, s, mid, l, r);
        long right = query(tree, node * 2 + 1, mid + 1, e, l, r);
        long small = Math.min(left, right);
        long big = Math.max(left, right);
        return Math.max(big, small * 2);
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        while(true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            if(n == 0) {
                break;
            }

            int[] arr = new int[n];
            for(int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            long[] tree = new long[4 * n];
            long[] low = new long[4 * n];

            init(tree, low, arr, 1, 0, n - 1);
            System.out.println(tree[1]);
        }


    }
}