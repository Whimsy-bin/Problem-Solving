package SWEA_1218_괄호짝짓기; // 2022.08.16

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Solution {

//	4 종류의 괄호문자들 '()', '[]', '{}', '<>' 로 이루어진 문자열이 주어진다.
//	이 문자열에 사용된 괄호들의 짝이 모두 맞는지 판별하는 프로그램을 작성한다.

	public static int func(int n, String s) {
		// 유효성 여부를 판단하여 저장할 ans 변수를 일단 유효함을 의미하는 1로 저장하고 아래 과정에서 유효하지 않으면 0으로 바꿔주는 방식을
		// 채용해보자.
		int ans = 1;

		// 후입선출(LastIn FirstOut) 방식의 Stack 선언
		Stack<Character> stack = new Stack<>();

		// 목표 : 입력받은 문자열을 char형 배열에 저장하고 하나씩 확인해보자.
		for (int i = 0 ; i < n ; i ++) {
			char c = s.charAt(i);
			
			// 여는 괄호의 입력을 받으면, 스택에 해당 괄호를 추가해준다.
			if (c == '{' || c == '[' || c == '(' || c == '<')
				stack.push(c);

			// 그렇지 않으면~ 닫는 괄호의 입력을 받은 것이다.
			else {
				// 스택이 비어있으면 여는 괄호가 없는 것이므로 ans = 0으로 바꿔주고 for문을 탈출한다.
				if (stack.isEmpty()) {
					ans = 0;
					break;
				}
				// 비어있지 않다면 여는 괄호가 있는 것이므로, 스택에서 해당 괄호를 빼준다
				else if (stack.peek() == '{' && c == '}')
					stack.pop();
				else if (stack.peek() == '[' && c == ']')
					stack.pop();
				else if (stack.peek() == '(' && c == ')')
					stack.pop();
				else if (stack.peek() == '<' && c == '>')
					stack.pop();
				// 위에 해당하지 않는다면 엉뚱한 여는 괄호가 있는 것이므로, ans = 0으로 바꿔주고 for문을 탈출한다.
				else {
					ans = 0;
					break;
				}
			}
		} // 목표 for문이 닫히는 곳

		// 위의 과정이 끝났을 때 스택에 무언가 남아있으면 짝을 이루지 못한 여는 괄호가 남은 것이므로 ans = 0으로 바꿔준다.
		if (stack.isEmpty() == false)
			ans = 0;

		// ans를 반환한다.
		return ans;

	} // func

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 10개의 테스트 케이스가 주어지므로 tc가 1부터 T까지만 for문을 돌도록 하자.
		int T = 10;
		for (int tc = 1; tc <= T; tc++) {
			int length = Integer.parseInt(br.readLine()); // 이 풀이 방식에서는 length는 필요가 없었다.
			// 문자열의 정보를 받아서 위의 함수에 적용시켜 받은 반환값을 ans에 저장한다.
			String str = br.readLine();
			int ans = func(length, str);

			// 계산한 값을 출력하면서 한 회차를 마친다.
			System.out.println("#" + tc + " " + ans);
		}

		br.close();

	} // main
} // class
