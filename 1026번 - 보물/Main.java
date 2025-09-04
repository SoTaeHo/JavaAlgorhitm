
/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 1026                              :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: thxogh1 <boj.kr/u/thxogh1>                  +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/1026                           #+#        #+#      #+#    */
/*   Solved: 2025/09/04 17:43:09 by thxogh1       ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        List<Integer> a = new ArrayList<>();
        List<Integer> b = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            a.add(Integer.parseInt(st.nextToken()));
        }
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            b.add(Integer.parseInt(st.nextToken()));
        }

        Collections.sort(a);
        Collections.sort(b, Comparator.reverseOrder());

        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans += a.get(i) * b.get(i);
        }
        System.out.println(ans);
    }
}