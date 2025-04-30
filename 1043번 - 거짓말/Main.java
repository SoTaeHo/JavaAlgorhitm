
/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 1043                              :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: thxogh1 <boj.kr/u/thxogh1>                  +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/1043                           #+#        #+#      #+#    */
/*   Solved: 2025/04/30 12:11:22 by thxogh1       ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int[] parent;
    static int[] rank;

    static int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    static void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        if (rootX == rootY) {
            return;
        } else {
            if (rank[rootX] > rank[rootY]) {
                parent[rootY] = rootX;
            } else if (rank[rootX] < rank[rootY]) {
                parent[rootX] = rootY;
            } else {
                parent[rootX] = rootY;
                rank[rootY] += 1;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        parent = new int[n + 1];
        rank = new int[n + 1];

        for (int i = 1; i < n + 1; i++) {
            parent[i] = i;
            rank[i] = 1;
        }

        st = new StringTokenizer(br.readLine());
        int cnt = Integer.parseInt(st.nextToken());
        if (cnt == 0) {
            System.out.println(m);
            return;
        }
        int temp = 0;
        for (int i = 0; i < cnt; i++) {
            if (i == 0) {
                temp = Integer.parseInt(st.nextToken());
            } else {
                int num = Integer.parseInt(st.nextToken());
                union(temp, num);
                temp = num;
            }
        }

        List<List<Integer>> li = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            List<Integer> tempList = new ArrayList<>();
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            for (int j = 0; j < num; j++) {
                tempList.add(Integer.parseInt(st.nextToken()));
            }
            li.add(tempList);
        }

        for (int i = 0; i < m; i++) {
            int first = li.get(i).get(0);
            for (int j = 1; j < li.get(i).size(); j++) {
                union(first, li.get(i).get(j));
            }
        }

        int ans = 0;
        for (int i = 0; i < m; i++) {
            int first = li.get(i).get(0);
            boolean isAdd = true;
            for (int j = 0; j < cnt; j++) {
                if (find(first) == find(temp)) {
                    isAdd = false;
                    break;
                }
            }
            if (isAdd) {
                ans += 1;
            }
        }
        System.out.println(ans);
    }
}