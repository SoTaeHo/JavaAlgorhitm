/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 2563                              :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: thxogh1 <boj.kr/u/thxogh1>                  +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/2563                           #+#        #+#      #+#    */
/*   Solved: 2025/02/19 08:31:28 by thxogh1       ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[][] map = new int[101][101];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            for (int j = 0; j < 10; j++) {
                for (int k = 0; k < 10; k++) {
                    map[x + j][y + k] = 1;
                }
            }
        }
        int result = 0;
        for (int i = 0; i < 101; i++) {
            for (int j = 0; j < 101; j++) {
                if (map[i][j] == 1) {
                    result++;
                }
            }
        }

        // for (int i = 0; i < 101; i++) {
        // for (int j = 0; j < 101; j++) {
        // System.out.print(map[i][j]);
        // }
        // System.out.println();
        // }
        System.out.println(result);
    }
}