
/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 1613                              :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: thxogh1 <boj.kr/u/thxogh1>                  +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/1613                           #+#        #+#      #+#    */
/*   Solved: 2025/08/06 08:56:25 by thxogh1       ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[][] d = new int[n + 1][n + 1];
        for (int i = 1; i < k + 1; i++) {
            st = new StringTokenizer(br.readLine());
            int front = Integer.parseInt(st.nextToken());
            int back = Integer.parseInt(st.nextToken());

            d[front][back] = -1;
            d[back][front] = 1;
        }

        for (int m = 1; m < n + 1; m++) {
            for (int f = 1; f < n + 1; f++) {
                for (int e = 1; e < n + 1; e++) {
                    if (d[f][m] == -1 && d[m][e] == -1) {
                        d[f][e] = -1;
                    } else if (d[f][m] == 1 && d[m][e] == 1) {
                        d[f][e] = 1;
                    }
                }
            }
        }

        int s = Integer.parseInt(br.readLine());

        for (int i = 0; i < s; i++) {
            st = new StringTokenizer(br.readLine());
            sb.append(d[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())]).append('\n');
        }
        System.out.println(sb);
    }
}