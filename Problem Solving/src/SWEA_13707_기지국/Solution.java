package SWEA_13707_기지국; // 2022.08.24

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

	// 주어진 2차원 배열 지도에 위치한 기지국으로 커버되지 않는 집의 수를 찾는 프로그램을 작성하시오.

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		// 테스트 케이스의 수 T를 받아서 tc = 1부터 T까지 for문을 돌도록 해요
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine()); // 배열의 크기 N

			// N X N 크기의 2차원 배열을 만들어서 정보를 저장해주어요.
			String[][] map = new String[N][N];
			for (int i = 0; i < N; i++) {
				String str = br.readLine();
				String[] s = str.split("");
				for (int j = 0; j < N; j++)
					map[i][j] = s[j];
			}

			int[] dc = { -1, 0, 0, 1 };
			int[] dr = { 0, -1, 1, 0 };

			// 목표 : 기지국 A, B, C를 찾으면 해당하는 범위의 값을 "X"로 바꿔줄 겁니다.
			for (int k = 0; k < N * N; k++) {
				int Y = (k / N);
				int X = (k % N);
				String what = map[Y][X];

				// 기지국이라면~
				if (!what.equals("X") && !what.equals("H")) {
					for (int l = 0; l < 4; l++) {
						try {
							map[Y + dc[l]][X + dr[l]] = "X";
						} catch (ArrayIndexOutOfBoundsException e) {
							continue;
						}
					}
					// 기지국 B 또는 C라면~
					if (what.equals("B") || what.equals("C")) {
						for (int m = 0; m < 4; m++) {
							try {
								map[Y + 2 * dc[m]][X + 2 * dr[m]] = "X";
							} catch (ArrayIndexOutOfBoundsException e) {
								continue;
							}
						}
						// 기지국 C라면~
						if (what.equals("C")) {
							for (int m = 0; m < 4; m++) {
								try {
									map[Y + 3 * dc[m]][X + 3 * dr[m]] = "X";
								} catch (ArrayIndexOutOfBoundsException e) {
									continue;
								}
							}
						}
					}
				}
			} // 목표 for문이 끝나는 곳

			int ans = 0; // 그래도 남아있는 집의 수를 저장할 변수
			for (int n = 0; n < N * N; n++)
				ans = map[n / N][n % N].equals("H") ? ans + 1 : ans;

			sb.append("#" + tc + " ").append(ans).append("\n");
		}

		System.out.println(sb);
		br.close();

	} // main
}
// class
