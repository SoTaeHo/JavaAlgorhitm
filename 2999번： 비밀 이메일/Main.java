/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 2999                              :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: thxogh1 <boj.kr/u/thxogh1>                  +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/2999                           #+#        #+#      #+#    */
/*   Solved: 2025/03/10 13:42:09 by thxogh1       ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String str = br.readLine();
        int N = str.length();
        int R = 0;
        int C = 0;

        int maxR = 1;
        for (int i = 1; i <= Math.sqrt(N); i++) {
            if (N % i == 0) {
                if (i > maxR)
                    maxR = i;
            }
        }
        R = maxR;
        C = N / R;
        char map[][] = new char[R][C];

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < N; j += R) {
                sb.append(str.charAt(i + j));
            }
        }
        System.out.println(sb);
    }
}