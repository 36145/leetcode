package test.unknown;

import org.testng.annotations.Test;

public class IsPalindrome {

    @Test
    public void TestIsPalindrome(){

        System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
    }

    public boolean isPalindrome(String s) {

        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()){
            if (Character.isLetterOrDigit(c)){
                sb.append(Character.toLowerCase(c));
            }
        }

        char[] chars = sb.toString().toCharArray();



        for(int i = 0; i < chars.length/2; i++){
            char first = chars[i];
            char second = chars[chars.length-1-i];

           if (first != second){
               return false;
           }
        }
        return true;
    }
}
