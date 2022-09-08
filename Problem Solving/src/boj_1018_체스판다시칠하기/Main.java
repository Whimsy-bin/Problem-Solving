package boj_1018_체스판다시칠하기; // 2022.08.21

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

//	지민이는 자신의 저택에서 MN개의 단위 정사각형으로 나누어져 있는 M×N 크기의 보드를 찾았다.
//	어떤 정사각형은 검은색으로 칠해져 있고, 나머지는 흰색으로 칠해져 있다. 지민이는 이 보드를 잘라서 8×8 크기의 체스판으로 만들려고 한다.
//
//	체스판은 검은색과 흰색이 번갈아서 칠해져 있어야 한다.
//	구체적으로, 각 칸이 검은색과 흰색 중 하나로 색칠되어 있고, 변을 공유하는 두 개의 사각형은 다른 색으로 칠해져 있어야 한다.
//	따라서 이 정의를 따르면 체스판을 색칠하는 경우는 두 가지뿐이다. 하나는 맨 왼쪽 위 칸이 흰색인 경우, 하나는 검은색인 경우이다.
//
//	보드가 체스판처럼 칠해져 있다는 보장이 없어서, 지민이는 8×8 크기의 체스판으로 잘라낸 후에 몇 개의 정사각형을 다시 칠해야겠다고 생각했다.
//	당연히 8*8 크기는 아무데서나 골라도 된다. 지민이가 다시 칠해야 하는 정사각형의 최소 개수를 구하는 프로그램을 작성하시오.

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // 배열에 저장할 때 행의 길이
		int M = Integer.parseInt(st.nextToken()); // 배열에 저장할 때 열의 길이

		// 번갈아가면서 확인하기 쉽도록 B는 1로 W는 0으로 배열에 저장해줄게요.
		int[][] board = new int[N][M];
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			String temp[] = str.split("");
			for (int j = 0; j < M; j++) {
				board[i][j] = (temp[j].equals("B")) ? 1 : 0;
			}
		}

		int X = 0; // 8X8 구역의 가장 왼쪽 위 X좌표
		int Y = 0; // 8X8 구역의 가장 왼쪽 위 Y좌표
		int max = 0; // 체스판과 일치하는 정도가 가장 큰 값을 저장할 변수 선언

		// 목표 : 주어진 보드 정보에서, 번갈아가면서 색이 등장하는 정도가 가장 많을 때를 찾아봅시다.
		do { // 반드시 한 번은 찾아볼테니까 do-while문을 써볼까요?
			int color_info = board[Y][X]; // 이번에 확인할 8X8 구역의 가장 왼쪽 위의 좌표
			int match = 0;
			int mismatch = 0; // 가장 왼쪽 위 좌표를 다시 색칠할 경우도 있을 수 있으므로 일치하지 않을 때도 살펴봅니다.

			for (int k = 0; k < 8; k++) {
				for (int l = 0; l < 8; l++) {
					if (color_info == board[Y + k][X + l])
						match++;
					else
						mismatch++;
					color_info = 1 - color_info; // 번갈아가면서 확인하도록 color_info는 계속 바꿔주어요.
				}
				color_info = 1 - color_info; // 행바꿈이 될 때도 색 정보를 바꿔주어야 합니다.
			}
			max = Math.max(max, Math.max(match, mismatch));

			if (X < M - 8) // 이번 행의 끝 열까지 다 살펴보기
				X++;
			else { // 마지막 열까지 다 살펴봤으면 행바꿈해주기
				Y++;
				X = 0;
			}

		} while (Y <= N - 8); // Y가 N-8 을 넘어설 때까지 while문을 돌도록 한다.

		System.out.println(64 - max);
		br.close();

	} // main
} // class