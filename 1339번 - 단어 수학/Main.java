
/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 1339                              :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: thxogh1 <boj.kr/u/thxogh1>                  +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/1339                           #+#        #+#      #+#    */
/*   Solved: 2026/01/12 14:26:31 by thxogh1       ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] weight = new int[26];

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < str.length(); j++) {
                weight[str.charAt(j) - 'A'] += (int) Math.pow(10, str.length() - j - 1);
            }
        }

        Arrays.sort(weight);

        int num = 9;
        int ans = 0;

        for (int i = 25; i >= 0; i--) {
            if (weight[i] == 0)
                break;
            ans += weight[i] * num;
            num -= 1;
        }

        System.out.println(ans);
    }
}

// ABCDEFGHIJ

// AB