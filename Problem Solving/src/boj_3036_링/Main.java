package boj_3036_링; // 2022.08.24

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

//	상근이는 창고에서 링 N개를 발견했다. 상근이는 각각의 링이 앞에 있는 링과 뒤에 있는 링과 접하도록 바닥에 내려놓았다. 
//	
//	상근이는 첫 번째 링을 돌리기 시작했고, 나머지 링도 같이 돌아간다는 사실을 발견했다.
//	나머지 링은 첫 번째 링 보다 빠르게 돌아가기도 했고, 느리게 돌아가기도 했다.
//	이렇게 링을 돌리다 보니 첫 번째 링을 한 바퀴 돌리면, 나머지 링은 몇 바퀴 도는지 궁금해졌다.
//
//	링의 반지름이 주어진다. 이때, 첫 번째 링을 한 바퀴 돌리면, 나머지 링은 몇 바퀴 돌아가는지 구하는 프로그램을 작성하시오.

	// 최대공약수를 구하는 메소드 선언 (유클리드 호제법을 참조했어요.)
	public static int func(int large, int small) {
		if (large % small == 0)
			return small;

		return func(small, large % small);
	} // func

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine()); // 링의 갯수
		StringTokenizer st = new StringTokenizer(br.readLine());
		int first = Integer.parseInt(st.nextToken()); // 첫번째 링의 반지름

		// 목표 : 다음 링의 반지름에 대한 정보를 통해 두 수의 최대공약수를 구하고 기약분수 형태로 sb에 저장하자.
		for (int i = 2; i <= N; i++) {
			int next = Integer.parseInt(st.nextToken());
			int large = Math.max(first, next);
			int small = Math.min(first, next);
			int gcd = func(large, small); // 최대공약수 구하기
			sb.append(first / gcd).append("/").append(next / gcd).append("\n");
		} // 목표 for문 끝나는 곳

		System.out.println(sb);
		br.close();

	} // main
} // class
