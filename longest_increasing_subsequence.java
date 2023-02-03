package DYNAMICprogrammin;

public class longest_increasing_subsequence {
    public static int LIS(int[] arr,int n){
        int[] lis=new int[n];
        lis[0]=1;
        for (int i=1;i<n;i++){
            lis[i]=1;
            for (int j=0;j<i;j++){
                if (arr[j]<arr[i]){
                    lis[i]=Math.max(lis[i],lis[j]+1);
                }
            }
        }
        int result=lis[0];
        for (int i=1;i<n;i++){
            result=Math.max(result,lis[i]);
        }
        return result;
    }
    public static int lis_binarySearch(int[]arr,int n){
        int[] tail=new int[n];
        int length=1;
        tail[0]=arr[0];
        for (int i=1;i<n;i++){
            if (arr[i]>tail[length-1]){
                tail[length]=arr[i];
                length++;
            }
            else {
                int c=findCeilINdex(tail,0,length-1,arr[i]);
                tail[c]=arr[i];
            }
        }
        return length;
    }
    public static int findCeilINdex(int[] tail,int start,int end,int target){
        while (end>start){
            int mid=start+((end-start)/2);
            if (tail[mid]>=target){
                end=mid;
            }
            else {
                start=mid+1;
            }
        }
        return end;
    }
    public static void main(String[] args) {
        int[] arr={3,10,20,4,6,7};
        int n=arr.length;
        System.out.println("i am dynamic "+LIS(arr,n));
        System.out.println("i am binary search "+lis_binarySearch(arr,n));
    }
}
