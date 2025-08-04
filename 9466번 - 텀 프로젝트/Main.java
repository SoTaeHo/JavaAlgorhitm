/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 9466                              :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: thxogh1 <boj.kr/u/thxogh1>                  +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/9466                           #+#        #+#      #+#    */
/*   Solved: 2025/08/04 21:19:01 by thxogh1       ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[] arr;
    static int[] visited;
    static int ans;

    static void dfs(int idx) {
        visited[idx] = 1;
        if(visited[arr[idx]] == 0) {
            dfs(arr[idx]);
        } else if (visited[arr[idx]] == 1) {
            ans -= 1;
            for(int i = arr[idx]; i != idx; i = arr[i]) {
                ans -= 1;
            }
        }

        visited[idx] = 2;

    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for(int tcase = 0; tcase < T; tcase++) {
            int n = Integer.parseInt(br.readLine());
            ans = n;
            arr = new int[n + 1];
            visited = new int[n + 1];
            st = new StringTokenizer(br.readLine());
            for(int i = 1; i < n + 1; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }     

            for(int i = 1; i < n + 1; i++) {
                if(visited[i] == 0) {
                    dfs(i);
                }
            }
            
            sb.append(ans).append('\n');
        }
        System.out.println(sb);
    }
}