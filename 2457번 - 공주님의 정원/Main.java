
/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 2457                              :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: thxogh1 <boj.kr/u/thxogh1>                  +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/2457                           #+#        #+#      #+#    */
/*   Solved: 2026/01/21 16:01:11 by thxogh1       ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static class Flower {
        int start, end;

        Flower(int sm, int sd, int em, int ed) {
            this.start = sm * 100 + sd;
            this.end = em * 100 + ed;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        List<Flower> li = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            li.add(new Flower(
                    Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken())));
        }
        li.sort(Comparator.comparingInt((Flower f) -> f.start)
                .thenComparing(Comparator.comparingInt((Flower f) -> f.end).reversed()));

        int targetStart = 301;
        int targetEnd = 1130;

        int idx = 0;
        int currentEnd = targetStart;
        int cnt = 0;
        while (currentEnd <= targetEnd) {
            int maxEnd = currentEnd;

            while (idx < N && li.get(idx).start <= currentEnd) {
                maxEnd = Math.max(maxEnd, li.get(idx).end);
                idx++;
            }

            if (maxEnd == currentEnd) {
                System.out.println(0);
                return;
            }

            currentEnd = maxEnd;
            cnt++;
        }

        System.out.println(cnt);
    }

}