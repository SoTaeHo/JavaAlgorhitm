
/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 2143                              :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: thxogh1 <boj.kr/u/thxogh1>                  +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/2143                           #+#        #+#      #+#    */
/*   Solved: 2025/12/22 18:03:14 by thxogh1       ###          ###   ##.kr    */
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

        int T = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());

        int[] a = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        int m = Integer.parseInt(br.readLine());
        int[] b = new int[m];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            b[i] = Integer.parseInt(st.nextToken());
        }

        List<Integer> sumA = new ArrayList<>();
        List<Integer> sumB = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum += a[j];
                sumA.add(sum);
            }
        }

        for (int i = 0; i < m; i++) {
            int sum = 0;
            for (int j = i; j < m; j++) {
                sum += b[j];
                sumB.add(sum);
            }
        }

        Collections.sort(sumB);

        long answer = 0L;
        for (int val : sumA) {
            int target = T - val;
            answer += upperBound(sumB, target) - lowerBound(sumB, target);
        }
        System.out.println(answer);
    }

    static long upperBound(List<Integer> li, int target) {
        int start = 0;
        int end = li.size();

        while (start < end) {
            int mid = (start + end) / 2;
            if (li.get(mid) > target) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        return start;
    }

    static long lowerBound(List<Integer> li, int target) {
        int start = 0;
        int end = li.size();

        while (start < end) {
            int mid = (start + end) / 2;
            if (li.get(mid) >= target) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        return start;
    }
}