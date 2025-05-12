
/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 1107                              :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: thxogh1 <boj.kr/u/thxogh1>                  +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/1107                           #+#        #+#      #+#    */
/*   Solved: 2025/05/12 09:27:45 by thxogh1       ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int cnt;
    static int value;
    static boolean[] arr;

    static void find(int idx, int num) {
        for (int i = 0; i < 10; i++) {
            if (!arr[i]) {
                int temp = num * 10 + i;
                int click = Math.abs(n - temp) + String.valueOf(temp).length();
                cnt = Math.min(cnt, click);
                if (idx < 6) {
                    find(idx + 1, temp);
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        StringTokenizer st;
        arr = new boolean[10];

        if (m > 0) {
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < m; i++) {
                arr[Integer.parseInt(st.nextToken())] = true;
            }
        }
        if (n == 100) {
            System.out.println(0);
            return;
        }

        cnt = Math.abs(n - 100);
        find(0, 0);
        System.out.println(cnt);
    }
}