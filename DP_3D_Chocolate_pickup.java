package DYNAMICprogrammin;

public class DP_3D_Chocolate_pickup {
    public static int recursion(int[][] matrix,int n, int m,int i,int j1,int j2){
        if (j1<0||j1>=m||j2<0||j2>=m){
            return (-1)*((int)1e9);
        }
        if (i==n-1){
            if (j1==j2){
                return matrix[i][j1];
            }
            else {
                return matrix[i][j1]+matrix[i][j2];
            }
        }
        int maxi=0;
        for (int k=-1;k<=1;k++){
            for (int l=-1;l<=1;l++){
                if (j1==j2){
                    maxi=Math.max(maxi,matrix[i][j1]+recursion(matrix,n,m,i+1,j1+k,j2+l));
                }
                else {
                    maxi=Math.max(maxi,matrix[i][j1]+matrix[i][j2]+recursion(matrix,n,m,i+1,j1+k,j2+l));
                }
            }
        }
        return maxi;
    }
    public static int tabulation(int n,int m,int[][] grid){
        int[][][] dp=new int[n][m][m];
        for(int j1=0;j1<m;j1++){
            for(int j2=0;j2<m;j2++){
                if(j1==j2){
                    dp[n-1][j1][j2]=grid[n-1][j1];
                }
                else{
                    dp[n-1][j1][j2]=grid[n-1][j1]+grid[n-1][j2];
                }
            }
        }
        for(int i=n-2;i>=0;i++){
            for(int j1=0;j1<m;j1++){
                for(int j2=0;j2<m;j2++){
                    int maxi=(-1)*((int)1e9);
                    for (int k=-1;k<=1;k++){
                        for (int l=-1;l<=1;l++){
                            int value=0;
                            if (j1==j2){
                                value=grid[i][j1];
                            }
                            else {
                                value=grid[i][j1]+grid[i][j2];
                            }
                            if (j1+k>=0&&j1+k<m&&j2+l>=0&&j2+l<m){
                                value+=grid[i][j1]+dp[i+1][j1+k][j2+l];
                            }
                            else {
                                value+=(-1)*((int)1e9);
                            }
                            maxi=Math.max(maxi,value);
                        }
                    }
                    dp[i][j1][j2]=maxi;
                }
            }
        }
        return dp[0][0][m-1];
    }
    public static void main(String[] args) {

    }
}
