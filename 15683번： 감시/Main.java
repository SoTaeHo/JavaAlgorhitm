
/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 15683                             :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: thxogh1 <boj.kr/u/thxogh1>                  +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/15683                          #+#        #+#      #+#    */
/*   Solved: 2025/03/26 14:27:44 by thxogh1       ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int result = Integer.MAX_VALUE;
    static int count = 0;
    static int n;
    static int m;

    static class Point {
        int row;
        int col;
        int value;

        Point(int row, int col, int value) {
            this.row = row;
            this.col = col;
            this.value = value;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        int[][] map = new int[n][m];
        List<Point> li = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] != 0 && map[i][j] != 6) {
                    li.add(new Point(i, j, map[i][j]));
                }
                if (map[i][j] == 0) {
                    count++;
                }
            }
        }
        List<Integer> dir = new ArrayList<>();
        permutation(map, li, dir, 0, 0);
        System.out.println(result);
    }

    static void permutation(int[][] map, List<Point> li, List<Integer> dir, int depth, int cnt) {
        if (depth == li.size()) {

            int[][] copy = new int[n][m];
            for (int i = 0; i < n; i++) {
                copy[i] = map[i].clone();
            }
            int temp = calc(copy, li, dir);
            result = Math.min(temp, result);
            // System.out.println(temp);
            // for (int i = 0; i < n; i++) {
            // for (int j = 0; j < m; j++) {
            // System.out.print(copy[i][j] + " ");
            // }
            // System.out.println();
            // }
            // System.out.println();
            return;
        }

        for (int i = 0; i < 4; i++) {
            dir.add(i);
            permutation(map, li, dir, depth + 1, cnt);
            dir.remove(dir.size() - 1);
        }
    }

    static boolean isValid(int r, int c) {
        return r < n && r >= 0 && c < m && c >= 0;
    }

    static int calc(int[][] map, List<Point> li, List<Integer> dir) {
        int result = count;
        for (int i = 0; i < li.size(); i++) {
            if (li.get(i).value == 1) {
                int nx = li.get(i).row;
                int ny = li.get(i).col;

                if (dir.get(i) == 0) {
                    nx -= 1;
                    while (isValid(nx, ny) && map[nx][ny] != 6) {
                        if (map[nx][ny] == 0) {
                            result--;
                            map[nx][ny] = 7;
                        }
                        nx--;
                    }
                } else if (dir.get(i) == 1) {
                    nx += 1;
                    while (isValid(nx, ny) && map[nx][ny] != 6) {
                        if (map[nx][ny] == 0) {
                            result--;
                            map[nx][ny] = 7;
                        }
                        nx++;
                    }
                } else if (dir.get(i) == 2) {
                    ny -= 1;
                    while (isValid(nx, ny) && map[nx][ny] != 6) {
                        if (map[nx][ny] == 0) {
                            result--;
                            map[nx][ny] = 7;
                        }
                        ny--;
                    }
                } else if (dir.get(i) == 3) {
                    ny += 1;
                    while (isValid(nx, ny) && map[nx][ny] != 6) {
                        if (map[nx][ny] == 0) {
                            result--;
                            map[nx][ny] = 7;
                        }
                        ny++;
                    }
                }
            } else if (li.get(i).value == 2) {
                int nx = li.get(i).row;
                int ny = li.get(i).col;

                if (dir.get(i) == 0 || dir.get(i) == 1) {
                    nx -= 1;
                    while (isValid(nx, ny) && map[nx][ny] != 6) {
                        if (map[nx][ny] == 0) {
                            result--;
                            map[nx][ny] = 7;
                        }
                        nx--;
                    }
                    nx = li.get(i).row;
                    ny = li.get(i).col;

                    nx += 1;
                    while (isValid(nx, ny) && map[nx][ny] != 6) {
                        if (map[nx][ny] == 0) {
                            result--;
                            map[nx][ny] = 7;
                        }
                        nx++;
                    }
                } else if (dir.get(i) == 2 || dir.get(i) == 3) {
                    ny -= 1;
                    while (isValid(nx, ny) && map[nx][ny] != 6) {
                        if (map[nx][ny] == 0) {
                            result--;
                            map[nx][ny] = 7;
                        }
                        ny--;
                    }
                    nx = li.get(i).row;
                    ny = li.get(i).col;

                    ny += 1;
                    while (isValid(nx, ny) && map[nx][ny] != 6) {
                        if (map[nx][ny] == 0) {
                            result--;
                            map[nx][ny] = 7;
                        }
                        ny++;
                    }
                }
            } else if (li.get(i).value == 3) {
                int nx = li.get(i).row;
                int ny = li.get(i).col;
                if (dir.get(i) == 0) {
                    nx -= 1;
                    while (isValid(nx, ny) && map[nx][ny] != 6) {
                        if (map[nx][ny] == 0) {
                            result--;
                            map[nx][ny] = 7;
                        }
                        nx--;
                    }

                    nx = li.get(i).row;

                    ny += 1;
                    while (isValid(nx, ny) && map[nx][ny] != 6) {
                        if (map[nx][ny] == 0) {
                            result--;
                            map[nx][ny] = 7;
                        }
                        ny++;
                    }
                } else if (dir.get(i) == 1) {
                    nx += 1;
                    while (isValid(nx, ny) && map[nx][ny] != 6) {
                        if (map[nx][ny] == 0) {
                            result--;
                            map[nx][ny] = 7;
                        }
                        nx++;
                    }

                    nx = li.get(i).row;

                    ny += 1;
                    while (isValid(nx, ny) && map[nx][ny] != 6) {
                        if (map[nx][ny] == 0) {
                            result--;
                            map[nx][ny] = 7;
                        }
                        ny++;
                    }
                } else if (dir.get(i) == 2) {
                    nx += 1;
                    while (isValid(nx, ny) && map[nx][ny] != 6) {
                        if (map[nx][ny] == 0) {
                            result--;
                            map[nx][ny] = 7;
                        }
                        nx++;
                    }

                    nx = li.get(i).row;

                    ny -= 1;
                    while (isValid(nx, ny) && map[nx][ny] != 6) {
                        if (map[nx][ny] == 0) {
                            result--;
                            map[nx][ny] = 7;
                        }
                        ny--;
                    }
                } else if (dir.get(i) == 3) {
                    nx -= 1;
                    while (isValid(nx, ny) && map[nx][ny] != 6) {
                        if (map[nx][ny] == 0) {
                            result--;
                            map[nx][ny] = 7;
                        }
                        nx--;
                    }

                    nx = li.get(i).row;

                    ny -= 1;
                    while (isValid(nx, ny) && map[nx][ny] != 6) {
                        if (map[nx][ny] == 0) {
                            result--;
                            map[nx][ny] = 7;
                        }
                        ny--;
                    }
                }
            } else if (li.get(i).value == 4) {

                int nx = li.get(i).row;
                int ny = li.get(i).col;
                int up = 0, down = 0, left = 0, right = 0;
                nx -= 1;
                while (isValid(nx, ny) && map[nx][ny] != 6 && dir.get(i) != 0) {
                    if (map[nx][ny] == 0) {
                        result--;
                        map[nx][ny] = 7;
                    }
                    nx--;
                }

                nx = li.get(i).row;

                ny += 1;
                while (isValid(nx, ny) && map[nx][ny] != 6 && dir.get(i) != 1) {
                    if (map[nx][ny] == 0) {
                        result--;
                        map[nx][ny] = 7;
                    }
                    ny++;
                }

                ny = li.get(i).col;
                nx += 1;
                while (isValid(nx, ny) && map[nx][ny] != 6 && dir.get(i) != 2) {
                    if (map[nx][ny] == 0) {
                        result--;
                        map[nx][ny] = 7;
                    }
                    nx++;
                }

                nx = li.get(i).row;

                ny -= 1;
                while (isValid(nx, ny) && map[nx][ny] != 6 && dir.get(i) != 3) {
                    if (map[nx][ny] == 0) {
                        result--;
                        map[nx][ny] = 7;
                    }
                    ny--;
                }

            } else if (li.get(i).value == 5) {
                int nx = li.get(i).row;
                int ny = li.get(i).col;
                nx -= 1;
                while (isValid(nx, ny) && map[nx][ny] != 6) {
                    if (map[nx][ny] == 0) {
                        result--;
                        map[nx][ny] = 7;
                    }
                    nx--;
                }

                nx = li.get(i).row;

                ny += 1;
                while (isValid(nx, ny) && map[nx][ny] != 6) {
                    if (map[nx][ny] == 0) {
                        result--;
                        map[nx][ny] = 7;
                    }
                    ny++;
                }

                ny = li.get(i).col;
                nx += 1;
                while (isValid(nx, ny) && map[nx][ny] != 6) {
                    if (map[nx][ny] == 0) {
                        result--;
                        map[nx][ny] = 7;
                    }
                    nx++;
                }

                nx = li.get(i).row;

                ny -= 1;
                while (isValid(nx, ny) && map[nx][ny] != 6) {
                    if (map[nx][ny] == 0) {
                        result--;
                        map[nx][ny] = 7;
                    }
                    ny--;
                }
            } else {
                System.out.println("error");
            }
        }
        return result;
    }
}