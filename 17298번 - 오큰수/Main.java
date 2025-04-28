
/* ************************************************************************** */
/*                                                                            */
/* ::: ::: ::: */
/* Problem Number: 17298 :+: :+: :+: */
/* +:+ +:+ +:+ */
/* By: thxogh1 <boj.kr/u/thxogh1> +#+ +#+ +#+ */
/* +#+ +#+ +#+ */
/* https://boj.kr/17298 #+# #+# #+# */
/* Solved: 2025/04/28 19:07:58 by thxogh1 ### ### ##.kr */
/*                                                                            */
/* ************************************************************************** */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int[] ans = new int[n];
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        for (int i = 1; i < n; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] < arr[i]) {
                ans[stack.pop()] = arr[i];
            }
            stack.push(i);
        }
        while (!stack.isEmpty()) {
            ans[stack.pop()] = -1;
        }
        for (int num : ans) {
            sb.append(num).append(" ");
        }
        System.out.println(sb);
    }
}