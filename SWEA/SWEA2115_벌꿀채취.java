import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    static int maxIncome;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int tcase = Integer.parseInt(br.readLine());
        for (int t = 1; t <= tcase; t++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            maxIncome = 0;
            int maxNum = 0;
            int map[][] = new int[n][n];
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n - m + 1; j++) {
                    maxIncome = 0;
                    int first = getHoney(map, i, j, m, c);
                    for (int k = 0; k < n; k++) {
                        for (int l = 0; l < n - m + 1; l++) {
                            if (isDuplicate(i, j, k, l, n)) {
                                // System.out.println("continue");
                                continue;
                            }
                            maxIncome = 0;
                            int second = getHoney(map, k, l, m, c);
                            maxNum = Math.max(maxNum, first + second);
                        }
                    }
                }
            }
            System.out.print("#" + t + " ");
            System.out.println(maxNum);
        }
    }

    static boolean isDuplicate(int x1, int y1, int x2, int y2, int n) {
        if (x1 == x2 && y1 == y2)
            return true;
        else
            return x1 == x2 && Math.abs(y2 - y1) < n;
    }

    static int getHoney(int[][] map, int x, int y, int m, int c) {
        boolean[] visited = new boolean[m];
        subset(map, visited, 0, x, y, m, c);
        return maxIncome;
    }

    static void subset(int[][] map, boolean[] visited, int depth, int x, int y, int m, int c) {
        if (depth == m) {
            int weight = 0;
            int income = 0;
            for (int i = 0; i < visited.length; i++) {
                if (visited[i]) {
                    weight += map[x][y + i];
                    income += (int) Math.pow(map[x][y + i], 2);
                }
            }
            if (weight > c) {
                return;
            } else {
                maxIncome = Math.max(maxIncome, income);
            }
        }

        for (int i = depth; i < m; i++) {
            visited[i] = true;
            subset(map, visited, depth + 1, x, y, m, c);

            visited[i] = false;
            subset(map, visited, depth + 1, x, y, m, c);
        }
    }

}

// 1000*2^5