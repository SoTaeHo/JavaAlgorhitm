
/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 1174                              :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: thxogh1 <boj.kr/u/thxogh1>                  +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/1174                           #+#        #+#      #+#    */
/*   Solved: 2025/05/08 08:34:53 by thxogh1       ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<Long> li = new ArrayList<>();
        List<Long> now;
        List<Long> next = new ArrayList<>();

        for (long i = 0; i < 10; i++) {
            li.add(i);
        }

        now = new ArrayList<>(li.subList(0, li.size()));
        for (int k = 0; k < 9; k++) {
            for (int i = 1; i < 10; i++) {
                for (int j = 0; j < now.size(); j++) {
                    int firstLetter = String.valueOf(now.get(j)).charAt(0) - '0';
                    if (firstLetter < i) {
                        long temp = now.get(j);
                        int digits = (temp == 0) ? 1 : (int) Math.log10(temp) + 1;
                        long newNumber = i * (long) Math.pow(10, digits) + temp;
                        li.add(newNumber);
                        next.add(newNumber);
                    }
                }
            }
            // if (k == 1) {
            // System.out.println(next);
            // }
            now.clear();
            now.addAll(next);
            next.clear();
        }
        if (li.size() < n) {
            System.out.println(-1);
        } else {
            System.out.println(li.get(n - 1));
        }
    }
}

// 0 1 2 3 4 5 6 7 8 9
// 10
// 20 21
// 30 31 32
// 40 41 42 43
// 50 51 52 53 54
// 60 61 62 63 64 65
// 70 71 72 73 74 75 76
// 80 81 82 83 84 85 86 87
// 90 91 92 93 94 95 96 97 98

// 210
// 310 320 321
// 410 420 421 430 431 432

// 3210
// 4210 4310 4320 4321
//