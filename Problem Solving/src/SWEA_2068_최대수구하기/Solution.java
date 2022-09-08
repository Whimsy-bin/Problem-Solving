package SWEA_2068_최대수구하기; // 2022.08.09

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {

//		10개의 수를 입력 받아, 그 중에서 가장 큰 수를 출력하는 프로그램을 작성하라.
//		각 수는 0 이상 10000 이하의 정수이다.
		
		Scanner sc = new Scanner(System.in);

		// 테스트 케이스의 수 T를 받고 그 숫자까지만 while문을 돌도록 해요.
		int T = sc.nextInt();
		int tc = 1;
		while (tc <= T) {
			System.out.print("#" + tc + " ");

			int N = 10; // 숫자는 10개가 주어지고요.
			int max = 0; // 최댓값을 담을 max 변수입니다.

			// 숫자를 받으면서 바로바로 큰 숫자를 max에 담아줍니다.
			for (int i = 1; i <= N; i++) {
				int num = sc.nextInt();
				max = Math.max(max, num);
			}

			// 저장된 최댓값을 출력해주고 한 회차를 마쳤으니 tc++을 해줄게요.
			System.out.println(max);
			tc++;
		}

		sc.close();

	} // main
} // class
