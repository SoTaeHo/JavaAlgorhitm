
/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 13904                             :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: thxogh1 <boj.kr/u/thxogh1>                  +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/13904                          #+#        #+#      #+#    */
/*   Solved: 2026/01/20 10:29:24 by thxogh1       ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static class Assignment {
        int d, w;

        Assignment(int d, int w) {
            this.d = d;
            this.w = w;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        Assignment[] arr = new Assignment[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i] = new Assignment(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        Arrays.sort(arr, Comparator.comparingInt((Assignment a) -> a.d).thenComparingInt(a -> -a.w));

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (Assignment a : arr) {
            pq.add(a.w);

            if (pq.size() > a.d) {
                pq.poll();
            }
        }

        int ans = 0;
        while (!pq.isEmpty()) {
            ans += pq.poll();
        }
        System.out.println(ans);
    }
}