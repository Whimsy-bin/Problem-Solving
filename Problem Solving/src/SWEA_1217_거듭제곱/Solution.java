package SWEA_1217_거듭제곱; // 2s022.08.14

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
//	다음과 같이 두 개의 숫자 N, M이 주어질 때, N의 M 거듭제곱 값을 구하는 프로그램을 재귀호출을 이용하여 구현해 보아라.
//	2 5 = 2 X 2 X 2 X 2 X 2 = 32
//	3 6 = 3 X 3 X 3 X 3 X 3 X 3 = 729

	// 거듭제곱을 구할 함수 선언
	public static int func(int N, int M) {
		int result = 0;

		// M이 0이 되면 1을 곱하도록 한다.(0을 반환하면 열심히 계산해놓고 마지막에 0을 곱해주게 되겠네요?)
		if (M == 0)
			result = 1;
		// 그렇지 않을 때는 거듭제곱의 정의에 따라 이전 값에 N을 계속 곱해주도록 설정한다.
		else
			result = func(N, M - 1) * N;
		
		return result;
	} // func

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = 10; // 테스트 케이스 수가 10개로 정해졌으므로 이 만큼만 for문을 돌도록 해요.
		for (int tc = 1; tc <= T; tc++) {
			int num = Integer.parseInt(br.readLine()); // 테스트 케이스 번호를 받는다.
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken()); // 어떤 숫자를 거듭제곱할지
			int M = Integer.parseInt(st.nextToken()); // 얼마나 거듭제곱할지
			
			// 계산한 값을 출력하고 for문을 닫으면 한 회차 끝!
			System.out.println("#" + num + " " + func(N, M));
		}
		
		br.close();
		
	} // main
} // class
