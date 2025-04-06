
/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 1011                              :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: thxogh1 <boj.kr/u/thxogh1>                  +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/1011                           #+#        #+#      #+#    */
/*   Solved: 2025/03/19 08:30:20 by thxogh1       ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        long[] d = new long[501];
        for(int i = 0; i < d.length; i++) {
            d[i] = (long)1e10;
        }
        int[][] edge = new int[m][3];
        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            edge[i][0] = Integer.parseInt(st.nextToken());
            edge[i][1] = Integer.parseInt(st.nextToken());
            edge[i][2] = Integer.parseInt(st.nextToken());
        }

        boolean negCycle = bellmanFord(d, edge, n, m);
        if(negCycle) {
            System.out.println(-1);
            return;
        }
        else {
            for(int i = 2; i <= n; i++) {
                if(d[i] < (long)1e10)
                    sb.append(d[i]).append('\n');
                else
                    sb.append(-1).append('\n');
            }
        }
        System.out.println(sb);
    }

   static boolean bellmanFord(long[] d, int[][] edge, int n, int m) {
        d[1] = 0;

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                int start = edge[j][0];
                int dest = edge[j][1];
                int cost = edge[j][2];
                
                if(d[start] != (long)1e10 && d[dest] > d[start] + cost) {
                    d[dest] = d[start] + cost;
                    if(i == n - 1)
                        return true;
                }
              }
        }
        return false;
    }
}
