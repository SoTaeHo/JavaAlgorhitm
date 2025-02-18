/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 2567                              :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: thxogh1 <boj.kr/u/thxogh1>                  +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/2567                           #+#        #+#      #+#    */
/*   Solved: 2025/02/17 13:49:57 by thxogh1       ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Pair[] arr = new Pair[n];
        int result = 0;
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        int[][] map = new int[101][101];
        StringTokenizer st;
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            for(int j = 0; j < 10; j++) {
                for(int k = 0; k < 10; k++) {
                    if (map[j + x][k + y] == 0) {
                        map[j + x][k + y] = 1;
                    }
                }
            }
        }
        for(int i = 1; i < 100; i++) {
            for(int j = 1; j < 100; j++) {
                if (map[i][j] == 1) {
                    for(int k = 0; k < 4; k++) {
                        int nx = i + dx[k];
                        int ny = j + dy[k];
                        
                        if(map[nx][ny] == 0)
                            result++;
                    }
                }
            }
        }
        System.out.println(result);
    }
    
}

class Pair {
    public int x;
    public int y;

    Pair(int x, int y) {
        this.x=x;
        this.y=y;
    }
}

