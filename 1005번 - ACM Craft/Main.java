
/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 1005                              :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: thxogh1 <boj.kr/u/thxogh1>                  +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/1005                           #+#        #+#      #+#    */
/*   Solved: 2025/04/11 16:47:20 by thxogh1       ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int tc = Integer.parseInt(br.readLine());

        for (int t = 0; t < tc; t++) {

            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());

            int[] degree = new int[n + 1];
            int[] weight = new int[n + 1];
            int[] ans = new int[n + 1];
            for (int i = 1; i < n + 1; i++) {
                weight[i] = Integer.parseInt(st.nextToken());
            }
            List<List<Integer>> arr = new ArrayList<>();
            for (int i = 0; i < n + 1; i++) {
                arr.add(new ArrayList<>());
            }
            for (int i = 0; i < k; i++) {
                st = new StringTokenizer(br.readLine());
                int s = Integer.parseInt(st.nextToken());
                int e = Integer.parseInt(st.nextToken());
                arr.get(s).add(e);
                degree[e] += 1;
            }
            int w = Integer.parseInt(br.readLine());
            Queue<Integer> q = new ArrayDeque<>();
            for (int i = 1; i < n + 1; i++) {
                ans[i] = weight[i];
                if (degree[i] == 0) {
                    q.offer(i);
                }
            }
            while (!q.isEmpty()) {
                int node = q.poll();
                for (int i = 0; i < arr.get(node).size(); i++) {
                    int num = arr.get(node).get(i);
                    degree[num] -= 1;
                    ans[num] = Math.max(weight[num] + ans[node], ans[num]);
                    if (degree[num] == 0)
                        q.offer(num);

                }
            }
            sb.append(ans[w]).append('\n');
        }
        System.out.println(sb);
    }
}
