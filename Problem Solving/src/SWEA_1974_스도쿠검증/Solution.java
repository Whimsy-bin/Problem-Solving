package SWEA_1974_스도쿠검증; // 2022.08.24

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

//	스도쿠는 숫자퍼즐로, 가로 9칸 세로 9칸으로 이루어져 있는 표에 1 부터 9 까지의 숫자를 채워넣는 퍼즐이다.
//	같은 줄에 1 에서 9 까지의 숫자를 한번씩만 넣고, 3 x 3 크기의 작은 격자 또한, 1 에서 9 까지의 숫자가 겹치지 않아야 한다.
//	입력으로 9 X 9 크기의 스도쿠 퍼즐의 숫자들이 주어졌을 때, 위와 같이 겹치는 숫자가 없을 경우, 1을 정답으로 출력하고 그렇지 않을 경우 0 을 출력한다.

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		// 테스트 케이스의 수 T를 받아서 tc=1부터 T까지 for문을 돌도록 해요
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			sb.append("#" + tc + " ");

			// 일단 스도쿠 퍼즐의 정보를 9 X 9 배열에 다 담아보자.
			int[][] puzzle = new int[9][9];
			for (int i = 0; i < 9; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < 9; j++)
					puzzle[i][j] = Integer.parseInt(st.nextToken());
			}

			boolean check = true; // 올바른 스도쿠 퍼즐인지 아닌지 여부를 저장할 논리형 변수 선언

			// 목표 : 가로 세로 검사. 1~9까지의 곱은 3628800이므로 이것을 활용한다.
			for (int k = 0; k < 9; k++) {
				int multiply_r = 1;
				int multiply_c = 1;
				for (int l = 0; l < 9; l++) {
					multiply_r *= puzzle[k][l];
					multiply_c *= puzzle[l][k];
				}
				// 한 줄이라도 그렇지 않은 경우가 있으면 바로 for문을 탈출하자
				if (multiply_r != 362880 || multiply_c != 362880) {
					check = false;
					break;
				}
			}

			// 목표 : 3 X 3 크기의 작은 격자 검사.
			int Y = 0;
			int X = 0;
			// 가로 세로 검사에서 이미 걸려서 check가 false로 바뀌었으면 할 필요가 없다
			while (check && Y != 9) {
				int multiply_g = 1;
				for (int m = 0; m < 9; m++)
					multiply_g *= puzzle[(m / 3) + Y][(m % 3) + X];

				if (multiply_g != 362880) {
					check = false;
					break;
				}
				
				// 검사할 격자 위치를 바꾸어준다.
				if (X != 6)
					X += 3;
				else {
					Y += 3;
					X = 0;
					
				}
			}
			
			sb.append(check ? 1 : 0).append("\n");
		}
		

		System.out.println(sb);
		br.close();

	} // main
} // class
