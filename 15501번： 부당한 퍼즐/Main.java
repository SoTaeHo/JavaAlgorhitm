
/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 15501                             :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: thxogh1 <boj.kr/u/thxogh1>                  +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/15501                          #+#        #+#      #+#    */
/*   Solved: 2025/03/24 10:13:20 by thxogh1       ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] my = new int[n];
        int[] copy = new int[n];

        int myIndex = 0;
        int copyIndex = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            my[i] = Integer.parseInt(st.nextToken());
            if (my[i] == 1)
                myIndex = i;
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            copy[i] = Integer.parseInt(st.nextToken());
            if (copy[i] == 1)
                copyIndex = i;
        }
        int[] modify = new int[n];
        System.arraycopy(copy, copyIndex, modify, 0, n - copyIndex); // k부터 끝까지 복사
        System.arraycopy(copy, 0, modify, n - copyIndex, copyIndex); // 0부터 k-1까지 복사
        boolean check = true;
        boolean checkReverse = true;
        for (int i = 1; i < n; i++) {
            if (my[(myIndex + i) % n] != modify[i]) {
                check = false;
                break;
            }
        }
        for (int i = 1; i < n; i++) {
            if (my[(myIndex - i + n) % n] != modify[i]) {
                checkReverse = false;
                break;
            }
        }
        if (check || checkReverse) {
            System.out.println("good puzzle");
        } else {
            System.out.println("bad puzzle");
        }

    }
}

// 12345 23451 34512 45123 51234