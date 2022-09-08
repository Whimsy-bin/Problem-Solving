package boj_1358_하키; // 2022.08.16

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

//	지난주에, 민식주식회사는 IIHF(International Ice Hockey Federation)로부터 긴급한 전화를 받았다.
//	IIHF는 같은 팀이 링크안에 너무 많으면 알람이 울리는 시스템을 설치해달라고 요청했다. 시스템은 다음과 같이 3개의 부분으로 이루어진다.
//
//	디지털카메라가 링크의 사진을 매 1초마다 찍는다.
//	디지털카메라가 찍은 사진에서 각 선수의 위치를 뽑아낸다.
//	하키 링크 안에 같은 팀 선수가 총 몇 명인지 계산한다.
//	
//	하키 링크는 (X, Y)가 가장 왼쪽 아래 모서리인 W * H 크기의 직사각형과, 반지름이 H/2이면서 중심이 (X, Y+R), (X+W, Y+R)에 있는 두 개의 원으로 이루어져 있다. 아래 그림을 참고한다.
//	선수들의 위치가 주어질 때, 링크 안 또는 경계에 있는 선수가 총 몇 명인지 구하는 프로그램을 작성하시오.

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer info = new StringTokenizer(br.readLine());
		int W = Integer.parseInt(info.nextToken()); // 직사각형의 가로
		int H = Integer.parseInt(info.nextToken()); // 직사각형의 세로이자 원의 지름
		int R = H/2; // 원의 반지름
		int X = Integer.parseInt(info.nextToken()); // 직사각형의 왼쪽 아래 모서리의 X좌표
		int Y = Integer.parseInt(info.nextToken()); // 직사각형의 왼쪽 아래 모서리의 Y좌표
		int P = Integer.parseInt(info.nextToken()); // 선수의 수

		int ans = 0; // 링크 안 또는 경계에 있는 선수를 담을 변수

		// 목표 : 선수의 좌표를 받을 때마다 해당 선수가 조건을 만족하는지 확인하여 해당하면 ans++을 해주자
		for (int i = 0; i < P; i++) {
			StringTokenizer player = new StringTokenizer(br.readLine());
			int playerX = Integer.parseInt(player.nextToken()); // 해당 선수의 X좌표
			int playerY = Integer.parseInt(player.nextToken()); // 해당 선수의 Y좌표

			// 선수가 직사각형 구역에 있는지 확인
			if (X <= playerX && playerX <= X + W && Y <= playerY && playerY <= Y + H)
				ans++;
			
			// 선수가 원 부분에 있는지 확인
			else {
				// 원의 오른쪽 부분도 한꺼번에 확인해주기 위해 좌표를 평행이동해준다.
				if (playerX > X + W) 
					playerX -= W;
				
				// 원의 정의에 따라 (원의 중심의 X좌표 - 해당 점의 X좌표)^2 + (원의 중심의 Y좌표 - 해당 점의 Y좌표)^2 < R^2 이면 해당 점은 원 안에 있다.
				if((Math.pow(X-playerX,2)) + (Math.pow(Y+R-playerY,2)) <= Math.pow(R, 2) )
					ans++;
			}
		} // 목표 for문

		// 계산한 ans 값을 출력해준다.
		System.out.println(ans);
		br.close();

	} // main
} // class
