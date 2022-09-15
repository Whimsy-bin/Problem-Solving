package boj_17299_오등큰수; // 2022.09.08

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

//	크기가 N인 수열 A = A1, A2, ..., AN이 있다.
//	수열의 각 원소 Ai에 대해서 오등큰수 NGF(i)를 구하려고 한다.
//
//	Ai가 수열 A에서 등장한 횟수를 F(Ai)라고 했을 때, Ai의 오등큰수는 오른쪽에 있으면서 수열 A에서 등장한 횟수가 F(Ai)보다 큰 수 중에서 가장 왼쪽에 있는 수를 의미한다.
//	그러한 수가 없는 경우에 오등큰수는 -1이다.
//
//	예를 들어, A = [1, 1, 2, 3, 4, 2, 1]인 경우 F(1) = 3, F(2) = 2, F(3) = 1, F(4) = 1이다.
//	A1의 오른쪽에 있으면서 등장한 횟수가 3보다 큰 수는 없기 때문에, NGF(1) = -1이다.
//	A3의 경우에는 A7이 오른쪽에 있으면서 F(A3=2) < F(A7=1) 이기 때문에, NGF(3) = 1이다. NGF(4) = 2, NGF(5) = 2, NGF(6) = 1 이다.

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine()); // 수열의 크기
		StringTokenizer st = new StringTokenizer(br.readLine()); // 수열에 들어갈 숫자들

		int[] arr = new int[N + 1]; // 수열에 들어가는 숫자들을 저장할 배열, 0번 인덱스는 사용 X
		int[] F = new int[1000000 + 1]; // 해당 숫자가 수열 A에서 등장한 횟수를 저장할 배열, 0번 인덱스는 사용 X

		for (int i = 1; i <= N; i++) {
			int now = Integer.parseInt(st.nextToken());
			arr[i] = now;
			F[now]++;
		}

		int[] ans = new int[N + 1]; // 정답을 저장할 배열, 0번 인덱스는 사용 X
		Deque<Integer> num = new ArrayDeque<>(); // 숫자의 등장횟수들을 저장할 덱
		Deque<Integer> idx = new ArrayDeque<>(); // 숫자의 index를 저장할 덱

		// 목표 : 오등큰수가 있으면 ans 배열에 넣어준다.
		for (int i = 1; i <= N; i++) {

			int target = arr[i]; // 이번 숫자
			for (int j = num.size(); 0 <= j; j--) {
				// 덱이 비어있거나 이번 숫자의 등장횟수가 top보다 작으면 덱에 추가해준다.
				if (num.isEmpty() || F[target] <= num.peekLast()) {
					num.add(F[target]);
					idx.add(i);
					break;
				}
				// 이번 숫자의 등장횟수가 top보다 크면 그 숫자를 저장하고 stack.pop을 한다.
				else {
					ans[idx.pollLast()] = target;
					num.pollLast();
				}
			}
		} // 목표 for문 끝나는 곳

		// 위의 과정을 거쳤음에도 남은 숫자들은 오등큰수가 없는 숫자들이다.
		while (!idx.isEmpty())
			ans[idx.pop()] = -1;

		for (int k = 1; k <= N; k++)
			sb.append(ans[k]).append(" ");

		System.out.println(sb);
		br.close();

	} // main
} // class
