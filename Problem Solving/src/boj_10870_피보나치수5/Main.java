package boj_10870_피보나치수5; // 2022.08.13

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

//		피보나치 수는 0과 1로 시작한다. 0번째 피보나치 수는 0이고, 1번째 피보나치 수는 1이다. 그 다음 2번째 부터는 바로 앞 두 피보나치 수의 합이 된다.
//		이를 식으로 써보면 Fn = Fn-1 + Fn-2 (n ≥ 2)가 된다.
//	
//		n=17일때 까지 피보나치 수를 써보면 다음과 같다.
//		0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610, 987, 1597
//	
//		n이 주어졌을 때, n번째 피보나치 수를 구하는 프로그램을 작성하시오.

	// 재귀호출을 할 함수 선언
	public static int func(int n) {
		int result = 0;

		// n < 2일 때는 더 이상 재귀호출을 하지 않도록 반환값 설정을 해주어야 하는데,
		// 0번째 피보나치 수는 0이고, 1번재 피보나치 수는 1로 문제에 주어졌다.
		// n >= 2일 때는 피보나치 수의 정의에 따라 func(n-2) + fuc(n-1)를 계산하여 반환하도록 한다.
		if (n == 0)
			result = 0;
		else if (n == 1)
			result = 1;
		else
			result = func(n - 1) + func(n - 2);

		// 계산한 결과값을 반환한다.
		return result;
	} // func

	public static void main(String[] args) throws IOException {

		// 몇 번째 피보나치 수를 불러올지 지정해주는 0 이상 20 이하의 정수 N을 입력받아서 func(N)을 출력한다.
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		System.out.println(func(N));
		br.close();

	} // main
} // class
