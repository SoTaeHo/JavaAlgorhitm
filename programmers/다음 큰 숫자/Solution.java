class Solution {
    public int solution(int n) {
        int answer = n + 1;
        
        while(nextNumber(n, answer)) {
            answer += 1;
        }
        
        return answer;
    }
    
    static boolean nextNumber(int a, int b) {
        int first = 0;
        while(a > 0) {
            if (a % 2 == 1) {
                first += 1;
            }
            a = a >> 1;
        }
        
        int second = 0;
        while(b > 0) {
            if (b % 2 == 1) {
                second += 1;
            }
            b = b >> 1;
        }
        
        return !(first == second);
    }
    
}