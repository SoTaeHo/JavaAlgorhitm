class Solution {
    static int n;
    static int x;
    static int m;
    static int answer = 0;
    static int SIZE = 101;
    static int[][] graph;
    static int[][] location;
    static int[] destination;
    static boolean[] isDelete;
    
    public int solution(int[][] points, int[][] routes) {
        n = points.length;
        x = routes.length;
        m = routes[0].length;
        graph = new int[SIZE][SIZE];
        location = new int[x][2];
        destination = new int[x];
        isDelete = new boolean[x];
        
        for(int i = 0; i < x; i++) {
            destination[i] = 1;
        }
        
        // 로봇 배치
        for(int i = 0; i < routes.length; i++) {
            int x = points[routes[i][0] - 1][0];
            int y = points[routes[i][0] - 1][1];
            
            location[i][0] = x;
            location[i][1] = y;
        }
  
            answer += count();
       
        while (notEnd()) { 
            // 위험한 상황 체크
            draw();
            answer += count();
            delete();
            System.out.println(answer);
            graph = new int[SIZE][SIZE];
            // 로봇 이동
            move(points, routes);
        }
        
    
        return answer;
    }
    
    static void show() {
        for(int i = 0; i < SIZE; i++) {
            for(int j = 0; j < SIZE; j++) {
                System.out.print(graph[i][j]);
            }
            System.out.println();
        }
    }
    
    static void delete() {
        for(int i = 0; i < x; i++) {
            if (destination[i] == m) {
                isDelete[i] = true;
            }
        }
    }
    
    static void draw() {
        for(int i = 0; i < x; i++) {
            if(isDelete[i]) {
                continue;
            }
            graph[location[i][0]][location[i][1]] += 1;
        }
    }
    
    static int count() {
        int ans = 0;
        for(int i = 0; i < SIZE; i++) {
            for(int j = 0; j < SIZE; j++) {
                if(graph[i][j] > 1) {
                    // System.out.println("i : " + i + " / j : " + j + " / graph[i][j] : " + graph[i][j]);
                    ans += 1;
                }
            }
        }
        return ans;
    }
    
    static void move(int[][] points, int[][] routes) {
        for(int i = 0; i < location.length; i++) {
            if(destination[i] >= m) {
                continue;
            }
            
            int next = routes[i][destination[i]] - 1;
            
            if(location[i][0] != points[next][0]) {
                if(location[i][0] > points[next][0]) {
                    location[i][0] -= 1;
                } else {
                    location[i][0] += 1;
                }
            } else {
                if(location[i][1] > points[next][1]) {
                    location[i][1] -= 1;
                } else {
                    location[i][1] += 1;
                }
            }
            
            if (location[i][0] == points[next][0] && location[i][1] == points[next][1]) {
               destination[i] += 1;
            }
        }
    }
    static boolean notEnd() {
        for(boolean b : isDelete) {
            if (!b) {
                return true;
            }
        }
        return false;
    }
    
}