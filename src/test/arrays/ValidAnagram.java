package test.arrays;

import java.util.HashMap;
import java.util.Map;

public class ValidAnagram {

    public boolean isAnagram(String s, String t) {

        if (s.length() != t.length()){
            return false;
        }
        HashMap<Character,Integer> charCount = new HashMap<>();
        HashMap<Character,Integer> charSecond = new HashMap<>();
        char[] first = s.toCharArray();
        char[] second = t.toCharArray();

        for (int i = 0 ; i < s.length(); i++){
            charCount.put(first[i],charCount.getOrDefault(first[i],0)+1);
            charSecond.put(second[i],charSecond.getOrDefault(second[i],0)+1);
        }

        for (Map.Entry<Character, Integer> entry: charCount.entrySet()){

           if  (!entry.getValue().equals(charSecond.getOrDefault(entry.getKey(),0))){
               return false;
           }

        }

        return true;



    }
}
