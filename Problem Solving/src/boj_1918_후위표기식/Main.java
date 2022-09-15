package boj_1918_후위표기식; // 2022.09.14

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {

//	중위 표기식이 주어졌을 때 후위 표기식으로 고치는 프로그램을 작성하시오

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		char[] formula = br.readLine().toCharArray();

		Deque<Character> convert = new ArrayDeque<>(); // 연산을 도와줄 덱 선언

		for (int i = 0; i < formula.length; i++) {
			char target = formula[i];
			switch (target) {
			case '(':
				convert.addLast(target);
				break;
			case '*':
			case '/':
				while (true) {
					if (convert.isEmpty() || convert.peekLast() == '+' || convert.peekLast() == '-' || convert.peekLast() == '(') {
						convert.addLast(target);
						break;
					} else
						sb.append(convert.pollLast());
				}
				break;
			case '+':
			case '-':
				while (true) {
					if (convert.isEmpty() || convert.peekLast() == '(') {
						convert.addLast(target);
						break;
					} else
						sb.append(convert.pollLast());
				}
				break;
			case ')':
				while (convert.peekLast() != '(')
					sb.append(convert.pollLast());
				convert.pollLast();
				break;
			default:
				sb.append(target);
				break;
			}
		} // 목표 while문 닫히는 곳

		while (!convert.isEmpty())
			sb.append(convert.pollLast());
		
		System.out.println(sb);
		br.close();

	} // main
} // class
