/* ************************************************************************** */
 /*                                                                            */
 /*                                                      :::    :::    :::     */
 /*   Problem Number: 1541                              :+:    :+:      :+:    */
 /*                                                    +:+    +:+        +:+   */
 /*   By: thxogh1 <boj.kr/u/thxogh1>                  +#+    +#+          +#+  */
 /*                                                  +#+      +#+        +#+   */
 /*   https://boj.kr/1541                           #+#        #+#      #+#    */
 /*   Solved: 2025/09/26 21:43:34 by thxogh1       ###          ###   ##.kr    */
 /*                                                                            */
 /* ************************************************************************** */
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String expression = br.readLine();
        int ans = 0;
        int temp = 0;
        boolean isMinus = false;
        for (int i = 0; i < expression.length(); i++) {
            char now = expression.charAt(i);
            if ('0' <= now && now <= '9') {
                temp = temp * 10 + (now - '0');
            } else if (now == '-') {
                if (isMinus) {
                    ans -= temp;
                } else {
                    ans += temp;
                    isMinus = true;
                }
                temp = 0;
            } else if (now == '+') {
                if (isMinus) {
                    ans -= temp;
                } else {
                    ans += temp;
                }
                temp = 0;
            }
        }
        if (isMinus) {
            ans -= temp;
        } else {
            ans += temp;
        }
        System.out.println(ans);
    }
}
