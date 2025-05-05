
/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 9252                              :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: thxogh1 <boj.kr/u/thxogh1>                  +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/9252                           #+#        #+#      #+#    */
/*   Solved: 2025/05/06 01:20:54 by thxogh1       ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String f = br.readLine();
        String s = br.readLine();

        int[][] dp = new int[f.length() + 1][s.length() + 1];

        for (int i = 1; i <= f.length(); i++) {
            for (int j = 1; j <= s.length(); j++) {
                if (f.charAt(i - 1) == s.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        System.out.println(dp[f.length()][s.length()]);
        StringBuilder lcs = new StringBuilder();
        int i = f.length(), j = s.length();
        while (i > 0 && j > 0) {
            if (f.charAt(i - 1) == s.charAt(j - 1)) {
                lcs.append(f.charAt(i - 1));
                i--;
                j--;
            } else if (dp[i - 1][j] > dp[i][j - 1]) {
                i--;
            } else {
                j--;
            }
        }

        System.out.println(lcs.reverse().toString());
    }
}