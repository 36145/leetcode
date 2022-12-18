package test.twopointer;

import org.testng.annotations.Test;

import java.util.Arrays;

public class TwoSumIITest {

    @Test
    public void TwoSumTwoTest(){
        int[] nums = new int[]{2,7,11,15};
        int target = 9;

        System.out.println(Arrays.toString(twoSum(nums, target)));

    }

    public int[] twoSum(int[] numbers, int target) {
        //array is sorted
        //no extra space

        int l = 0 ;
        int r = numbers.length-1;
       while ( l < r){

           int currSum = numbers[l]+numbers[r];
           if (currSum == target) {
               return new int[]{l+1,r+1};
           }else if (currSum > target){
               r--;
           }else {
               l++;
           }
       }

        return null;
    }
//    public int[] twoSum(int[] numbers, int target) {
//        //array is sorted
//        //no extra space
//
//        for(int i = 0; i < numbers.length-1; i++){
//
//            int search = target - numbers[i];
//
//            int l = i+1;
//            int r = numbers.length - 1;
//
//            while ( l <= r){
//
//                int m = (l + r)  /2 ;
//
//                int midVal = numbers[m];
//                if (midVal == search){
//                    return new int[]{i+1, m+1};
//                }else if (midVal > search){
//                    r = m-1;
//                }else {
//                    l = m + 1;
//                }
//
//            }
//        }
//
//        return null;
//    }
}
