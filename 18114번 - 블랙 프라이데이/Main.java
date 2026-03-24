/* ************************************************************************** */
 /*                                                                            */
 /*                                                      :::    :::    :::     */
 /*   Problem Number: 18114                             :+:    :+:      :+:    */
 /*                                                    +:+    +:+        +:+   */
 /*   By: thxogh1 <boj.kr/u/thxogh1>                  +#+    +#+          +#+  */
 /*                                                  +#+      +#+        +#+   */
 /*   https://boj.kr/18114                          #+#        #+#      #+#    */
 /*   Solved: 2026/03/24 20:22:21 by thxogh1       ###          ###   ##.kr    */
 /*                                                                            */
 /* ************************************************************************** */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int C;
    static int[] w;
    static Set<Integer> set = new HashSet<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        w = new int[N];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            int val = Integer.parseInt(st.nextToken());
            if (val == C) {
                System.out.println(1);
                return;
            }
            w[i] = val;
            set.add(val);
        }

        for (int i = 0; i < N - 1; i++) {
            for (int j = i + 1; j < N; j++) {
                if (w[i] + w[j] == C) {
                    System.out.println(1);
                    return;
                }
                if (set.contains(C - w[i] - w[j]) && w[i] != C - w[i] - w[j] && w[j] != C - w[i] - w[j]) {
                    System.out.println(1);
                    return;
                }
            }
        }

        System.out.println(0);
    }
}
