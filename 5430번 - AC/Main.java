
/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 5430                              :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: thxogh1 <boj.kr/u/thxogh1>                  +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/5430                           #+#        #+#      #+#    */
/*   Solved: 2025/05/19 10:04:23 by thxogh1       ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Main {
    static BufferedReader br;
    static StringTokenizer st;
    static StringBuilder sb;

    static void print(List<Integer> li, boolean reversed) {
        sb.append("[");

        if (!reversed) {
            for (int i = 0; i < li.size() - 1; i++) {
                sb.append(li.get(i) + ",");
            }
            if (li.size() > 0) {
                sb.append(li.get(li.size() - 1));
            }

        } else {
            for (int i = li.size() - 1; i >= 1; i--) {
                sb.append(li.get(i) + ",");
            }
            if (li.size() > 0) {
                sb.append(li.get(0));
            }
        }
        sb.append("]").append('\n');
    }

    static void solution() throws IOException {
        String pattern = br.readLine();
        int len = Integer.parseInt(br.readLine());
        String arrStr = br.readLine();

        List<Integer> li;
        if (arrStr.length() == 2) {
            li = new ArrayList<>();
        } else {

            arrStr = arrStr.substring(1, arrStr.length() - 1);
            li = Arrays.stream(arrStr.split(",")).map(Integer::parseInt).collect(Collectors.toList());
        }
        boolean reversed = false;
        for (int i = 0; i < pattern.length(); i++) {
            if (pattern.charAt(i) == 'R') {
                reversed = !reversed;
            } else {
                if (li.size() > 0) {
                    if (!reversed) {
                        li.remove(0);
                    } else {
                        li.remove(li.size() - 1);
                    }
                } else {
                    sb.append("error").append('\n');
                    return;
                }
            }
        }
        print(li, reversed);
    }

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            solution();
        }
        System.out.println(sb);
    }
}