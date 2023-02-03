package HASH;

import java.util.*;

public class first_unique_character_usingLINKEDHASHMAP {
    public static void main(String[] args) {
        Map<Character,Integer> map=new LinkedHashMap<>();
        String sc="adcbcdaacbe";
        for(int i=0;i<sc.length();i++){
            char ch=sc.charAt(i);
            if(map.containsKey(ch)==false){
                map.put(ch,1);
            }
            else {
                map.put(ch,map.get(ch)+1);
            }
        }
        for (Character ch: map.keySet()){
            if (map.get(ch)==1){
                System.out.println(ch);
                break;
            }
        }

        }
}
