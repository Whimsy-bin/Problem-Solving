package boj_8320_직사각형을만드는방법; // 2022.08.21

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

//	상근이는 변의 길이가 1인 정사각형 n개를 가지고 있다. 이 정사각형을 이용해서 만들 수 있는 직사각형의 개수는 총 몇 개일까?
//
//	두 직사각형 A와 B가 있을 때, A를 이동, 회전시켜서 B를 만들 수 없으면, 두 직사각형은 다르다고 한다.
//	직사각형을 만들 때, 정사각형을 변형시키거나, 한 정사각형 위에 다른 정사각형을 놓을 수 없다. 또, 직사각형은 정사각형으로 꽉 차있어야 한다.

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		// 하나씩 한 방향으로 붙인 직사각형은 항상 만들 수 있으므로, 반드시 N개 이상이다.
		int ans = N;

		for (int i = 2; i <= 100; i++) {
			if (N < Math.pow(i, 2))
				break;
			// N의 제곱보다 크면 이후로는 N번째마다 하나씩 더 추가해줘야 한다.
			else
				ans += (N / i) - i + 1;
		}

		System.out.println(ans);

	} // main
} // class