/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 1135                              :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: thxogh1 <boj.kr/u/thxogh1>                  +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/1135                           #+#        #+#      #+#    */
/*   Solved: 2025/12/08 18:37:32 by thxogh1       ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static List<Integer>[] tree;
    static int dfs(int cur) {

       List<Integer> times = new ArrayList<>();

        for (int next : tree[cur]) {
            times.add(dfs(next));
        }

        times.sort(Comparator.reverseOrder());

        int max = 0;
        for (int i = 0; i < times.size(); i++) {
            max = Math.max(max, times.get(i) + i + 1);
        }

        return max;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        N = Integer.parseInt(br.readLine());
        tree = new List[N];
        for(int i = 0 ; i < N; i++) {
            tree[i] = new ArrayList<>();
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        st.nextToken();
        for(int i = 1 ; i < N; i++) {
            tree[Integer.parseInt(st.nextToken())].add(i);
        }

        System.out.println(dfs(0));
    }
}