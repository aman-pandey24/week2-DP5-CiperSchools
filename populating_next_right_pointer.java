package CP;

public class populating_next_right_pointer {
    private static class treenode3{
        int data;
        treenode3 left;
       treenode3 right;
       treenode3 next;
        treenode3(int data){
            this.data=data;
        }
    }
    public void connect(treenode3 root) {
        treenode3 level_start=root;
        while(level_start!=null){
            treenode3 cur=level_start;
            while(cur!=null){
                if(cur.left!=null) cur.left.next=cur.right;
                if(cur.right!=null && cur.next!=null) cur.right.next=cur.next.left;

                cur=cur.next;
            }
            level_start=level_start.left;
        }
    }
    public static void main(String[] args) {

    }
}
