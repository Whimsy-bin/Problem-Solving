package SWEA_1966_숫자를정렬하자; // 2022.08.19

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution_2 {
	public static void main(String[] args) throws IOException {

//		주어진 N 길이의 숫자열을 오름차순으로 정렬하여 출력하라.

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		// 테스트 케이스의 수 T를 받아서 tc=1부터 T까지 for문을 돌도록 해요.
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc);

			int N = Integer.parseInt(br.readLine()); // 숫자열의 갯수
			StringTokenizer st = new StringTokenizer(br.readLine()); // 숫자열 입력

			// 입력받은 숫자열을 ArrayList에 저장해줄게요.
			List<Integer> original = new ArrayList<>();
			for (int i = 0; i < N; i++) {
				original.add(Integer.parseInt(st.nextToken()));
			}

			// 삽입정렬 방식으로 숫자를 정렬할 거에요.
			// 정렬된 원소들이 담길 LinkedList를 만들어주고 하나는 정렬 방식 없이 옮겨줄게요.
			List<Integer> sortedList = new LinkedList<>();
			sortedList.add(original.get(0));
			original.remove(0);

			// 목표 : 정렬되지 않은 original에서 하나씩 가져와서 sortedList에 정렬하면서 넣어주기
			while (!original.isEmpty()) { // 정렬되는 원소들은 original에서 삭제해줄거라서 original이 empty 상태가 될 때까지 진행하면 되겠죠?
				int target = original.get(0);
				int idx = 0;
				for (int j = sortedList.size() - 1; j >= 0; j--) {
					if (sortedList.get(j) <= target) {
						idx = j + 1;
						break;
					}
				}
				sortedList.add(idx, target);
				original.remove(0);
			} // 목표 while문이 끝나는 곳
			
			// 이제 정렬된 원소들을 순서대로 StringBuilder에 저장할게요.
			for (int k = 0; k < sortedList.size(); k++) {
				sb.append(" ").append(sortedList.get(k));
			}
			// 한 회차를 마치면서 개행
			sb.append("\n");
		}

		System.out.print(sb);
		br.close();
		
	} // main
} // class
