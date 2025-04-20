/* ************************************************************************** */
 /*                                                                            */
 /*                                                      :::    :::    :::     */
 /*   Problem Number: 10816                             :+:    :+:      :+:    */
 /*                                                    +:+    +:+        +:+   */
 /*   By: thxogh1 <boj.kr/u/thxogh1>                  +#+    +#+          +#+  */
 /*                                                  +#+      +#+        +#+   */
 /*   https://boj.kr/10816                          #+#        #+#      #+#    */
 /*   Solved: 2025/04/20 19:52:33 by thxogh1       ###          ###   ##.kr    */
 /*                                                                            */
 /* ************************************************************************** */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int temp = Integer.parseInt(st.nextToken());
            if (map.containsKey(temp)) {
                map.replace(temp, map.get(temp) + 1);
            } else {
                map.put(temp, 1);
            }
        }
        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            int temp = Integer.parseInt(st.nextToken());
            if (map.containsKey(temp)) {
                sb.append(map.get(temp)).append(' ');
            } else {
                sb.append(0).append(' ');
            }
        }
        System.out.println(sb);
    }
}
