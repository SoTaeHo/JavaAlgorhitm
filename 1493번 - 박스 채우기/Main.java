
/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 1493                              :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: thxogh1 <boj.kr/u/thxogh1>                  +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/1493                           #+#        #+#      #+#    */
/*   Solved: 2026/01/29 16:35:59 by thxogh1       ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long length = Long.parseLong(st.nextToken());
        long width = Long.parseLong(st.nextToken());
        long height = Long.parseLong(st.nextToken());

        int N = Integer.parseInt(br.readLine());

        int[] cube = new int[21];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            cube[a] = b;
        }

        long filled = 0;
        long ans = 0;

        for (int i = 20; i >= 0; i--) {
            filled <<= 3;

            long size = 1L << i;
            long maxFit = (length / size) * (width / size) * (height / size);

            long canUse = maxFit - filled;
            if (canUse <= 0)
                continue;

            long use = Math.min(canUse, cube[i]);
            filled += use;
            ans += use;
        }

        if (filled == length * width * height) {
            System.out.println(ans);
        } else {
            System.out.println(-1);
        }
    }
}