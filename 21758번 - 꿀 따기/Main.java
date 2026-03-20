
/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 21758                             :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: thxogh1 <boj.kr/u/thxogh1>                  +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/21758                          #+#        #+#      #+#    */
/*   Solved: 2026/03/20 16:56:56 by thxogh1       ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] prefix = new int[N];
        prefix[0] = arr[0];
        for (int i = 1; i < N; i++) {
            prefix[i] = prefix[i - 1] + arr[i];
        }

        int total = prefix[N - 1];
        int answer = 0;

        for (int i = 1; i < N - 1; i++) {
            int val = (total - arr[0] - arr[i]) + (total - prefix[i]);
            answer = Math.max(answer, val);
        }
        for (int i = 1; i < N - 1; i++) {
            int val = (total - arr[N - 1] - arr[i]) + prefix[i - 1];
            answer = Math.max(answer, val);
        }
        for (int i = 1; i < N - 1; i++) {
            int val = prefix[i] - arr[0] + prefix[N - 1] - prefix[i - 1] - arr[N - 1];
            answer = Math.max(answer, val);
        }
        System.out.println(answer);

    }
}