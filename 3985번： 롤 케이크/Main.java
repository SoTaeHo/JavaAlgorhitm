/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 3985                              :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: thxogh1 <boj.kr/u/thxogh1>                  +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/3985                           #+#        #+#      #+#    */
/*   Solved: 2025/03/10 16:47:26 by thxogh1       ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int L = Integer.parseInt(br.readLine());
        int N = Integer.parseInt(br.readLine());
        boolean[] isSelected = new boolean[L];
        int expectedNum = 0;
        int expectedIdx = 0;
        int realNum = 0;
        int realIdx = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int P = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            if (K - P > expectedNum) {
                expectedNum = K - P;
                expectedIdx = i;
            }
            int temp = 0;
            for (int j = P - 1; j < K; j++) {
                if (!isSelected[j]) {
                    isSelected[j] = true;
                    temp++;
                }
            }
            if (temp > realNum) {
                realNum = temp;
                realIdx = i;
            }
        }
        System.out.printf("%d\n%d\n", expectedIdx + 1, realIdx + 1);
    }
}