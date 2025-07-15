
/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 2696                              :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: thxogh1 <boj.kr/u/thxogh1>                  +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/2696                           #+#        #+#      #+#    */
/*   Solved: 2025/07/15 08:29:35 by thxogh1       ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int TC = Integer.parseInt(br.readLine());
        for (int t = 0; t < TC; t++) {
            int m = Integer.parseInt(br.readLine());

            sb.append(m % 2 == 1 ? m / 2 + 1 : m / 2).append('\n');

            PriorityQueue<Integer> minHeap = new PriorityQueue<>();
            PriorityQueue<Integer> maxHeap = new PriorityQueue<>((o1, o2) -> Integer.compare(o2, o1));
            int j = 1;
            int k = 1;
            for (int i = m; i > 0; i -= 10) {
                st = new StringTokenizer(br.readLine());
                while (st.hasMoreTokens()) {
                    int now = Integer.parseInt(st.nextToken());
                    if (maxHeap.isEmpty() || now <= maxHeap.peek()) {
                        maxHeap.offer(now);
                    } else {
                        minHeap.offer(now);
                    }

                    if (maxHeap.size() < minHeap.size()) {
                        maxHeap.offer(minHeap.poll());
                    } else if (maxHeap.size() > minHeap.size() + 1) {
                        minHeap.offer(maxHeap.poll());
                    }
                    if (j++ % 2 == 1) {
                        sb.append(maxHeap.peek()).append(' ');
                        if (k++ % 10 == 0) {
                            sb.append('\n');
                            k = 1;
                        }
                    }
                }
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }
}