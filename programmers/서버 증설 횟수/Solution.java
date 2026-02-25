class Solution {
    public int solution(int[] players, int m, int k) {
        int answer = 0;
        int[] servers = new int[24];
        
        for(int i = 0; i < players.length; i++) {
            while (players[i] >= servers[i] * m + m) {
                answer += 1;
                for(int j = 0; j < k; j++) {
                    if(i + j >= 24) {
                        break;
                    }
                    servers[i + j] += 1;
                }
            }
//            System.out.println(players[i] + "|" + servers[i] + "|" + answer);
        }
        
        return answer;
    }
}