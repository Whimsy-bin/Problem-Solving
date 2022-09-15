package SWEA_7272_안경이없어; // 2022.08.28

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Solution {

//	어느 날 경근이는 알파벳 대문자로 이루어진 두 문자열을 비교해야 했는데, 이 날은 공교롭게도 안경이 없었다.
//	경근이는 매우 눈이 나빠서 안경을 벗으면 문자열을 문자 단위로 구별할 수는 있지만, 두 문자가 정확히 같은 지는 알지 못한다.
//	특히 알파벳 대문자 같은 경우 문자에 나 있는 구멍의 개수가 같으면 같은 문자이고, 다르면 다른 문자라고 생각한다.
//
//	예를 들어 구멍이 하나도 없는 CEFGHIJKLMNSTUVWXYZ들을 같은 문자로 생각하고,
//	구멍이 한 개 나 있는 ADOPQR들을 같은 문자로 생각하며,
//	구멍이 두 개 나 있는 유일한 문자 B는 유일하게 정확히 알 수 있다.
//
//	알파벳 대문자로 이루어진 두 문자열이 주어졌을 때, 경근이는 두 문자열이 같다고 판별하는지 다르다고 판별할 것인가?

	static HashSet<String> one_hole = new HashSet<>();

	// 문자열이 담긴 배열을 받아서 알파벳의 구멍 갯수로 바꿔줄 메소드
	static void func(String[] arr) {

		for (int i = 0; i < arr.length; i++) {
			String target = arr[i];
			if (target.equals("B"))
				arr[i] = "2";
			else if (one_hole.contains(target))
				arr[i] = "1";
			else
				arr[i] = "0";
		}
		
	} // func

	public static void main(String[] args) throws IOException {

		// 구멍이 한 개인 알파벳들을 HashSet에 추가해준다.
		one_hole.add("A");
		one_hole.add("D");
		one_hole.add("O");
		one_hole.add("P");
		one_hole.add("Q");
		one_hole.add("R");

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		// 테스트 케이스의 수 T를 받아서 tc=1부터 T까지 for문을 돌도록 해요.
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			String first[] = st.nextToken().split("");
			String second[] = st.nextToken().split("");
			
			// 배열의 값들을 알파벳의 구멍의 갯수로 바꿔주어요.
			func(first);
			func(second);
			
			// 변경 후 두 배열의 값이 같은지 다른지 비교하여 ans에 담고
			String ans = Arrays.equals(first, second) ? "SAME" : "DIFF";
			
			// 출력 형식에 맞추어 sb에 저장하면서 한 회차 끝!
			sb.append("#" + tc + " ").append(ans).append("\n");
		}
		
		System.out.println(sb);
		br.close();

	} // main
} // class
