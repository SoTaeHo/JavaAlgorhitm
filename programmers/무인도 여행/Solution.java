import java.util.*;

class Solution {
    
    static int n;
    static int m;
    static boolean[][] visited;
    static String[] graph;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0, 0, -1, 1};
    
    public int[] solution(String[] maps) {
        List<Integer> li = new ArrayList<>();        
        n = maps.length;
        m = maps[0].length();
        graph = maps;
        visited = new boolean[n][m];
        
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if (graph[i].charAt(j) != 'X' && !visited[i][j]) {
                    int result = dfs(i, j);
                    li.add(result);
                }
            }
        }
        
        Collections.sort(li);
        int[] answer = li.stream()
                .mapToInt(Integer::intValue)
                .toArray();
        
        if(answer.length == 0) {
            return new int[]{-1};
        } else {
            return answer;
        }
    }
    
    static int dfs(int r, int c) {
        
        visited[r][c] = true;
        int sum = graph[r].charAt(c) - '0';
        
        for(int i = 0; i < 4; i++) {
            int nx = r + dx[i];
            int ny = c + dy[i]; 
            
            if(nx < 0 || nx >= n || ny < 0 || ny >= m) {
                continue;
            }
            
            if (visited[nx][ny]) {
                continue;
            }
            
            if (graph[nx].charAt(ny) == 'X') {
                continue;
            }
            
            sum += dfs(nx, ny);
        }
        
        return sum;
    }
}