package boj_2293_동전1; // 2022.08.24 

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

//	n가지 종류의 동전이 있다. 각각의 동전이 나타내는 가치는 다르다. 이 동전을 적당히 사용해서, 그 가치의 합이 k원이 되도록 하고 싶다.
//	그 경우의 수를 구하시오. 각각의 동전은 몇 개라도 사용할 수 있다.
//	사용한 동전의 구성이 같은데, 순서만 다른 것은 같은 경우이다.

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		System.out.println(K);
		System.out.println(N);
		int ans = 0;
		for (int i = 0; i < N; i++) {
			int coin = Integer.parseInt(br.readLine());
			System.out.println(coin);
			ans += (K / coin);
		}

		System.out.println(ans);
		br.close();

	} // main
}
