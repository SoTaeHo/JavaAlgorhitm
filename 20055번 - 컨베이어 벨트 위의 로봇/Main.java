
/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 20055                             :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: thxogh1 <boj.kr/u/thxogh1>                  +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/20055                          #+#        #+#      #+#    */
/*   Solved: 2025/10/01 08:52:19 by thxogh1       ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] belt = new int[2 * n];
        boolean[] isBlank = new boolean[n];
        Arrays.fill(isBlank, true);
        int cnt = 0;
        int idx = 0;
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < 2 * n; i++) {
            belt[i] = Integer.parseInt(st.nextToken());
            if (belt[i] == 0) {
                cnt += 1;
            }
        }

        while (cnt < k) {
            // 1. 벨트 회전
            int temp = belt[2 * n - 1];
            for (int i = 2 * n - 2; i >= 0; i--) {
                belt[i + 1] = belt[i];
            }
            belt[0] = temp;

            for (int i = n - 2; i >= 0; i--) {
                isBlank[i + 1] = isBlank[i];
            }
            isBlank[0] = true;
            isBlank[n - 1] = true;
            // 2. 가장 먼저 올라간 로봇부터 이동
            for (int i = n - 2; i >= 0; i--) {
                if (!isBlank[i] && isBlank[i + 1] && belt[i + 1] > 0) {
                    isBlank[i] = true;
                    isBlank[i + 1] = false;
                    belt[i + 1] -= 1;
                    if (belt[i + 1] == 0) {
                        cnt += 1;
                    }
                }
            }
            isBlank[n - 1] = true;
            // 3. 올리는 위치
            if (belt[0] != 0) {
                isBlank[0] = false;
                belt[0] -= 1;
                if (belt[0] == 0) {
                    cnt += 1;
                }

            }
            // 4. k 이상이면 종료
            // System.out.println(idx + " : cnt = " + cnt);
            // System.out.println(Arrays.toString(belt));
            idx += 1;
        }
        System.out.println(idx);
    }
}