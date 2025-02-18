import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Problem2615 {

	static int dx[] = { -1, 1, 0, 0, -1, -1, 1, 1 };
	static int dy[] = { 0, 0, -1, 1, -1, 1, -1, 1 };
	static int rdx[] = { 1, -1, 0, 0, 1, 1, -1, -1 };
	static int rdy[] = { 0, 0, 1, -1, 1, -1, 1, -1 };
	static int winner;
	static int row;
	static int col;
	static int arr[][] = new int[20][20];
	static int xPos[] = new int[5];
	static int yPos[] = new int[5];
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int i = 1; i < 20; i++) {
			String str = br.readLine();
			String[] input = str.split(" ");
			for (int j = 1; j < 20; j++) {
				// System.out.printf("%d %d\n", i, j);

				arr[i][j] = Integer.parseInt(input[j - 1]);
			}
		}

		for (int i = 1; i < 20; i++) {
			for (int j = 1; j < 20; j++) {
				if (arr[i][j] == 0)
					continue;
				else if (arr[i][j] == 1 || arr[i][j] == 2) {
					int num = arr[i][j];
					xPos[0] = i;
					yPos[0] = j;
					for (int k = 0; k < 8; k++) {
						for (int l = 1; l <= 4; l++) {
							if (i + l * dx[k] < 20 && i + l * dx[k] >= 0 && j + l * dy[k] < 20 && j + l * dy[k] >= 0
									&& arr[i + l * dx[k]][j + l * dy[k]] == num
									) {
									
								xPos[l] = i + l * dx[k];
								yPos[l] = j + l * dy[k];
								if (l == 4) {
									// System.out.printf("%d %d\n", i + (l + 1) * dx[k], j + (l + 1) * dy[k]);
									if ( // 육목체크
										i + (l + 1) * dx[k] < 20 && i + (l + 1) * dx[k] >= 0 && j + (l + 1) * dy[k] < 20 && j + (l + 1) * dy[k] >= 0 
										&& arr[i + (l + 1)* dx[k]][j + (l + 1)* dy[k]] == num
									) {
										break;
									}
									if ( // 육목체크 2
										i + rdx[k] < 20 && i + rdx[k] >= 0 && j + rdy[k] < 20 && j + rdy[k] >= 0 
										&& arr[i + rdx[k]][j + rdy[k]] == num
									) {
										break;
									}
									// System.out.printf("%d %d\n",i , j);
									if (winner == 0) {
										winner = num;
										getPos(xPos, yPos, k);
									} else if (winner != num) {
										System.out.printf("%d %d\n",i , j);
										System.out.println("0");
										// System.out.println(winner);
										return;
									}
								}
							} else {
								break;
							}
						}
					}
				}

			}
		}
		System.out.println(winner);
		if (winner != 0)
			System.out.printf("%d %d\n", row, col);
	}

	public static void getPos(int[] xPos, int[] yPos, int k) {

		int min = 99;
		int idx = 0;
		// System.out.println(Arrays.toString(xPos));
		// System.out.println(Arrays.toString(yPos));
		// System.out.println(k);
		for (int i = 0; i < xPos.length; i++) {
			if (min > yPos[i]) {

				min = yPos[i];
				idx = i;
			}
		}
		row = xPos[idx];
		col = min;
	}
}
