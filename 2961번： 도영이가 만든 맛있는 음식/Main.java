
/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 2961                              :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: thxogh1 <boj.kr/u/thxogh1>                  +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/2961                           #+#        #+#      #+#    */
/*   Solved: 2025/02/21 13:40:59 by thxogh1       ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static Food[] arr;
    static long result = 2147483647;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        arr = new Food[n];
        visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i] = new Food(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        subset(0);
        System.out.println(result);
    }

    static class Food {
        public Food(int acidity, int acerbity) {
            this.acidity = acidity;
            this.acerbity = acerbity;
        }

        int acidity;
        int acerbity;
    }

    static void subset(int depth) {
        if (depth == n) {
            int isNothing = 0;
            for (int i = 0; i < n; i++) {
                if (!visited[i])
                    isNothing++;
            }
            if (isNothing == n)
                return;
            long taste = calculate();
            if (result > taste) {
                result = taste;
            }
            return;
        }

        visited[depth] = true;
        subset(depth + 1);

        visited[depth] = false;
        subset(depth + 1);
    }

    static long calculate() {
        long acidity = 1;
        long acerbity = 0;
        for (int i = 0; i < n; i++) {
            if (!visited[i])
                continue;
            acidity *= arr[i].acidity;
            acerbity += arr[i].acerbity;
        }
        // System.out.println(acidity);
        // System.out.println(acerbity);
        return Math.abs(acerbity - acidity);
    }
}