/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 10211                             :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: thxogh1 <boj.kr/u/thxogh1>                  +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/10211                          #+#        #+#      #+#    */
/*   Solved: 2025/03/18 11:11:19 by thxogh1       ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());

            int[] s = new int[n + 1];
            st = new StringTokenizer(br.readLine());
            s[1] = Integer.parseInt(st.nextToken());
            for (int j = 2; j <= n; j++) {
                s[j] = s[j - 1] + Integer.parseInt(st.nextToken());
            }
            System.out.println(Arrays.toString(s));
            int maxNum = s[1];
            for (int j = 0; j <= n; j++) {
                for (int k = j + 1; k <= n; k++) {
                    // System.out.println(s[k] - s[j]);
                    maxNum = Math.max(maxNum, s[k] - s[j]);
                }
            }
            System.out.println(maxNum);
        }
    }
}

// 1 2 3 4 5
// 1 3 6 10 15