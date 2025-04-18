
/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 11725                             :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: thxogh1 <boj.kr/u/thxogh1>                  +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/11725                          #+#        #+#      #+#    */
/*   Solved: 2025/04/18 08:29:41 by thxogh1       ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());

        List<List<Integer>> li = new ArrayList<>();
        Queue<Integer> q = new ArrayDeque<>();

        for (int i = 0; i < n + 1; i++) {
            li.add(new ArrayList<>());
        }

        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int first = Integer.parseInt(st.nextToken());
            int second = Integer.parseInt(st.nextToken());

            li.get(first).add(second);
            li.get(second).add(first);

        }

        int[] parent = new int[100001];
        q.offer(1);
        while (!q.isEmpty()) {
            int cur = q.poll();

            for (int i = 0; i < li.get(cur).size(); i++) {
                if (parent[li.get(cur).get(i)] != 0)
                    continue;
                q.offer(li.get(cur).get(i));
                parent[li.get(cur).get(i)] = cur;
            }
        }
        for (int i = 2; i < n + 1; i++) {
            sb.append(parent[i]).append('\n');
        }
        System.out.println(sb);
    }
}