
/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 13549                             :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: thxogh1 <boj.kr/u/thxogh1>                  +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/13549                          #+#        #+#      #+#    */
/*   Solved: 2025/05/02 08:45:23 by thxogh1       ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        boolean[] visited = new boolean[100001];
        int[] arr = new int[100001];
        Arrays.fill(arr, Integer.MAX_VALUE);
        Queue<Integer> q = new ArrayDeque<>();
        arr[n] = 0;
        q.offer(n);
        while (!q.isEmpty()) {

            int now = q.poll();
            if (now == k) {
                break;
            }
            if (visited[now]) {
                continue;
            }

            visited[now] = true;
            if (now - 1 >= 0 && now - 1 <= 100000 && arr[now - 1] > arr[now]) {
                q.offer(now - 1);
                arr[now - 1] = arr[now] + 1;
            }
            if (now + 1 >= 0 && now + 1 <= 100000 && arr[now + 1] > arr[now]) {
                q.offer(now + 1);
                arr[now + 1] = arr[now] + 1;
            }
            if (now * 2 >= 0 && now * 2 <= 100000 && arr[now * 2] > arr[now]) {
                q.offer(now * 2);
                arr[now * 2] = arr[now];
            }

        }
        System.out.println(arr[k]);
    }
}