package boj_2653_색종이; // 2022.08.22

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

//	가로, 세로의 크기가 각각 100인 정사각형 모양의 흰색 도화지가 있다.
//	이 도화지 위에 가로, 세로의 크기가 각각 10인 정사각형 모양의 검은색 색종이를 색종이의 변과 도화지의 변이 평행하도록 붙인다.
//	이러한 방식으로 색종이를 한 장 또는 여러 장 붙인 후 색종이가 붙은 검은 영역의 넓이를 구하는 프로그램을 작성하시오.

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		// 값을 따로 지정해주지 않아 모두 0이 할당되어 있는 100 X 100 크기의 2차원 도화지 배열을 선언해준다.
		int[][] paper = new int[100][100];
		int N = Integer.parseInt(br.readLine()); // 색종이의 수
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			int X = Integer.parseInt(st.nextToken());
			int Y = Integer.parseInt(st.nextToken());
			// 색종이를 붙인 위치에 따라 10 X 10 크기의 배열 값은 1로 변경해준다.
			for (int j = 99 - Y; j > 89 - Y; j--) {
				for (int k = X; k < X + 10; k++)
					paper[j][k] = 1;
			}
		}

		int ans = 0; // 검은색 영역의 넓이를 더할 변수 선언
		// paper 배열에서 1의 수를 세면 끝!
		for (int j = 0; j < 100; j++) {
			for (int k = 0; k < 100; k++) {
				if (paper[j][k] == 1)
					ans++;
			}
		}

		System.out.println(ans);
		br.close();

	} // main
} // class
