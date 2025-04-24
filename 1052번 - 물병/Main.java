
/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 1052                              :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: thxogh1 <boj.kr/u/thxogh1>                  +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/1052                           #+#        #+#      #+#    */
/*   Solved: 2025/04/24 09:14:51 by thxogh1       ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        List<Integer> li = new ArrayList<>();

        while (n != 0) {
            li.add(n % 2);
            n /= 2;
        }
        if (allElementIsZero(li, k)) {
            System.out.println(0);
            return;
        }
        int temp = 0;
        for (int i = li.size() - 1; i >= 0; i--) {
            if (li.get(i) == 1) {
                temp++;
            }
            if (temp == k) {
                temp = i;
                break;
            }
        }
        int ans = (int) Math.pow(2, temp);

        for (int i = 0; i < temp; i++) {
            if (li.get(i).intValue() == 1) {
                ans -= Math.pow(2, i);
            }
        }
        System.out.println(ans);
    }

    static boolean allElementIsZero(List<Integer> li, int k) {
        int cnt = 0;
        for (int i = 0; i < li.size(); i++) {
            if (li.get(i).intValue() == 1) {
                cnt++;
            }
        }
        if (cnt > k) {
            return false;
        } else {
            return true;
        }
    }
}