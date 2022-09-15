package boj_1934_최소공배수; // 2022.09.14

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

//	두 자연수 A와 B에 대해서, A의 배수이면서 B의 배수인 자연수를 A와 B의 공배수라고 한다.
//	이런 공배수 중에서 가장 작은 수를 최소공배수라고 한다. 예를 들어, 6과 15의 공배수는 30, 60, 90등이 있으며, 최소 공배수는 30이다.
//
//	두 자연수 A와 B가 주어졌을 때, A와 B의 최소공배수를 구하는 프로그램을 작성하시오.

	// 최대공약수를 구할 메소드
	public static int func(int large, int small) {
		if (large % small == 0)
			return small;

		return func(small, large % small);
	} // func

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		// 테스트 케이스의 수 T를 받아서 tc = 1부터 T까지 for문을 돌도록 해요
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {

			StringTokenizer st = new StringTokenizer(br.readLine());

			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());

			// 최소공배수를 구하려면 최대공약수를 먼저 구해야 한다!
			int GCD = func(Math.max(A, B), Math.min(A, B)); // 최대공약수
			int LCM = A * B / GCD; // 최소공배수

			sb.append(LCM).append("\n");
		}

		System.out.println(sb);
		br.close();

	} // main
} // class
