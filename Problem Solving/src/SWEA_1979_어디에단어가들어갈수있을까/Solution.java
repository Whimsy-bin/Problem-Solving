package SWEA_1979_어디에단어가들어갈수있을까; // 2022.08.12

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		
//		N X N 크기의 단어 퍼즐을 만들려고 한다. 입력으로 단어 퍼즐의 모양이 주어진다.
//		주어진 퍼즐 모양에서 특정 길이 K를 갖는 단어가 들어갈 수 있는 자리의 수를 출력하는 프로그램을 작성하라.

		Scanner sc = new Scanner(System.in);

		// 테스트 케이스의 수 T를 받고 그 숫자까지만 while문을 돌도록 해요.
		int T = sc.nextInt();
		int tc = 1;
		while (tc <= T) {
			
			int N = sc.nextInt(); // 단어 퍼즐의 크기
			int K = sc.nextInt(); // 단어의 길이

			// (N+2)*(N+2) 크기의 배열을 선언하고, 입력값의 저장은 [1][1]부터 할게요.
			// 이러면 주어지는 단어 퍼즐의 외곽에 0(검은색 부분)이 채워진 배열이 완성됩니다.
			int[][] arr = new int[N + 2][N + 2];
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					arr[i][j] = sc.nextInt();
				}
			}
			
			int ans = 0; // 답을 저장할 변수 선언
			// 목표 : X,Y 좌표를 시작으로 오른쪽으로 혹은 아래로 K길이의 단어가 딱 맞게 들어가는지 확인
			for (int Y = 1; Y <= N; Y++) {
				for (int X = 1; X <= N; X++) {

					// 오른쪽 방향으로 탐색할 건데, 해당 좌표의 바로 왼쪽이 0(검은색)일 때만 실행하도록 해요. 
					if (arr[Y][X - 1] == 0) {
						int check = 0;
						// 1(흰색 부분)이 계속 이어지면 check를 더해주고 아니면 break를 걸어줍니다.
						// 단어의 길이를 넘어서도 흰색 부분이 계속될 수도 있기 때문에 K+1까지도 확인을 해줘야 해요.
						for (int k = 0; k < K + 1; k++) {
							if (arr[Y][X + k] == 1)
								check++;
							else
								break;
						}
						// 1(흰 색 부분)이 이어진 부분이 단어의 길이와 딱 맞는다면 주어진 조건에 맞으므로 ans++을 해줘요.
						if (check == K)
							ans++;
					}

					// 아래 방향도 위와 같은 방식으로 탐색해줍니다.
					if (arr[Y - 1][X] == 0) {
						int check = 0;
						for (int l = 0; l < K + 1; l++) {
							if (arr[Y + l][X] == 1)
								check++;
							else
								break;
						}
						if (check == K)
							ans++;
					}
				}
			} // 목표 for문이 닫히는 곳
			
			// 테스트 케이스 번호와 답을 형식에 맞게 출력해주고 한 회차가 끝났으니 tc++을 해줍니다.
			System.out.println("#" + tc + " " + ans);
			tc++;
		}
		sc.close();
	} // main
} // class
