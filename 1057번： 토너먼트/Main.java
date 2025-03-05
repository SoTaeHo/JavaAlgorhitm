/* ************************************************************************** */
/*                                                                            */
/* ::: ::: ::: */
/* Problem Number: 1057 :+: :+: :+: */
/* +:+ +:+ +:+ */
/* By: thxogh1 <boj.kr/u/thxogh1> +#+ +#+ +#+ */
/* +#+ +#+ +#+ */
/* https://boj.kr/1057 #+# #+# #+# */
/* Solved: 2025/03/05 08:57:00 by thxogh1 ### ### ##.kr */
/*                                                                            */
/* ************************************************************************** */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int kim = Integer.parseInt(st.nextToken());
        int su = Integer.parseInt(st.nextToken());

        int round = 1;

        while (true) {
            if (Math.min(su, kim) % 2 == 1 && Math.max(su, kim) / 2 == Math.min(su, kim) / 2 + 1
                    && Math.abs(kim - su) == 1) {
                break;
            }
            if (kim % 2 == 1) {
                kim = kim / 2 + 1;
            } else {
                kim /= 2;
            }
            if (su % 2 == 1) {
                su = su / 2 + 1;
            } else {
                su /= 2;
            }
            if (round > N) {
                System.out.println(-1);
                return;
            }
            round++;
        }
        // System.out.println("kim : " + kim);
        // System.out.println("su : " + su);
        System.out.println(round);
    }
}
// 12 = 1
// 34 = 2
// 56 = 3