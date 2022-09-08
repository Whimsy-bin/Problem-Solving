package boj_2669_직사각형네개의합집합의면적구하기; // 2022.08.22

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

//	평면에 네 개의 직사각형이 놓여 있는데 그 밑변은 모두 가로축에 평행하다.
//	이 네 개의 직사각형들은 서로 떨어져 있을 수도 있고, 겹쳐 있을 수도 있고, 하나가 다른 하나를 포함할 수도 있으며, 변이나 꼭짓점이 겹칠 수도 있다.
//	이 직사각형들이 차지하는 면적을 구하는 프로그램을 작성하시오.

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		// 값을 따로 지정해주지 않아 모두 0이 할당되어 있는 100 X 100 크기의 2차원 배열을 선언해준다.
		int[][] plane = new int[100][100];
		int N = 4; // 직사각형의 갯수
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			int lbX = Integer.parseInt(st.nextToken()); // 왼쪽 아래(left_bottom) 꼭짓점의 X좌표
			int lbY = Integer.parseInt(st.nextToken()); // 왼쪽 아래(left_bottom) 꼭짓점의 Y좌표
			int rtX = Integer.parseInt(st.nextToken()); // 오른쪽 위(right_top) 꼭짓점의 X좌표
			int rtY = Integer.parseInt(st.nextToken()); // 오른쪽 위(right_top) 꼭짓점의 Y좌표
			// 직사각형의 꼭짓점의 위치 정보에 따라 해당하는 구역은 1 값을 할당해준다.
			for (int j = 99 - lbY; j > 99 - rtY; j--) {
				for (int k = lbX; k < rtX; k++)
					plane[j][k] = 1;
			}
		}

		int ans = 0; // 직사각형이 차지하는 면적의 넓이를 저장할 변수 선언
		// 배열에서 1의 수를 세면 끝!
		for (int j = 0; j < 100; j++) {
			for (int k = 0; k < 100; k++) {
				if (plane[j][k] == 1)
					ans++;
			}
		}

		System.out.println(ans);
		br.close();

	} // main
} // class
