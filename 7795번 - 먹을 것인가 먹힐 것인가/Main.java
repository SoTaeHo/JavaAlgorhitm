
/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 7795                              :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: thxogh1 <boj.kr/u/thxogh1>                  +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/7795                           #+#        #+#      #+#    */
/*   Solved: 2025/09/19 08:55:01 by thxogh1       ###          ###   ##.kr    */
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

        int tcase = Integer.parseInt(br.readLine());

        for (int T = 0; T < tcase; T++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            int[] arr = new int[a];
            int[] brr = new int[b];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < a; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < b; i++) {
                brr[i] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(brr);
            Arrays.sort(arr);
            int idx = a - 1;
            int ans = 0;
            int e = b - 1;
            while (idx >= 0 && e >= 0) {
                // System.out.println("arr[idx] : " + arr[idx] + " / brr[e] : " + brr[e] + " / e
                // : " + e);
                if (arr[idx] > brr[e]) {
                    ans += e + 1;
                    idx -= 1;
                } else {
                    e -= 1;
                }
            }
            System.out.println(ans);
        }
    }
}