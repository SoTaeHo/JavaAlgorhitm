
/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 18352                             :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: thxogh1 <boj.kr/u/thxogh1>                  +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/18352                          #+#        #+#      #+#    */
/*   Solved: 2025/07/25 14:08:30 by thxogh1       ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());

        List<List<Integer>> li = new ArrayList<>();
        for (int i = 0; i < n + 1; i++) {
            li.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            li.get(start).add(end);
        }
        int[] d = new int[n + 1];
        Arrays.fill(d, Integer.MAX_VALUE);
        d[x] = 0;
        Queue<Integer> pq = new ArrayDeque<>();

        pq.offer(x);
        while (!pq.isEmpty()) {
            int now = pq.poll();

            for (int i = 0; i < li.get(now).size(); i++) {
                if (d[li.get(now).get(i)] > d[now] + 1) {
                    d[li.get(now).get(i)] = d[now] + 1;
                    pq.add(li.get(now).get(i));
                }
            }
        }

        for (int i = 1; i < n + 1; i++) {
            if (d[i] == k) {
                sb.append(i).append('\n');
            }
        }
        if (sb.toString().length() == 0) {
            System.out.println(-1);
        } else {
            System.out.println(sb);
        }
    }
}