/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 10653                             :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: thxogh1 <boj.kr/u/thxogh1>                  +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/10653                          #+#        #+#      #+#    */
/*   Solved: 2025/07/23 23:28:50 by thxogh1       ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] xPos = new int[n];
        int[] yPos = new int[n];

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            xPos[i] = Integer.parseInt(st.nextToken());
            yPos[i] = Integer.parseInt(st.nextToken());
        }

        int[] dist = new int[n];
        
        for (int i = 1; i < n - 1; i++) {
            dist[i] = Math.abs(xPos[i - 1] - xPos[i]) + Math.abs(yPos[i - 1] - yPos[i])
            + Math.abs(xPos[i + 1] - xPos[i]) + Math.abs(yPos[i + 1] - yPos[i]);
        }

    }
}

// 3 <= N <= 500
// nCk 
// 0 -> 1 -> 2-> 3 -> 4
// 어떤 점을 가지 않았을 때 빠지는 값을 미리 구할 수 있다.
// 그렇다면 두점 연속으로 빠지면..?? 이건 의미 없는 것 같고
// 500이면 n^3?? n! / (n - k)! 개 인데
// 한 점을 기준으로 자신의 양 옆 점과의 거리를 구하고 거리가 가장 큰 점들을 빼주자.
