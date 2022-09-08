package A_연습장;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	
	// 문제 설명
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		// 테스트 케이스의 수 T를 받아서 tc=1부터 T까지 for문을 돌도록 해요
//		int T = Integer.parseInt(br.readLine());

		// 테스트 케이스 수는 10개가 주어지므로 tc=1부터 10까지 for문을 돌도록 하자.
		int T = 10;
		for (int tc = 1; tc <= T; tc++) {
			sb.append("#" + tc);

			sb.append("\n");
		}

		System.out.println(sb);
		br.close();
		
	} // main
} // class
