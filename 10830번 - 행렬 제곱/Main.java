
/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 10830                             :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: thxogh1 <boj.kr/u/thxogh1>                  +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/10830                          #+#        #+#      #+#    */
/*   Solved: 2025/05/06 19:35:46 by thxogh1       ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int[][] ans;
    static int[][] matrix;

    static int[][] multifly(int[][] first, int[][] second) {
        int[][] result = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    result[i][j] += first[i][k] * second[k][j];
                    result[i][j] %= 1000;
                }
            }
        }
        return result;
    }

    static int[][] power(int[][] temp, long exponent) {

        if (exponent == (long) 1) {
            return temp;
        }

        int[][] result = power(temp, exponent / 2);

        result = multifly(result, result);

        if (exponent % 2 == (long) 1) {
            result = multifly(result, matrix);
        }
        return result;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        long b = Long.parseLong(st.nextToken());

        matrix = new int[n][n];
        ans = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                matrix[i][j] = Integer.parseInt(st.nextToken()) % 1000;
            }
        }
        ans = power(matrix, b);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(ans[i][j] + " ");
            }
            System.out.println();
        }
    }
}