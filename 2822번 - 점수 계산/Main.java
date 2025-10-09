/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 2822                              :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: thxogh1 <boj.kr/u/thxogh1>                  +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/2822                           #+#        #+#      #+#    */
/*   Solved: 2025/10/09 22:15:31 by thxogh1       ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static class Score implements Comparable<Score>{
        int idx;
        int val;

        Score(int idx, int val) {
            this.idx = idx;
            this.val = val;
        }

         @Override
         public int compareTo(Score o) {
            return Integer.compare(this.val, o.val);
         }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Score[] arr = new Score[8];
        int[] index = new int[5];

        for(int i = 0; i < 8; i++) {
            arr[i] = new Score(i + 1, Integer.parseInt(br.readLine()));
        }
        Arrays.sort(arr);
        int sum = 0;
        for(int i = 3; i < 8; i++) {
            sum += arr[i].val;
            index[i - 3] = arr[i].idx;
        }
        System.out.println(sum);
        Arrays.sort(index);
        for(int i = 0; i < 5; i++) {
            System.out.print(index[i] + " ");
        }
    }
}