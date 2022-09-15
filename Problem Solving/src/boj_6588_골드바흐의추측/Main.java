package boj_6588_골드바흐의추측; // 2022.09.15

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

//	1742년, 독일의 아마추어 수학가 크리스티안 골드바흐는 레온하르트 오일러에게 다음과 같은 추측을 제안하는 편지를 보냈다.
//
//	4보다 큰 모든 짝수는 두 홀수 소수의 합으로 나타낼 수 있다.
//	
//	예를 들어 8은 3 + 5로 나타낼 수 있고, 3과 5는 모두 홀수인 소수이다.
//	또, 20 = 3 + 17 = 7 + 13, 42 = 5 + 37 = 11 + 31 = 13 + 29 = 19 + 23 이다.
//	이 추측은 아직도 해결되지 않은 문제이다.
//	백만 이하의 모든 짝수에 대해서, 이 추측을 검증하는 프로그램을 작성하시오.

	public static void main(String[] args) throws IOException {

		List<Integer> primeNum = new ArrayList<>(); // 소수들을 저장할 ArrayList
		primeNum.add(2); // 최초 소수 2

		// 목표 : 3부터 1,000,000까지의 숫자 중 소수들을 ArrayList에 저장해보자
		target: for (int i = 3; i <= 1000000; i++) {
			for (int j = 0; primeNum.get(j) <= Math.sqrt(i); j++) {
				if (i % primeNum.get(j) == 0)
					continue target;
			}
			primeNum.add(i);
		}

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		// 마지막 줄에 0이 입력되므로 0이 입력되면 while문을 벗어나도록 하자.
		while (true) {
			int n = Integer.parseInt(br.readLine());
			if (n == 0)
				break;

			// b-a가 가장 커야한다는 조건에 따라 두 번째 숫자는 커야 하므로 일단 마지막 index값을 할당해두자.
			int maxIdx = primeNum.size() - 1;

			// 그치만 n보다도 크게 되면 쓸모없는 연산이 생기므로 적절하게 조절해준다.
			for (int k = 1; k < primeNum.size(); k++) {
				if (n - 3 <= primeNum.get(k))
					maxIdx = k - 1;
			}

			// 목표 : 범위 내의 가장 작은 소수 + 가장 큰 소수부터 하여 큰 소수 쪽의 값을 줄여가면서 n을 두 홀수 소수의 합으로 나타내보자.
			int startIdx = 1;
			int LastIdx = maxIdx;
			while (true) {
				int first = primeNum.get(startIdx);
				int second = primeNum.get(LastIdx);

				// 해당하는 숫자들을 찾았으면 sb에 저장하고 while문을 벗어나자.
				if (first + second == n) {
					sb.append(n + " = " + first + " + " + second).append("\n");
					break;
				}

				// 아직 못 찾았으면 큰 소수 쪽의 값을 줄여가면서 다시 찾아보자.
				if (startIdx < LastIdx)
					LastIdx--;
				else {
					startIdx++;
					LastIdx = maxIdx;
				}

			} // 목표 while문 끝나는 곳

		} // 이 추측은 백만 이하의 n에 대해서 틀리지 않으므로 "Goldbach's conjecture is wrong."를 출력할 일이 없다.

		System.out.println(sb);
		br.close();

	} // main
} // class
