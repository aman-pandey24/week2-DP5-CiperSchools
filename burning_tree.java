package CP;

import java.util.LinkedList;
import java.util.Queue;

public class burning_tree {
    private static class treenode3{
        int data;
        treenode3 left;
        treenode3 right;
        treenode3(int data){
            this.data=data;
        }
    }
    private static Queue<treenode3> queue=new LinkedList<>();
    private static int burning(treenode3 root,int targetNode){
        if (root==null){
            return 0;
        }
        if (root.data==targetNode){
            System.out.println(root.data);
            if (root.left!=null){
                queue.offer(root.left);
            }
            if (root.right!=null){
                queue.offer(root.right);
            }
            return 1;
        }
        int left=burning(root.left,targetNode);
        if (left==1){
            int queuesize=queue.size();
            for (int i=0;i<queuesize;i++){
                treenode3 current=queue.poll();
                System.out.println(current.data);
                if (current.left!=null){
                    queue.offer(current.left);
                }
                if (current.right!=null){
                    queue.offer(current.right);
                }
            }
            if (root.right!=null){
                queue.offer(root.right);
            }
            System.out.println(root.data);
            return 1;
        }
        return 0;
    }
    public static void main(String[] args) {
        treenode3 root=new treenode3(1);
        root.left=new treenode3(2);
        root.right=new treenode3(3);
        root.left.left=new treenode3(4);
        root.left.right=new treenode3(5);
        root.left.right.right=new treenode3(6);
        root.left.right.right.left=new treenode3(7);
        while (!queue.isEmpty()){
            int qsize=queue.size();
            for (int i=0;i<qsize;i++){
                treenode3 curr= queue.poll();
                System.out.println(curr.data+" ");
                if (curr.left!=null){
                    queue.offer(curr.left);
                }
                if (curr.right!=null){
                    queue.offer(curr.right);
                }
            }
            System.out.println();
        }
    }
}
