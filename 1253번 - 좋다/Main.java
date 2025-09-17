
/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 1253                              :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: thxogh1 <boj.kr/u/thxogh1>                  +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/1253                           #+#        #+#      #+#    */
/*   Solved: 2025/09/17 08:53:34 by thxogh1       ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static boolean binarySearch(int[] arr, int val) {

        int s = 0;
        int e = arr.length - 1;

        while (s <= e) {
            int mid = (s + e) / 2;
            if (arr[mid] < val) {
                s = mid + 1;
            } else if (arr[mid] > val) {
                e = mid - 1;
            } else {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        int ans = 0;
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        for (int i = 0; i < n; i++) {
            int s = 0;
            int e = n - 1;
            int target = arr[i];

            while (s < e) {
                int sum = arr[s] + arr[e];

                if (sum == target) {
                    if (s != i && e != i) {
                        ans += 1;
                        break;
                    } else if (s == i) {
                        s += 1;
                    } else {
                        e -= 1;
                    }
                } else if (sum < target) {
                    s += 1;
                } else {
                    e -= 1;
                }
            }
        }

        System.out.println(ans);
    }
}