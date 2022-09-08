package SWEA_1209_Sum; // 2022.08.11

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {

//		2차원 배열이 주어질 때, 각 행의 합, 각 열의 합, 각 대각선의 합 중 최댓값을 구하는 프로그램을 작성하여라.

//		총 10개의 테스트 케이스가 주어진다.
//		배열의 크기는 5X5으로 동일하다.
//		각 행의 합은 integer 범위를 넘어가지 않는다.
//		동일한 최댓값이 있을 경우, 하나의 값만 출력한다.

		Scanner sc = new Scanner(System.in);

		// 10개의 testcase가 주어지므로 tc가 1부터 10이 될때까지만 while문을 돌도록 합시다.
		int T = 10;
		int tc = 1;
		while (tc <= T) {

			// N은 굳이 왜 주어지는지 몰?루 일단 출력해보자.
			int N = sc.nextInt();
			System.out.print("#" + N + " ");

			int size = 100; // 행렬의 크기는 100 X 100으로 고정
			int[][] arr = new int[size][size]; // 주어지는 값들을 받아서 2차원 배열에 저장합시다.
			for (int i = 0; i < size; i++) {
				for (int j = 0; j < 100; j++) {
					arr[i][j] = sc.nextInt();
				}
			}

			int row = 0; // 여기에는 행의 합을 담고
			int column = 0; // 여기에는 열의 합을 담고
			int diagonalL = 0; // 여기에는 왼쪽 끝에서부터 내려오는 대각선의 합을 담고
			int diagonalR = 0; // 여기에는 오른쪽 끝에서부터 내려오는 대각선의 합을 담고
			int max = 0; // 최댓값을 저장할 변수 max까지 선언!
			for (int k = 0; k < size; k++) {
				row = 0;
				column = 0;
				for (int l = 0; l < size; l++) {
					row += arr[k][l];
					column += arr[l][k];
				}
				// 여기까지 계산한 행의 합과 열의 합 중에 최댓값이 있으면 max에 저장
				max = Math.max(max, Math.max(row, column));
				diagonalL += arr[k][k];
				diagonalR += arr[size - 1 - k][size - 1 - k];
			}
			// 대각선의 합까지 검사하여 max에 저장하면 검사 끝
			max = Math.max(max, Math.max(diagonalL, diagonalR));
			
			// 저장된 최댓값을 출력해주고 한 회차를 마쳤으니 tc++을 해줄게요.
			System.out.println(max);
			tc++;
		}
		sc.close();
	} // main
} // class
