/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 1182                              :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: thxogh1 <boj.kr/u/thxogh1>                  +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/1182                           #+#        #+#      #+#    */
/*   Solved: 2025/02/27 09:54:59 by thxogh1       ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] arr;
    static int result = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        subset(0, 0, true, n, s);
        System.out.println(result);
    }

    public static void subset(int depth, int total, boolean isFirst, int n, int s) {
        if (depth == n) {
            if (total == s && !isFirst) {
                System.out.println("hi");
                result++;
            }
            return;
        }
        if (total == s && !isFirst) {
            result++;
            // return;
        }
        subset(depth + 1, total + arr[depth], false, n, s);
        subset(depth + 1, total, true, n, s);
    }
}
