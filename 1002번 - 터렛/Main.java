
/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 1002                              :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: thxogh1 <boj.kr/u/thxogh1>                  +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/1002                           #+#        #+#      #+#    */
/*   Solved: 2025/09/11 08:34:10 by thxogh1       ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tcase = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for (int t = 0; t < tcase; t++) {
            st = new StringTokenizer(br.readLine());

            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int r1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            int r2 = Integer.parseInt(st.nextToken());

            int dx = x1 - x2;
            int dy = y1 - y2;
            int distSquare = dx * dx + dy * dy;
            int radiusSum = r1 + r2;
            int rSquare = radiusSum * radiusSum;
            int diff = Math.abs(r1 - r2);
            int diffSquare = diff * diff;
            if (dx == 0 && dy == 0 && r1 == r2) {
                System.out.println(-1);
            } else if (rSquare < distSquare || distSquare < diffSquare) {
                System.out.println(0);
            } else if (distSquare == diffSquare || distSquare == rSquare) {
                System.out.println(1);
            } else {
                System.out.println(2);
            }
        }
    }
}