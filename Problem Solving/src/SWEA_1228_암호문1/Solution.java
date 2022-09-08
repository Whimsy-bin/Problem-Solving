package SWEA_1228_암호문1; // 2022.08.19

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Node {
	public int code;
	public Node link;

	public Node(int password) {
		this.code = password;
		this.link = null;
	}
} // class

class Password {
	private Node front;
	private Node rear;

	public Node get(int idx) {
		Node curr = front;
		for (int i = 0; i < idx; i++)
			curr = curr.link;
		return curr;
	}
	
	// 맨 뒤에 주어진 데이터를 추가하는 메소드 Add
	public void Add(int N) {
		Node node = new Node(N);
		if (!(front == null))
			rear.link = rear = node;
		else
			front = rear = node;
	}

	// 중간 x의 위치에 삽입하는 메소드 insertion
	public void Insertion(int x, int s) {
		Node node = new Node(s);
		if (x != 0) {
			Node prev = get(x - 1);
			node.link = prev.link;
			prev.link = node;
		} else {
			node.link = front;
			front = node;
		}
	}

	// 앞에서부터 n개만 출력하는 메소드 outputs
	public void outputs(int n) {
		Node curr = front;
		for (int i = 0; i < n; i++) {
			System.out.print(curr.code + " ");
			curr = curr.link;
		}
		System.out.println();
	}
} // class

public class Solution {

//	0 ~ 999999 사이의 수를 나열하여 만든 암호문이 있다.
//	암호문을 급히 수정해야 할 일이 발생했는데, 이 암호문은 특수 제작된 처리기로만 수정이 가능하다.
//
//	이 처리기는 다음과 같이 1개의 기능을 제공한다.
//	1. I(삽입) x, y, s : 앞에서부터 x의 위치 바로 다음에 y개의 숫자를 삽입한다. s는 덧붙일 숫자들이다.[ ex) I 3 2 123152 487651 ]
//
//	위의 규칙에 맞게 작성된 명령어를 나열하여 만든 문자열이 주어졌을 때, 암호문을 수정하고, 수정된 결과의 처음 10개 숫자를 출력하는 프로그램을 작성하여라.

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 테스트 케이스의 수가 10개로 주어지므로 tc=1부터 10까지 for문을 돌도록 해요
		int T = 10;
		for (int tc = 1; tc <= T; tc++) {
			int length = Integer.parseInt(br.readLine()); // 초기 암호문의 길이
			StringTokenizer st = new StringTokenizer(br.readLine(), " "); // 초기 암호문의 정보

			// 초기 암호문의 정보를 추가해줍니다.
			Password secret = new Password();
			for (int i = 0; i < length; i++) {
				secret.Add(Integer.parseInt(st.nextToken()));
			}

			int N = Integer.parseInt(br.readLine()); // 명령어의 개수
			st = new StringTokenizer(br.readLine(), " "); // 명령어의 내용
			// 목표 : 명령어의 개수만큼 for문을 돌면서 명령어를 실행해줍니다.
			for (int j = 0; j < N; j++) {
				if (st.nextToken().equals("I")) {
					int x = Integer.parseInt(st.nextToken());
					int y = Integer.parseInt(st.nextToken());
					for (int k = 0; k < y; k++) {
						secret.Insertion(x, Integer.parseInt(st.nextToken()));
						x++; // 암호문을 한 번 수정할 때마다 암호문의 길이가 하나씩 늘어나니까 암호문을 넣을 곳을 지정해주던 x도 하나씩 늘려줍니다.
					}
				}
			}
			
			// 출력해주면서 한 회차를 마칩니다.
			System.out.printf("#" + tc + " ");
			secret.outputs(10);
		}
		
		br.close();
		
	} // main
} // class
