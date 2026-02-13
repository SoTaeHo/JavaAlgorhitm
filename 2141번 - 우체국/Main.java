
/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 2141                              :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: thxogh1 <boj.kr/u/thxogh1>                  +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/2141                           #+#        #+#      #+#    */
/*   Solved: 2026/02/13 11:16:06 by thxogh1       ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        long[][] arr = new long[N][2];
        long totalPeople = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            long x = Long.parseLong(st.nextToken());
            long a = Long.parseLong(st.nextToken());
            arr[i][0] = x;
            arr[i][1] = a;
            totalPeople += a;
        }

        Arrays.sort(arr, Comparator.comparingLong(v -> v[0]));

        long half = (totalPeople + 1) / 2;
        long sum = 0;

        for (int i = 0; i < N; i++) {
            sum += arr[i][1];
            if (sum >= half) {
                System.out.println(arr[i][0]);
                break;
            }
        }

    }
}