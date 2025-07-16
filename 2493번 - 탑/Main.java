
/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 2493                              :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: thxogh1 <boj.kr/u/thxogh1>                  +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/2493                           #+#        #+#      #+#    */
/*   Solved: 2025/07/16 09:48:37 by thxogh1       ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        Deque<Integer> dq = new ArrayDeque<>();
        int[] height = new int[n + 1];
        int[] ans = new int[n + 1];

        for (int i = 1; i < n + 1; i++) {
            height[i] = Integer.parseInt(st.nextToken());
        }
        dq.push(n);
        for (int i = n - 1; i >= 0; i--) {
            if (height[dq.peek()] > height[i]) {
                dq.push(i);
                continue;
            } else {
                while (!dq.isEmpty()) {
                    if (height[i] > height[dq.peek()]) {
                        ans[dq.pop()] = i;
                    } else {
                        break;
                    }
                }
                dq.push(i);
            }
        }

        for (int i = 1; i < n + 1; i++) {
            System.out.print(ans[i] + " ");
        }
    }
}