import java.io.*;
import java.util.*;

public class Main {
    static int N, r, c, d;

    static int[] dx = { -1, 0, 1, 0 };
    static int[] dy = { 0, -1, 0, 1 };
    static int[][] graph;
    static boolean[][] visited;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        int inputD = Integer.parseInt(st.nextToken());
        if (inputD == 1)
            d = 0;
        else if (inputD == 2)
            d = 2;
        else if (inputD == 3)
            d = 1;
        else if (inputD == 4)
            d = 3;

        graph = new int[N + 1][N + 1];
        visited = new boolean[N + 1][N + 1];

        for (int i = 1; i < N + 1; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j < N + 1; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        visited[r][c] = true;
        sb.append(r).append(' ').append(c).append('\n');

        while (goNextArea() || findNextArea()) {

        }

        System.out.println(sb);

    }

    static boolean reachable(int x, int y) {

        // System.out.println("x : " + x + " / y : " + y);

        if (x <= 0 || x >= N + 1 || y <= 0 || y >= N + 1) {
            return false;
        } else if (graph[x][y] == 1) {
            return false;
        } else if (visited[x][y]) {
            return false;
        }
        return true;
    }

    static boolean goNextArea() {
        // 1 단계 : 사방탐색
        if (reachable(r + dx[d], c + dy[d])) {
            r += dx[d];
            c += dy[d];
            visited[r][c] = true;
            sb.append(r).append(' ').append(c).append('\n');
            return true;
        } else if (reachable(r + dx[(d + 1) % 4], c + dy[(d + 1) % 4])) {
            r += dx[(d + 1) % 4];
            c += dy[(d + 1) % 4];
            d = (d + 1) % 4;
            visited[r][c] = true;
            sb.append(r).append(' ').append(c).append('\n');
            return true;
        } else if (reachable(r + dx[(d + 3) % 4], c + dy[(d + 3) % 4])) {
            r += dx[(d + 3) % 4];
            c += dy[(d + 3) % 4];
            d = (d + 3) % 4;
            visited[r][c] = true;
            sb.append(r).append(' ').append(c).append('\n');
            return true;
        } else if (reachable(r + dx[(d + 2) % 4], c + dy[(d + 2) % 4])) {
            r += dx[(d + 2) % 4];
            c += dy[(d + 2) % 4];
            d = (d + 2) % 4;
            visited[r][c] = true;
            sb.append(r).append(' ').append(c).append('\n');
            return true;
        }
        return false;
    }

    static boolean findNextArea() {

        Queue<int[]> q = new ArrayDeque<>();
        boolean[][] qVisited = new boolean[N + 1][N + 1];

        qVisited[r][c] = true;
        q.add(new int[] { r, c, 0, d });

        List<int[]> candidates = new ArrayList<>();
        int minDist = Integer.MAX_VALUE;

        while (!q.isEmpty()) {
            int[] now = q.poll();
            int cx = now[0];
            int cy = now[1];
            int dist = now[2];

            if (dist > minDist)
                break;

            if (!visited[cx][cy] && graph[cx][cy] == 0) {
                candidates.add(now);
                minDist = dist;
                continue;
            }

            int[] order = { 1, 2, 3, 0 };
            for (int i : order) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if (nx <= 0 || nx >= N + 1 || ny <= 0 || ny >= N + 1)
                    continue;
                if (graph[nx][ny] == 1)
                    continue;
                if (qVisited[nx][ny])
                    continue;

                qVisited[nx][ny] = true;
                q.add(new int[] { nx, ny, dist + 1, i });
            }
        }

        if (candidates.isEmpty()) {
            return false;
        }

        candidates.sort((a, b) -> {
            if (a[0] != b[0])
                return a[0] - b[0];
            return a[1] - b[1];
        });

        int[] target = candidates.get(0);
        r = target[0];
        c = target[1];
        d = target[3];

        visited[r][c] = true;
        sb.append(r).append(' ').append(c).append('\n');

        return true;
    }
}