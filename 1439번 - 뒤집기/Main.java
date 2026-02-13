
/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 1439                              :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: thxogh1 <boj.kr/u/thxogh1>                  +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/1439                           #+#        #+#      #+#    */
/*   Solved: 2026/02/13 12:31:03 by thxogh1       ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        char start = str.charAt(0);
        int ans = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) != start) {
                ans += 1;
                while (i < str.length() && str.charAt(i) != start) {
                    i++;
                }
            }
        }
        System.out.println(ans);
    }
}

// 1100110011001100