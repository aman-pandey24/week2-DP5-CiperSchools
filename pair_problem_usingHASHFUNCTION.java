package HASH;

import jdk.swing.interop.SwingInterOpUtils;

import java.util.HashMap;

public class pair_problem_usingHASHFUNCTION {
    public static void main(String[] args) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        int arr[][] = {{1, 2}, {2, 3}, {2, 1}, {3, 2}};
        for (int i = 0; i < arr.length; i++) {
            int a = arr[i][0];
            int b = arr[i][1];
            Integer data=hashMap.get(b);
           if(data!=null && data==a){
              System.out.println("("+a+","+b+")");
            }
           else hashMap.put(a,b);
        }
    }
}