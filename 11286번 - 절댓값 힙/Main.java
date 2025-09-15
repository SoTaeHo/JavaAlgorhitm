
/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 11286                             :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: thxogh1 <boj.kr/u/thxogh1>                  +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/11286                          #+#        #+#      #+#    */
/*   Solved: 2025/09/16 08:38:48 by thxogh1       ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {

    static class Absolute implements Comparable<Absolute> {
        int value;
        int absValue;

        Absolute(int value, int absValue) {
            this.value = value;
            this.absValue = absValue;
        }

        @Override
        public int compareTo(Main.Absolute o) {
            if (absValue != o.absValue) {
                return Integer.compare(this.absValue, o.absValue);
            } else {
                return Integer.compare(this.value, o.value);
            }
        }

    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        PriorityQueue<Absolute> pq = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());

            if (num != 0) {
                pq.offer(new Absolute(num, Math.abs(num)));
            } else {
                if (pq.isEmpty()) {
                    sb.append(0).append('\n');
                } else {
                    sb.append(pq.poll().value).append('\n');
                }
            }
        }
        System.out.println(sb);
    }
}