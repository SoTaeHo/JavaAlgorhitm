
/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 1016                              :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: thxogh1 <boj.kr/u/thxogh1>                  +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/1016                           #+#        #+#      #+#    */
/*   Solved: 2025/09/09 08:39:52 by thxogh1       ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    // static List<Integer> sieve6k(long n) {
    // List<Integer> primes = new ArrayList<>();

    // if (n < 2)
    // return primes;

    // if (n >= 2)
    // primes.add(2);
    // if (n >= 3)
    // primes.add(3);

    // Map<Long, Boolean> isPrime = new HashMap<>();
    // for (long i = 5; i <= n; i += 6) {
    // if (i <= n) {
    // isPrime.put(i, true);
    // }
    // if (i + 2 <= n) {
    // isPrime.put(i, true);
    // }
    // }

    // for (int i = 5; (long) i * i <= n; i += (i % 6 == 1 ? 4 : 2)) {
    // if (isPrime.get(i)) {
    // for (long j = i * i; j <= n; j += i * 2) {
    // isPrime.put(j, false);
    // }
    // }
    // }

    // for (int i = 5; i <= n; i++) {
    // if (isPrime.get(i)) {
    // primes.add(i);
    // }
    // }
    // return primes;
    // }

    // static List<Integer> sieve(int n) {
    // boolean[] isComplete = new boolean[n + 1];

    // isComplete[0] = true;
    // isComplete[1] = true;

    // for (int i = 2; i * i <= n; i++) {
    // if (!isComplete[i]) {
    // for (int j = i; j <= n; j += i) {
    // isComplete[j] = true;
    // }
    // }
    // }

    // List<Integer> primes = new ArrayList<>();
    // for (int i = 2; i <= n; i++) {
    // if (!isComplete[i])
    // primes.add(i);
    // }
    // return primes;
    // }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long minNum = Long.parseLong(st.nextToken());
        long maxNum = Long.parseLong(st.nextToken());

        int size = (int) (maxNum - minNum + 1);

        boolean[] isNotSquare = new boolean[size];

        int limit = (int) Math.sqrt(maxNum);
        boolean[] isPrime = new boolean[limit + 1];
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;

        for (int i = 2; i * i <= limit; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= limit; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        for (int i = 2; i <= limit; i++) {
            if (!isPrime[i]) {
                continue;
            }
            long square = (long) i * i;
            long start = ((minNum + square - 1) / square) * square;
            for (long j = start; j <= maxNum; j += square) {
                isNotSquare[(int) (j - minNum)] = true;
            }
        }

        int ans = 0;
        for (boolean val : isNotSquare) {
            if (val) {
                ans++;
            }
        }
        System.out.println(ans);
    }
}