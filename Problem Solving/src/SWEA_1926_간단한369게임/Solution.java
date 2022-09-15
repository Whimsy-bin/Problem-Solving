package SWEA_1926_간단한369게임; // 2022.08.29

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Solution {

//	3 6 9 게임을 프로그램으로 제작중이다. 게임 규칙은 다음과 같다.
//
//	1. 숫자 1부터 순서대로 차례대로 말하되, “3” “6” “9” 가 들어가 있는 수는 말하지 않는다.
//	2. "3" "6" "9"가 들어가 있는 수를 말하지 않는대신, 박수를 친다. 이 때, 박수는 해당 숫자가 들어간 개수만큼 쳐야 한다. 
//	
//	예를 들어 숫자 35의 경우 박수 한 번, 숫자 36의 경우 박수를 두번 쳐야 한다.
//	박수를 치는 부분은 숫자 대신, 박수 횟수에 맞게 “-“ 를 출력한다.

	static StringBuilder sb = new StringBuilder();
	static HashSet<Integer> clap = new HashSet<>();

	// 이번 숫자에 무엇을 해야할지 점검할 메소드 선언!
	static void clap_or_not(int num) {

		int tmp = num; // num가 바뀌면 곤란하니까 잠시 tmp에 저장해서 사용할게요.

		// 목표 : 이번 숫자에는 어떤 행동을 해야할지 ans에 저장해주자!
		String ans = "";
		while (tmp != 0) {
			int rest = tmp % 10;
			tmp /= 10;

			// 숫자에 3 또는 6 또는 9가 포함되어 있다면 박수를 의미하는 "-"를 추가해줘요.
			if (clap.contains(rest))
				ans += "-";

		} // 목표 while문 끝나는 곳

		// 위 while문을 돌면서 박수("-")가 한 번도 추가되지 않았다면 3, 6, 9 모두를 가지고 있지 않은 숫자이므로 숫자 그대로 읽으면
		// 되겠죠?
		if (ans.equals(""))
			ans += num;

		// 출력 형식에 맞추어 공백을 추가해주고 sb에 저장해줄게요.
		ans += " ";
		sb.append(ans);

	} // clap_or_not

	public static void main(String[] args) throws IOException {

		clap.add(3);
		clap.add(6);
		clap.add(9);

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		for (int i = 1; i <= N; i++)
			clap_or_not(i);

		System.out.println(sb);
		br.close();

	} // main
} // class