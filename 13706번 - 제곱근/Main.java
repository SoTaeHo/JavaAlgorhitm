
/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 13706                             :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: thxogh1 <boj.kr/u/thxogh1>                  +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/13706                          #+#        #+#      #+#    */
/*   Solved: 2025/07/30 08:51:56 by thxogh1       ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {

    public static BigInteger sqrt(BigInteger n) {
        if (BigInteger.ONE == n) {
            return n;
        }

        BigInteger two = BigInteger.valueOf(2);
        BigInteger low = BigInteger.ONE;
        BigInteger high = n;
        BigInteger mid, squared;

        while (low.compareTo(high) <= 0) {
            mid = low.add(high).divide(two);
            squared = mid.multiply(mid);

            int cmp = squared.compareTo(n);
            if (cmp == 0) {
                return mid;
            } else if (cmp < 0) {
                low = mid.add(BigInteger.ONE);
            } else {
                high = mid.subtract(BigInteger.ONE);
            }
        }

        return high;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BigInteger n = new BigInteger(br.readLine());
        System.out.println(sqrt(n));
    }
}