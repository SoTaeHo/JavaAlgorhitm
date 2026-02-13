
/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 10610                             :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: thxogh1 <boj.kr/u/thxogh1>                  +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/10610                          #+#        #+#      #+#    */
/*   Solved: 2026/02/13 12:44:15 by thxogh1       ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        char[] arr = str.toCharArray();

        StringBuilder sb = new StringBuilder();

        for (char c : arr) {
            sb.append(c);
        }

        int sum = 0;
        boolean hasZero = false;

        for (char c : arr) {
            sum += c - '0';
            if (c == '0')
                hasZero = true;
        }

        if (!hasZero || sum % 3 != 0) {
            System.out.println(-1);
            return;
        }

        for (int i = arr.length - 1; i >= 0; i--) {
            sb.append(arr[i]);
        }

        System.out.println(sb);
    }
}

// 30 60 90 120 150 180 210 240 270 300
// 330 360 390 420 450 480 510 540 570 600
// 630 660 690 720 750 780 810 840 870 900