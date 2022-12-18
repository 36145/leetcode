package test.unknown;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class EncodeDecodeStrings {
    @Test
    public void TestEncodeDecode() {
        String[] strings = new String[]{"lint", "code", "love", "you"};
        String encoded = encode(List.of(strings));
        System.out.println(decode(encoded));
    }
    char delim = ';';



    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();

        for (String s : strs){
            sb.append(s.length());
            sb.append(delim);
            sb.append(s);
        }
        return sb.toString();
    }

    public List<String> decode(String str) {

       char[] characters = str.toCharArray();

       List<String> ans = new ArrayList<>();
       for(int i  =0; i < characters.length;i++){

           StringBuilder digitString= new StringBuilder();
           while(true){
               char c = characters[i];
                i++;
               if (c == delim){
                   break;
               }
               digitString.append(c);
           }

           int stringLength = Integer.parseInt(digitString.toString());
           digitString.setLength(0);
           for (int j = i; j < stringLength+i; j++){
               digitString.append(characters[j]);
           }
           ans.add(digitString.toString());
           i+= stringLength - 1;

       }

       return ans;
    }
}
