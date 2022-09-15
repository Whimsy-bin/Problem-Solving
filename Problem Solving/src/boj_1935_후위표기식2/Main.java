package boj_1935_후위표기식2; // 2022.09.08

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {

//	후위 표기식과 각 피연산자에 대응하는 값들이 주어져 있을 때, 그 식을 계산하는 프로그램을 작성하시오.

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()); // 피연산자의 갯수
		char[] calculation = br.readLine().toCharArray(); // 후위표기식을 char형으로 하나씩 끊어서 저장

		int[] num = new int[N]; // 피연산자들을 저장
		for (int i = 0; i < N; i++)
			num[i] = Integer.parseInt(br.readLine());

		Deque<Double> operation = new ArrayDeque<>(); // 연산을 도와줄 덱 선언
		// 목표 : 후위표기식을 앞에서부터 읽으면서 숫자가 나오면 덱에 넣고, 연산자가 나오면 계산하여 다시 덱에 넣어준다.
		for (int j = 0; j < calculation.length; j++) {
			double result = 0; // 다음에 덱에 저장할 숫자를 저장해둘 result 선언
			// 뺼셈과 나눗셈은 순서에 주의하여 계산해주자.
			switch (calculation[j]) {
			case '+':
				result = operation.pollLast() + operation.pollLast();
				break;
			case '-':
				double b = operation.pollLast();
				double a = operation.pollLast();
				result = a - b;
				break;
			case '*':
				result = operation.pollLast() * operation.pollLast();
				break;
			case '/':
				double d = operation.pollLast();
				double c = operation.pollLast();
				result = c / d;
				break;
			default:
				result = num[calculation[j] - 'A'];
				break;
			}
			operation.add(result);

		} // 목표 for문 닫히는 곳

		// 출력 형식에 맞추어 소숫점 둘째 자리까지 출력하면 끝!
		System.out.println(String.format("%.2f", operation.pop()));
		br.close();

	} // main
} // class
