/*
输入某二叉树的前序遍历和中序遍历的结果，
请重建出该二叉树。假设输入的前序遍历和中
序遍历的结果中都不含重复的数字。例如输入
前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历
序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
 */



public class ReConstructBinaryTree4 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public static void bianli(TreeNode tree){
        System.out.println(tree.val);
        if (tree.left != null) bianli(tree.left);
        if (tree.right != null) bianli(tree.right);
    }
    public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        TreeNode root = new TreeNode(pre[0]);
        int len = pre.length;

        if(len == 1){
            root.left = null;
            root.right = null;
            return root;
        }

        int rootval  = root.val,i;
        for(i=0; i< len; i++){
            if (in[i] == rootval)
                break;
        }

        if (i>0) {
            int[] pree = new int[i];
            int[] inn = new int[i];

            for (int j = 0;j < i;j++) {
                pree[j] = pre[j + 1];
                inn[j] = in[j];
            }
            root.left = reConstructBinaryTree(pree ,in );
        }else{
            root.left = null;
        }

        if (len - i - 1 > 0){
            int[] pree = new int[len-i-1];
            int[] inn = new int[len-i-1];

            for (int j = i+1 ;j < len ;j++){
                pree[j-i-1] = pre[j];
                inn[j-i-1] = pre[j];
            }
            root.right = reConstructBinaryTree(pree ,inn);
        }else {
            return root;
        }
        return root;
    }

    public static void main(String[] args) {
        ReConstructBinaryTree4 bt4 = new ReConstructBinaryTree4();
        int[] a ={1,2,4,7,3,5,6,8};
        int[] b = {4,7,2,1,5,3,8,6};
        TreeNode root = bt4.reConstructBinaryTree(a,b);
        bianli(root);
    }
}
