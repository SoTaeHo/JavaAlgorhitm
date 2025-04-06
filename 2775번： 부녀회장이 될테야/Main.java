
/* ************************************************************************** */
/*                                                                            */
/* ::: ::: ::: */
/* Problem Number: 2775 :+: :+: :+: */
/* +:+ +:+ +:+ */
/* By: thxogh1 <boj.kr/u/thxogh1> +#+ +#+ +#+ */
/* +#+ +#+ +#+ */
/* https://boj.kr/2775 #+# #+# #+# */
/* Solved: 2025/04/07 07:56:18 by thxogh1 ### ### ##.kr */
/*                                                                            */
/* ************************************************************************** */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());

        for (int t = 0; t < tc; t++) {
            int k = Integer.parseInt(br.readLine());
            int n = Integer.parseInt(br.readLine());

            int[] map = new int[n + 1];
            int[] s = new int[n + 1];
            int sum = 0;
            for (int i = 1; i < n + 1; i++) {
                sum += i;
                map[i] = i;
                s[i] = sum;
            }

            for (int i = 1; i < k + 1; i++) {
                sum = 0;
                for (int j = 1; j < n + 1; j++) {
                    map[j] = s[j];
                    sum += map[j];
                    s[j] = sum;
                }
            }
            System.out.println(map[n]);
        }
    }
}

// 1 6 21
// 1 5 15
// 1 4 10
// 1 3 6
// 1 2 3