
/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 1038                              :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: thxogh1 <boj.kr/u/thxogh1>                  +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/1038                           #+#        #+#      #+#    */
/*   Solved: 2025/08/20 13:29:32 by thxogh1       ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Queue;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        List<Long> li = new ArrayList<>();

        Queue<Long> q = new ArrayDeque<>();
        for (long i = 0; i < 10; i++) {
            q.offer(i);
        }

        while (!q.isEmpty()) {
            long num = q.poll();
            li.add(num);

            long last = num % 10;
            for (int i = 0; i < last; i++) {
                q.offer(num * 10 + i);
            }
        }

        Collections.sort(li);

        if (n < li.size()) {
            System.out.println(li.get(n));
        } else {
            System.out.println(-1);
        }
    }
}