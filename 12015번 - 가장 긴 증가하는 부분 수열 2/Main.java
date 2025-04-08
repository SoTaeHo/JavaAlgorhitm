
/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 12015                             :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: thxogh1 <boj.kr/u/thxogh1>                  +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/12015                          #+#        #+#      #+#    */
/*   Solved: 2025/04/08 09:44:17 by thxogh1       ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        List<Integer> arr = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr.add(Integer.parseInt(st.nextToken()));
        }

        // int[] dp = new int[n + 1];
        List<Integer> dp = new ArrayList<>();
        for (int i = 0; i < n; i++) {

            int idx = Collections.binarySearch(dp, arr.get(i));

            if (idx < 0) {
                idx = -idx - 1;
            }

            if (idx == dp.size()) {
                dp.add(arr.get(i));
            } else {
                dp.set(idx, arr.get(i));
            }
        }
        System.out.println(dp.size());
    }
}