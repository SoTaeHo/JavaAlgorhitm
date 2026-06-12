import java.util.*;

class Solution {
    public int[] solution(String[] gems) {
        
        int[] answer = new int[2];
        Set<String> set = new HashSet<>();
        
        for(String str : gems) {
            set.add(str);
        }       
        
        int n = gems.length;
        int cnt = set.size();
        
        int start = 0, end = 0;
        int minLen = Integer.MAX_VALUE;
        Map<String, Integer> map = new HashMap<>();
        
        while(end < n) {
            
            map.put(gems[end], map.getOrDefault(gems[end], 0) + 1);
            
            while(map.size() == cnt) {
                if (minLen > end - start + 1) {
                    minLen = end - start + 1;
                    answer[0] = start + 1;
                    answer[1] = end + 1;
                }
                map.put(gems[start], map.get(gems[start]) - 1);
                if(map.get(gems[start]) == 0) {
                    map.remove(gems[start]);
                }
                start += 1;
            }
            end += 1;
        }
        return answer;
    }
}