/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 11000                             :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: thxogh1 <boj.kr/u/thxogh1>                  +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/11000                          #+#        #+#      #+#    */
/*   Solved: 2026/02/23 16:00:51 by thxogh1       ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static class Lecture {
        int s;
        int t;

        Lecture(int s, int t) {
            this.s = s;
            this.t = t;
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        List<Lecture> li = new ArrayList<>();
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            li.add(new Lecture(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }
        Collections.sort(li, Comparator.comparingInt(e -> e.s));
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(Lecture lec : li) {
            if(!pq.isEmpty() && pq.peek() <= lec.s) {
                pq.poll();
            }
            pq.add(lec.t);
        }

        System.out.println(pq.size());
    }
}