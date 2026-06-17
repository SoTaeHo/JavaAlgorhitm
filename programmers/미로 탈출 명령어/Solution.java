class Solution {
    public String solution(int n, int m, int x, int y, int r, int c, int k) {
 
        int dist = Math.abs(r - x) + Math.abs(c - y);
        
        if(dist > k || (k - dist) % 2 == 1) {
            return "impossible";
        }
        
        StringBuilder sb = new StringBuilder();
        
        int[] dx = {1,0,0,-1};
        int[] dy = {0,-1,1,0};
        char[] dir = {'d', 'l', 'r', 'u'};
        
        int cx = x;
        int cy = y;
        
        for (int step = 0; step < k; step++) {
            
            for(int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];
                
                if (nx < 1 || nx > n || ny < 1 || ny > m) {
                    continue;
                }
                
                int remain = k - step - 1;
                
                int need = Math.abs(nx - r) + Math.abs(ny - c);
                
                if(need <= remain && (remain - need) % 2 == 0) {
                    sb.append(dir[i]);
                    cx = nx;
                    cy = ny;
                    break;
                }
            }
        }
        return sb.toString();
    }
}
