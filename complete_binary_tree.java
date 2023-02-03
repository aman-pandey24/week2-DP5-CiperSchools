package CP;

public class complete_binary_tree {
    public static class treenode1{
        int data;
        treenode1 left;
        treenode1 right;
        treenode1(int data){
            this.data=data;
        }
    }
    public static boolean isfullBinaryTree(treenode1 root){
        if (root.left==null&&root.right==null){
            return true;
        }
        if (root.left!=null&&root.right!=null){
            boolean isleftFullBinaryTree=isfullBinaryTree(root.left);
            boolean isrightFullBinaryTree=isfullBinaryTree(root.right);
            return isleftFullBinaryTree&&isrightFullBinaryTree;
        }
        return false;
    }
    public static int countnode(treenode1 root){
        if (root==null){
            return 0;
        }
        int leftnodes=countnode(root.left);
        int rightnode=countnode(root.right);
        return 1+leftnodes+rightnode;
    }
    public static boolean completeBinaryTree(treenode1 root,int index,int numberofNodes){
        if (root==null){
            return true;
        }
        if (index>=numberofNodes){
            return false;
        }
        boolean leftCompletetree=completeBinaryTree(root.left,2*index+1,numberofNodes);
        boolean rightCompletetree=completeBinaryTree(root.right,2*index+2,numberofNodes);
        return leftCompletetree&&rightCompletetree;
    }
    public static boolean isCompleteBinaryTree(treenode1 root){
        return completeBinaryTree(root,0,countnode(root));
    }
    public static void main(String[] args) {
        treenode1 root=new treenode1(1);
        root.left=new treenode1(2);
        root.right=new treenode1(3);
        root.left.left=new treenode1(4);
        root.left.right=new treenode1(5);
        root.left.left.right=new treenode1(6);
        root.left.left.left=new treenode1(7);
        System.out.println(isfullBinaryTree(root));

    }
}
