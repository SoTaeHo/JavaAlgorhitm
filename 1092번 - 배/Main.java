
/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 1092                              :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: thxogh1 <boj.kr/u/thxogh1>                  +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/1092                           #+#        #+#      #+#    */
/*   Solved: 2025/09/18 08:43:19 by thxogh1       ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        int[] crane = new int[n];
        for (int i = 0; i < n; i++) {
            crane[i] = Integer.parseInt(st.nextToken());
        }
        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        int[] box = new int[m];
        for (int i = 0; i < m; i++) {
            box[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(box);
        Arrays.sort(crane);
        if (box[m - 1] > crane[n - 1]) {
            System.out.println(-1);
            return;
        }

        List<Integer> boxes = new ArrayList<>();
        for (int b : box)
            boxes.add(b);

        int time = 0;
        while (!boxes.isEmpty()) {
            int idx = boxes.size() - 1;
            for (int i = n - 1; i >= 0; i--) {
                if (idx < 0)
                    break;
                while (idx >= 0 && crane[i] < boxes.get(idx)) {
                    idx--;
                }
                if (idx >= 0) {
                    boxes.remove(idx);
                    idx--;
                }
            }
            time++;
        }
        System.out.println(time);
    }
}