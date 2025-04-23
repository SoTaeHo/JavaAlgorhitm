
/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 1082                              :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: thxogh1 <boj.kr/u/thxogh1>                  +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/1082                           #+#        #+#      #+#    */
/*   Solved: 2025/04/23 09:02:49 by thxogh1       ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int ans = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        int[] number = new int[n];
        int lowerBound = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            number[i] = Integer.parseInt(st.nextToken());
            lowerBound = Math.min(number[i], lowerBound);
        }
        int m = Integer.parseInt(br.readLine());
        String str = "";

        while (m >= lowerBound) {
            boolean isLow = false;
            int price = Integer.MAX_VALUE;
            int digit = 0;
            for (int i = 0; i < n; i++) {
                // 첫자리가 0이면 continue;
                if (str.equals("") && i == 0) {
                    continue;
                }

                if (m - number[i] >= lowerBound) {
                    isLow = true;
                }
                // 만약 isLow가 true라면 숫자를 더 살 수 있으므로
                // price가 가장 적은 숫자를 선택하되, 차이가 lowerBound 이상 안나면 더 큰 숫자 선택
                if (isLow) {
                    if (price >= number[i]) {
                        price = number[i];
                        digit = i;
                    } else if ((m - price) / lowerBound == (m - number[i]) / lowerBound) {
                        price = number[i];
                        digit = i;
                    }
                } else {
                    // 만약 isLow가 false라면 다음에 숫자를 더 못사므로 m의 제한 내에 가장 큰 숫자 선택
                    // System.out.println("else");
                    if (m >= number[i] && digit < i) {
                        digit = i;
                        price = number[i];
                    }
                }
            }
            // System.out.println("digit : " + digit);
            str += digit;
            m -= price;
        }
        System.out.println(str);
        // 첫 자리가 0인 경우 예외처리

    }
}