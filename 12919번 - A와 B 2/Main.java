
/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 12919                             :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: thxogh1 <boj.kr/u/thxogh1>                  +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/12919                          #+#        #+#      #+#    */
/*   Solved: 2026/03/25 16:24:58 by thxogh1       ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */
import java.io.*;
import java.util.*;

public class Main {

    static String S;
    static int answer = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        S = br.readLine();
        String T = br.readLine();

        dfs(T);

        System.out.println(answer);
    }

    static void dfs(String cur) {
        if (answer == 1)
            return;

        if (cur.length() == S.length()) {
            if (cur.equals(S))
                answer = 1;
            return;
        }

        if (cur.charAt(cur.length() - 1) == 'A') {
            dfs(cur.substring(0, cur.length() - 1));
        }

        if (cur.charAt(0) == 'B') {
            String next = cur.substring(1);
            String reversed = new StringBuilder(next).reverse().toString();
            dfs(reversed);
        }
    }
}