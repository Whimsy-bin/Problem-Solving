package boj_11650_좌표정렬하기; // 2022.08.13

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

//2차원 평면 위의 점 N개가 주어진다. 좌표를 x좌표가 증가하는 순으로, x좌표가 같으면 y좌표가 증가하는 순서로 정렬한 다음 출력하는 프로그램을 작성하시오.

// 새롭게 쓸 배열 클래스를 정의해준다.
class Sort implements Comparable<Sort> {
	int X;
	int Y;

	// 이렇게 두 개의 인자를 받아서 써먹도록 하고
	public Sort(int X, int Y) {
		super();
		this.X = X;
		this.Y = Y;
	}

	// Collections.sort 정렬 메소드를 재정의해준다.
	@Override
	public int compareTo(Sort sort) {
		if (this.X == sort.X)
			return this.Y - sort.Y;
		else
			return this.X - sort.X;
	}

	// 출력형식에 맞춰서 toString도 재정의해준다.
	@Override
	public String toString() {
		return X + " " + Y;
	}

} // class

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		// 주어지는 입력값들을 N X 2의 2차원 배열에 저장을 한다.
		List<Sort> arr = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			arr.add(new Sort(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
		}
		
		// 정렬을 해주면 위에 재정의해준대로 조건에 맞게 정렬이 될 것이다.
		Collections.sort(arr);

		// 어지럽다 출력을 빨리 하고 끝내자.
		for (int j = 0; j < arr.size(); j++) {
			System.out.println(arr.get(j).toString());
		}

		br.close();

	} // main
} // class
