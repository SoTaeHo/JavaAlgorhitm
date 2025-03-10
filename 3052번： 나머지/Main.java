/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 3052                              :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: thxogh1 <boj.kr/u/thxogh1>                  +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/3052                           #+#        #+#      #+#    */
/*   Solved: 2025/03/10 17:05:56 by thxogh1       ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        boolean[] visited = new boolean[42];
        int cnt = 0;
        for (int i = 0; i < 10; i++) {
            int n = Integer.parseInt(br.readLine());

            if (!visited[n % 42]) {

                visited[n % 42] = true;
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}