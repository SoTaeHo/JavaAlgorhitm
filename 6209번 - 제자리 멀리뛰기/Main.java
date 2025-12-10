
/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 6209                              :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: thxogh1 <boj.kr/u/thxogh1>                  +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/6209                           #+#        #+#      #+#    */
/*   Solved: 2025/12/10 16:00:01 by thxogh1       ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static boolean possible(int[] island, int mid, int m) {
        int removed = 0;
        int last = 0;

        for (int i = 1; i < island.length; i++) {
            if (island[i] - island[last] < mid) {
                removed += 1;
            } else {
                last = i;
            }
        }

        return removed <= m;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int d = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] island = new int[n + 2];
        island[0] = 0;
        island[n + 1] = d;
        for (int i = 1; i <= n; i++) {
            island[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(island);

        int left = 1;
        int right = d;
        int ans = 0;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (possible(island, mid, m)) {
                ans = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        System.out.println(ans);
    }
}

// 0 2 11 14 17 21 25
// 2 9 3 3 4 4

// 0 11 17 21 25