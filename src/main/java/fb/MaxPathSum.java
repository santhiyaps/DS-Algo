package fb;

 class TreeNode {
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
public class MaxPathSum {
    int max=0;
    public int maxPathSum(TreeNode root) {
        pathSum(root,0);
        return max;
    }
    private void pathSum(TreeNode node,int sum){
        if(node!=null){
            sum+=node.val;
            if(node.left==null && node.right==null){
                max=Math.max(max,sum);
            }else{
                pathSum(node.right,sum);
                pathSum(node.left,sum);
            }
        }
    }

    public static void main(String[] args) {
        TreeNode node=new TreeNode(1);
        node.left=new TreeNode(2);
        node.right=new TreeNode(3);
        MaxPathSum maxPathSum=new MaxPathSum();
        System.out.println(maxPathSum.maxPathSum(node));
    }
}
