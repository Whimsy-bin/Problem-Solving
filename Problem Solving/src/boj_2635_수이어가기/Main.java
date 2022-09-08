package boj_2635_수이어가기; // 2022.08.20~21

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

//	다음과 같은 규칙에 따라 수들을 만들려고 한다.
//
//	첫 번째 수로 양의 정수가 주어진다. 두 번째 수는 양의 정수 중에서 하나를 선택한다.
//	세 번째부터 이후에 나오는 모든 수는 앞의 앞의 수에서 앞의 수를 빼서 만든다.
//	예를 들어, 세 번째 수는 첫 번째 수에서 두 번째 수를 뺀 것이고, 네 번째 수는 두 번째 수에서 세 번째 수를 뺀 것이다.
//	음의 정수가 만들어지면, 이 음의 정수를 버리고 더 이상 수를 만들지 않는다.
//	첫 번째 수로 100이 주어질 때, 두 번째 수로 60을 선택하여 위의 규칙으로 수들을 만들면 7개의 수들 100, 60, 40, 20, 20 , 0, 20이 만들어진다.
//	그리고 두 번째 수로 62를 선택하여 위의 규칙으로 수들을 만들면 8개의 수들 100, 62, 38, 24, 14, 10, 4, 6이 만들어진다.
//	위의 예에서 알 수 있듯이, 첫 번째 수가 같더라도 두 번째 수에 따라서 만들어지는 수들의 개수가 다를 수 있다.
//
//	입력으로 첫 번째 수가 주어질 때, 이 수에서 시작하여 위의 규칙으로 만들어지는 최대 개수의 수들을 구하는 프로그램을 작성하시오.
//	최대 개수의 수들이 여러 개일 때, 그중 하나의 수들만 출력하면 된다.

	public static List<Integer> func(List<Integer> list, int M, int Switch) {
		if (Switch == 0) {
			for (; list.size() != 1 && list.get(0) <= M;) {
				list.remove(0);
			}
		} else
			for (;  list.size() != 1 &&list.get(list.size() - 1) >= M;) {
				list.remove(list.size() - 1);
			}

		return list;
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		double N = Integer.parseInt(br.readLine());
		int M = 0;
		List<Integer> candidate = new ArrayList<>();
		for (int i = 0; i <= N; i++) {
			candidate.add(i);
		}
		int n = 1;
		int m = 1;
		int Switch = 0;
		while (candidate.size() != 1) {
			int tmp = m;
			m += n;
			n = tmp;
			M = (Switch == 0) ? (int) Math.floor(n * N / m) : (int) Math.ceil(n * N / m);

			func(candidate, M, Switch);
			Switch = 1 - Switch;
		}

		M = candidate.get(0);
		List<Integer> ans = new ArrayList<>();
		ans.add((int) N);
		ans.add(M);
		for (int j = 1; ans.get(ans.size() - 1) >= 0; j++) {
			ans.add(ans.get(j - 1) - ans.get(j));
		}

		sb.append(ans.size() - 1).append("\n");
		for (int k = 0; k < ans.size() - 1; k++) {
			sb.append(ans.get(k)).append(" ");
		}

		System.out.println(sb);

	} // main
} // class
