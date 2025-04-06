import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    static int tall, small, ans;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int tcase = Integer.parseInt(br.readLine());

        for (int t = 1; t <= tcase; t++) {
            int n = Integer.parseInt(br.readLine());
            int m = Integer.parseInt(br.readLine());
            ans = 0;
            int[][] map = new int[n + 1][n + 1];
            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                map[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = 1;
            }
            for (int i = 1; i <= n; i++) {
                tall = 0;
                small = 0;
                findTall(map, new boolean[n + 1], i, n);
                findSmall(map, new boolean[n + 1], i, n);
                if (tall + small == n - 1) {
                    ans++;
                }
            }
            sb.append("#").append(t).append(" ").append(ans).append('\n');

        }
        System.out.println(sb);
    }

    static void findTall(int[][] map, boolean[] visited, int from, int n) {
        visited[from] = true;
        for (int i = 1; i <= n; i++) {
            if (!visited[i] && map[from][i] == 1) {
                findTall(map, visited, i, n);
                tall++;
            }
        }
    }

    static void findSmall(int[][] map, boolean[] visited, int to, int n) {
        visited[to] = true;
        for (int i = 1; i <= n; i++) {
            if (!visited[i] && map[i][to] == 1) {
                findSmall(map, visited, i, n);
                small++;
            }
        }
    }
}
