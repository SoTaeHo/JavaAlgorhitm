import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA2117_홈_방범서비스 {
    static int cnt;
    static int ans;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int tcase = Integer.parseInt(br.readLine());

        for (int t = 1; t <= tcase; t++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            cnt = 0;
            ans = 0;
            int[][] map = new int[n][n];

            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            int k = 1;
            while (k <= n + 2) {
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        calc(map, i, j, k, m);
                    }
                }
                k++;
            }
            sb.append("#").append(t).append(" ").append(cnt).append('\n');
        }
        System.out.println(sb);
    }

    static void calc(int[][] map, int r, int c, int k, int m) {
        int result = 0;
        int cntHome = 0;
        for (int i = r - k + 1; i < r + k; i++) {
            for (int j = c - k + 1; j < c + k; j++) {
                if (!isValid(i, j, map.length))
                    continue;
                if (Math.abs(r - i) + Math.abs(c - j) >= k)
                    continue;
                if (map[i][j] == 1) {
                    cntHome++;
                    result += m;
                }
            }
        }

        result = result - ((k * k) + (k - 1) * (k - 1));
        if (cntHome > cnt && result >= 0) {
            cnt = cntHome;
            ans = result;
        }
    }

    static boolean isValid(int r, int c, int n) {
        return r >= 0 && r < n && c >= 0 && c < n;
    }
}