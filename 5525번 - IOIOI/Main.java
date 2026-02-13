
/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 5525                              :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: thxogh1 <boj.kr/u/thxogh1>                  +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/5525                           #+#        #+#      #+#    */
/*   Solved: 2026/02/13 13:23:23 by thxogh1       ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        char[] s = br.readLine().toCharArray();

        int ans = 0;
        int count = 0;

        for (int i = 0; i + 2 < M; i++) {
            if (s[i] == 'I' && s[i + 1] == 'O' && s[i + 2] == 'I') {
                count++;
                if (count >= N) {
                    ans++;
                }
                i += 1;
            } else {
                count = 0;
            }
        }

        System.out.println(ans);
    }
}