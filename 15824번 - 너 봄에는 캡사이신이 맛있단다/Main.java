
/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 15824                             :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: thxogh1 <boj.kr/u/thxogh1>                  +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/15824                          #+#        #+#      #+#    */
/*   Solved: 2026/01/28 20:50:49 by thxogh1       ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static final long MOD = 1_000_000_007L;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        long[] arr = new long[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }

        Arrays.sort(arr);

        long[] pow = new long[N + 1];
        pow[0] = 1;
        for (int i = 1; i < N + 1; i++) {
            pow[i] = (pow[i - 1] * 2) % MOD;
        }

        long maxSum = 0;
        long minSum = 0;

        for (int i = 0; i < N; i++) {
            maxSum = (maxSum + arr[i] * pow[i]) % MOD;
            minSum = (minSum + arr[i] * pow[N - 1 - i]) % MOD;
        }

        long ans = (maxSum - minSum) % MOD;
        if (ans < 0) {
            ans += MOD;
        }

        System.out.println(ans);
    }
}