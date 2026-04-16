class Solution {

    int m, n;
    int[] dx = { -1, 1, 0, 0 };
    int[] dy = { 0, 0, -1, 1 };

    public boolean dfs(char[][] board, int x, int y, String word, int cnt) {
        if (cnt == word.length())
            return true;

        char temp = board[x][y];
        board[x][y] = '#';

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || ny < 0 || nx >= m || ny >= n)
                continue;

            if (board[nx][ny] == word.charAt(cnt)) {
                if (dfs(board, nx, ny, word, cnt + 1)) {
                    return true;
                }
            }
        }

        board[x][y] = temp;
        return false;
    }

    public boolean exist(char[][] board, String word) {
        m = board.length;
        n = board[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == word.charAt(0)) {
                    if (dfs(board, i, j, word, 1)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}