package SWEA_1984_중간평균값구하기; // 2022.08.09

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {

		// 10개의 수를 입력 받아, 최대 수와 최소 수를 제외한 나머지의 평균값을 출력하는 프로그램을 작성하라.
		// (소수점 첫째 자리에서 반올림한 정수를 출력한다.)
		// 각 수는 0 이상 10000 이하의 정수이다.

		Scanner sc = new Scanner(System.in);

		// 테스트 케이스의 수 T를 받고 그 숫자까지만 while문을 돌도록 해요.
		int T = sc.nextInt();
		int tc = 1;
		while (tc <= T) {
			System.out.print("#" + tc + " ");

			int N = 10; // 숫자는 10개가 주어지고요.
			double sum = 0; // 여기에는 주어지는 숫자를 다 더해줄거에요.
			int min = Integer.MAX_VALUE; // 최솟값을 찾아 저장해줄 변수 선언
			int max = 0; // 최댓값을 찾아 저장해줄 변수 선언

			for (int i = 0; i < N; i++) {
				// 숫자를 받아서 Sum에 더해주고 최솟값인지 최댓값인지도 비교를 해봅니다.
				int num = sc.nextInt();
				sum += num;
				min = Math.min(min, num);
				max = Math.max(max, num);
			}

			// 최댓값과 최솟값은 제외했어야 하니까 다시 빼주고 정답을 저장할 변수 ans에 평균을 계산해줍니다.
			sum = (sum - min - max);
			double ans = (sum / (N - 2));

			// 소숫점 첫째 자리에서 반올림하라고 했으니, 형식에 맞추어 출력해봅시다.
			System.out.println(Math.round(ans));

			// 한 회차를 마쳤으니 tc++을 해줄게요.
			tc++;
		}

		sc.close();
	} // main
} // class