import java.util.*;

class Solution {

    static List<List<Integer>> graph;
    static int[] info;
    static int answer = 0;

    public int solution(int[] info, int[][] edges) {
        this.info = info;
        graph = new ArrayList<>();

        for (int i = 0; i < info.length; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] e : edges) {
            graph.get(e[0]).add(e[1]);
        }

        List<Integer> li = new ArrayList<>();
        li.add(0);

        dfs(0, 0, 0, li);
        return answer;
    }

    static void dfs(int node, int sheep, int wolf, List<Integer> li) {
        if (info[node] == 0) {
            sheep += 1;
        } else {
            wolf += 1;
        }

        if (sheep <= wolf) {
            return;
        }

        answer = Math.max(answer, sheep);

        List<Integer> copy = new ArrayList<>(li);
        copy.remove(Integer.valueOf(node));
        for (int i : graph.get(node)) {
            copy.add(i);
        }

        for (int i : copy) {
            dfs(i, sheep, wolf, copy);
        }
    }
}