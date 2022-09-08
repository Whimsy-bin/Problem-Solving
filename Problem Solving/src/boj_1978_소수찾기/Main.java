package boj_1978_소수찾기; // 2022.08.08~09

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {

		// 주어진 수 N개 중에서 소수가 몇 개인지 찾아서 출력하는 프로그램을 작성하시오.

		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt(); // N개의 숫자를 일단 받아보자
		int prime = 0; // 여기에 소수의 개수를 저장할 것이다.
		List<Integer> arr = new ArrayList<>();
		
		for (int i = 0; i < N; i++) {
			int num = sc.nextInt();
			// 입력받은 숫자가 1이면 패스
			if (num == 1)
				continue;
			// 입력받은 숫자가 2면 소수의 개수를 저장하는 prime에 1을 늘려주고 패스
			else if (num == 2)
				prime++;
			// 그 외에는 아래에서 확인하도록 배열에 추가해주자.
			else
				arr.add(num);
		}

		// 생각해보니까 정렬은 할 필요가 없었던 것 같고
//		Collections.sort(Num);

		for (int j = 0; j < arr.size(); j++) {
			// 2부터 해당 index의 값보다 작은 수까지 나누어가면서 소수인지 아닌지 확인할 것이다.
			boolean can = true;
			int k = 2;
			do {
				// 나누어 떨어진다면~ 소수가 아니므로 while문을 벗어나도록 can을 false로 바꾼다.
				if (arr.get(j) % k == 0)
					can = false;

				// while문을 돌 때마다 k는 더해주어야 다음 자연수도 나누어보겠지
				k++;
			} while (can && k < arr.get(j));

			// 위의 while문을 돌면서도 can을 true로 유지했다면 그 숫자는 소수이므로 prime에 1을 더해준다.
			if (can == true)
				prime++;
		}

		System.out.println(prime);
		sc.close();
		
	} // main
} // class