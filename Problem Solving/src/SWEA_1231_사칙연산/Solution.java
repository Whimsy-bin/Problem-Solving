package SWEA_1231_사칙연산; // 2022.08.23

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

//	사칙연산으로 구성되어 있는 식은 이진 트리로 표현할 수 있다.
//	임의의 정점에 연산자가 있으면 해당 연산자의 왼쪽 서브 트리의 결과와 오른쪽 서브 트리의 결과를 사용해서 해당 연산자를 적용한다.
//	
//	사칙연산 “+, -, *, /”와 양의 정수로만 구성된 임의의 이진트리가 주어질 때, 이를 계산한 결과를 출력하는 프로그램을 작성하라.
//	단, 중간 과정에서의 연산은 실수 연산으로 하되, 최종 결과값이 정수로 떨어지지 않으면 정수부만 출력한다.

	// 각각의 정점 정보가 숫자인지 연산자인지 구분할 메소드 선언
	public static boolean isStringDouble(String s) {

		try {
			Double.parseDouble(s);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}

	} // isStringDouble

	// 사칙연산을 해줄 메소드 선언
	public static int func(int a, int b, String operation) {
		int result = 0;

		switch (operation) {
		case "+":
			result = (a + b);
			break;
		case "-":
			result = (a - b);
			break;
		case "*":
			result = (a * b);
			break;
		case "/":
			result = (a / b);
			break;
		}
		return result;

	} // func

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int T = 10; // 테스트 케이스의 수는 10개로 고정!
		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine()); // 이번 회차에서 정점의 갯수
			String[][] tree = new String[N + 1][]; // 정점의 정보를 담을 tree 가변배열 선언(0번 행은 사용하지 않을 것이다)

			// 정점의 정보에 따라 열의 길이를 설정해주면서 tree의 정보 입력값을 받아주자.
			for (int i = 1; i <= N; i++) {
				st = new StringTokenizer(br.readLine());
				int idx = Integer.parseInt(st.nextToken()); // (i와 같은 값이다)
				String data = st.nextToken(); // 정점에 담길 값

				// 정점에 담길 값이 숫자인지 연산자인지 검사하여 해당 행에서 열의 길이를 설정한다.
				if (isStringDouble(data)) {
					tree[idx] = new String[1];
					tree[idx][0] = data;
				} else {
					tree[idx] = new String[3];
					tree[idx][0] = data;
					tree[idx][1] = st.nextToken();
					tree[idx][2] = st.nextToken();
				}
			}

			// 목표 : tree의 가장 아래쪽에서 올라오면서 연산자가 있는 부분은 자식 노드와 사칙연산하여 값을 재할당해준다.
			for (int j = N; j >= 1; j--) {
				// 값이 연산자인 정점의 행만 열의 길이가 3이다.
				if (tree[j].length == 3) {
					String operation = tree[j][0]; // 해당 연산자
					int a_idx = Integer.parseInt(tree[j][1]); // 왼쪽 자식의 노드 번호(배열 index)
					int a = Integer.parseInt(tree[a_idx][0]); // 왼쪽 자식의 값
					int b_idx = Integer.parseInt(tree[j][2]); // 오른쪽 자식의 노드 번호(배열 index)
					int b = Integer.parseInt(tree[b_idx][0]); // 오른쪽 자식의 값
					tree[j] = new String[1]; // 연산을 마치면 해당 정점에 숫자만 남을 것이므로 열의 길이를 1로 다시 설정해준다.
					tree[j][0] = String.valueOf(func(a, b, operation)); // 위의 사칙연산 메소드의 반환값을 지정해주면 끝
				}
			}

			// 한 회차를 마치면서 tree의 루트 노드(시작 노드)의 값을 sb에 저장해준다.
			sb.append("#" + tc + " ").append(tree[1][0]).append("\n");
		}

		System.out.println(sb);
		br.close();

	} // main
} // class
