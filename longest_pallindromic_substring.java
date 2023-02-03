package DYNAMICprogrammin;

import java.util.HashMap;

public class longest_pallindromic_substring {
    public static void main(String[] args) {
        int[] arr={2,4,6,6,4,2,4};
        System.out.println(ans(arr));
    }
    public static int ans(int[] arr){
        HashMap<Integer,Integer> hash=new HashMap<>();
        for (int i=0;i<arr.length;i++) {
            if (hash.containsKey(arr[i])) {
                hash.put(arr[i], hash.get(arr[i]) + 1);
            } else {
                hash.put(arr[i], 1);
            }
        }
        int ans=0;
        for (int x:hash.values()){
            if (x==1){
                return -1;
            }
            else if(x%3==0){
                ans+=(x/3);
            }
            else{
                ans+=(x/3)+1;
            }
        }
        return ans;
    }
}
