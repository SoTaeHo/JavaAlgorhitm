// /* ************************************************************************** */
// /*                                                                            */
// /*                                                      :::    :::    :::     */
// /*   Problem Number: 10974                             :+:    :+:      :+:    */
// /*                                                    +:+    +:+        +:+   */
// /*   By: thxogh1 <boj.kr/u/thxogh1>                  +#+    +#+          +#+  */
// /*                                                  +#+      +#+        +#+   */
// /*   https://boj.kr/10974                          #+#        #+#      #+#    */
// /*   Solved: 2025/02/19 10:36:28 by thxogh1       ###          ###   ##.kr    */
// /*                                                                            */
// /* ************************************************************************** */

// import java.util.Scanner;

// public class Main {

//     static int n;
//     static boolean[] visited;
//     static int[] arr;

//     public static void main(String[] args) {
//         Scanner sc = new Scanner(System.in);
//         n = sc.nextInt();
//         visited = new boolean[n];
//         arr = new int[n];
//         find(0);
//         sc.close();
//     }

//     public static void find(int cnt) {
//         if (cnt == n) {
//             StringBuilder sb = new StringBuilder("");
//             for (int i = 0; i < n; i++) {
//                 sb.append(arr[i]).append(" ");
//             }
//             sb.append('\n');
//             System.out.print(sb);
//             return;
//         }
//         for (int i = 0; i < n; i++) {
//             if (visited[i])
//                 continue;
//             visited[i] = true;
//             arr[cnt] = i + 1;
//             find(cnt + 1);
//             visited[i] = false;
//         }
//     }
// }

import java.io.IOException;
import java.util.Arrays;

public class Main {
    private static int N;
    private static char[] ans;
    private static boolean[] visit;
    private static StringBuilder sb;

    private static void backTracking(int len) {

        if (len == N) {
            sb.append(ans);
            return;
        }

        for (int i = 1; i <= N; i++) {
            if (visit[i])
                continue;
            ans[len << 1] = (char) (i + '0');
            visit[i] = true;
            backTracking(len + 1);
            visit[i] = false;
        }
    }

    public static void main(String[] args) throws IOException {
        N = System.in.read() - '0';
        sb = new StringBuilder();
        ans = new char[N << 1];
        visit = new boolean[N + 1];
        Arrays.fill(ans, ' ');
        ans[(N << 1) - 1] = '\n';

        backTracking(0);

        System.out.println(sb);
    }
}