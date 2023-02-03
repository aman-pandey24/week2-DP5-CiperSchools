package CP;

public class perfect_binarytree {
    public static class treenode2{
        int data;
        treenode2 left;
        treenode2 right;

        treenode2(int data){
            this.data=data;
        }
    }
    public static int findADepth(treenode2 node)
    {
        int d = 0;
        while (node != null)
        {
            d++;
            node = node.left;
        }
        return d;
    }
    static boolean isPerfectRec(treenode2 root, int d, int level)
    {
        if (root == null) {
            return true;
        }
        if (root.left == null && root.right == null)
            return (d == level+1);
        if (root.left == null || root.right == null)
            return false;
        return isPerfectRec(root.left, d, level+1) && isPerfectRec(root.right, d, level+1);
    }
    static boolean isPerfect(treenode2 root)
    {
        int d = findADepth(root);
        return isPerfectRec(root, d, 0);
    }
    public static void main(String[] args) {
        treenode2 root=new treenode2(1);
        root.left=new treenode2(2);
        root.right=new treenode2(3);
        root.left.left=new treenode2(4);
        root.left.right=new treenode2(5);
        root.left.right.right=new treenode2(6);
        root.left.right.right.left=new treenode2(7);
        if (isPerfect(root) == true)
            System.out.println("Yes");
        else
            System.out.println("No");
    }
}
