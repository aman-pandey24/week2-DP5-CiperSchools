package CP;
import java.util.*;
public class Recovery_of_BST {
    protected static class TreeNode{
        int data;
        TreeNode left;
        TreeNode right;
        TreeNode(int data){
            this.data=data;
        }
    }
    ArrayList<Integer> a=new ArrayList<>();
    int i=0;
    public void recoverTree(TreeNode root) {
        inorder(root);
        Collections.sort(a);
        correct(root);
    }
    public void inorder(TreeNode root){
        if(root==null)
        {
            return;
        }
        inorder(root.left);
        a.add(root.data);
        inorder(root.right);
    }
    public void correct(TreeNode root)
    {
        if(root==null) return;
        if(root!=null)
        {
            correct(root.left);
            if(root.data!=a.get(i))
            {
                root.data=a.get(i);
            }
            i++;
            correct(root.right);
        }
    }
    protected  static void main(String[] args) {

    }
}
