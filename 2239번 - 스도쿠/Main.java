
/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 2239                              :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: thxogh1 <boj.kr/u/thxogh1>                  +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/2239                           #+#        #+#      #+#    */
/*   Solved: 2025/05/05 20:09:47 by thxogh1       ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static int[][] map;
    static String ans = "";
    static boolean complete;

    static boolean isValid(int x, int y, int num) {
        for (int i = 0; i < 9; i++) {
            if (map[x][i] == num) {
                return false;
            }
            if (map[i][y] == num) {
                return false;
            }

        }
        int nx = (x / 3) * 3;
        int ny = (y / 3) * 3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (map[nx + i][ny + j] == num) {
                    return false;
                }
            }
        }
        return true;
    }

    static String makeString() {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                sb.append(map[i][j]);
            }
        }
        return sb.toString();
    }

    static void sudoku(int x, int y) {
        if (x == 9 && y == 0) {
            complete = true;
            ans = makeString();
            return;
        }
        int nextX = x;
        int nextY = y + 1;
        if (nextY == 9) {
            nextX++;
            nextY = 0;
        }
        if (map[x][y] != 0) {
            sudoku(nextX, nextY);
        } else {
            for (int k = 1; k <= 9; k++) {

                if (isValid(x, y, k)) {
                    map[x][y] = k;
                    sudoku(nextX, nextY);
                    if (complete)
                        return;
                    map[x][y] = 0;
                }
            }
        }

    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        map = new int[9][9];
        for (int i = 0; i < 9; i++) {
            String str = br.readLine();
            for (int j = 0; j < 9; j++) {
                map[i][j] = str.charAt(j) - '0';
            }
        }
        sudoku(0, 0);
        for (int i = 0; i < ans.length(); i += 9) {
            System.out.println(ans.substring(i, i + 9));
        }

    }
}