package SWEA_2001_파리퇴치; // 2022.08.11

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {

//		N x N 배열 안의 숫자는 해당 영역에 존재하는 파리의 개수를 의미한다.
//		
//		M x M 크기의 파리채를 한 번 내리쳐 최대한 많은 파리를 죽이고자 한다.
//		죽은 파리의 개수를 구하라!
//		
//		1. N 은 5 이상 15 이하이다.
//		2. M은 2 이상 N 이하이다.
//		3. 각 영역의 파리 갯수는 30 이하 이다.

		Scanner sc = new Scanner(System.in);

		// 테스트 케이스의 수 T를 받고 그 숫자까지만 while문을 돌도록 해요.
		int T = sc.nextInt();
		int tc = 1;
		while (tc <= T) {
			System.out.printf("#" + tc + " ");

			int N = sc.nextInt(); // 배열의 크기 저장
			int M = sc.nextInt(); // 파리채의 크기 저장
			
			// N*N 크기의 배열에 파리의 개수를 저장합시다.
			int[][] arr = new int[N][N]; 
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					arr[i][j] = sc.nextInt();
				}
			}
			
			int X = 0; // 파리채가 내리친 구역의 가장 왼쪽 위 X좌표
			int Y = 0; // 파리채가 내리친 구역의 가장 왼쪽 위 Y좌표
			int max = 0; // 가장 많은 파리를 죽였을 때 죽은 파리의 개수를 저장할 변수 선언
			do { // M은 N이하라서 반드시 한 번은 내려치므로 do-while문을 써보도록 하자
				
				int kill = 0; // 이번에 파리채가 내려친 구역에서 죽은 파리의 수를 저장할 변수 선언
				// 목표 : 파리채가 내려친 구역에서 죽은 파리의 수를 구한다.
				for (int k = 0; k < M; k++) {
					for (int l = 0; l < M; l++) {
						kill += arr[Y+k][X+l];
					}
				}
				
				// 이번에 내려친 구역에서 죽은 파리의 수와 기존의 max값을 비교하여 큰 수를 저장
				max = Math.max(max, kill);
				
				// 방금 내려친 곳에서 X가 아직 N-M 미만이라면 오른쪽으로만 한 칸 이동하여 다시 내려치도록 해주고
				if (X<N-M) 
					X++;
				// 방금 내려친 곳에서 X가 N-M 이상이라면 Y++해주고 X는 0으로 초기화해준다.
				else {
					Y++;
					X=0;
				}
			} while (Y<=N-M); // Y가 N-M을 넘어설 때까지 while문을 돌도록 한다.
			
			// max를 출력해주고 한 회차를 마쳤으니 tc++을 해줄게요.
			System.out.println(max);
			tc++;
		}

		sc.close();
	} // main
} // class
