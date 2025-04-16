
/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 13913                             :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: thxogh1 <boj.kr/u/thxogh1>                  +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/13913                          #+#        #+#      #+#    */
/*   Solved: 2025/04/16 16:44:44 by thxogh1       ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        Queue<Integer> q = new ArrayDeque<>();

        int[] map = new int[100001];
        int[] before = new int[100001];
        // Arrays.fill(map, );
        q.offer(n);
        map[n] = 1;
        while (!q.isEmpty()) {
            int pos = q.poll();
            if (pos == m) {
                break;
            }

            if (pos - 1 >= 0 && before[pos - 1] == 0) {
                q.offer(pos - 1);
                map[pos - 1] = map[pos] + 1;
                before[pos - 1] = pos;
            }
            if (pos + 1 <= 100000 && before[pos + 1] == 0) {
                q.offer(pos + 1);
                map[pos + 1] = map[pos] + 1;
                before[pos + 1] = pos;
            }
            if (pos != 0 && pos * 2 <= 100000 && before[pos * 2] == 0) {
                q.offer(pos * 2);
                map[pos * 2] = map[pos] + 1;
                before[pos * 2] = pos;
            }
            System.out.print("bef : " + pos + " / ");
            for (int i = 0; i < 10; i++) {
                System.out.print(before[i] + " ");
            }
            System.out.println();
            System.out.print("map : " + pos + " / ");
            for (int i = 0; i < 10; i++) {
                System.out.print(map[i] + " ");
            }
            System.out.println();
            System.out.println();

        }
        q.clear();
        System.out.println(map[m] - 1);
        Stack<Integer> stack = new Stack<>();
        int idx = m;
        stack.push(idx);
        // for (int i = 0; i < 10; i++) {
        // System.out.print(before[i] + " ");
        // }
        while (idx != n) {
            stack.push(before[idx]);
            idx = before[idx];
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop()).append(" ");
        }
        System.out.println(sb);
    }
}