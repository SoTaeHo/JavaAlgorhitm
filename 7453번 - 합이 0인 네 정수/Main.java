/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 7453                              :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: thxogh1 <boj.kr/u/thxogh1>                  +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/7453                           #+#        #+#      #+#    */
/*   Solved: 2025/04/25 18:44:34 by thxogh1       ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[] a = new int[n];
        int[] b = new int[n];
        int[] c = new int[n];
        int[] d = new int[n];
        int[] ab = new int[n * n];
        int[] cd = new int[n * n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            a[i] = Integer.parseInt(st.nextToken());
            b[i] = Integer.parseInt(st.nextToken());
            c[i] = Integer.parseInt(st.nextToken());
            d[i] = Integer.parseInt(st.nextToken());
        }
        int idx = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                ab[idx] = a[i] + b[j];
                cd[idx] = c[i] + d[j];
                idx++;
            }
        }
        Arrays.sort(ab);
        Arrays.sort(cd);

        int s = 0;
        int e = n * n - 1;
        long ans = 0;

        while (s < n * n && e >= 0) {
            if (ab[s] + cd[e] < 0) {
                s++;
            } else if (ab[s] + cd[e] > 0) {
                e--;
            } else if (ab[s] + cd[e] == 0) {
                long sc = 1;
                long ec = 1;
                while (s + 1 < n * n && ab[s] == ab[s + 1]) {
                    sc++;
                    s++;
                }
                while (e - 1 >= 0 && cd[e] == cd[e - 1]) {
                    ec++;
                    e--;
                }
                ans += sc * ec;
                s++;
            }
        }
        System.out.println(ans);
    }
}

// 1000 000 000 000
// n^4 = 4조 => 브루트포스 다메