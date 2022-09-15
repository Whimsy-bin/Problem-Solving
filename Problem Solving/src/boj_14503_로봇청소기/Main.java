package boj_14503_로봇청소기; // 2022.09.05 

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

//	로봇 청소기가 주어졌을 때, 청소하는 영역의 개수를 구하는 프로그램을 작성하시오.
//
//	로봇 청소기가 있는 장소는 N×M 크기의 직사각형으로 나타낼 수 있으며, 1×1크기의 정사각형 칸으로 나누어져 있다.
//	각각의 칸은 벽 또는 빈 칸이다. 청소기는 바라보는 방향이 있으며, 이 방향은 동, 서, 남, 북중 하나이다.
//	지도의 각 칸은 (r, c)로 나타낼 수 있고, r은 북쪽으로부터 떨어진 칸의 개수, c는 서쪽으로 부터 떨어진 칸의 개수이다.
//
//	로봇 청소기는 다음과 같이 작동한다.
//
//	현재 위치를 청소한다.
//	현재 위치에서 현재 방향을 기준으로 왼쪽방향부터 차례대로 탐색을 진행한다.
//	왼쪽 방향에 아직 청소하지 않은 공간이 존재한다면, 그 방향으로 회전한 다음 한 칸을 전진하고 1번부터 진행한다.
//	왼쪽 방향에 청소할 공간이 없다면, 그 방향으로 회전하고 2번으로 돌아간다.
//	네 방향 모두 청소가 이미 되어있거나 벽인 경우에는, 바라보는 방향을 유지한 채로 한 칸 후진을 하고 2번으로 돌아간다.
//	네 방향 모두 청소가 이미 되어있거나 벽이면서, 뒤쪽 방향이 벽이라 후진도 할 수 없는 경우에는 작동을 멈춘다.
//	로봇 청소기는 이미 청소되어있는 칸을 또 청소하지 않으며, 벽을 통과할 수 없다.

	static int[][] area;
	static int ans = 0;
	static int rotation = 0;

//	static void Robot(int r, int c, int d) {
//	 Robot(int r, int c, int d) {	
//		 this.r = r;
//		 this.c = r;
//		 this.d = r;
//		
//	}}

	static void operation(int r, int c, int d) {

		if (area[r][c] == 0) {
			area[r][c] = -1;
			ans++;
		}
		d = (d != 0) ? (d - 1) : 3;
		int dr[] = { -1, 0, 1, 0 };
		int dc[] = { 0, 1, 0, -1 };

		if (area[r + dr[d]][c + dc[d]] != 1) {
			r += dr[d];
			c += dc[d];
			rotation = 0;
		} else
			rotation++;

		if (rotation == 4) {
			if (area[r - dr[d]][c - dc[d]] != 1) {
				r -= dr[d];
				c -= dc[d];
				rotation = 0;
			} else
				return;
		} else
			operation(r, c, d);
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());

		area = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++)
				area[i][j] = Integer.parseInt(st.nextToken());
		}

		operation(r, c, d);
		System.out.println(ans);
		br.close();

	}// main
} // class
