/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 2941                              :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: thxogh1 <boj.kr/u/thxogh1>                  +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/2941                           #+#        #+#      #+#    */
/*   Solved: 2025/03/05 07:59:37 by thxogh1       ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();

        int length = str.length();
        // System.out.println(length);
        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i) == '=') {
                if (str.charAt(i - 1) == 'z' && i > 1 && str.charAt(i - 2) == 'd') {
                    length -= 2;
                } else {
                    length -= 1;
                }
            } else if (str.charAt(i) == 'j') {
                if (str.charAt(i - 1) == 'n' || str.charAt(i - 1) == 'l')
                    length -= 1;
            } else if (str.charAt(i) == '-') {
                length -= 1;
            }
        }
        System.out.println(length);
    }
}