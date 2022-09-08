package SWEA_1204_최빈수구하기; // 2022.08.09

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {

		// 어느 고등학교에서 실시한 1000명의 수학 성적을 토대로 통계 자료를 만들려고 한다.
		// 이때, 이 학교에서는 최빈수를 이용하여 학생들의 평균 수준을 짐작하는데, 여기서 최빈수는 특정 자료에서 가장 여러 번 나타나는 값을
		// 의미한다.

		// 다음과 같은 수 분포가 있으면,
		// 10, 8, 7, 2, 2, 4, 8, 8, 8, 9, 5, 5, 3
		// 최빈수는 8이 된다.

		// 최빈수를 출력하는 프로그램을 작성하여라 (단, 최빈수가 여러 개 일 때에는 가장 큰 점수를 출력하라).

		Scanner sc = new Scanner(System.in);

		// 테스트 케이스의 수 T를 받고 그 숫자까지만 for문을 돌도록 한다.
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {

			// N은 굳이 왜 주어지는지 몰?루 일단 출력해보자
			int N = sc.nextInt();
			System.out.print("#" + N + " ");

			// 점수의 종류는 0점부터 100점까지 101개가 있으니 크기가 101인 배열을 만들어보자.
			int score = 101;
			int arr[] = new int[score];

			// 학생 1000명의 점수를 받아서 arr[점수]에 하나씩 늘린다.
			// 이렇게 되면 arr[점수]에는 해당 점수를 받은 사람의 수가 저장된다.
			for (int i = 0; i < 1000; i++) {
				arr[sc.nextInt()]++;
			}

			int mode = 0; // 최빈수를 저장할 변수
			int cnt = 0; // 최빈수의 횟수를 저장할 변수
			for (int j = 0; j < arr.length; j++) {

				// j를 받은 사람의 수 arr[j]가 cnt보다 크다면 새로운 최빈수로서 mode와 cnt를 갱신한다.
				if (cnt < arr[j]) {
					cnt = arr[j];
					mode = j;
				}
				// 둘이 같다면 둘 중의 큰 수를 최빈수 mode에 저장한다.
				else if (cnt == arr[j])
					mode = Math.max(mode, j);
			}

			System.out.println(mode);
		}
		sc.close();
		
	} // main
} // class
