/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 2589                              :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: thxogh1 <boj.kr/u/thxogh1>                  +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/2589                           #+#        #+#      #+#    */
/*   Solved: 2025/08/14 19:55:48 by thxogh1       ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static class Point {
        int x;
        int y;

        public Point (int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int[][] map = new int[r][c];
        int[][] visited;
        int ans = 0;
        for(int i = 0; i < r; i++) {
            String str = br.readLine();
            for(int j = 0; j < c; j++) {
                if(str.charAt(j) == 'L') {
                    map[i][j] = 1;
                }
            }
        }
   
        for(int i = 0; i < r; i++) {
            for(int j = 0; j < c; j++) {
                if (map[i][j] == 1) {
                    Queue<Point> q = new ArrayDeque<>();
                    q.offer(new Point(i, j));
                    visited = new int[r][c];
                    visited[i][j] = 1;
                    int maxNum = 0;
                    while(!q.isEmpty()) {
                        Point now = q.poll();
                        for(int k = 0; k < 4; k++) {
                            int nx = now.x + dx[k];
                            int ny = now.y + dy[k];
                            if(nx < 0 || nx >= r || ny < 0 || ny >= c) {
                                continue;
                            }
                            
                            if(visited[nx][ny] != 0) {
                                continue;
                            }

                            if (map[nx][ny] == 0) {
                                continue;
                            }

                            visited[nx][ny] = visited[now.x][now.y] + 1;
                            q.offer(new Point(nx, ny));

                            maxNum = Math.max(maxNum, visited[nx][ny]);
                        }
                    }
                    ans = Math.max(ans, maxNum - 1);
                    // for(int a = 0; a < r; a++) {
                    //     for(int b = 0; b < c; b++) {
                    //         System.out.print(visited[a][b] + " ");
                    //     }
                    //     System.out.println();
                    // }
                    // System.out.println();
                }
            }
        }
        System.out.println(ans);
    }
}