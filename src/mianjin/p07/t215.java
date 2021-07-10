package mianjin.p07;

public class t215 {

    int quicksort(int[] nums , int start , int end , int index ){
        int partion = part(nums , start , end);
        if( partion == index)return nums[index];
        else if(partion > index){
           return quicksort(nums , start , partion-1 , index);
        }else {
           return quicksort(nums , partion + 1 , end , index);
        }
    }

    int part(int [] nums , int left , int rigth){
        int p = left+1;
        while (left < rigth){
            while (left < rigth && nums[p] > nums[left])left++;
            while (left < rigth && nums[p] <= nums[rigth])rigth--;
            if(left < rigth){
                swap(nums , left , rigth);
                left++;
                rigth--;
            }
        }

        if(left == rigth && nums[rigth] > nums[p]){
            rigth--;
        }
        swap(nums , rigth , p);
        return rigth;

    }

    void swap(int[] nums , int l , int r ){
        int t = nums[l];
        nums[l] = nums[r];
        nums[r] = t;
    }


    public int findKthLargest(int[] nums, int k) {
        return quicksort(nums , 0 , nums.length , nums.length - k);
    }
}
