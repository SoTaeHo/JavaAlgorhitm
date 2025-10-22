
/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 17609                             :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: thxogh1 <boj.kr/u/thxogh1>                  +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/17609                          #+#        #+#      #+#    */
/*   Solved: 2025/10/22 08:50:22 by thxogh1       ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static int check(String str, int start, int end, boolean skipped) {
        while (start < end) {
            if (str.charAt(start) == str.charAt(end)) {
                start += 1;
                end -= 1;
            } else {
                if (skipped) {
                    return 2;
                } else {
                    int left = check(str, start + 1, end, true);
                    int right = check(str, start, end - 1, true);

                    return Math.min(left, right);
                }
            }
        }
        if (skipped) {
            return 1;
        } else {
            return 0;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int tcase = 0; tcase < T; tcase++) {
            String str = br.readLine();
            System.out.println(check(str, 0, str.length() - 1, false));
            ;
        }
    }
}