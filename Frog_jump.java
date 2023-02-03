package DYNAMICprogrammin;

import java.util.Arrays;

public class Frog_jump {
    public static int minimum_recursion(int[]arr,int n){
        if (n==0){
            return 0;
        }
        int left=minimum_recursion(arr,n-1)+Math.abs(arr[n]-arr[n-1]);
        int right=Integer.MAX_VALUE;
        if(n>1){
            right=minimum_recursion(arr,n-2)+Math.abs(arr[n]-arr[n-2]);
        }
        return Math.min(left,right);
    }
    public static int minimum_memoization(int[]arr,int n,int[]dp){
        if (n==0){
            return 0;
        }
        if (dp[n]!=-1){
            return dp[n];
        }
        int left=minimum_memoization(arr,n-1,dp)+Math.abs(arr[n]-arr[n-1]);
        int right= Integer.MAX_VALUE;
        if (n>1){
            right=minimum_memoization(arr,n-2,dp)+Math.abs(arr[n]-arr[n-2]);
        }
        return dp[n]=Math.min(left,right);
    }
    public static int minimum_tabulation(int[]arr,int n,int[]dp){
        dp[0]=0;
        for (int i=1;i<n;i++){
            int right=Integer.MAX_VALUE;
            int left=dp[i-1]+Math.abs(arr[i]-arr[i-1]);
            if (i>1){
                right=dp[i-2]+Math.abs(arr[i]-arr[i-2]);
            }
            dp[i]=Math.min(left,right);
        }
        return dp[n-1];
    }
    public static int k_minimum_memoization(int[]arr,int n,int[]dp,int k){
        if(n==0){
            return 0;
        }
        if(dp[n]!=-1){
            return dp[n];
        }
        int minstep=Integer.MAX_VALUE;
        for(int i=1;i<=k;i++){
            if ((n-i)>=0) {
                int jump = k_minimum_memoization(arr, n - i, dp, k) + Math.abs(arr[n] - arr[n - i]);
                minstep=Math.min(jump,minstep);
            }
            }
        return dp[n]=minstep;
    }
    public static int k_minimum_tabulation(int[]arr,int n,int[]dp,int k){
        dp[0]=0;
        for (int i=1;i<n;i++){
            int minstep=Integer.MAX_VALUE;
            for(int j=1;j<=k;j++){
                if ((i-j)>=0) {
                    int jump = dp[i-j] + Math.abs(arr[i] - arr[i - j]);
                    minstep=Math.min(jump,minstep);
                }
            }
            dp[i]=minstep;
        }
        return dp[n-1];
    }
    public static void main(String[] args) {
        int[] arr={30,10,60,10,60,50};
        int n=arr.length;
        int[]dp=new int[n];
        Arrays.fill(dp,-1);
        System.out.println("i am recursion "+minimum_recursion(arr,n-1));
        System.out.println("i am memo "+minimum_memoization(arr,n-1,dp));
        System.out.println("i am tabulation "+minimum_tabulation(arr,n,dp));
        System.out.println("i am k_memo "+k_minimum_memoization(arr,n-1,dp,6));
        System.out.println("i am k_tabulation "+k_minimum_tabulation(arr,n,dp,6));
    }
}
