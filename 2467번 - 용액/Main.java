
/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 2467                              :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: thxogh1 <boj.kr/u/thxogh1>                  +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/2467                           #+#        #+#      #+#    */
/*   Solved: 2025/05/05 18:43:35 by thxogh1       ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int arr[] = new int[n];
        int alkaline = 0;
        int acid = n - 1;
        int front = alkaline;
        int rear = acid;
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int ans = Integer.MAX_VALUE;
        int it = 1;
        while (front < rear) {
            // System.out.println("it : " + it++);
            int temp = arr[front] + arr[rear];
            // System.out.println("temp : " + temp + " / ans : " + ans);
            if (ans > Math.abs(temp)) {
                ans = Math.abs(temp);
                alkaline = front;
                acid = rear;
            }

            if (temp > 0) {
                rear -= 1;
            } else if (temp < 0) {
                front += 1;
            } else {
                System.out.printf("%d %d", arr[alkaline], arr[acid]);
                return;
            }
        }
        System.out.printf("%d %d", arr[alkaline], arr[acid]);
    }
}