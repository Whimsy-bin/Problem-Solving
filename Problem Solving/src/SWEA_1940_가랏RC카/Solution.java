package SWEA_1940_가랏RC카; // 2022.08.28

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	// 문제 설명

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		// 테스트 케이스의 수 T를 받아서 tc=1부터 T까지 for문을 돌도록 해요
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			int speed = 0;
			int distance = 0;
			int N = Integer.parseInt(br.readLine());
			for (int i = 1; i <= N; i++) {
				st = new StringTokenizer(br.readLine());
				int command = Integer.parseInt(st.nextToken());
				if (command != 0) {
					int aclrt = Integer.parseInt(st.nextToken());
					speed = (command == 1) ? speed + aclrt : Math.max(speed - aclrt, 0);
				}
				distance += speed;
			}

			sb.append("#" + tc + " ").append(distance).append("\n");
		}

		System.out.println(sb);
		br.close();

	} // main
} // class
