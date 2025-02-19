/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 27434                             :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: thxogh1 <boj.kr/u/thxogh1>                  +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/27434                          #+#        #+#      #+#    */
/*   Solved: 2025/02/19 09:23:35 by thxogh1       ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        BigInteger num = fact(1, n);
        System.out.println(num);
    }

    public static BigInteger fact(int a, int n) {
        BigInteger temp = BigInteger.valueOf(a);
        if (a < n) {
            int b = (a + n) / 2;
            temp = fact(a, b).multiply(fact(b + 1, n));
        }
        return temp;
    }
}