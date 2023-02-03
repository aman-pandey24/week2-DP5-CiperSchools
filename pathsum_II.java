package CP;
import java.util.*;
public class pathsum_II {
    public class TreeNode {
        int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result=new ArrayList<>();
        List<Integer> temp=new ArrayList<>();
        f(result,temp,root,sum);
        return result;
    }
    public static void f(List<List<Integer>> result,List<Integer> temp,TreeNode root,int sum){
        if(root==null){
            return ;
        }
        temp.add(root.val);
        if(root.left==null&&root.right==null&&sum==root.val){
            result.add(new ArrayList(temp));
            temp.remove(temp.size()-1);
            return;
        }
        else{
            f(result,temp,root.left,sum-root.val);
            f(result,temp,root.right,sum-root.val);
        }
        temp.remove(temp.size()-1);
    }
    public static void main(String[] args) {

    }
}
