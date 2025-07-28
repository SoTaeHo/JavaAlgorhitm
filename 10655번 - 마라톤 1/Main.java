
/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 10655                             :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: thxogh1 <boj.kr/u/thxogh1>                  +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/10655                          #+#        #+#      #+#    */
/*   Solved: 2025/07/23 08:44:30 by thxogh1       ###          ###   ##.kr    */
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
        int[] xPos = new int[n];
        int[] yPos = new int[n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            xPos[i] = Integer.parseInt(st.nextToken());
            yPos[i] = Integer.parseInt(st.nextToken());
        }
        int total = 0;
        for (int i = 1; i < n; i++) {
            total += Math.abs(xPos[i] - xPos[i - 1]) + Math.abs(yPos[i] - yPos[i - 1]);
        }
        int ans = Integer.MAX_VALUE;
        for (int i = 1; i < n - 1; i++) {
            int temp = total - (Math.abs(xPos[i] - xPos[i - 1]) + Math.abs(yPos[i] - yPos[i - 1]));
            temp -= Math.abs(xPos[i] - xPos[i + 1]) + Math.abs(yPos[i] - yPos[i + 1]);
            temp += Math.abs(xPos[i + 1] - xPos[i - 1]) + Math.abs(yPos[i + 1] - yPos[i - 1]);
            if (ans > temp) {
                ans = temp;
            }
        }
        System.out.println(ans);
    }
}
