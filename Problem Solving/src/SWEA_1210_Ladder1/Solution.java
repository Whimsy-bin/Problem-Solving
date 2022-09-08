package SWEA_1210_Ladder1; // 2022.08.11

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {

//		점심 시간에 산책을 다니는 사원들은 최근 날씨가 더워져, 사다리 게임을 통하여 누가 아이스크림을 구입할지 결정하기로 한다.
//		김 대리는 사다리타기에 참여하지 않는 대신 사다리를 그리기로 하였다.
//		사다리를 다 그리고 보니 김 대리는 어느 사다리를 고르면 X표시에 도착하게 되는지 궁금해졌다. 이를 구해보자.

		Scanner sc = new Scanner(System.in);

		// 10개의 testcase가 주어지므로 tc가 1부터 10이 될때까지만 while문을 돌도록 합시다.
		int T = 10;
		int tc = 1;
		while (tc <= T) {

			// N은 굳이 왜 주어지는지 몰?루 일단 출력해보자.
			int N = sc.nextInt();
			System.out.print("#" + N + " ");

			int size = 100; // 행렬의 크기는 100 X 100으로 고정
			int X = 0;
			int[][] arr = new int[size][size]; // 주어지는 값들을 받아서 2차원 배열에 저장합시다.
			for (int i = 0; i < size; i++) {
				for (int j = 0; j < 100; j++) {
					arr[i][j] = sc.nextInt();
					if (arr[i][j] == 2)
						X = j; // 2가 등장하는 도착점의 X좌표는 저장해두어야 합니다.
				}
			}
			
			// 목표 : Y좌표를 하나씩 올라오면서 출발점의 X좌표를 찾는 것
			for (int Y = 99; Y > 0; Y--) {
				String direction = "free"; // 방향을 자유로 초기화해두고
				
				// X좌표가 0이 아닐 때만 이 while문을 검사할 수 있어요.
				while (X != 0 && (direction == "free" || direction == "left")) {
					if (arr[Y][X - 1] == 1) {
						X--;
						direction = "left"; // 오른쪽 왼쪽을 왔다갔다 하지 않게 찾던 방향이 "왼쪽"임을 저장해둡니다.
					} else
						break;
				}
				
				// X좌표가 99가 아닐 때만 이 while문을 검사할 수 있어요.
				while (X != 99 && direction == "free") {
					if (arr[Y][X + 1] == 1) {
						X++;
						// 방향이 왼쪽이 아니면 오른쪽밖에 없으니까 여기서는 방향을 "오른쪽"이라고 따로 저장해주지 않아도 됩니다.
					} else
						break;
				}
			}
			
			// 찾았다 X좌표~ 출력해주고 한 회차를 마쳤으니 tc++을 해줄게요.
			System.out.println(X);
			tc++;
		}

		sc.close();
	} // main
} // class
