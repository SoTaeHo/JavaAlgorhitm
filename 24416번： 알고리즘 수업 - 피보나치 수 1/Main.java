
/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 24416                             :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: thxogh1 <boj.kr/u/thxogh1>                  +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/24416                          #+#        #+#      #+#    */
/*   Solved: 2025/04/07 08:15:45 by thxogh1       ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static int[] d;
    static int first = 0;
    static int second = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        d = new int[n + 1];
        d[1] = 1;
        d[2] = 1;
        fib(n);
        dp(n);
        System.out.println(first + " " + second);
    }

    static int fib(int n) {
        if (n == 1 || n == 2) {
            first++;
            return 1;
        } else
            return fib(n - 1) + fib(n - 2);
    }

    static int dp(int n) {
        for (int i = 3; i < n + 1; i++) {
            d[i] = d[i - 1] + d[i - 2];
            second++;
        }
        return d[n];
    }
}