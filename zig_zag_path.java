package CP;
import java.util.*;
public class zig_zag_path {
    private static class treenode3{
        int data;
        treenode3 left;
        treenode3 right;
        treenode3(int data){
            this.data=data;
        }
    }
    public List<List<Integer>> zigzagLevelOrder(treenode3 root) {
        List<List<Integer>> arr=new ArrayList<>();
        if(root==null){
            return arr;
        }
        Queue<treenode3> q=new LinkedList<>();
        q.add(root);
        boolean flag=true;
        while(!q.isEmpty()){
            int level=q.size();
            List<Integer> temp=new ArrayList<>();
            for(int i=0;i<level;i++){
                treenode3 curr=q.poll();
                if(flag){
                    temp.add(curr.data);
                }
                else{
                    temp.add(0,curr.data);
                }
                if(curr.left!=null){
                    q.add(curr.left);
                }
                if(curr.right!=null){
                    q.add(curr.right);
                }
            }
            flag=!flag;
            arr.add(temp);
        }
        return arr;
    }
    public static void main(String[] args) {

    }
}
