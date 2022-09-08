package SWEA_1954_달팽이숫자; // 2022.08.11

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
	public static void main(String[] args) throws IOException {

//		달팽이는 1부터 N*N까지의 숫자가 시계방향으로 이루어져 있다.
//		다음과 같이 정수 N을 입력 받아 N크기의 달팽이를 출력하시오.

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 테스트 케이스의 수 T를 받고 그 숫자까지만 while문을 돌도록 해요.
		int T = Integer.parseInt(br.readLine());
		int tc = 1;
		while (tc <= T) {
			System.out.println("#" + tc + " ");

			// 배열의 크기를 받고 N X N 의 달팽이를 만들게요.
			int N = Integer.parseInt(br.readLine());
			int[][] arr = new int[N][N];

			int shell = N; // 바깥을 돌면서 숫자를 입력해줄건데 달팽이의 초기 바깥 껍질의 크기는 N이죠.
			int i = 1; // 바깥 껍질을 도는 i는 1부터 (4*shell-4)까지 돌면 초기화해줄 거에요.

			int num = 1; // 숫자는 1부터 입력!
			int X = 0; // 이번 숫자가 들어갈 배열 위치의 X좌표
			int Y = 0; // 이번 숫자가 들어갈 배열 위치의 Y좌표

			// 달팽이의 크기 N은 1이상이라 한 번은 반드시 하니까 do-while문을 쓸게요.
			do {
				arr[Y][X] = num;
				if (i < shell) // 위쪽 입력
					X++;
				else if (i < 2 * shell - 1) // 오른쪽 입력
					Y++;
				else if (i < 3 * shell - 2) // 왼쪽 입력
					X--;
				else if (i < 4 * shell - 4) // 아래쪽 입력
					Y--;
				else {
					// 바깥 껍질 끝! 다음 껍질을 채워주러 (shell - 2) 처리해주고 i는 다시 처음으로 초기화
					shell -= 2;
					i = 0;
					X++; // 끝난 위치의 오른쪽 한 칸에서 새로운 바깥 껍질이 시작되니까 X++을 해줘야해요.
				}
				i++;
				num++;
			} while (shell > 0); // 껍질이 남아있으면 계속계속 배열을 채우도록 합니다.

			// 완성된 달팽이 배열을 출력할게요.
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < N; k++) {
					System.out.print(arr[j][k] + " ");
				}
				System.out.println("");
			}

			// 한 회차를 마쳤으니 tc++을 해줄게요.
			tc++;
		}
		br.close();
	} // main
} // class
