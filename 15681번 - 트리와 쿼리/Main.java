
/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 15681                             :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: thxogh1 <boj.kr/u/thxogh1>                  +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/15681                          #+#        #+#      #+#    */
/*   Solved: 2025/05/05 19:14:42 by thxogh1       ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static List<List<Integer>> li;
    static int[] ans;
    static boolean[] visited;

    static int dfs(int node) {
        if (li.get(node).size() == 0) {
            ans[node] = 1;
            return 1;
        }
        if (visited[node]) {
            return 0;
        }
        visited[node] = true;
        int cnt = 0;
        for (int i = 0; i < li.get(node).size(); i++) {
            cnt += dfs(li.get(node).get(i));
        }
        ans[node] = cnt + 1;
        return cnt + 1;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());
        ans = new int[n + 1];
        li = new ArrayList<>();
        for (int i = 0; i < n + 1; i++) {
            li.add(new ArrayList<>());
        }
        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            li.get(s).add(e);
            li.get(e).add(s);
        }
        visited = new boolean[n + 1];
        dfs(r);
        for (int i = 0; i < q; i++) {
            System.out.println(ans[Integer.parseInt(br.readLine())]);
        }
    }
}