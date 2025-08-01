
/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 1106                              :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: thxogh1 <boj.kr/u/thxogh1>                  +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/1106                           #+#        #+#      #+#    */
/*   Solved: 2025/08/01 08:38:46 by thxogh1       ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static class City {
        int cost;
        int estimated;

        public City(int cost, int estimated) {
            this.cost = cost;
            this.estimated = estimated;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int c = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        City[] arr = new City[n + 1];
        for (int i = 1; i < n + 1; i++) {
            st = new StringTokenizer(br.readLine());

            arr[i] = new City(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        int[] dp = new int[100001];

        for (int i = 1; i < 100001; i++) 
            for (int j = 1; j < n + 1; j++) {
                if (i >= arr[j].cost) {
                    dp[i] = Math.max(dp[i], dp[i - arr[j].cost] + arr[j].estimated);
                }
                if (dp[i] >= c) {
                    System.out.println(i);
                    return;
                }
            }

        }
    }
}