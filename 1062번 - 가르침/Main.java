
/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 1062                              :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: thxogh1 <boj.kr/u/thxogh1>                  +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/1062                           #+#        #+#      #+#    */
/*   Solved: 2025/10/21 08:28:59 by thxogh1       ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static boolean[] canRead;
    static int N, K, max = 0;
    static String[] arr;

    static boolean check(String word) {
        for (int i = 0; i < word.length(); i++) {
            if (!canRead[word.charAt(i) - 'a']) {
                return false;
            }
        }
        return true;
    }

    static void dfs(int cnt, int start) {
        if (cnt == K - 5) {
            int readable = 0;
            for (String word : arr) {
                if (check(word)) {
                    readable += 1;
                }
            }
            max = Math.max(max, readable);
        }

        for (int i = start; i < 26; i++) {
            if (!canRead[i]) {
                canRead[i] = true;
                dfs(cnt + 1, i + 1);
                canRead[i] = false;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        canRead = new boolean[26];
        if (K < 5) {
            System.out.println(0);
            return;
        } else if (K == 26) {
            System.out.println(N);
            return;
        }
        arr = new String[N];
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            arr[i] = str.substring(4, str.length() - 4);
        }

        canRead['a' - 'a'] = true;
        canRead['c' - 'a'] = true;
        canRead['i' - 'a'] = true;
        canRead['n' - 'a'] = true;
        canRead['t' - 'a'] = true;

        dfs(0, 0);

        System.out.println(max);
    }
}

// a, c, i, n, t
