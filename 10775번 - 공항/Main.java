
/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 10775                             :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: thxogh1 <boj.kr/u/thxogh1>                  +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/10775                          #+#        #+#      #+#    */
/*   Solved: 2025/11/24 12:09:35 by thxogh1       ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int g = Integer.parseInt(br.readLine());
        int p = Integer.parseInt(br.readLine());

        int[] airplain = new int[p + 1];
        int[] gate = new int[g + 1];

        for (int i = 1; i < g + 1; i++) {
            gate[i] = i;
        }

        for (int i = 1; i < p + 1; i++) {
            airplain[i] = Integer.parseInt(br.readLine());
        }

        int ans = 0;

        for (int i = 1; i < p + 1; i++) {
            int idx = find(gate, airplain[i]);
            if (idx == 0) {
                break;
            }
            gate[idx] = idx - 1;
            ans += 1;
        }
        System.out.println(ans);
    }

    static int find(int[] gate, int x) {
        if (gate[x] == x) {
            return x;
        }
        return gate[x] = find(gate, gate[x]);
    }
}