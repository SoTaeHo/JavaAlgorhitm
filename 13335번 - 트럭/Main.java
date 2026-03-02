
/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 13335                             :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: thxogh1 <boj.kr/u/thxogh1>                  +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/13335                          #+#        #+#      #+#    */
/*   Solved: 2026/03/02 13:04:00 by thxogh1       ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        Queue<Integer> q = new ArrayDeque<>();
        Queue<Integer> b = new ArrayDeque<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            q.add(Integer.parseInt(st.nextToken()));
        }

        for (int i = 0; i < w; i++) {
            b.add(0);
        }

        int cnt = 0;
        int weight = 0;

        while (!b.isEmpty()) {
            cnt += 1;

            weight -= b.poll();

            if (!q.isEmpty()) {
                if (weight + q.peek() <= L) {
                    int temp = q.poll();
                    b.add(temp);
                    weight += temp;
                } else {
                    b.add(0);
                }
            }
        }

        System.out.println(cnt);
    }
}