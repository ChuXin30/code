package leetcode101.c05;

//347. 前 K 个高频元素
//        给你一个整数数组 nums 和一个整数 k ，请你返回其中出现频率前 k 高的元素。你可以按 任意顺序 返回答案。
//
//
//
//        示例 1:
//
//        输入: nums = [1,1,1,2,2,3], k = 2
//        输出: [1,2]
//        示例 2:
//
//        输入: nums = [1], k = 1
//        输出: [1]

//首先我们使用一共hashmap来存储每个数字出现的次数
//然后使用一共优先队列，优先队列的顶部就是出现次数最多的数字，
//然后按照k 从优先队列里面取出k个元素

import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

public class t347 {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer , Integer> hashMap = new HashMap<Integer , Integer>();
        for(int i = 0 ; i < nums.length ; i++){
            hashMap.put(nums[i] , hashMap.getOrDefault(nums[i],0)+1);
        }
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<int[]>(new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                return b[1] - a[1];
            }
        });

        for(int key : hashMap.keySet()){
            int num = hashMap.get(key);
            if(priorityQueue.size() <= k){
                priorityQueue.offer(new int[]{key, num});
            }else{
                if(num > priorityQueue.peek()[1]){
                    priorityQueue.poll();
                    priorityQueue.offer(new int[]{key,num});
                }
            }
        }

        int[] ret = new int[k];
        for(int i = 0 ; i <  k ; i++ ){
            ret[i] = priorityQueue.peek()[0];
            priorityQueue.poll();
        }
        return  ret;

    }
}
