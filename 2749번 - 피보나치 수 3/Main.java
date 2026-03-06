
/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 2749                              :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: thxogh1 <boj.kr/u/thxogh1>                  +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/2749                           #+#        #+#      #+#    */
/*   Solved: 2026/03/06 18:11:26 by thxogh1       ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    static long[][] matrix = { { 1, 1 }, { 1, 0 } };
    static int MOD = 1_000_000;

    static long[][] power(long[][] m, long exp) {
        if (exp == (long) 1) {
            return m;
        }

        long[][] res = power(m, exp / 2);

        res = multiply(res, res);

        if (exp % 2 == (long) 1) {
            res = multiply(res, m);
        }

        return res;
    }

    static long[][] multiply(long[][] a, long[][] b) {
        long[][] c = new long[2][2];

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                for (int k = 0; k < 2; k++) {
                    c[i][j] += a[i][k] * b[k][j];
                    c[i][j] %= MOD;
                }
            }
        }

        return c;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(br.readLine());

        long[][] ans = power(matrix, n - 1);
        System.out.println(ans[0][0] % MOD);
    }
}