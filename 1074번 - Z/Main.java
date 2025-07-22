
/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 1074                              :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: thxogh1 <boj.kr/u/thxogh1>                  +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/1074                           #+#        #+#      #+#    */
/*   Solved: 2025/07/22 08:38:57 by thxogh1       ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int ans = 0;

    static public void rec(int n, int r, int c) {
        if (n == 0) {
            return;
        }
        int nr = r % (int) Math.pow(2, n - 1);
        int nc = c % (int) Math.pow(2, n - 1);

        int dr = r / (int) Math.pow(2, n - 1);
        int dc = c / (int) Math.pow(2, n - 1);

        if (dr == 0 && dc == 0) {
            ans += (int) Math.pow(4, n - 1) * 0;
        } else if (dr == 0 && dc == 1) {
            ans += (int) Math.pow(4, n - 1) * 1;
        } else if (dr == 1 && dc == 0) {
            ans += (int) Math.pow(4, n - 1) * 2;
        } else if (dr == 1 && dc == 1) {
            ans += (int) Math.pow(4, n - 1) * 3;
        }
        // System.out.println(ans);
        rec(n - 1, nr, nc);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        rec(n, r, c);
        System.out.println(ans);
    }
}