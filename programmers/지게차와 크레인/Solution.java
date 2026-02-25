import java.util.*;

class Solution {
    static char[][] graph;
    
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static int n;
    static int m;
    static Queue<Point> qq = new ArrayDeque<>();
    
    static class Point {
        int x;
        int y;
        
        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    
    static void bfs(char c) {
        Queue<Point> q = new ArrayDeque<>();
        boolean[][] visited = new boolean[n + 2][m + 2];
        
        q.add(new Point(0, 0));
        
        while(!q.isEmpty()) {
            Point p = q.poll();
            
            for(int i = 0; i < 4; i++) {
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];
                
                if (nx < 0 || nx >= n + 2 || ny < 0 || ny >= m + 2) {
                    continue;
                }
                
                if(graph[nx][ny] == c) {
                    qq.add(new Point(nx, ny));
                    continue;
                }
                
                if(visited[nx][ny]) {
                    continue;
                }
                
                if(graph[nx][ny] != 0) {
                    continue;
                }
                
                visited[nx][ny] = true;
                q.add(new Point(nx, ny));
            }
        }
    }
    
    static void remove(char c) {
        for(int i = 0; i < n + 2; i++) {
            for(int j = 0; j < m + 2; j++) {
                if(graph[i][j] == c) {
                    graph[i][j] = 0;
                }
            }
        }
    }
    
    public int solution(String[] storage, String[] requests) {
        int answer = 0;
        n = storage.length;
        m = storage[0].length();
        graph = new char[n + 2][m + 2];
        
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                graph[i + 1][j + 1] = storage[i].charAt(j);
            }
        }
        
        for(String request : requests) {
            if(request.length() == 1) {
                System.out.println("bfs");
                bfs(request.charAt(0));
                while(!qq.isEmpty()) {
                    Point p = qq.poll();
                    graph[p.x][p.y] = 0;
                }
            } else {
                System.out.println("charAt : " + request.charAt(0));
                remove(request.charAt(0));
            }
        }
        
        for(int i = 0; i < n + 2; i++) {
            for(int j = 0; j < m + 2; j++) {
                if(graph[i][j] != 0) {
                    answer += 1;
                }
                // if(graph[i][j] == 0) {
                    // System.out.print(0);    
                // }
                // System.out.print(graph[i][j]);
            }
            // System.out.println();
        }
        return answer;
    }
}