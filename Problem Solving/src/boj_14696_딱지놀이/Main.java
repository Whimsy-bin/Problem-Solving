package boj_14696_딱지놀이; // 2022.08.21

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

//	두 어린이 A, B가 딱지놀이를 한다. 딱지놀이 규칙은 다음과 같다. 두 어린이는 처음에 여러 장의 딱지를 가지고 있고, 매 라운드마다 각자 자신이 가진 딱지 중 하나를 낸다. 딱지에는 별(★), 동그라미(●), 네모(■), 세모(▲), 네 가지 모양 중 하나 이상의 모양이 표시되어 있다. 두 어린이가 낸 딱지 중 어느 쪽이 더 강력한 것인지는 다음 규칙을 따른다.
//
//	만약 두 딱지의 별의 개수가 다르다면, 별이 많은 쪽의 딱지가 이긴다.
//	별의 개수가 같고 동그라미의 개수가 다르다면, 동그라미가 많은 쪽의 딱지가 이긴다.
//	별, 동그라미의 개수가 각각 같고 네모의 개수가 다르다면, 네모가 많은 쪽의 딱지가 이긴다.
//	별, 동그라미, 네모의 개수가 각각 같고 세모의 개수가 다르다면, 세모가 많은 쪽의 딱지가 이긴다.
//	별, 동그라미, 네모, 세모의 개수가 각각 모두 같다면 무승부이다.
//	
//	라운드의 수 N과 두 어린이가 순서대로 내는 딱지의 정보가 주어졌을 때, 각 라운드별로 딱지놀이의 결과를 구하는 프로그램을 작성하시오.

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= N; tc++) {

			StringTokenizer A_info = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(A_info.nextToken());
			int[] A_card = new int[5];
			for (int i = 0; i < a; i++) {
				A_card[Integer.parseInt(A_info.nextToken())]++;
			}

			StringTokenizer B_info = new StringTokenizer(br.readLine());
			int b = Integer.parseInt(B_info.nextToken());
			int[] B_card = new int[5];
			for (int j = 0; j < b; j++) {
				B_card[Integer.parseInt(B_info.nextToken())]++;
			}

			String winner = "D";
			for (int k = 4; k >= 1; k--) {
				if(A_card[k]<B_card[k]) {
					winner = "B";
					break;
				} else if(A_card[k]>B_card[k]) {
					winner = "A";
					break;
			}
		}
			
			sb.append(winner).append("\n");
			
		}
		
		System.out.println(sb);
		br.close();
		
	}
}