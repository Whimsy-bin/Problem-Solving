package SWEA_4047_영준이의카드카운팅; // 2022.08.18

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

//	최근 영준이는 카드 게임에 꽂혀 있다.
//	영준이가 하는 카드 게임에는 한 덱의 카드가 필요한데 여기서 얘기하는 “한 덱”이란 스페이드, 다이아몬드, 하트, 클로버 무늬 별로 각각 A, 2~10, J, Q, K의 라벨
//	즉 4개의 무늬 별로 각각 13장씩 총 52장의 카드가 있는 모음을 의미한다.
//	편의상 A는 1, J, Q, K는 11, 12, 13으로 하여 1~13의 숫자가 카드에 적혀있다고 하자.
//	영준이는 몇 장의 카드를 이미 가지고 있는데 게임을 하기 위해서 몇 장의 카드가 더 필요한지 알고 싶어 한다.
//	그리고 이미 겹치는 카드를 가지고 있다면 오류를 출력하고자 한다.
//
//	지금 가지고 있는 카드의 정보가 주어지면 이 작업을 수행하는 프로그램을 작성하라.

	public static String func(String str) {

		int S = 13;
		int D = 13;
		int H = 13;
		int C = 13;

		String[] card = str.split("(?<=\\G...)");
		for (int i = 0; i < card.length; i++) {
			for (int j = card.length - 1; j > i; j--) {
				if (card[i].equals(card[j]))
					return "ERROR";
			}

			if (card[i].contains("S"))
				S--;
			else if (card[i].contains("D"))
				D--;
			else if (card[i].contains("H"))
				H--;
			else
				C--;
		}

		return (String.valueOf(S) + " " + String.valueOf(D) + " " + String.valueOf(H) + " " + String.valueOf(C));
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			String cardinfo = br.readLine();
			String ans = func(cardinfo);
			System.out.println("#" + tc + " " + ans);
		}

		br.close();

	} // main
} // class
