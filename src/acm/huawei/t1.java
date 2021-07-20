package acm.huawei;

import java.util.LinkedList;
import java.util.Scanner;


public class t1 {
//	public static int findmin(int[][] dp , int[][] time , int h , int w ) {
//		int min = 1001;
//		LinkedList<int[]> dirLinkedList = new LinkedList<int[]>();
//		dirLinkedList.add(new int[]{-1,-1} );
//		dirLinkedList.add(new int[]{-1,0} );
//		dirLinkedList.add(new int[]{-1,1} );
//		dirLinkedList.add(new int[]{1,-1} );
//		dirLinkedList.add(new int[]{1,0} );
//		dirLinkedList.add(new int[]{1,1} );
//		dirLinkedList.add(new int[]{0,1} );
//		dirLinkedList.add(new int[]{0,-1} );
//
//		
//		for(int i = 0 ; i < dirLinkedList.size() ; i++ ) {
//			int high = h + dirLinkedList.get(i)[0];
//			int width = w + dirLinkedList.get(i)[1];
//			
//			if(high >= 0 && high < time.length && width >=0 && width < time[0].length ) {
//				if(time[high][width] == time[h][w] ) {
//					min = Math.min(min, dp[h][w]-1);
//				}else {
//					min = Math.min(min, dp[high][width]);
//				}
//			}
//		}
//		
//		return min;
//	}
//	
	static int min = Integer.MAX_VALUE;
	static LinkedList<int[]> dirLinkedList = new LinkedList<int[]>();
	static int n;
	static int m;
	static int[][] time;
	public static void findmin( boolean[][] visited , int h , int w, int length ) {
//		System.out.println("h="+h+"\tw="+w+"\tlength="+length);
		if( h == n-1 && w == m-1  ) {
			min = Math.min(min, length);
			return;
		}
		if(length > min) {
			return;
		}
		
		for(int i = 0 ; i < dirLinkedList.size() ; i++ ) {
			int high = h + dirLinkedList.get(i)[0];
			int width = w + dirLinkedList.get(i)[1];
			
			if(high >= 0 && high < n && width >=0 && width < m && !visited[high][width] ) {
				visited[high][width] = true;
				if(time[high][width] == time[h][w] ) {
					if((length + time[high][width]-1) <= 0 )findmin( visited , high , width , 0 );
					else {
						findmin( visited , high , width , length + time[high][width]-1 );
					}
				}else {
					findmin(visited , high , width , length + time[high][width] );
				}
				visited[high][width] = false;
			}
		}
		
	}
	public static void main(String[] argv) {
		Scanner scanner = new Scanner(System.in);
		while(scanner.hasNext()) {
			n = scanner.nextInt();
			m = scanner.nextInt();
			time = new int[n][m];
			dirLinkedList.add(new int[]{1,1} );
			dirLinkedList.add(new int[]{1,0} );
			dirLinkedList.add(new int[]{0,1} );

			dirLinkedList.add(new int[]{-1,0} );
			dirLinkedList.add(new int[]{-1,1} );
			dirLinkedList.add(new int[]{1,-1} );
			dirLinkedList.add(new int[]{0,-1} );
			dirLinkedList.add(new int[]{-1,-1} );

			int count = 0;
			for(int i = 0 ; i < n ; i++) {
				for(int j = 0 ; j < m ; j++) {
					time[i][j] = scanner.nextInt();
					if(i== 0 || j == 0)count+= time[i][j];
				}
			}
			min = count;
			boolean[][] visited = new boolean[n][m];
			findmin(  visited , 0 , 0 , time[0][0] );
			System.out.println(min);
			
		}
	}
}
