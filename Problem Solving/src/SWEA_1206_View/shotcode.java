package SWEA_1206_View; // 2022.08.08

import java.util.Scanner;

class shotcode {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int z = 1; z <= 10; z++) {
			System.out.print("#" + z + " ");
			int n = sc.nextInt();
			int[] h = new int[n];
			for (int y = 0; y < n; y++) {
				h[y] = sc.nextInt();
			}
			long sum = 0;
			for (int y = 2; y < n - 2; y++) {
				sum += Math.max(0, (h[y] - Math.max(Math.max(h[y - 1], h[y + 1]), Math.max(h[y - 2], h[y + 2]))));
			}
			System.out.println(sum);
		}
		sc.close();
	}
}