
/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 1027                              :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: thxogh1 <boj.kr/u/thxogh1>                  +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/1027                           #+#        #+#      #+#    */
/*   Solved: 2025/11/03 17:58:42 by thxogh1       ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] building = new int[N + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i < N + 1; i++) {
            building[i] = Integer.parseInt(st.nextToken());
        }
        int answer = 0;
        for (int i = 1; i < N + 1; i++) {
            int left = 0;
            int right = 0;

            double dx = -1000000000;
            for (int j = i - 1; j > 0; j--) {
                double temp = (double) (building[j] - building[i]) / (i - j);
                if (temp > dx) {
                    left += 1;
                    dx = temp;
                }
            }

            dx = -1000000000;
            for (int j = i + 1; j < N + 1; j++) {
                double temp = (double) (building[j] - building[i]) / (j - i);
                if (temp > dx) {
                    right += 1;
                    dx = temp;
                }
            }
            answer = Math.max(answer, left + right);
        }
        System.out.println(answer);
    }
}