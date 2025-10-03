/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 4375                              :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: thxogh1 <boj.kr/u/thxogh1>                  +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/4375                           #+#        #+#      #+#    */
/*   Solved: 2025/10/03 17:50:02 by thxogh1       ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;

        while ((line = br.readLine()) != null) {

            int n = Integer.parseInt(line);

            int remainder = n;
            int length = 1;

            while (remainder != 0) {
                remainder = (remainder * 10 + 1) % n;
                length++;
            }

            System.out.println(length - 1);
        }
    }
}