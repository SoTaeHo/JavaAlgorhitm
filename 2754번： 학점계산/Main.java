/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 2754                              :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: thxogh1 <boj.kr/u/thxogh1>                  +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/2754                           #+#        #+#      #+#    */
/*   Solved: 2025/03/18 16:13:58 by thxogh1       ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String score = br.readLine();
        if (score.length() == 1) {
            System.out.println("0.0");
        } else {
            String remainder;
            if (score.charAt(1) == '+')
                remainder = ".3";
            else if (score.charAt(1) == '-')
                remainder = ".7";
            else
                remainder = ".0";
            System.out.println((Math.abs(score.charAt(0) - 69) - (score.charAt(1) == '-' ? 1 : 0)) + remainder);
        }
    }

}