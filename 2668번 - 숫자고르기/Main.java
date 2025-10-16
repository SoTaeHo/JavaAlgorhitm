
/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 2668                              :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: thxogh1 <boj.kr/u/thxogh1>                  +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/2668                           #+#        #+#      #+#    */
/*   Solved: 2025/10/16 18:01:37 by thxogh1       ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        boolean[] isAdded = new boolean[N + 1];
        int[] arr = new int[N + 1];

        for (int i = 1; i < N + 1; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int ans = 0;
        List<Integer> li = new ArrayList<>();
        List<Integer> ansList = new ArrayList<>();
        for (int i = 1; i < N + 1; i++) {
            if (!isAdded[i]) {
                int total = 0;
                boolean[] visited = new boolean[N + 1];

                for (int j = i; !visited[j]; j = arr[j]) {

                    total += 1;
                    li.add(j);
                    visited[j] = true;

                    if (arr[j] == i) {
                        ans += total;
                        ansList.addAll(li);
                        for (int el : li) {
                            isAdded[el] = true;
                        }
                        break;
                    }
                }
            }
            li.clear();
        }
        Collections.sort(ansList);
        System.out.println(ans);

        for (int i : ansList) {
            System.out.println(i);
        }
    }
}