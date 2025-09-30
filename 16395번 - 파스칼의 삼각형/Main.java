
/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 16395                             :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: thxogh1 <boj.kr/u/thxogh1>                  +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/16395                          #+#        #+#      #+#    */
/*   Solved: 2025/09/30 08:44:31 by thxogh1       ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[][] arr = new int[n + 1][n + 1];

        arr[1][1] = 1;
        if (n >= 2) {
            arr[2][1] = 1;
            arr[2][2] = 1;

        }

        for (int i = 3; i < n + 1; i++) {
            arr[i][1] = 1;
            arr[i][i] = 1;

            for (int j = 2; j < i; j++) {
                arr[i][j] = arr[i - 1][j - 1] + arr[i - 1][j];
            }
        }
        // for (int i = 1; i < n + 1; i++) {
        // System.out.println(Arrays.toString(arr[i]));

        // }
        System.out.println(arr[n][k]);
    }
}