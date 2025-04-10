
/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 1786                              :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: thxogh1 <boj.kr/u/thxogh1>                  +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/1786                           #+#        #+#      #+#    */
/*   Solved: 2025/04/10 10:08:39 by thxogh1       ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static int cnt = 0;

    static void kmp(String p, int[] pi) {
        int n = p.length();
        int i = -1;
        int j = 0;
        pi[j] = i;

        while (j < n) {
            // abaaba
            if (i == -1 || p.charAt(i) == p.charAt(j)) {
                pi[++j] = ++i;
            } else {
                i = pi[i];
            }
        }
    }

    static void find(String t, String p, int[] pi) {
        int n = t.length();
        int m = p.length();

        int i = 0;
        int j = 0;

        while (i < n) {
            if (j == -1 || t.charAt(i) == p.charAt(j)) {
                i++;
                j++;
            } else {
                j = pi[j];
            }
            if (j == m) {
                cnt++;
                sb.append(i - j + 1).append(' ');
                j = pi[j];
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String t = br.readLine();
        String p = br.readLine();

        int[] pi = new int[p.length() + 1];

        kmp(p, pi);
        find(t, p, pi);
        System.out.println(cnt);
        System.out.println(sb);
    }
}