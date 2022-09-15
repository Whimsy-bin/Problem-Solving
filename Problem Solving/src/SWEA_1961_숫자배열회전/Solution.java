package SWEA_1961_숫자배열회전; // 2022.08.24

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	// N x N 행렬이 주어질 때,
	// 시계 방향으로 90도, 180도, 270도 회전한 모양을 출력하라.

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		// 테스트 케이스의 수 T를 받아서 tc=1부터 T까지 for문을 돌도록 해요
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			sb.append("#" + tc + "\n");

			// 주어진 행렬의 정보를 2차원 배열에받는다.
			int N = Integer.parseInt(br.readLine());
			int[][] matrix = new int[N][N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++)
					matrix[i][j] = Integer.parseInt(st.nextToken());
			}

			// 목표 : 정해진 출력 형식에 맞추어 sb에 저장하자
			for (int k = 0; k < N; k++) {
				// 90도 회전
				for (int l = N - 1; l >= 0; l--)
					sb.append(matrix[l][k]);
				sb.append(" ");
				// 180도 회전
				for (int m = N - 1; m >= 0; m--)
					sb.append(matrix[N - 1 - k][m]);
				sb.append(" ");
				// 270도 회전
				for (int n = 0; n < N; n++)
					sb.append(matrix[n][N - 1 - k]);
				sb.append("\n");

			} // 목표 for문 끝나는 곳
		}

		System.out.println(sb);
		br.close();

	} // main
} // class
