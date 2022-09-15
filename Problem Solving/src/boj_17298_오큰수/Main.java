package boj_17298_오큰수; // 2022.09.07
	
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

//	크기가 N인 수열 A = A1, A2, ..., AN이 있다. 수열의 각 원소 Ai에 대해서 오큰수 NGE(i)를 구하려고 한다.
//	Ai의 오큰수는 오른쪽에 있으면서 Ai보다 큰 수 중에서 가장 왼쪽에 있는 수를 의미한다.
//	그러한 수가 없는 경우에 오큰수는 -1이다.
//
//	예를 들어, A = [3, 5, 2, 7]인 경우 NGE(1) = 5, NGE(2) = 7, NGE(3) = 7, NGE(4) = -1이다.
//	A = [9, 5, 4, 8]인 경우에는 NGE(1) = -1, NGE(2) = 8, NGE(3) = 8, NGE(4) = -1이다.

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine()); // 수열의 크기
		StringTokenizer st = new StringTokenizer(br.readLine()); // 수열에 들어갈 숫자들
		int[] ans = new int[N + 1]; // 정답을 저장할 배열, 0번 인덱스는 쓰지 않겠다.

		// 목표 : 이번 숫자가 stack.top보다 크면 그 숫자를 ans[idx]에 저장하고 stack.pop을 한다.
		Stack<Integer> num = new Stack<>(); // 숫자들을 저장할 스택
		Stack<Integer> idx = new Stack<>(); // 숫자의 index를 저장할 스택
		for (int i = 1; i < N + 1; i++) {

			int target = Integer.parseInt(st.nextToken()); // 이번 숫자
			for (int j = num.size(); 0 <= j; j--) {
				// 스택이 비어있거나 이번 숫자가 stack.top보다 작으면 스택에 추가해준다.
				if (num.isEmpty() || target <= num.peek()) {
					num.add(target);
					idx.add(i);
					break;
				}
				// 이번 숫자가 stack.top보다 크면 그 숫자를 저장하고 stack.pop을 한다.
				else {
					ans[idx.pop()] = target;
					num.pop();
				}
			}
		} // 목표 for문 끝나는 곳

		// 위의 과정을 거쳤음에도 남은 숫자들은 오큰수가 없는 숫자들이다.
		while (!idx.isEmpty())
			ans[idx.pop()] = -1;

		for (int k = 1; k <= N; k++)
			sb.append(ans[k]).append(" ");

		System.out.println(sb);
		br.close();

	} // main
} // class
