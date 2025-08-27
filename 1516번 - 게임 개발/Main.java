
/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 1516                              :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: thxogh1 <boj.kr/u/thxogh1>                  +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/1516                           #+#        #+#      #+#    */
/*   Solved: 2025/08/27 12:16:26 by thxogh1       ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());

        List<Integer>[] li = new List[n + 1];

        for (int i = 0; i < n + 1; i++) {
            li[i] = new ArrayList<>();
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int[] rank = new int[n + 1];
        int[] ans = new int[n + 1];
        boolean[] visited = new boolean[n + 1];
        for (int i = 1; i < n + 1; i++) {
            st = new StringTokenizer(br.readLine());
            String token = st.nextToken();
            while (!token.equals("-1")) {
                li[i].add(Integer.parseInt(token));
                token = st.nextToken();
            }
            rank[i] = li[i].size() - 1;
            if (li[i].size() == 1 && !visited[i]) {
                pq.offer(i);
                visited[i] = true;
            }
        }
        while (!pq.isEmpty()) {
            int now = pq.poll();
            // System.out.println("now : " + now);

            for (int i = 1; i < n + 1; i++) {
                for (int j = 1; j < li[i].size(); j++) {
                    if (li[i].get(j) == now) {
                        rank[i] -= 1;
                    }
                }
                if (rank[i] == 0 && !visited[i]) {
                    pq.offer(i);
                    visited[i] = true;
                }
            }
            int value = 0;
            for (int i = 1; i < li[now].size(); i++) {
                value = Math.max(value, ans[li[now].get(i)]);
                // System.out.println("ans : " + ans[li[now].get(i)]);
                // System.out.println("value : " + value);
            }
            // System.out.println("now : " + now + " / li[now].get(0) : " + li[now].get(0));
            ans[now] = value + li[now].get(0);
        }

        for (int i = 1; i < n + 1; i++) {
            System.out.println(ans[i]);
        }
    }
}