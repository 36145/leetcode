package test.unknown;

import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class LongestRepeatingCharacterReplacement {

    @Test
    public void TestCharacterReplacement(){
        String s = "ABAABB";
        int k = 2;

        System.out.println(characterReplacement(s,k));
    }

    public int characterReplacement(String s, int k) {

        int ans = 0;

        int i = 0;
        int j = 0;

        HashMap<Character, Integer> frequencyMap = new HashMap<>();
        while (j < s.length()){

            char current = s.charAt(j);
            int count =  frequencyMap.getOrDefault(current, 0);
            frequencyMap.put(current,++count);
            j++;

            int maxFreq = 0;
            for (Map.Entry<Character, Integer> entry : frequencyMap.entrySet()){
                maxFreq = Math.max(entry.getValue(),maxFreq);
            }

            if (j - i - maxFreq > k){
                int newCount = frequencyMap.get(s.charAt(i));
                newCount--;
                frequencyMap.put(s.charAt(i),newCount);
                i++;

            }

            ans = Math.max(ans, j - i);
        }

        return ans;
    }
}
