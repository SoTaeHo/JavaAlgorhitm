
/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 1707                              :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: thxogh1 <boj.kr/u/thxogh1>                  +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/1707                           #+#        #+#      #+#    */
/*   Solved: 2025/05/14 08:37:22 by thxogh1       ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static boolean[] visited;
    static int[] type;

    static class Node {
        int num;
        int type;

        Node(int num, int type) {
            this.num = num;
            this.type = type;
        }
    }

    static boolean bfs(List<List<Integer>> li, Node node) {

        Queue<Node> q = new ArrayDeque<>();
        q.offer(node);

        while (!q.isEmpty()) {
            Node now = q.poll();

            for (int next : li.get(now.num)) {
                if (now.type == type[next]) {
                    return false;
                } else if (visited[next]) {
                    continue;
                }
                visited[next] = true;

                if (type[next] == 0) {
                    if (now.type == 1) {
                        q.offer(new Node(next, 2));
                        type[next] = 2;
                    } else if (now.type == 2) {
                        q.offer(new Node(next, 1));
                        type[next] = 1;
                    }
                }

            }
        }

        return true;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int tc = Integer.parseInt(br.readLine());

        while (tc-- > 0) {
            st = new StringTokenizer(br.readLine());

            int v = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            List<List<Integer>> li = new ArrayList<>();
            visited = new boolean[v + 1];
            type = new int[v + 1];
            for (int i = 0; i < v + 1; i++) {
                li.add(new ArrayList<>());
            }
            for (int i = 0; i < e; i++) {
                st = new StringTokenizer(br.readLine());
                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());
                li.get(start).add(end);
                li.get(end).add(start);
            }
            boolean success = true;
            for (int i = 1; i < v + 1; i++) {
                if (type[i] == 0) {
                    if (!bfs(li, new Node(i, 1))) {
                        System.out.println("NO");
                        success = false;
                        break;
                    }
                }
            }
            if (success) {
                System.out.println("YES");
            }
        }
    }
}