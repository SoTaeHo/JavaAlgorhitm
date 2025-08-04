
/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 1446                              :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: thxogh1 <boj.kr/u/thxogh1>                  +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/1446                           #+#        #+#      #+#    */
/*   Solved: 2025/07/29 08:47:59 by thxogh1       ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static class Shortcut {
        int start;
        int end;
        int length;

        public Shortcut(int start, int end, int length) {
            this.start = start;
            this.end = end;
            this.length = length;
        }
    }

    static int n;
    static int d;
    static int ans = Integer.MAX_VALUE;

    static Shortcut[] arr;

    public static void dfs(int position, int dist) {

        if (position > d) {
            return;
        }
        if (position == d) {
            ans = Math.min(dist, ans);
            return;
        }

        for (int i = 0; i < n; i++) {
            if (position == arr[i].start) {
                dfs(arr[i].end, dist + arr[i].length);
            }
        }
        dfs(position + 1, dist + 1);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());
        arr = new Shortcut[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i] = new Shortcut(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken()));
        }

        dfs(0, 0);
        System.out.println(ans);
    }
}