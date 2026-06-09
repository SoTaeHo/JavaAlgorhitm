import java.util.*;

class Solution {
    public String solution(int n, int t, int m, String[] timetable) {
        
        int[] table = new int[timetable.length];
        
        for(int i = 0; i < timetable.length; i++) {
            table[i] = Integer.parseInt(timetable[i].split(":")[0]) * 60 +
                Integer.parseInt(timetable[i].split(":")[1]);
        }
        
        Arrays.sort(table);
        
        int bus = 540;
        int idx = 0;
        int ans = 0;
        
        for(int i = 0; i < n; i++) {
            int cnt = 0;
            
            while(idx < table.length && table[idx] <= bus && cnt < m) {
                idx += 1;
                cnt += 1;
            }
            
            if (i == n - 1) {
                if (cnt < m) {
                    ans = bus;
                } else {
                    ans = table[idx - 1] - 1;
                }
            }
            
            bus += t;
        }
        
        return String.format("%02d:%02d", ans / 60, ans % 60);
    }
}