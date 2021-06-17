package leetcode101.c05;

public class quicksort {
    //方法一
    public static void quickSort(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }
    public static void quickSort(int[] arr, int start, int end) {
        // 如果区域内的数字少于 2 个，退出递归
        if (start >= end) return;
        // 将数组分区，并获得中间值的下标
        int middle = partition(arr, start, end);
        // 对左边区域快速排序
        quickSort(arr, start, middle - 1);
        // 对右边区域快速排序
        quickSort(arr, middle + 1, end);
    }
    // 将 arr 从 start 到 end 分区，左边区域比基数小，右边区域比基数大，然后返回中间值的下标
    public static int partition(int[] arr, int start, int end) {
        // 取第一个数为基数
        int pivot = arr[start];
        // 从第二个数开始分区
        int left = start + 1;
        // 右边界
        int right = end;
        while (left < right) {
            // 找到第一个大于基数的位置
            while (left < right && arr[left] <= pivot) left++;
            // 找到第一个小于基数的位置
            while (left < right && arr[right] >= pivot) right--;
            // 交换这两个数，使得左边分区都小于或等于基数，右边分区大于或等于基数
            if (left < right) {
                exchange(arr, left, right);
                left++;
                right--;
            }
        }
        // 如果 left 和 right 相等，单独比较 arr[right] 和 pivot
        if (left == right && arr[right] > pivot) right--;
        // 将基数和轴交换
        exchange(arr, start, right);
        return right;
    }
    private static void exchange(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    //方法二
    void quick_sort(int[] nums , int l , int r){
        if(l + 1 >= r)return;
        int first = l , last = r - 1 , key = nums[first];
        while (first < last){
            while (first < last && nums[last] >= key){
                --last;
            }
            nums[first] = nums[last];
            while (first < last && nums[first] <= key){
                ++first;
            }
            nums[last] = nums[first];
        }
        nums[first] = key;
        quick_sort(nums , l , first);
        quick_sort(nums , first+1 , r);
    }

    public static void main(String[] args) {
        int[] nums = {1,3,5,7,2,6,4,8,9,2,8,7,6,0,3,5,9,4,1,0};
        new quicksort().quick_sort(nums, 0 , nums.length);
        for(int n : nums){
            System.out.print(n + " ");
        }
    }
}
