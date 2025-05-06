
/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 1644                              :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: thxogh1 <boj.kr/u/thxogh1>                  +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/1644                           #+#        #+#      #+#    */
/*   Solved: 2025/05/06 14:30:23 by thxogh1       ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static boolean[] getPrimes(int n) {
        boolean[] isPrime = new boolean[n + 1];
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;

        for (int i = 2; i * i <= n; i++) {
            if (!isPrime[i])
                continue;
            for (int j = i * i; j <= n; j += i) {
                isPrime[j] = false;
            }
        }
        return isPrime;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        boolean[] isPrime = getPrimes(n);
        List<Integer> li = new ArrayList<>();

        for (int i = 0; i < n + 1; i++) {
            if (isPrime[i])
                li.add(i);
        }
        int l = 0;
        int r = 1;
        if (li.size() == 1) {
            System.out.println(1);
            return;
        }
        int ans = 0;
        while (l <= r && r < li.size()) {
            // System.out.println(l + " " + r);
            int temp = 0;
            for (int i = l; i <= r; i++) {
                temp += li.get(i);
            }
            // System.out.println(temp);
            if (temp == n) {
                ans += 1;
                r += 1;
            } else if (temp > n) {
                l += 1;
            } else if (temp < n) {
                r += 1;
            }
        }
        System.out.println(ans);
    }
}