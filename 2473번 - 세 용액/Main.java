
/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 2473                              :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: thxogh1 <boj.kr/u/thxogh1>                  +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/2473                           #+#        #+#      #+#    */
/*   Solved: 2025/05/06 13:48:19 by thxogh1       ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        long[] arr = new long[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }
        Arrays.sort(arr);
        int alkaline = 0;
        int acid = n - 1;
        int left = alkaline;
        int right = acid;
        int mid = 0;
        long ans = Long.MAX_VALUE;

        for (int i = 0; i <= n - 3; i++) {
            alkaline = i + 1;
            acid = n - 1;
            while (alkaline < acid) {
                long temp = arr[alkaline] + arr[acid] + arr[i];
                if (ans > Math.abs(temp)) {
                    mid = i;
                    left = alkaline;
                    right = acid;
                    ans = Math.abs(temp);
                }
                if (temp < 0) {
                    alkaline += 1;
                } else if (temp > 0) {
                    acid -= 1;
                } else {
                    System.out.printf("%d %d %d", arr[mid], arr[left], arr[right]);
                    return;
                }
            }
        }
        System.out.printf("%d %d %d", arr[mid], arr[left], arr[right]);

    }
}