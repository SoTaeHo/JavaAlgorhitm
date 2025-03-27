
/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 15686                             :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: thxogh1 <boj.kr/u/thxogh1>                  +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/15686                          #+#        #+#      #+#    */
/*   Solved: 2025/03/27 13:00:20 by thxogh1       ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static class Point {
        int row;
        int col;

        Point(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    static int n;
    static int m;
    static List<Point> chicken;
    static List<Point> house;
    static boolean[] visited;
    static int[][] map;
    static int result = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n + 1][n + 1];
        chicken = new ArrayList<>();
        house = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 2) {
                    chicken.add(new Point(i, j));
                } else if (map[i][j] == 1) {
                    house.add(new Point(i, j));
                }
            }
        }
        visited = new boolean[chicken.size()];

        combination(0);

        System.out.println(result);
    }

    static void combination(int depth) {
        if (depth == m) {
            int temp = calc();
            System.out.println(Arrays.toString(visited));
            result = Math.min(result, temp);
            return;
        }

        for (int i = depth; i < chicken.size(); i++) {
            if (visited[i])
                continue;

            visited[i] = true;
            combination(depth + 1);
            visited[i] = false;
        }
    }

    static int calc() {
        int result = 0;
        for (int i = 0; i < house.size(); i++) {
            int temp = 101;
            for (int j = 0; j < chicken.size(); j++) {
                if (!visited[j])
                    continue;
                int dist = Math.abs(house.get(i).row - chicken.get(j).row) +
                        Math.abs(house.get(i).col - chicken.get(j).col);
                temp = Math.min(temp, dist);
            }
            result += temp;
        }
        return result;
    }
}

/*
 * 0 i = 3
 * 1 i = 3
 * 2 i = 3
 * m = 3
 * 
 * 13 * 12 * 11 * 10 * 9 * 8 * ..
 * 
 */