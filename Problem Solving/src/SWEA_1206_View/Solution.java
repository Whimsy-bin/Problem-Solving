package SWEA_1206_View; // 2022.08.08

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) throws Exception {

//		강변에 빌딩들이 옆으로 빽빽하게 밀집한 지역이 있다.
//		이곳에서는 빌딩들이 너무 좌우로 밀집하여, 강에 대한 조망은 모든 세대에서 좋지만 왼쪽 또는 오른쪽 창문을 열었을 때 바로 앞에 옆 건물이 보이는 경우가 허다하였다.
//		그래서 이 지역에서는 왼쪽과 오른쪽으로 창문을 열었을 때, 양쪽 모두 거리 2 이상의 공간이 확보될 때 조망권이 확보된다고 말한다.
//		빌딩들에 대한 정보가 주어질 때, 조망권이 확보된 세대의 수를 반환하는 프로그램을 작성하시오.

		Scanner sc = new Scanner(System.in);

		// 10개의 testcase가 주어지므로 1로 초기화된 tc가 10이 될때까지 while문을 돌도록 설정한다.
		int tc = 1;
		while (tc <= 10) {

			// 빌딩의 숫자를 받는다.
			int T = sc.nextInt();

			// 빌딩의 높이를 배열에 저장한다.
			int arr[] = new int[T];
			for (int i = 0; i < T; i++) {
				arr[i] = sc.nextInt();
			}

			// 조망권이 확보된 세대의 수를 저장할 변수를 선언
			int ans = 0;

			// 조망권이 확보된 곳을 검사해보자.
			// 배열의 [0] [1] 과 [T-1], [T-2] 에는 0이 저장되어 있을테니 검사할 필요가 없다.
			for (int j = 2; j < T - 2; j++) {
				int canL = 0; // 기준 빌딩의 왼쪽을 고려하였을때 조망권이 확보될 가능성이 있는 세대를 저장할 변수 선언
				int canR = 0; // 기준 빌딩의 오른쪽을 고려하였을때 조망권이 확보될 가능성이 있는 세대를 저장할 변수 선언

				// 먼저 기준 빌딩의 왼쪽을 살펴보아 조망권이 확보될 가능성이 있는 세대를 파악한다.
				if (arr[j] > arr[j - 1] && arr[j] > arr[j - 2]) {
					if (arr[j - 1] > arr[j - 2]) {
						canL += (arr[j] - arr[j - 1]);
					} else {
						canL += (arr[j] - arr[j - 2]);
					}

					// 다음으로 기준 빌딩의 오른쪽을 살펴보아 조망권이 확보될 가능성이 있는 세대를 파악한다.
					if (arr[j] > arr[j + 1] && arr[j] > arr[j + 2]) {
						if (arr[j + 1] > arr[j + 2]) {
							canR += (arr[j] - arr[j + 1]);
						} else {
							canR += (arr[j] - arr[j + 2]);
						}
					}
				}

				// 두 값 중 작은 값을 ans에 더해준다.
				ans += (canL < canR) ? canL : canR;
			}
			// 주어진 형식에 맞추어 출력을 하고 tc값을 1 더해주자.
			System.out.println("#" + tc + " " + ans);
			tc++;
		}
		sc.close();
	} // main
} // class
