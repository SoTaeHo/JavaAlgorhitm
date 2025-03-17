/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 2110                              :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: thxogh1 <boj.kr/u/thxogh1>                  +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/2110                           #+#        #+#      #+#    */
/*   Solved: 2025/03/17 11:10:59 by thxogh1       ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);

        int start = 1;
        int end = arr[n - 1] - arr[0] + 1;
        while (start < end) {
            int mid = (end + start) / 2;
            int cnt = 1;
            int prev = arr[0];
            for (int i = 1; i < arr.length; i++) {
                if (arr[i] - prev >= mid) {
                    cnt++;
                    prev = arr[i];
                }
            }
            if (cnt >= c) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }

        System.out.println(start - 1);
    }
}