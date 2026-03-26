/* ************************************************************************** */
 /* */
 /* :::    :::    :::   */
 /* Problem Number: 2159                               :+:    :+:      :+:   */
 /* +:+    +:+        +:+  */
 /* By: thxogh1 <boj.kr/u/thxogh1>                 +#+    +#+          +#+  */
 /* +#+      +#+        +#+   */
 /* https://boj.kr/2159                         #+#        #+#      #+#    */
 /* Solved: 2026/03/26 21:15:20 by thxogh1       ###          ###   ##.kr    */
 /* */
 /* ************************************************************************** */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[] dx = {0, -1, 1, 0, 0};
    static int[] dy = {0, 0, 0, -1, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());

        long[] dp = new long[5];
        int[] prevX = new int[5];
        int[] prevY = new int[5];

        for (int i = 0; i < 5; i++) {
            prevX[i] = x;
            prevY[i] = y;
        }

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            int nx = Integer.parseInt(st.nextToken());
            int ny = Integer.parseInt(st.nextToken());

            long[] nextDp = new long[5];
            int[] nextX = new int[5];
            int[] nextY = new int[5];

            for (int j = 0; j < 5; j++) {
                nextX[j] = nx + dx[j];
                nextY[j] = ny + dy[j];
                nextDp[j] = Long.MAX_VALUE;

                if (nextX[j] < 1 || nextX[j] > 100000 || nextY[j] < 1 || nextY[j] > 100000) {
                    continue;
                }

                for (int k = 0; k < 5; k++) {
                    if (prevX[k] < 1 || prevX[k] > 100000 || prevY[k] < 1 || prevY[k] > 100000) {
                        continue;
                    }

                    long dist = Math.abs(prevX[k] - nextX[j]) + Math.abs(prevY[k] - nextY[j]);
                    nextDp[j] = Math.min(nextDp[j], dp[k] + dist);
                }
            }

            dp = nextDp;
            prevX = nextX;
            prevY = nextY;
        }

        long answer = Long.MAX_VALUE;
        for (int i = 0; i < 5; i++) {
            answer = Math.min(answer, dp[i]);
        }

        System.out.println(answer);
    }
}
