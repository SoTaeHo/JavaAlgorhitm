
/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 9663                              :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: thxogh1 <boj.kr/u/thxogh1>                  +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/9663                           #+#        #+#      #+#    */
/*   Solved: 2025/05/02 09:04:31 by thxogh1       ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static int n;
    static int[] arr;
    static int ans;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        ans = 0;
        arr = new int[n + 1];
        queen(1);
        System.out.println(ans);
    }

    static void queen(int row) {
        if (row == n + 1) {
            ans += 1;
            return;
        }

        for (int i = 1; i < n + 1; i++) {
            arr[row] = i;

            if (posibility(row)) {
                queen(row + 1);
            }
        }
    }

    static boolean posibility(int row) {
        for (int i = 1; i < row; i++) {
            if (arr[row] == arr[i]) {
                return false;
            } else if (Math.abs(row - i) == Math.abs(arr[row] - arr[i])) {
                return false;
            }
        }
        return true;
    }
}