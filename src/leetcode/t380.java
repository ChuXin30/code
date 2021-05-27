package leetcode;

import java.util.*;

class t380 {
    HashMap<Integer , Integer> hashMap;
    LinkedList<Integer> linkedList;
    Random random = new Random();
    /** Initialize your data structure here. */
    public t380() {
        hashMap = new HashMap<Integer, Integer>();
        linkedList = new LinkedList<Integer >();
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if(!hashMap.containsKey(val) ){
            hashMap.put(val , linkedList.size());
            linkedList.add(val);
            return true;
        }else{
            return false;
        }
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if(!hashMap.containsKey(val))return false;
        int index = hashMap.get(val);
        int lastval = linkedList.get(linkedList.size()-1);
        linkedList.set(index , lastval);
        linkedList.remove(linkedList.size()-1);
        hashMap.remove(val);
        return true;
    }

    /** Get a random element from the set. */
    public int getRandom() {
        return  linkedList.get( random.nextInt(linkedList.size()) );
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */

