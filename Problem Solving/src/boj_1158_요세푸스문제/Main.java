package boj_1158_요세푸스문제; // 2022.08.18

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Node {
	public int data;
	public Node prev;
	public Node next;

	public Node(int data) {
		this.data = data;
		this.prev = null;
		this.next = null;
	}
} // node

class Josephus {
	private Node front;
	private Node rear;

	public void formed(int N) {
		front = null;
		rear = null;

		for (int i = 1; i <= N; i++) {
			Node node = new Node(i);

			if (front == null) {
				front = node;
				rear = front;
			} else {
				rear.next = node;
				node.prev = rear;
				rear = node;
			}
		}
		rear.next = front;
		front.prev = rear;
	}

	public int remove(int N, int K) {
		Node curr = rear;

		for (int k = 1; k <= N; k++) {
			for (int j = 1; j <= K; j++) {
				curr = curr.next;
			}

			Node prevNode = curr.prev;
			Node nextNode = curr.next;

			int data = curr.data;

			if (k < N)
				System.out.print(data + ", ");
			else
				System.out.print(data);

			prevNode.next = nextNode;
			nextNode.prev = prevNode;
			curr = prevNode;
		}
		return curr.data;
	}

} // Josephus

public class Main {

//	요세푸스 문제는 다음과 같다.
//	1번부터 N번까지 N명의 사람이 원을 이루면서 앉아있고, 양의 정수 K(≤ N)가 주어진다.
//	이제 순서대로 K번째 사람을 제거한다. 한 사람이 제거되면 남은 사람들로 이루어진 원을 따라 이 과정을 계속해 나간다.
//	이 과정은 N명의 사람이 모두 제거될 때까지 계속된다. 원에서 사람들이 제거되는 순서를 (N, K)-요세푸스 순열이라고 한다.
//	예를 들어 (7, 3)-요세푸스 순열은 <3, 6, 2, 7, 5, 1, 4>이다.
//	N과 K가 주어지면 (N, K)-요세푸스 순열을 구하는 프로그램을 작성하시오.

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		Josephus A = new Josephus();

		A.formed(N);
		System.out.print("<");
		A.remove(N, K);
		System.out.print(">");

		br.close();
		
	} // main
} // class
