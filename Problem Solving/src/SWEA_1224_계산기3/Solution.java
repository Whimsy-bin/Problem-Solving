package SWEA_1224_계산기3; // 2022.09.14

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {

//	문자열로 이루어진 계산식이 주어질 때, 이 계산식을 후위 표기식으로 바꾸어 계산하는 프로그램을 작성하시오.
//
//	예를 들어
//	“3+(4+5)*6+7”
//	라는 문자열로 된 계산식을 후위 표기식으로 바꾸면 다음과 같다.
//	"345+6*+7+"
//	변환된 식을 계산하면 64를 얻을 수 있다.
//
//	문자열 계산식을 구성하는 연산자는 +, * 두 종류이며 문자열 중간에 괄호가 들어갈 수 있다. 
//	이 때 괄호의 유효성 여부는 항상 옳은 경우만 주어진다.
//	피연산자인 숫자는 0 ~ 9의 정수만 주어진다.

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder ans = new StringBuilder();

		// 테스트 케이스 수는 10개가 주어지므로 tc = 1부터 10까지 for문을 돌도록 하자.
		int T = 10;
		for (int tc = 1; tc <= T; tc++) {
			int length = Integer.parseInt(br.readLine()); // 문자열 계산식의 길이
			char[] formula = br.readLine().toCharArray(); // 해당 문자열 계산식

			StringBuilder sb = new StringBuilder(); // 전환된 표기식을 저장할 StringBuilder 선언
			Deque<Character> convert = new ArrayDeque<>(); // 표기식 전환을 도와줄 덱 선언

			// 목표 : 주어진 중위표기식을 후위표기식으로 바꾸자
			for (int i = 0; i < length; i++) {
				char target = formula[i];
				switch (target) {
				// 여는 괄호가 등장했을 때
				case '(':
					convert.addLast(target);
					break;
				// 곱하기가 등장했을 때
				case '*':
					while (true) {
						if (convert.isEmpty() || convert.peekLast() == '+' || convert.peekLast() == '(') {
							convert.addLast(target);
							break;
						} else
							sb.append(convert.pollLast());
					}
					break;
				// 더하기가 등장했을 때
				case '+':
					while (true) {
						if (convert.isEmpty() || convert.peekLast() == '(') {
							convert.addLast(target);
							break;
						} else
							sb.append(convert.pollLast());

					}
					break;
				// 닫는 괄호가 등장했을 때
				case ')':
					while (convert.peekLast() != '(')
						sb.append(convert.pollLast());
					convert.pollLast();
					break;
				// 피연산자가 등장했을 때
				default:
					sb.append(target);
					break;
				}
			} // 목표 for문 닫히는 곳

			while (!convert.isEmpty())
				sb.append(convert.pollLast());

			// 주어진 계산식이 후위표기식으로 바뀌었다.
			String postfix = sb.toString();
//			System.out.println(postfix);

			char[] calculation = postfix.toCharArray(); // 후위표기식을 char형으로 하나씩 끊어서 저장
			Deque<Integer> operation = new ArrayDeque<>(); // 연산을 도와줄 덱 선언

			// 목표 : 후위표기식을 앞에서부터 읽으면서 숫자가 나오면 덱에 넣고, 연산자가 나오면 계산하여 다시 덱에 넣어준다.
			for (int j = 0; j < calculation.length; j++) {
				int result = 0; // 다음에 덱에 넣어줄 숫자를 저장해둘 result 선언
				switch (calculation[j]) {
				case '+':
					result = operation.pollLast() + operation.pollLast();
					break;
				case '*':
					result = operation.pollLast() * operation.pollLast();
					break;
				default:
					result = calculation[j] - '0';
					break;
				}
				operation.add(result);
			} // 목표 for문 닫히는 곳

			// operation 덱에 남은 숫자는 계산식의 결과이다.
			ans.append("#" + tc + " ").append(operation.pop()).append("\n");
		}

		System.out.println(ans);
		br.close();

	} // main
} // class
