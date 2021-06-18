package leetcode101.c06;

//126. 单词接龙 II
//        按字典 wordList 完成从单词 beginWord 到单词 endWord 转化，一个表示此过程的 转换序列 是形式上像 beginWord -> s1 -> s2 -> ... -> sk 这样的单词序列，并满足：
//
//        每对相邻的单词之间仅有单个字母不同。
//        转换过程中的每个单词 si（1 <= i <= k）必须是字典 wordList 中的单词。注意，beginWord 不必是字典 wordList 中的单词。
//        sk == endWord
//        给你两个单词 beginWord 和 endWord ，以及一个字典 wordList 。请你找出并返回所有从 beginWord 到 endWord 的 最短转换序列 ，如果不存在这样的转换序列，返回一个空列表。每个序列都应该以单词列表 [beginWord, s1, s2, ..., sk] 的形式返回。
//
//
//
//        示例 1：
//
//        输入：beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log","cog"]
//        输出：[["hit","hot","dot","dog","cog"],["hit","hot","lot","log","cog"]]
//        解释：存在 2 种最短的转换序列：
//        "hit" -> "hot" -> "dot" -> "dog" -> "cog"
//        "hit" -> "hot" -> "lot" -> "log" -> "cog"
//        示例 2：
//
//        输入：beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log"]
//        输出：[]
//        解释：endWord "cog" 不在字典 wordList 中，所以不存在符合要求的转换序列。

//使用bfs 算法
// 首先我们将beginWord的单词加入到队列中
// 取出当前队列中的元素 代表这一层有多少个单词
// 每次将与该单词相距为1的加入到队列
// 然后继续之前 从当前队列取出元素的操作 直到找到endword


//bfs + dfs
/*
先用bfs来建立一颗树，树的根节点为beginword
子节点为与父节点相聚为1的的节点

然后变量这颗树到跟节点的所有值
 */

import java.util.*;

public class t126 {

    public  int calDefferent(String s1 , String s2){
        int count = 0;
        for(int i = 0 ; i < s1.length() ; i++){
            if(s1.charAt(i) != s2.charAt(i))count++;
        }
        return count;
    }

    public void dfs(HashMap<String , List<String>> tree, LinkedList<String> ans, String end , String tmp, List<List<String>> ret){
        if(tmp.equals(end)){
            // ans.add(end);
            ret.add(new ArrayList (ans));
            return;
        }

        int size = tree.get(tmp).size();
        for(int i = 0 ; i < size ; i++ ){
            String new_s = tree.get(tmp).get(i);
            ans.add(new_s);
            dfs(tree , ans , end , new_s , ret);
            ans.remove(ans.size()-1);
        }

    }

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> ret = new ArrayList<List<String>>();
        LinkedList<String> eg = new LinkedList<String>();
        HashSet<String  > visited = new HashSet<String >();
        HashMap<String , List<String>> tree = new HashMap<>();
        HashMap<String , Integer> deepth = new HashMap<>();

        for(int i = 0 ; i < wordList.size() ; i++){
            visited.add(wordList.get(i));
        }

        if(!visited.contains(endWord))return ret;

        eg.offer(beginWord);
        deepth.put(beginWord, 0);//有一些边的关系，由于不是最短路径上的边，不可以被记录下来
//        从一个单词出发，修改每一位字符，将它修改成为 a 到 z 中的所有字符，看看修改以后是不是在题目中给出的单词列表中；
//        有一些边的关系，由于不是最短路径上的边，不可以被记录下来。为此，我们这样做：为扩展出的单词记录附加的属性：层数。即下面代码中的 steps。如果当前的单词扩散出去得到的单词的层数在以前出现过，则不应该记录这样的边的关系。



        int deep = 0;
        boolean flag = false;
        while( !eg.isEmpty() ){
            int size = eg.size();
            deep++;
            for(int i = 0 ; i < size ; i++){
                String temp = eg.poll();
                tree.put(temp , new ArrayList<String>());
                visited.remove(temp);
                for(int j = 0 ; j < wordList.size() ; j++ ){
                    String s2 =  wordList.get(j);
                    if(  calDefferent(s2, temp) == 1 ){
                        System.out.println( s2 + "  " + deepth.get(s2) );
                        if(visited.contains(s2)){
                            eg.offer(s2);
                            visited.remove(s2);
                            tree.get(temp).add(s2);
                            deepth.put(s2 , deep);
                        }else if(!deepth.containsKey(s2) || deepth.get(s2) > deepth.get(temp)){
                            tree.get(temp).add(s2);
                            deepth.put(s2 , deep);
                        }

                        // if(temp.equals(endWord)){
                        //     flag = true;
                        // }
                    }
                }
            }
            // if(flag == true){
            //     break;
            // }
        }
        // for(String key : tree.keySet()){
        //     System.out.println( key + "  " +tree.get(key.toString()) );
        // }

        LinkedList<String> ans = new LinkedList<String>();
        ans.add(beginWord);
        dfs(tree , ans , endWord , beginWord , ret);

        return ret;

    }

}
