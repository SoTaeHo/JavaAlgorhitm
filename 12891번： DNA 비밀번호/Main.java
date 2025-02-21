/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 12891                             :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: thxogh1 <boj.kr/u/thxogh1>                  +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/12891                          #+#        #+#      #+#    */
/*   Solved: 2025/02/21 15:12:31 by thxogh1       ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int s = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());

        String str = br.readLine();

        st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int g = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());
        int result = 0;
        int[] ans = new int[4];
        for (int i = 0; i < p; i++) {
            if (str.charAt(i) == 'A')
                ans[0]++;
            else if (str.charAt(i) == 'C')
                ans[1]++;
            else if (str.charAt(i) == 'G')
                ans[2]++;
            else if (str.charAt(i) == 'T')
                ans[3]++;
        }
        if (ans[0] >= a && ans[1] >= c && ans[2] >= g && ans[3] >= t) {
            result++;
        }
        for (int i = 0; i < s - p; i++) {
            if (str.charAt(i) == 'A')
                ans[0]--;
            else if (str.charAt(i) == 'C')
                ans[1]--;
            else if (str.charAt(i) == 'G')
                ans[2]--;
            else if (str.charAt(i) == 'T')
                ans[3]--;

            if (str.charAt(i + p) == 'A')
                ans[0]++;
            else if (str.charAt(i + p) == 'C')
                ans[1]++;
            else if (str.charAt(i + p) == 'G')
                ans[2]++;
            else if (str.charAt(i + p) == 'T')
                ans[3]++;

            if (ans[0] >= a && ans[1] >= c && ans[2] >= g && ans[3] >= t) {
                result++;
            }
        }
        System.out.println(result);
    }

}