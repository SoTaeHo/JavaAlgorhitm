
/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 11444                             :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: thxogh1 <boj.kr/u/thxogh1>                  +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/11444                          #+#        #+#      #+#    */
/*   Solved: 2025/05/06 18:37:14 by thxogh1       ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    static long[][] matrix = { { 1, 1 }, { 1, 0 } };

    static long[][] power(long[][] a, long exponent) {
        if (exponent == (long) 1) {
            return a;
        }
        long[][] res = new long[2][2];

        res = power(a, exponent / 2);

        res = multifly(res, res);

        if (exponent % 2 == (long) 1) {
            res = multifly(res, matrix);
        }
        return res;
    }

    static long[][] multifly(long[][] f, long[][] s) {
        long[][] res = new long[2][2];

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                for (int k = 0; k < 2; k++) {
                    res[i][j] += f[i][k] * s[k][j];
                    res[i][j] %= 1000000007;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long n = Long.parseLong(br.readLine());
        if (n == 0 || n == 1) {
            System.out.println(n);
            return;
        }

        System.out.println(power(matrix, n - 1)[0][0]);
    }
}