package boj_11047_동전0; // 2022.08.13

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {

//		준규가 가지고 있는 동전은 총 N종류이고, 각각의 동전을 매우 많이 가지고 있다.
//		동전을 적절히 사용해서 그 가치의 합을 K로 만들려고 한다. 이때 필요한 동전 개수의 최솟값을 구하는 프로그램을 작성하시오.

		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt(); // 동전의 종류 N
		int K = sc.nextInt(); // 가치의 합 K

		List<Integer> arr = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			arr.add(sc.nextInt());
		}
		
		int ans = 0;
		int idx = arr.size() - 1; // 젤 마지막에 가장 가치가 큰 동전의 가격이 적혀있으므로 배열의 뒤쪽부터 탐색한다.
		do {
			int coin = arr.get(idx); // 이번 동전의 가격을 기억해두고
			if (K >= coin) { // 해당 동전 가격보다 맞추어야 할 가치가 더 크다면 K에서는 빼주고 ans는 1을 더해준다.
				K -= coin;
				ans++;
			} else
				idx--; // 그렇지 않으면 한 단계 작은 가치의 동전으로 찾아보도록 설정해주고
		} while (K > 0); // 가치의 합 K만큼 동전을 맞추었으면 while문을 벗어나도록 한다.
		
		System.out.println(ans);
		sc.close();
		
	} // main
} // class