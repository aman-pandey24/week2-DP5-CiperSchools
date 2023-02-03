package DYNAMICprogrammin;

public class Edit_Distance {
    public static int Min(int a,int b,int c){
       return Math.min(Math.min(a,b),c);
    }
    public static int covert1StringtoOther(String s1,String s2,int m,int n){
        if (m==0){
            return n;
        }
        if (n==0){
            return m;
        }
        if (s1.charAt(m-1)==s2.charAt(n-1)){
            return covert1StringtoOther(s1,s2,m-1,n-1);
        }
        else {
            return 1+Min(covert1StringtoOther(s1,s2,m,n-1),covert1StringtoOther(s1,s2,m-1,n),covert1StringtoOther(s1,s2,m-1,n-1));
        }
    }
    public static int dpMemoisation(String s1,String s2,int m,int n,int[][] dp){
        if (m==0){
            dp[0][n]=n;
        }
        if (n==0){
            dp[m][0]=m;
        }
        else {
            if (s1.charAt(m-1)==s2.charAt(n-1)){
                dp[m][n]=dp[m-1][n-1];
            }
            else {
                dp[m][n]=1+Min(dpMemoisation(s1,s2,m-1,n,dp),dpMemoisation(s1,s2,m,n-1,dp),dpMemoisation(s1,s2,m-1,n-1,dp));
            }
        }
        return dp[m-1][n-1];
    }
    public static int DPtabulation(String s1,String s2){
        int m=s1.length();
        int n=s2.length();
        int[][] dp=new int[m+1][n+1];
        for (int i=0;i<=m;i++){
            dp[i][0]=i;
        }
        for (int i=1;i<=n;i++){
            dp[0][i]=i;
        }
        for (int i=1;i<=m;i++){
            for (int j=1;j<=n;j++){
                if (s1.charAt(i-1)==s2.charAt(j-1)){
                    dp[i][j]=dp[i-1][j-1];
                }
                else {
                    dp[i][j]=1+Math.min(Math.min(dp[i][j-1],dp[i-1][j]),dp[i-1][j-1]);
                }
            }
        }
        return dp[m][n];
    }
    public static void main(String[] args) {
        String s1="SUNDAY";
        String s2="SATURDAY";
        int m=s1.length();
        int n=s2.length();
        System.out.println(covert1StringtoOther(s1,s2,m,n));
        int[][] dp=new int[m+1][n+1];
        for (int i=0;i<=m;i++){
            for (int j=0;j<=n;j++){
                dp[i][j]=0;
            }
        }
        System.out.println("i am dpMemoisation "+dpMemoisation(s1,s2,m,n,dp));
        System.out.println("i am dp tabulation "+DPtabulation(s1,s2));
    }
}
