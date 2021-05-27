package acm;

import java.util.Scanner;

public class test2016_2 {
	public static void main(String[] argv) {
		Scanner scanner = new Scanner(System.in);
		while(scanner.hasNext()) {
			int n = scanner.nextInt();
			if(n <= 0) {
				break;
			}
			int[] nums = new int[n];
			for(int i = 0 ; i < n ; i++) {
				nums[i] = 0 ;
			}
			int index = 0;
			for(int i = 0 ; i < n ; i++) {
				int jump = 0;
				while(true) {
					if(jump == 2)break;
					else if(nums[index%n] == 0) {
						index++;
						jump++;
					}else {
						index++;
					}
				}
				while(nums[index%n] == 1)index++;
				nums[index%n] = 1;
//				System.out.println("index="+index%n);

			}
//			System.out.println("index="+index);
			System.out.println(index%n);

		}
	}
}
