package mianshi.rizhiyi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 给两个List a,b，实现两个List两个List的并集，即合并两个List，重复的元素只保留一个。
// 不可以调用现成的集合方法
// 有空闲限制，a的长度是m，b的长度是n，额外空间最多用m+n (不是O(m+n))
// 尝试优化下，最少的时间复杂度是多少，在代码注释里给出最终的时间复杂度
class ListUnion {

    public static void quickSort(List<Integer> arr, int start, int end) {
        if (start >= end) return;
        int middle = partition(arr, start, end);
//        System.out.println(arr);

        quickSort(arr, start, middle - 1);
        quickSort(arr, middle + 1, end);
    }
    public static int partition(List<Integer> arr, int start, int end) {
        int pivot = arr.get(start);
        int left = start + 1;
        int right = end;
        while (left < right) {
            while (left < right &&  arr.get(left) <= pivot) left++;
            while (left < right &&  arr.get(right)  >= pivot) right--;
            if (left < right) {
                exchange(arr, left, right);
                left++;
                right--;
            }
        }
        if (left == right && arr.get(right) > pivot) right--;
        exchange(arr, start, right);
        return right;
    }
    private static void exchange(List<Integer> arr, int i, int j) {
        int temp = arr.get(i);
        arr.set(i , arr.get(j));
        arr.set(j , temp);
    }

    static List<Integer> union(List<Integer> a, List<Integer> b) {
        // 在这儿实现
        //时间复杂度O(nlog(n)) 空间复杂度O（1）
        //思路：先将连个list进行排序，然后合并链表
        quickSort(a , 0 , a.size()-1);
        quickSort(b , 0 , b.size()-1);
//        System.out.println(a);
//        System.out.println(b);
        //合并
        int index1 = 0, index2 = 0 , indexRet = 0;
        int n1 = a.size() , n2 = b.size();
        ArrayList<Integer> ret = new ArrayList<>();

        while (index1 < n1 && index2 < n2){
            int num1 = a.get(index1);
            int num2 = b.get(index2);
//            System.out.println(ret);
//            System.out.println("index1="+index1+" index2="+index2);
            if( num1 < num2 ){
                if(ret.isEmpty()  ){
                    ret.add( num1 );
                    indexRet++;
                }else if( num1 != ret.get(indexRet-1) ){
                    ret.add(num1);
                    indexRet++;
                }
                index1++;
            }else {
                if(ret.isEmpty()  ){
                    ret.add( num2 );
                    indexRet++;
                }else if( num2 != ret.get(indexRet-1) ){
                    ret.add(num2);
                    indexRet++;
                }
                index2++;
            }
        }

        while (index1 < n1){
            ret.add( a.get(index1++) );
        }

        while (index2 < n2){
            ret.add( b.get(index2++) );
        }
        return ret;
    }
    public static void main(String[] args) {
        // union([ 2, 1, 3], [ 2, 3, 4]) ==  [1, 2, 3, 4]
        System.out.println(union(Arrays.asList(2,2,1,3,8,0,100), Arrays.asList(2,3,4)));
    }
}

public class t1_1 {
}
