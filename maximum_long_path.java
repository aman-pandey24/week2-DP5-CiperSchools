package CP;

import java.util.ArrayList;

public class maximum_long_path {
    public static class treenode{
        int data;
        treenode left;
        treenode right;

        treenode(int data){
            this.data=data;
        }
    }
    public static int height(treenode root){
        if (root==null){
            return 0;
        }
        int left=1+height(root.left);
        int right=1+height(root.right);
        return Math.max(left,right);
    }
    public static int diameter(treenode root){
        int[] res=new int[1];
        h(root,res);
        return res[0]-1;
    }
    public static int h(treenode root,int[] res){
        if(root==null){
            return 0;
        }
        int left=h(root.left,res);
        int right=h(root.right,res);
        res[0]=Math.max(res[0],1+left+right);
        return 1+Math.max(left,right);
    }
    public static ArrayList<Integer> max_length(treenode root){
        ArrayList<Integer> path=new ArrayList<>();
        path.add(root.data);
        ArrayList<Integer> leftpath=max_length(root.left);
        ArrayList<Integer> rightpath=max_length(root.right);
        ArrayList<Integer> result=getMax(leftpath,rightpath);
        if (result!=null){
            path.addAll(result);
        }
        return path;
    }
    public static ArrayList<Integer> getMax(ArrayList<Integer> leftpath,ArrayList<Integer> rightpath){
        if (leftpath.size()==0&&rightpath.size()==0){
            return null;
        }
        if (leftpath==null){
            return rightpath;
        }
        if (rightpath==null){
            return leftpath;
        }
        if (leftpath.size()>rightpath.size()){
            return leftpath;
        }
        else {
            return rightpath;
        }

    }
    public static void main(String[] args) {
        treenode root=new treenode(1);
        root.left=new treenode(2);
        root.right=new treenode(3);
        root.left.left=new treenode(4);
        root.left.right=new treenode(5);
        root.left.right.right=new treenode(6);
        root.left.right.right.left=new treenode(7);
        System.out.println(height(root));
    }
}
