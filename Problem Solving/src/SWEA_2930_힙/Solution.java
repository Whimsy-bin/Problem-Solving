package SWEA_2930_힙; // 2022.08.23

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {

//	힙(Heap)은 최댓값 혹은 최솟값을 찾아내는 연산을 빠르게 하기 위해 고안된 자료구조이다.
//	완전이진트리(Complete binary tree)를 기본으로 한 자료구조로서 다음과 같은 힙 속성(property)을 만족한다.
//	- A가 B의 부모노드(parent node) 이면, A의 키(key)값과 B의 키값 사이에는 항상 일정한 대소관계가 성립한다.
//	키값의 대소관계는 오로지 부모노드와 자식노드 간에만 성립하며, 형제노드 사이에서는 일정한 대소관계가 정해지지 않는다.
//	부모노드의 키값이 자식노드의 키값보다 항상 크거나 같은 힙을 '최대 힙', 부모노드의 키값이 자식노드의 키값보다 항상 작거나 같은 힙을 '최소 힙'이라고 부른다.
//	
//	힙의 루트노드(root node)는 힙을 구성하는 노드의 키값 중 최댓값 혹은 최솟값을 가지게 된다.
//	본 문제에서는 최대 힙(max heap)을 올바르게 구현하였는지 확인할 수 있다.
//	초기에 최대 힙이 비어있을 때에 다음의 2가지 연산을 수행하는 프로그램을 작성하자.
//	연산 1. 자연수 x를 삽입
//	연산 2. 최대 힙의 루트 노드의 키값을 출력하고, 해당 노드를 삭제

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		// 테스크 케이스의 수 T를 받아서 tc = 1부터 T까지 for문을 돌도록 한다.
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc).append(" ");

			int N = Integer.parseInt(br.readLine()); // 연산의 수 N
			List<Integer> Heap = new ArrayList<>();
			Heap.add(-1); // 배열 사용의 편의성을 위해서 0번 idx에 -1을 저장해두자.
			// 목표 :
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine()); // 연산 정보
				int operation = Integer.parseInt(st.nextToken()); // 연산의 종류 : 1 또는 2
				// 연산이 1이라면 새로운 자연수 X를 삽입한다.
				if (operation == 1) {
					int X = Integer.parseInt(st.nextToken());
					Heap.add(X);
					for (int idxL = Heap.size() - 1; idxL / 2 > 0; idxL /= 2)
						if (X > Heap.get(idxL / 2)) {
							Heap.set(idxL, Heap.get(idxL / 2));
							Heap.set(idxL / 2, X);
						}
				}
				// 연산이 2라면 최댓값을 출력하고 해당값을 삭제한다.
				else if (operation == 2) {
					// 배열에 0번 인덱스만 있다면 최댓값이 없는 것이다.
					if (Heap.size() == 1)
						sb.append(Heap.get(0)).append(" ");
					// 배열에 0, 1번 인덱스만 있다면 유효한 값은 1번 인덱스 뿐이다.
					else if (Heap.size() == 2) {
						sb.append(Heap.get(1)).append(" ");
						Heap.remove(1);
					}
					// 그 외에 배열에 0,1, ... , Heap.size()-1 번 인덱스까지 있다면 아래 과정을 수행해주자.
					else {
						sb.append(Heap.get(1)).append(" "); // 1번 인덱스에 늘 최댓값이 저장되어 있다.
						// 1번 인덱스의 값(최댓값)과 가장 마지막 인덱스의 값의 자리를 바꿔주고 최댓값은 삭제한다.
						int idxL = Heap.size() - 1;
						Heap.set(1, Heap.get(idxL));
						Heap.remove(idxL);

						// 이제 1번 자리로 와버린 마지막 인덱스의 값의 올바른 자리를 찾아가주자.
						// 현재 인덱스*2 인덱스가 존재하지 않는다면 자식 노드가 없는 것이니 for문을 벗어난다.
						for (int idx = 1; idx * 2 <= Heap.size() - 1;) {
							int tmp = Heap.get(idx);

							if (idx * 2 == Heap.size() - 1) {
								// 왼쪽 자식 밖에 없는데 그게 더 큰 값일 때
								if (tmp < Heap.get(idx * 2)) {
									Heap.set(idx, Heap.get(idx * 2));
									Heap.set(idx * 2, tmp);
									idx = idx * 2;
								} else
									break;
							} else {
								// 양쪽 자식 다 있고 왼쪽 자식 노드의 값이 더 클 때
								if (tmp < Heap.get(idx * 2) && Heap.get(idx * 2 + 1) < Heap.get(idx * 2)) {
									Heap.set(idx, Heap.get(idx * 2));
									Heap.set(idx * 2, tmp);
									idx = idx * 2;
								}
								// 양쪽 자식 다 있고 오른쪽 자식 노드의 값이 더 클 때
								else if (tmp < Heap.get(idx * 2 + 1) && Heap.get(idx * 2) < Heap.get(idx * 2 + 1)) {
									Heap.set(idx, Heap.get(idx * 2 + 1));
									Heap.set(idx * 2 + 1, tmp);
									idx = idx * 2 + 1;
								} else
									break;
							}
						}
					}
				}

			} // 목표 for문 닫히는 곳

			// 한 회차를 마치면서 줄 바꿈을 해준다.
			sb.append("\n");
		}

		System.out.println(sb);
		br.close();

	} // main
} // class
