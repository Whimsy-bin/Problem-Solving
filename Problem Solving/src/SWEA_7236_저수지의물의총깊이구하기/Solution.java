package SWEA_7236_저수지의물의총깊이구하기; // 2022.08.17

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 테스트 케이스의 수 T를 받아 tc=1부터 T까지 for문을 돌도록 한다.
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());

			// N X N 크기의 저수지 배열을 선언해주고 입력값을 받아 저장해주자.
			String reservoir[][] = new String[N][N];
			for (int i = 0; i < N; i++) {
				String temp = br.readLine();
				String arr[] = temp.split(" ");
				for (int j = 0; j < N; j++) {
					reservoir[i][j] = arr[j];
				}
			}
			
			// 해당 좌표의 11시 12시 1시 9시 3시 7시 6시 5시 방향 순서대로 탐색
			int dr[] = { -1, 0, 1, -1, 1, -1, 0, 1 };
			int dc[] = { -1, -1, -1, 0, 0, 1, 1, 1 };

			int max = 0; // 수위의 최댓값을 저장할 변수 선언
			// 목표 : 해당 좌표의 주변 8자리를 살펴봐서 W의 숫자를 세서 수위에 저장
			for (int k = 0; k < N; k++) {
				for (int l = 0; l < N; l++) {
					int water_level = 0;
					for (int m = 0; m < 8; m++) {
						// 배열을 벗어난 값을 잡을 때는 건너뛰도록 try-catch 구문 활용
						try {
							if (reservoir[k + dc[m]][l + dr[m]].equals("W"))
								water_level++;
						} catch (ArrayIndexOutOfBoundsException e) {
							continue;
						}

					} // 주변에 W가 하나도 없었으면 1이 되도록 설정
					if (water_level == 0)
						water_level++;

					// 기존의 수위 최댓값과 이번에 구한 수위 중 큰 값 저장
					max = Math.max(water_level, max);
				}
			} // 목표 for문 닫히는 곳
			
			// 구한 수위의 최댓값을 출력하면서 한 회차 끝!
			System.out.println("#" + tc + " " + max);
		}
		
		br.close();
		
	} // main
} // class