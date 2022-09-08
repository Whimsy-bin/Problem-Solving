package boj_2564_경비원; // 2022.08.19

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

//	동근이는 무인 경비 회사 경비원으로 항상 대기하고 있다가 호출이 들어오면 경비차를 몰고 그 곳으로 달려가야 한다.
//	동근이가 담당하고 있는 곳은 직사각형 모양의 블록으로 블록 중간을 가로질러 차가 통과할만한 길이 없다. 이 블록 경계에 무인 경비를 의뢰한 상점들이 있다.
//	
//	블록의 크기와 상점의 개수 및 위치 그리고 동근이의 위치가 주어질 때 동근이의 위치와 각 상점 사이의 최단 거리의 합을 구하는 프로그램을 작성하시오.

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int width = Integer.parseInt(st.nextToken());
		int height = Integer.parseInt(st.nextToken());

		int stores = Integer.parseInt(br.readLine());
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < stores+1; i++) {
			st = new StringTokenizer(br.readLine());
			int dir = Integer.parseInt(st.nextToken());
			int dst = Integer.parseInt(st.nextToken());
			int axis = 0;

			if (dir == 1) // 북쪽
				axis += dst;
			else if (dir == 2) // 남쪽
				axis -= (height+dst);
			else if (dir == 3) // 서쪽
				axis -= dst;
			else if (dir == 4) // 동쪽
				axis += (width+dst);

			list.add(axis);
		}
		
		int axisDonggeun = list.get(list.size()-1);
		int ans =0;
		for(int j =0; j < stores; j++) {
			int diff1 = Math.abs(axisDonggeun - list.get(j));
			int diff2 = 2*(height+width) - diff1;
			ans += Math.min(diff1, diff2);
		}
		System.out.println(ans);
		br.close();

	} // main
} // class
