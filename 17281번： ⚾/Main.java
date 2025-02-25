/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 17281                             :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: thxogh1 <boj.kr/u/thxogh1>                  +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/17281                          #+#        #+#      #+#    */
/*   Solved: 2025/02/25 15:53:20 by thxogh1       ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][9];
        int[] order = { 1, 2, 3, 4, 5, 6, 7, 8 };
        int maxScore = 0;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 9; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        do {
            int score = 0;
            int outCount = 0;
            boolean one = false;
            boolean two = false;
            boolean three = false;
            int now = 0; // order 에서의 포인터
            int[] newOrder = new int[9];
            System.arraycopy(order, 0, newOrder, 0, 3);
            newOrder[3] = 0;
            System.arraycopy(order, 3, newOrder, 4, 5);

            for (int i = 0; i < n; i++) {
                one = false;
                two = false;
                three = false;
                while (true) {

                    if (arr[i][newOrder[now]] == 0) {
                        outCount++;
                    } else if (arr[i][newOrder[now]] == 1) {
                        if (three) {
                            score++;
                            three = false;
                        }
                        if (two) {
                            three = true;
                            two = false;
                        }
                        if (one) {
                            two = true;
                        }
                        one = true;
                    } else if (arr[i][newOrder[now]] == 2) {
                        if (three) {
                            three = false;
                            score++;
                        }
                        if (two) {
                            two = false;
                            score++;
                        }
                        if (one) {
                            one = false;
                            three = true;
                        }
                        two = true;
                    } else if (arr[i][newOrder[now]] == 3) {
                        if (three) {
                            three = false;
                            score++;
                        }
                        if (two) {
                            two = false;
                            score++;
                        }
                        if (one) {
                            one = false;
                            score++;
                        }
                        three = true;
                    } else if (arr[i][newOrder[now]] == 4) {
                        if (three) {
                            score++;
                            three = false;
                        }
                        if (two) {
                            score++;
                            two = false;
                        }
                        if (one) {
                            score++;
                            one = false;
                        }
                        score++;
                    }
                    now = (now + 1) % 9;
                    if (outCount == 3) {
                        break;
                    }
                }
                outCount = 0;
            }
            if (maxScore < score)
                maxScore = score;
        } while (np(order, 8));
        System.out.println(maxScore);
    }

    public static boolean np(int[] arr, int n) {
        int i = n - 1;
        while (i > 0 && arr[i - 1] >= arr[i])
            i--;
        if (i == 0)
            return false;

        int j = n - 1;
        while (arr[i - 1] >= arr[j])
            j--;

        swap(arr, i - 1, j);

        int k = n - 1;
        while (i < k)
            swap(arr, i++, k--);
        return true;
    }

    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}