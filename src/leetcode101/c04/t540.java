package leetcode101.c04;

//540. 有序数组中的单一元素
//        给定一个只包含整数的有序数组，每个元素都会出现两次，唯有一个数只会出现一次，找出这个数。
//
//        示例 1:
//
//        输入: [1,1,2,3,3,4,4,8,8]
//        输出: 2
//        示例 2:
//
//        输入: [3,3,7,7,10,11,11]
//        输出: 10

public class t540 {
    public int singleNonDuplicate(int[] nums) {
        int ret = 0;
        for(int i = 0 ; i < nums.length ; i++ ){
            ret = ret^nums[i];
        }
        return  ret;
    }

    public int singleNonDuplicate1(int[] nums) {
        int lo = 0;
        int hi = nums.length - 1;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            boolean halvesAreEven = (hi - mid) % 2 == 0;
            if (nums[mid + 1] == nums[mid]) {
                if (halvesAreEven) {
                    lo = mid + 2;
                } else {
                    hi = mid - 1;
                }
            } else if (nums[mid - 1] == nums[mid]) {
                if (halvesAreEven) {
                    hi = mid - 2;
                } else {
                    lo = mid + 1;
                }
            } else {
                return nums[mid];
            }
        }
        return nums[lo];
    }

}
