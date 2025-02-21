/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 15650                             :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: thxogh1 <boj.kr/u/thxogh1>                  +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/15650                          #+#        #+#      #+#    */
/*   Solved: 2025/02/21 09:47:12 by thxogh1       ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int[] arr;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();
    static int n;
    static int r;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        arr = new int[r];
        visited = new boolean[n + 1];
        combination(1, 0);
        System.out.println(sb);
    }

    public static void combination(int start, int depth) {
        if (depth == r) {
            for (int i = 0; i < arr.length; i++) {
                if (i == arr.length - 1)
                    sb.append(arr[i]).append('\n');
                else
                    sb.append(arr[i]).append(' ');
            }
            return;
        }

        for (int i = start; i <= n; i++) {
            if (visited[i])
                continue;
            visited[i] = true;
            arr[depth] = i;
            combination(i + 1, depth + 1);
            visited[i] = false;
        }
    }
    
    static void comb(int start, int depth, int n, int r) {
        // 조합이 완성된 경우
        if (depth == r) {
            System.out.println(Arrays.toString(output));
            return;
        }

        // start 부터 n까지 반복
        for (int i = start; i < n; i++) {
            output[depth] = arr[i]; // 현재 depth를 인덱스로 사용
            comb(i + 1, depth + 1, n, r); // i + 1, depth + 1를 전달
        }
    }
}