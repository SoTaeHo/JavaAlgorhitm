
/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 11054                             :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: thxogh1 <boj.kr/u/thxogh1>                  +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/11054                          #+#        #+#      #+#    */
/*   Solved: 2025/04/21 15:20:56 by thxogh1       ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        int[] arr = new int[1001];
        for (int i = 1; i < n + 1; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] down = new int[1001];
        int[] up = new int[1001];
        int ans = 0;

        for (int i = 1; i < n + 1; i++) {
            up[i] = 1;
            for (int j = 1; j < i; j++) {
                if (arr[j] < arr[i]) {
                    up[i] = Math.max(up[i], up[j] + 1);
                }
            }
        }
        for (int i = n; i >= 0; i--) {
            down[i] = 1;
            for (int j = i + 1; j < n + 1; j++) {
                if (arr[j] < arr[i]) {
                    down[i] = Math.max(down[i], down[j] + 1);
                }
            }
        }

        for (int i = 1; i < n + 1; i++) {
            ans = Math.max(ans, up[i] + down[i]);
        }
        System.out.println(ans - 1);
    }
}