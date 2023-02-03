package CP;

public class coin_distribution {
    private static class treenode3{
        int data;
        treenode3 left;
        treenode3 right;
        treenode3(int data){
            this.data=data;
        }
    }
    static int res = 0;
    public static int distributeCoins(treenode3 root) {
        dfs(root);
        return res;
    }

    public static int dfs(treenode3 root) {
        if (root == null) return 0;
        int left = dfs(root.left), right = dfs(root.right);
        res += Math.abs(left) + Math.abs(right);
        return root.data + left + right - 1;
    }
    public static void main(String[] args) {

    }
}
