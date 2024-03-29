package src.leetcode101.c01;

//406. 根据身高重建队列
//        假设有打乱顺序的一群人站成一个队列，数组 people 表示队列中一些人的属性（不一定按顺序）。每个 people[i] = [hi, ki] 表示第 i 个人的身高为 hi ，前面 正好 有 ki 个身高大于或等于 hi 的人。
//
//        请你重新构造并返回输入数组 people 所表示的队列。返回的队列应该格式化为数组 queue ，其中 queue[j] = [hj, kj] 是队列中第 j 个人的属性（queue[0] 是排在队列前面的人）。
//
//
//
//        示例 1：
//
//        输入：people = [[7,0],[4,4],[7,1],[5,0],[6,1],[5,2]]
//        输出：[[5,0],[7,0],[5,2],[6,1],[4,4],[7,1]]
//        解释：
//        编号为 0 的人身高为 5 ，没有身高更高或者相同的人排在他前面。
//        编号为 1 的人身高为 7 ，没有身高更高或者相同的人排在他前面。
//        编号为 2 的人身高为 5 ，有 2 个身高更高或者相同的人排在他前面，即编号为 0 和 1 的人。
//        编号为 3 的人身高为 6 ，有 1 个身高更高或者相同的人排在他前面，即编号为 1 的人。
//        编号为 4 的人身高为 4 ，有 4 个身高更高或者相同的人排在他前面，即编号为 0、1、2、3 的人。
//        编号为 5 的人身高为 7 ，有 1 个身高更高或者相同的人排在他前面，即编号为 1 的人。
//        因此 [[5,0],[7,0],[5,2],[6,1],[4,4],[7,1]] 是重新构造后的队列。
//        示例 2：
//
//        输入：people = [[6,0],[5,0],[4,0],[3,2],[2,2],[1,4]]
//        输出：[[4,0],[5,0],[2,2],[3,2],[1,4],[6,0]]

import java.util.*;

public class t406 {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                if(a[1] == b[1]){
                    return a[0] - b[0];
                }else {
                    return a[1] - b[1];
                }
            }
        });

        LinkedList<int[]> list = new LinkedList<int[]>();
        int length = people.length;
        list.add(people[0]);
        for (int i = 0 ; i < length ; i++ ){
            int hight = people[i][0];
            int need = people[i][1];
            int count = 0 ;
            for(int j = 0 ; j < list.size() ; j++){
                if( hight <= list.get(j)[0] ){
                    count++;
                    if(count == need+1){
                        list.add( j-1 , people[i] );
                        break;
                    }
                }
            }
        }
        int[][] ret = new int[list.size()][2];
        for (int i = 0 ; i < list.size() ; i++){
            ret[i][0] = list.get(i)[0];
            ret[i][1] = list.get(i)[1];
        }
        return  ret;

    }


    //标准答案 比我的简介多了
    class Solution {
        public int[][] reconstructQueue(int[][] people) {
            Arrays.sort(people, new Comparator<int[]>() {
                public int compare(int[] person1, int[] person2) {
                    if (person1[0] != person2[0]) {
                        return person2[0] - person1[0];
                    } else {
                        return person1[1] - person2[1];
                    }
                }
            });
            List<int[]> ans = new ArrayList<int[]>();
            for (int[] person : people) {
                ans.add(person[1], person);
            }
            return ans.toArray(new int[ans.size()][]);
        }
    }


}
