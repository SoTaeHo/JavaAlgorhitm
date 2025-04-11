
/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 1005                              :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: thxogh1 <boj.kr/u/thxogh1>                  +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/1005                           #+#        #+#      #+#    */
/*   Solved: 2025/04/11 16:47:20 by thxogh1       ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int tc = Integer.parseInt(br.readLine());

        for (int t = 0; t < tc; t++) {
            int[][] map = new int[1001][1001];
            int[] count = new int[1001];

            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());

            int[] weight = new int[1001];
            for (int i = 1; i < n + 1; i++) {
                weight[i] = Integer.parseInt(st.nextToken());
            }
            for (int i = 0; i < k; i++) {
                st = new StringTokenizer(br.readLine());
                int s = Integer.parseInt(st.nextToken());
                int e = Integer.parseInt(st.nextToken());
                map[s][e] = 1;
                count[e] += 1;
            }
            int w = Integer.parseInt(br.readLine());
        }
    }

    static class Node {
        int index;
        int weight;

        public Node(int index, int weight) {
            this.index = index;
            this.weight = weight;
        }
    }

    static class Edge {
        int start;
        int end;

        public Edge(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
}
