package boj_2609_최대공약수와최소공배수; // 2022.09.13

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

//	두 개의 자연수를 입력받아 최대 공약수와 최소 공배수를 출력하는 프로그램을 작성하시오.

	// 최대공약수를 구할 메소드
	public static int func(int large, int small) {
		if (large % small == 0)
			return small;

		return func(small, large % small);
	} // func

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());

		int GCD = func(Math.max(A, B), Math.min(A, B)); // 최대공약수
		int LCM = A * B / GCD; // 최소공배수

		sb.append(GCD).append("\n").append(LCM);
		System.out.println(sb);
		br.close();

	} // main
} // class