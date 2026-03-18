import java.util.*;
import java.io.*;

class Solution {
    public int solution(int[][] board, int[][] skill) {
        int N = board.length;
        int M = board[0].length;

        int[][] diff = new int[N + 1][M + 1];
        for (int[] s : skill) {
            int type = s[0], r1 = s[1], c1 = s[2], r2 = s[3], c2 = s[4], degree = s[5];
            int val = (type == 1 ? -degree : degree);

            diff[r1][c1] += val;
            diff[r1][c2 + 1] -= val;
            diff[r2 + 1][c1] -= val;
            diff[r2 + 1][c2 + 1] += val;
        }

        for (int i = 1; i < N; i++) {
            for (int j = 0; j <= M; j++) {
                diff[i][j] += diff[i - 1][j];
            }
        }

        for (int i = 0; i <= N; i++) {
            for (int j = 1; j < M; j++) {
                diff[i][j] += diff[i][j - 1];
            }
        }

        int answer = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (board[i][j] + diff[i][j] > 0) {
                    answer += 1;
                }
            }
        }

        return answer;
    }
}