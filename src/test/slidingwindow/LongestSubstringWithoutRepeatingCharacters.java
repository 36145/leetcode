package test.slidingwindow;

import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.HashSet;

public class LongestSubstringWithoutRepeatingCharacters {

    @Test
    public void TestLength() {

        String s = "abcabcbb";
        System.out.println(lengthOfLongestSubstring(s));
    }

    public int lengthOfLongestSubstring(String s) {

        int i = 0;
        int j = 0;

        int ans = 0;
        HashSet<Character> set = new HashSet<>();
        while (j < s.length()){

            while(set.contains(s.charAt(j))){
                set.remove(s.charAt(i));
                i++;
            }

            set.add(s.charAt(j));
            j++;
            ans = Math.max(ans,j-i);
        }

        return ans;
    }
}
