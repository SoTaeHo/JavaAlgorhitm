class Solution {

    static int SIZE = 1_000_001;

    public int[] solution(int[][] edges) {
        int[] answer = new int[4];

        int[] input = new int[SIZE];
        int[] output = new int[SIZE];
        for (int[] edge : edges) {
            input[edge[1]] += 1;
            output[edge[0]] += 1;
        }

        for (int i = 1; i < SIZE; i++) {

            if (input[i] == 0 && output[i] >= 2) {
                answer[0] = i;
            } else if (input[i] != 0 && output[i] == 0) {
                answer[2] += 1;
            } else if (input[i] >= 2 && output[i] >= 2) {
                answer[3] += 1;
            }
        }

        answer[1] = output[answer[0]] - answer[2] - answer[3];
        return answer;
    }
}