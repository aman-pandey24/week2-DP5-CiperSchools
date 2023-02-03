package HASH;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class contiguous_array {
    public static void check_contiguous(int[] arr){
        Arrays.sort(arr);
        int first=arr[0];
        int last=arr[arr.length-1];
        int count=0;
        for (int i=0;i< arr.length;i++){
            if (first==arr[i]){
                count++;
            }
            else if (first+1==arr[i]){
                count++;
                first=first+1;
            }
        }
        System.out.println(count);
        if (count==arr.length){
            System.out.println("true");
        }
        else System.out.println("false");
    }
    public static void hashset(Integer[] arr){
        Set<Integer> hash=new HashSet<>(Arrays.asList(arr));
        int firstelement=hash.stream().findFirst().orElse(-1);
        int count=0;
        for (Integer x:hash){
            if (firstelement==x){
                firstelement=firstelement+1;
                count++;
            }
        }
        if (count==hash.size()){
            System.out.println("ARRAY IS IN CONTIGUOUS MANNER");
        }
        else {
            System.out.println("ARRAY IS NOT IN CONTIGUOUS MANNER");
        }

    }
    public static void main(String[] args) {
        Integer[] arr={4,3,3,6,9,8,7,5};
        hashset(arr);

    }
}
