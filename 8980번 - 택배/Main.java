
/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 8980                              :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: thxogh1 <boj.kr/u/thxogh1>                  +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/8980                           #+#        #+#      #+#    */
/*   Solved: 2025/10/14 08:40:18 by thxogh1       ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */2
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static class Node implements Comparable<Node> {
        int start;
        int end;
        int box;

        Node(int start, int end, int box) {
            this.start = start;
            this.end = end;
            this.box = box;
        }

        @Override
        public int compareTo(Node o) {
            if (this.end == o.end)
                return Integer.compare(this.start, o.start);
            return Integer.compare(this.end, o.end);
        }
    }

    static int N, C, M; // N <= 2000, 1 <= C <= 10000, 1 <= M <= 10000

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(br.readLine());

        Node[] boxes = new Node[M];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int box = Integer.parseInt(st.nextToken());
            boxes[i] = new Node(from, to, box);
        }

        Arrays.sort(boxes);

        int[] remain = new int[N + 1];
        Arrays.fill(remain, C);

        int ans = 0;
        for (Node cur : boxes) {
            int min = Integer.MAX_VALUE;
            for (int j = cur.start; j < cur.end; j++) {
                min = Math.min(min, remain[j]);
            }

            int load = Math.min(min, cur.box);
            if (load <= 0)
                continue;

            for (int j = cur.start; j < cur.end; j++) {
                remain[j] -= load;
            }
            ans += load;
        }

        System.out.println(ans);
    }
}