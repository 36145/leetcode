package test.arrays;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class GroupAnagrams {

    @Test
    public void TestGroupAnagrams(){

        String[] strs = new String[]{"eat","tea","tan","ate","nat","bat"};
        System.out.println(groupAnagrams(strs));
    }
    public List<List<String>> groupAnagrams(String[] strs) {

        List<List<String>> ans = new ArrayList<>();

        HashMap<String, List<String>> map = new HashMap<>();
        for (String s:  strs){

            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String sortedString = new String(chars);

            List<String> list = map.getOrDefault(sortedString,new ArrayList<>());
            list.add(s);
            map.put(sortedString,list);
        }

        ans.addAll(map.values());

        return ans;
    }
}
