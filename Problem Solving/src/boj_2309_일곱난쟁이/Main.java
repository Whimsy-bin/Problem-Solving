package boj_2309_일곱난쟁이; // 2022.08.20

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

//	왕비를 피해 일곱 난쟁이들과 함께 평화롭게 생활하고 있던 백설공주에게 위기가 찾아왔다. 일과를 마치고 돌아온 난쟁이가 일곱 명이 아닌 아홉 명이었던 것이다.
//	아홉 명의 난쟁이는 모두 자신이 "백설 공주와 일곱 난쟁이"의 주인공이라고 주장했다.
//	뛰어난 수학적 직관력을 가지고 있던 백설공주는, 다행스럽게도 일곱 난쟁이의 키의 합이 100이 됨을 기억해 냈다.
//
//	아홉 난쟁이의 키가 주어졌을 때, 백설공주를 도와 일곱 난쟁이를 찾는 프로그램을 작성하시오.

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		// 아홉 난쟁이들의 정보를 받아 ArrayList에 저장하고 일단 아홉 난쟁이의 키를 모두 더해보자.
		List<Integer> Dwarf = new ArrayList<>();
		int sum = 0;
		for (int i = 0; i < 9; i++) {
			int member = Integer.parseInt(br.readLine());
			sum += member;
			Dwarf.add(member);
		}
		Collections.sort(Dwarf); // 오름차순 정렬을 해준다.

		
		// 목표 : 두 난쟁이의 키를 빼보면서 키의 합이 100이 되면 해당되는 두 난쟁이를 제거해주고 출력단계로 넘어가자.
		target: for (int j = 0; j < 8; j++) {
			int first = Dwarf.get(j);
			for (int k = 0; j + k < 8; k++) {
				int second = Dwarf.get(j + k + 1);
				if (sum - first - second == 100) {
					Dwarf.remove(j + k + 1);
					Dwarf.remove(j);
					break target;
				}
			}
		} // 목표 for문 끝나는 곳

		// 아까 오름차순 정렬을 해주었으니 그대로 출력만 하면 되겠다.
		for (int l = 0; l < 7; l++) {
			sb.append(Dwarf.get(l)).append("\n");
		}
		System.out.println(sb);

	} // main
} // clas
