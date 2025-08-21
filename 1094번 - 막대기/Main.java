
/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 1094                              :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: thxogh1 <boj.kr/u/thxogh1>                  +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/1094                           #+#        #+#      #+#    */
/*   Solved: 2025/08/21 18:02:17 by thxogh1       ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.offer(64);
        int sum = 64;
        while (!pq.isEmpty()) {
            int now = pq.poll();

            int half = now / 2;

            if (sum == n) {
                break;
            }
            if (sum - half >= n) {
                pq.offer(half);
                sum -= half;
            } else {
                pq.offer(half);
                pq.offer(half);
            }
        }
        System.out.println(pq.size() + 1);
    }
}