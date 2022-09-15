package SWEA_13772_그는내가아는전설의폭탄마였어; // 2022.08.23

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	
//	폭탄마는 폭탄을 최고의 장소에 설치하여 최고의 기쁨을 누리고 싶다. 
//	2차원 배열의 맵이 주어지는데 각 칸에는 폭탄마 얻을 수 있는 행복(?)이 주어진다.
//	해당 폭탄은 특이해서 + 모양으로 터뜨릴 수도 있고 X 모양으로 터뜨릴 수도 있지만 따로 결정해 주는 것은 없다. 
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		// 테스트 케이스의 수 T를 받아서 tc = 1부터 T까지 for문을 돌도록 하자.
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken()); // 배열의 크기 N
			int P = Integer.parseInt(st.nextToken()); // 폭탄의 파워 P
			
			int[][] map = new int[N][N]; // 기쁨 수치를 담을 2차원 배열 선언
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++)
					map[i][j] = Integer.parseInt(st.nextToken());
			}
			
			// + 모양과 x모양으로 터뜨릴 폭탄의 델타 설정
			int[] plus_c = { -1, 0, 0, 1 };
			int[] plus_r = { 0, -1, 1, 0 };
			int[] across_c = { -1, -1, 1, 1 };
			int[] across_r = { -1, 1, -1, 1 };

			int max = 0; // 최고의 기쁨 값을 저장할 변수
			// 목표 : 모든 좌표에서 두 가지 방법으로 폭탄을 터뜨려보고 최고의 기쁨 값을 찾아보자.
			for (int k = 0; k < N; k++) {
				for (int l = 0; l < N; l++) {
					int sum = map[k][l]; // 이번에 폭탄을 터뜨리는 좌표에서 기쁨의 합을 저장할 변수 선언

					int plus_happiness = 0; // + 모양으로 터뜨렸을 때 얻을 수 있는 기쁨값
					int across_happiness = 0; // x 모양으로 터뜨렸을 때 얻을 수 있는 기쁨값
					for (int m = 1; m <= P; m++) {
						for (int n = 0; n < 4; n++) {
							int plus_y = m * plus_c[n] + k;
							int plus_x = m * plus_r[n] + l;
							int across_y = m * across_c[n] + k;
							int across_x = m * across_r[n] + l;
							// 배열의 범위를 벗어나는 곳을 참조하려고 하면 건너뛰도록 하자.
							try {
								plus_happiness += map[plus_y][plus_x];
								across_happiness += map[across_y][across_x];
							} catch (ArrayIndexOutOfBoundsException e) {
								continue;
							}
						}
					}
					// sum에 저장할 때도 두 가지 경우 중 큰 기쁨값을 가지는 것을 저장하자.
					sum += Math.max(plus_happiness, across_happiness);
					max = Math.max(max, sum);
				}
			} // 목표 for문이 끝나는 곳

			// 한 회차를 마치면서 답안을 sb에 저장해준다.
			sb.append("#" + tc + " ").append(max).append("\n");

		}

		System.out.println(sb);
		br.close();

	} // main
}// class