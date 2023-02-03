package CP;

public class deleteNode {
    private static class treenode3{
        int data;
        treenode3 left;
        treenode3 right;
        treenode3(int data){
            this.data=data;
        }
    }
    public static int max(treenode3 root){
        while (root.right!=null){
            root=root.right;
        }
        return root.data;
    }
    private static treenode3 delete_node(treenode3 root,int deletekey){
        if (deletekey<root.data){
            delete_node(root.left,deletekey);
        }
        else if(deletekey>root.data){
            delete_node(root.right,deletekey);
        }
        else {
            if (root.left!=null&&root.right!=null){
                int leftMax=max(root.left);
                root.data=leftMax;
                root.left=delete_node(root.left,deletekey);
                return root;
            }
            else if (root.left!=null){
                return root.left;
            }
            else if (root.right!=null){
                return root.right;
            }
        }
        return null;
    }
   protected static class binarysearch{
        treenode3 root;
        binarysearch(){
            root=null;
        }
        public boolean search(treenode3 node, int key){
            if (node==null){
                return false;
            }
            if (key==node.data){
                return true;
            }
            if (key<node.data){
                return search(node.left,key);
            }
            else {
                return search(node.right,key);
            }
        }
    }
    public static void main(String[] args) {
        binarysearch sc=new binarysearch();
        sc.root=new treenode3(15);
        sc.root.left=new treenode3(10);
        sc.root.right=new treenode3(18);
        sc.root.left.left=new treenode3(5);
        sc.root.left.right=new treenode3(8);
        sc.root.right.right=new treenode3(20);
        sc.root.right.left=new treenode3(16);
    }
}
