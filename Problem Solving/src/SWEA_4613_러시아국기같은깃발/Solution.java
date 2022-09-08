package SWEA_4613_러시아국기같은깃발; //2022.08.21

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

//	2016년은 삼성전자가 러시아 현지법인을 설립한지 20주년이 된 해이다. 이를 기념해서 당신은 러시아 국기를 만들기로 했다.
//	먼저 창고에서 오래된 깃발을 꺼내왔다. 이 깃발은 N행 M열로 나뉘어 있고, 각 칸은 흰색, 파란색, 빨간색 중 하나로 칠해져 있다.
//	당신은 몇 개의 칸에 있는 색을 다시 칠해서 이 깃발을 러시아 국기처럼 만들려고 한다. 다음의 조건을 만족해야 한다.
//
//	위에서 몇 줄(한 줄 이상)은 모두 흰색으로 칠해져 있어야 한다.
//	다음 몇 줄(한 줄 이상)은 모두 파란색으로 칠해져 있어야 한다.
//	나머지 줄(한 줄 이상)은 모두 빨간색으로 칠해져 있어야 한다.
//
//	이렇게 러시아 국기 같은 깃발을 만들기 위해서 새로 칠해야 하는 칸의 개수의 최솟값을 구하여라.

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		// 테스트 케이스의 수 T를 받아서 tc = 1 부터 T까지 for문을 돌도록 하자
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {

			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken()); // 배열에 저장할 때 행의 길이
			int M = Integer.parseInt(st.nextToken()); // 배열에 저장할 때 열의 길이

			String[][] board = new String[N][M];
			for (int i = 0; i < N; i++) {
				String str = br.readLine();
				String temp[] = str.split("");
				for (int j = 0; j < M; j++)
					board[i][j] = temp[j];
			}
			
			
			for(int k = 1; k < N; k++) {
				for (int j = 0; j < M; j++) {
					
					
				}
			}
			
			
			
			

			sb.append("#" + tc + " ").append(" ");
		}

		System.out.println(sb);
		br.close();

	} // main
} // class