package boj_17478_재귀함수가뭔가요; // 2022.08.25

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

//	평소에 질문을 잘 받아주기로 유명한 중앙대학교의 JH 교수님은 학생들로부터 재귀함수가 무엇인지에 대하여 많은 질문을 받아왔다.
//	매번 질문을 잘 받아주셨던 JH 교수님이지만 그는 중앙대학교가 자신과 맞는가에 대한 고민을 항상 해왔다.
//	중앙대학교와 자신의 길이 맞지 않다고 생각한 JH 교수님은 결국 중앙대학교를 떠나기로 결정하였다.
//	떠나기 전까지도 제자들을 생각하셨던 JH 교수님은 재귀함수가 무엇인지 물어보는 학생들을 위한 작은 선물로 자동 응답 챗봇을 준비하기로 했다.
//	JH 교수님이 만들 챗봇의 응답을 출력하는 프로그램을 만들어보자.

	static StringBuilder sb = new StringBuilder();
	static int count = 0; // 재귀를 몇 번 했는지 저장할 변수 선언

	// 재귀 호출을 할 메소드 선언
	public static void recursive(int n) {

		// n이 0이면 재귀 탈출!
		if (n == 0) {
			for (int i = 0; i < count; i++)
				sb.append("____");
			sb.append("\"재귀함수가 뭔가요?\"\n");
			for (int i = 0; i < count; i++)
				sb.append("____");
			sb.append("\"재귀함수는 자기 자신을 호출하는 함수라네\"\n");
			return;
		}

		// 0이 아니면 재귀 ㄱㄱㄱㄱ
		for (int i = 0; i < count; i++)
			sb.append("____");
		sb.append("\"재귀함수가 뭔가요?\"\n");
		for (int i = 0; i < count; i++)
			sb.append("____");
		sb.append("\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.\n");
		for (int i = 0; i < count; i++)
			sb.append("____");
		sb.append("마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.\n");
		for (int i = 0; i < count; i++)
			sb.append("____");
		sb.append("그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"\n");

		count++; // 재귀를 한 횟수를 저장할 수 있도록 ++을 해줘요.
		recursive(n - 1);

	} // recursive

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()); // 출력을 원하는 재귀 횟수

		sb.append("어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.\n"); // 질문 시작!
		recursive(N); // 원하는 횟수만큼 재귀 출력을 저장해주고,

		// 마무리해주면 끝!
		for (; count >= 0; count--) {
			for (int i = 0; i < count; i++)
				sb.append("____");
			sb.append("라고 답변하였지.\n");
		}

		System.out.println(sb);
		br.close();

	} // main
} // class
