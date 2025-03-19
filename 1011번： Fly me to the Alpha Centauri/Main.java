
/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 1011                              :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: thxogh1 <boj.kr/u/thxogh1>                  +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/1011                           #+#        #+#      #+#    */
/*   Solved: 2025/03/19 08:30:20 by thxogh1       ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int tcase = Integer.parseInt(br.readLine());

        for (int t = 0; t < tcase; t++) {
            st = new StringTokenizer(br.readLine());
            long x = Integer.parseInt(st.nextToken());
            long y = Integer.parseInt(st.nextToken());

            long sum = 0;
            int cnt = 0;
            int move = 0;
            while (sum < y - x) {
                cnt++;
                if (cnt % 2 != 0)
                    move++;
                System.out.println(sum);
                sum += move;
            }
            System.out.println(cnt);
        }
    }

}
// 1 2 3 3 4 4 5 5 5 6 6 6 7 7 7 7 8 8 8 8 9 9 9 9 9
// 1칸 1
