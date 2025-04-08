
/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 14003                             :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: thxogh1 <boj.kr/u/thxogh1>                  +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/14003                          #+#        #+#      #+#    */
/*   Solved: 2025/04/08 11:08:30 by thxogh1       ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        // dp 배열: LIS 끝 값을 저장
        int[] dp = new int[N];
        int[] prev = new int[N]; // 추적용: 이전 인덱스
        int[] lisIdx = new int[N]; // 각 길이의 마지막 인덱스

        int length = 0;

        for (int i = 0; i < N; i++) {
            int num = arr[i];
            int pos = lowerBound(dp, 0, length, num);

            dp[pos] = num;
            lisIdx[pos] = i;
            prev[i] = (pos > 0) ? lisIdx[pos - 1] : -1;
            System.out.println(Arrays.toString(dp));
            if (pos == length)
                length++;
        }
        System.out.println("---------------------");
        System.out.println(Arrays.toString(lisIdx));
        System.out.println(Arrays.toString(prev));
        // LIS 수열 복원
        List<Integer> lis = new ArrayList<>();
        int trace = lisIdx[length - 1];
        while (trace != -1) {
            lis.add(arr[trace]);
            trace = prev[trace];
        }

        Collections.reverse(lis);

        // 출력
        System.out.println(length);
        for (int num : lis) {
            System.out.print(num + " ");
        }
    }

    // lowerBound 구현 (이진 탐색): arr[left...right) 중에서 num 이상 처음 위치 반환
    private static int lowerBound(int[] arr, int left, int right, int target) {
        while (left < right) {
            int mid = (left + right) / 2;
            if (arr[mid] < target)
                left = mid + 1;
            else
                right = mid;
        }
        return left;
    }
}