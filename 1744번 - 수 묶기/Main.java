
/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 1744                              :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: thxogh1 <boj.kr/u/thxogh1>                  +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/1744                           #+#        #+#      #+#    */
/*   Solved: 2026/01/06 18:35:29 by thxogh1       ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {
    static int N;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        List<Integer> positive = new ArrayList<>();
        List<Integer> negative = new ArrayList<>();

        int cnt = 0;
        boolean hasZero = false;

        for (int i = 0; i < N; i++) {
            int temp = Integer.parseInt(br.readLine());

            if (temp > 1) {
                positive.add(temp);
            } else if (temp == 1) {
                cnt += 1;
            } else if (temp == 0) {
                hasZero = true;
            } else {
                negative.add(temp);
            }
        }

        positive.sort(Comparator.reverseOrder());
        negative.sort(Comparator.naturalOrder());
        int ans = 0;

        for (int i = 0; i + 1 < positive.size(); i += 2) {
            ans += positive.get(i) * positive.get(i + 1);
        }
        if (positive.size() % 2 == 1) {
            ans += positive.get(positive.size() - 1);
        }

        for (int i = 0; i + 1 < negative.size(); i += 2) {
            ans += negative.get(i) * negative.get(i + 1);
        }
        if (negative.size() % 2 == 1 && !hasZero) {
            ans += negative.get(negative.size() - 1);
        }
        ans += cnt;

        System.out.println(ans);

    }
}