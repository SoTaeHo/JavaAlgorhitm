
/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 1039                              :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: thxogh1 <boj.kr/u/thxogh1>                  +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/1039                           #+#        #+#      #+#    */
/*   Solved: 2026/03/30 15:59:44 by thxogh1       ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */
import java.io.*;
import java.util.*;

public class Main {
    static int N, K;
    static boolean[][] visited = new boolean[11][1000001];

    static void swap(char[] arr, int i, int j) {
        char tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    static class State {
        String num;
        int cnt;

        State(String num, int cnt) {
            this.num = num;
            this.cnt = cnt;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        String start = String.valueOf(N);
        int len = start.length();

        if (len == 1) {
            System.out.println(-1);
            return;
        }

        Queue<State> q = new ArrayDeque<>();
        q.offer(new State(start, 0));
        visited[0][N] = true;

        int answer = -1;

        while (!q.isEmpty()) {
            State cur = q.poll();

            if (cur.cnt == K) {
                answer = Math.max(answer, Integer.parseInt(cur.num));
                continue;
            }

            char[] arr = cur.num.toCharArray();

            for (int i = 0; i < len; i++) {
                for (int j = i + 1; j < len; j++) {

                    if (i == 0 && arr[j] == '0') {
                        continue;
                    }

                    swap(arr, i, j);
                    int next = Integer.parseInt(new String(arr));

                    if (!visited[cur.cnt + 1][next]) {
                        visited[cur.cnt + 1][next] = true;
                        q.offer(new State(String.valueOf(arr), cur.cnt + 1));
                    }

                    swap(arr, i, j);
                }
            }
        }

        System.out.println(answer);
    }
}