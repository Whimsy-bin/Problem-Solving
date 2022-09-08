package SWEA_1230_암호문3; // 2022.08.19

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {

//	0 ~ 999999 사이의 수를 나열하여 만든 암호문이 있다.
//	암호문을 급히 수정해야 할 일이 발생했는데, 이 암호문은 특수 제작된 처리기로만 수정이 가능하다.
//	
//	이 처리기는 다음과 같이 3개의 기능을 제공한다.
//	1. I(삽입) x, y, s : 앞에서부터 x의 위치 바로 다음에 y개의 숫자를 삽입한다. s는 덧붙일 숫자들이다.[ ex) I 3 2 123152 487651 ]
//	2. D(삭제) x, y : 앞에서부터 x의 위치 바로 다음부터 y개의 숫자를 삭제한다.[ ex) D 4 4 ]
//	3. A(추가) y, s : 암호문의 맨 뒤에 y개의 숫자를 덧붙인다. s는 덧붙일 숫자들이다. [ ex) A 2 421257 796813 ]
//
//	위의 규칙에 맞게 작성된 명령어를 나열하여 만든 문자열이 주어졌을 때, 암호문을 수정하고, 수정된 결과의 처음 10개 숫자를 출력하는 프로그램을 작성하여라.

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		// 테스트 케이스 수는 10개가 주어지므로 tc=1부터 10까지 for문을 돌도록 하자.
		int T = 10;
		for (int tc = 1; tc <= T; tc++) {
			sb.append("#" + tc);

			int N = Integer.parseInt(br.readLine()); // 원본 암호문의 길이
			String original = br.readLine(); // 원본 암호문
			StringTokenizer st = new StringTokenizer(original, " ");

			// 원본 암호문을 Linkedlist에 저장해주자.
			List<String> password = new LinkedList<>();
			for (int i = 0; i < N; i++) {
				password.add(st.nextToken());
			}

			int M = Integer.parseInt(br.readLine()); // 명령어의 개수
			st = new StringTokenizer(br.readLine(), " "); // 명령어의 내용

			// 목표 : 명령어에 맞게 삽입, 삭제 또는 추가를 실행해주면서 암호문을 수정하기!
			for (int j = 0; j < M; j++) {

				// 다음으로 오는 명령어를 확인한다.
				String command = st.nextToken();

				// 삽입 : 앞에서부터 x의 위치 다음에 y개의 숫자를 삽입한다.
				if (command.equals("I")) {
					int x = Integer.parseInt(st.nextToken());
					int y = Integer.parseInt(st.nextToken());
					for (int k = 0; k < y; k++) {
						password.add(x++, st.nextToken());
					}
				}
				// 삭제 : 앞에서부터 x의 위치 바로 다음부터 y개의 숫자를 삭제한다.
				else if (command.equals("D")) {
					int x = Integer.parseInt(st.nextToken());
					int y = Integer.parseInt(st.nextToken());
					for (int l = 0; l < y; l++) {
						password.remove(x);
					}
				}
				// 추가 : 암호문의 맨 뒤에 y개의 숫자를 덧붙인다.
				else if (command.equals("A")) {
					int y = Integer.parseInt(st.nextToken());
					for (int m = 0; m < y; m++) {
						password.add(st.nextToken());
					}
				}
			}

			// 암호문을 수정하고, 수정된 결과의 처음 10개 숫자만 출력하면 된다.
			for (int n = 0; n < 10; n++) {
				sb.append(" " + password.get(n));
			}

			// 한 회차가 끝난 기념으로 개행!
			sb.append("\n");

		}

		// Stringbuilder에 저장된 문자열들을 한번에 출력해주면 끝!
		System.out.println(sb);
		br.close();

	} // main
} // class
