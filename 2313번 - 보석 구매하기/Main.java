/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 2313                              :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: thxogh1 <boj.kr/u/thxogh1>                  +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/2313                           #+#        #+#      #+#    */
/*   Solved: 2026/03/27 17:26:40 by thxogh1       ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */
import java.io.*;
import java.util.*;

public class Main {

    static boolean isBetter(long sum1, int l1, int r1,
                            long sum2, int l2, int r2) {

        if (sum1 != sum2) return sum1 > sum2;

        int len1 = r1 - l1;
        int len2 = r2 - l2;
        if (len1 != len2) return len1 < len2;

        return l1 < l2;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        long totalSum = 0;
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            int L = Integer.parseInt(br.readLine());

            int[] arr = new int[L];
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < L; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }

            long curSum = arr[0];
            int curL = 0;

            long bestSum = arr[0];
            int bestL = 0, bestR = 0;

            for (int j = 1; j < L; j++) {
                int x = arr[j];

                if (curSum <= 0) {
                    curSum = x;
                    curL = j;
                } else {
                    curSum += x;
                }

                if (isBetter(curSum, curL, j, bestSum, bestL, bestR)) {
                    bestSum = curSum;
                    bestL = curL;
                    bestR = j;
                }
            }

            totalSum += bestSum;
            sb.append(bestL + 1).append(" ").append(bestR + 1).append("\n");
        }

        System.out.println(totalSum);
        System.out.print(sb);
    }
}