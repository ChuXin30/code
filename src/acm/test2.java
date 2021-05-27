package acm;
//
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class test2 {
	public static void main(String[] argv) {
		Scanner scanner = new Scanner(System.in);
		while(scanner.hasNext()) {
			int n = scanner.nextInt();
			int[] nums = new int[n];
			HashMap<Integer, Integer> hMap = new HashMap<Integer , Integer>();
			for(int i = 0 ; i < n ; i++) {
				int t = scanner.nextInt();
				nums[i] =t ;
				hMap.put(t, 1);
			}
			Arrays.sort(nums);
			for(int i = 0 ; i < n; i++) {
				if(hMap.get(nums[i]) == 1) {
					System.out.println(nums[i]);
					hMap.put(nums[i], 0);
				}
			}
		}
	}
}
