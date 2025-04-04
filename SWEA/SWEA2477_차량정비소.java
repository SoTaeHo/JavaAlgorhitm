import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA2477_차량정비소 {

    static class Info {
        int member;
        int tk;
        int first;
        int second;

        public Info(int member, int tk, int first, int second) {
            this.member = member;
            this.tk = tk;
            this.first = first;
            this.second = second;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int tcase = Integer.parseInt(br.readLine());

        for (int t = 1; t <= tcase; t++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            int[][] nrr = new int[n + 1][2];
            int[][] mrr = new int[m + 1][2];
            List<Info> krr = new ArrayList<>();
            boolean[] isUsingN = new boolean[n + 1];
            boolean[] isUsingM = new boolean[m + 1];
            PriorityQueue<Info> waitReception = new PriorityQueue<>((f, s) -> f.member - s.member);
            Queue<Info> waitRepair = new ArrayDeque<>();
            Info[] recepting = new Info[n + 1];
            Info[] repairing = new Info[m + 1];
            List<Info> end = new ArrayList<>();

            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= n; i++) {
                nrr[i][0] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= m; i++) {
                mrr[i][0] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= k; i++) {
                krr.add(new Info(i, Integer.parseInt(st.nextToken()), 0, 0));
            }
            Collections.sort(krr, (o1, o2) -> o1.tk - o2.tk);
            int tk = 0;
            while (end.size() != k) {
                // System.out.println(end.size());
                // tk에 도착한 사람은 접수창구 대기열에 삽입
                for (int i = 0; i < krr.size(); i++) {
                    if (krr.get(i).tk == tk) {
                        waitReception.offer(krr.get(i));
                    }
                }

                // 만약 채워졌던 창구 중 시간이 다되면 비워주고 end에 넣어준다.
                for (int i = 1; i <= m; i++) {
                    if (mrr[i][1] == 0 && isUsingM[i]) {
                        end.add(repairing[i]);
                        isUsingM[i] = false;
                        repairing[i] = null;
                    }
                }
                // 만약 채워졌던 접수 창구 중 시간이 다되면 비워주고 waitRepair에 넣어준다.
                for (int i = 1; i <= n; i++) {
                    if (nrr[i][1] == 0 && isUsingN[i]) {
                        waitRepair.offer(recepting[i]);
                        isUsingN[i] = false;
                        recepting[i] = null;
                    }
                }

                // 만약 비어있는 접수 창구가 있다면 waitReception에서 제거 후 창구를 채워준다.
                for (int i = 1; i <= n; i++) {
                    if (waitReception.isEmpty()) {
                        break;
                    }
                    if (nrr[i][1] == 0 && !isUsingN[i]) {
                        recepting[i] = waitReception.poll();
                        recepting[i].first = i;
                        nrr[i][1] = nrr[i][0];
                        isUsingN[i] = true;
                    }
                }

                // 만약 비어있는 수리 창구가 있다면 waitRepair에서 제거 후 창구를 채워준다.
                for (int i = 1; i <= m; i++) {
                    if (waitRepair.isEmpty()) {
                        break;
                    }
                    if (mrr[i][1] == 0 && !isUsingM[i]) {
                        repairing[i] = waitRepair.poll();
                        repairing[i].second = i;
                        mrr[i][1] = mrr[i][0];
                        isUsingM[i] = true;
                    }
                }

                for (int i = 1; i <= n; i++) {
                    if (nrr[i][1] != 0)
                        nrr[i][1]--;
                }

                for (int i = 1; i <= m; i++) {
                    if (mrr[i][1] != 0)
                        mrr[i][1]--;
                }
                tk++;
            }
            int ans = 0;
            for (int i = 0; i < end.size(); i++) {
                if (end.get(i).first == a && end.get(i).second == b) {
                    ans += end.get(i).member;
                }
            }

            // for (int i = 0; i < end.size(); i++) {
            // System.out.println("-------------------------");
            // System.out.println(end.get(i).member);
            // System.out.println(end.get(i).tk);
            // System.out.println(end.get(i).first);
            // System.out.println(end.get(i).second);
            // System.out.println();
            // }
            System.out.println("#" + t + " " + (ans == 0 ? -1 : ans));
        }
    }
}
