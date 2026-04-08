
/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 17225                             :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: thxogh1 <boj.kr/u/thxogh1>                  +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/17225                          #+#        #+#      #+#    */
/*   Solved: 2026/04/08 13:49:17 by thxogh1       ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        List<int[]> events = new ArrayList<>();

        int sangminFree = 0;
        int jisuFree = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            String color = st.nextToken();
            int count = Integer.parseInt(st.nextToken());

            if (color.equals("B")) {
                int start = Math.max(t, sangminFree);
                for (int j = 0; j < count; j++) {
                    events.add(new int[] { start + j * A, 0 });
                }
                sangminFree = start + count * A;
            } else {
                int start = Math.max(t, jisuFree);
                for (int j = 0; j < count; j++) {
                    events.add(new int[] { start + j * B, 1 });
                }
                jisuFree = start + count * B;
            }
        }

        events.sort((a, b) -> a[0] != b[0] ? a[0] - b[0] : a[1] - b[1]);

        StringBuilder sbSangmin = new StringBuilder();
        StringBuilder sbJisu = new StringBuilder();
        int sangminCount = 0;
        int jisuCount = 0;

        for (int i = 0; i < events.size(); i++) {
            int giftNum = i + 1;
            if (events.get(i)[1] == 0) {
                sangminCount++;
                if (sbSangmin.length() > 0)
                    sbSangmin.append(' ');
                sbSangmin.append(giftNum);
            } else {
                jisuCount++;
                if (sbJisu.length() > 0)
                    sbJisu.append(' ');
                sbJisu.append(giftNum);
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(sangminCount).append('\n');
        sb.append(sangminCount > 0 ? sbSangmin : "-1").append('\n');
        sb.append(jisuCount).append('\n');
        sb.append(jisuCount > 0 ? sbJisu : "-1");
        System.out.println(sb);
    }
}