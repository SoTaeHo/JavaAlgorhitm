
/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 7490                              :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: thxogh1 <boj.kr/u/thxogh1>                  +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/7490                           #+#        #+#      #+#    */
/*   Solved: 2025/10/02 09:49:10 by thxogh1       ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    static char[] arr;
    static StringBuilder sb;
    static List<String> li;

    static int evaluate(String s) {
        int sum = 0, num = 0, sign = 1;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                num = num * 10 + (c - '0');
            } else {
                sum += sign * num;
                num = 0;
                sign = (c == '+') ? 1 : -1;
            }
        }
        sum += sign * num;
        return sum;
    }

    static void solve(int n, int depth) {

        if (depth == n - 1) {
            if (depth == n - 1) {
                StringBuilder expr = new StringBuilder();
                for (int i = 0; i < n - 1; i++) {
                    expr.append(i + 1).append(arr[i]);
                }
                expr.append(n);

                String evalStr = expr.toString().replaceAll(" ", "");
                int ans = evaluate(evalStr);

                if (ans == 0) {
                    li.add(expr.toString());
                    // sb.append(expr).append("\n");
                }
                return;
            }
        }

        for (int i = 0; i < 3; i++) {
            if (i == 0) {
                arr[depth] = '+';
            } else if (i == 1) {
                arr[depth] = '-';
            } else if (i == 2) {
                arr[depth] = ' ';
            }

            solve(n, depth + 1);
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        int tcase = Integer.parseInt(br.readLine());
        for (int T = 0; T < tcase; T++) {
            int n = Integer.parseInt(br.readLine());
            li = new ArrayList<>();

            arr = new char[n - 1];
            solve(n, 0);
            Collections.sort(li);
            for (String str : li) {
                System.out.println(str);
            }
            System.out.println();
        }
    }
}