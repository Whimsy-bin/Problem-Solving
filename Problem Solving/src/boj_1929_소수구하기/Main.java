package boj_1929_소수구하기; // 2022.09.14

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

//	M이상 N이하의 소수를 모두 출력하는 프로그램을 작성하시오.

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		// (1 ≤ M ≤ N ≤ 1,000,000) M이상 N이하의 소수가 하나 이상 있는 입력만 주어진다.
		StringTokenizer st = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());

		// M이 2이하라면 sb에 2를 추가한다.
		if (M <= 2) 
			sb.append("2").append("\n");
		
		// 목표 : M부터 N까지(M이 2이하라면 3부터 N까지) 소수를 찾아 sb에 저장해보자.
		target: for (int i = Math.max(3, M); i <= N; i++) {
			
			// 이번 숫자(i)를 2부터 i의 제곱근까지 나누어보자
			for (int j = 2; j <= Math.sqrt(i); j++) {
				
				// 나누어떨어지는 경우가 있다면 소수가 아니므로 이번 i는 건너뛴다.
				if (i % j == 0)
					continue target;
			}
			
			// 건너뛰어지지 않고 여기까지 왔다면 해당 숫자는 소수이므로 sb에 저장한다.
			sb.append(i).append("\n");
		}

		// 소수들이 잘 저장된 sb를 출력하면 끝!
		System.out.println(sb);
		br.close();

	} // main
} // class
