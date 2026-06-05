import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        int[] prefix = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            prefix[i] = prefix[i - 1] + Integer.parseInt(st.nextToken());
        }

        int m = Integer.parseInt(br.readLine());

        int[][] dp = new int[4][n + 1];

        for (int k = 1; k < 4; k++) {
            for (int i = k * m; i <= n; i++) {
                int section = prefix[i] - prefix[i - m];
                dp[k][i] = Math.max(dp[k][i - 1], dp[k - 1][i - m] + section);
            }
        }

        System.out.println(dp[3][n]);
    }
}