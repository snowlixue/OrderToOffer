/*
输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）
 */


import sun.reflect.generics.tree.Tree;

public class HasSubtree17 {

    //树的结构
    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;
        public TreeNode(int val) {
            this.val = val;
        }

        /**   增加左子节点
         * addLeft:
         * @param value
         * void  返回类型
         */
        public void addLeft(int value){
            TreeNode leftChild = new TreeNode(value);
            this.left = leftChild;
        }
        /**
         * addRight: 增加右子节点
         * @param value
         * void  返回类型
         */
        public void addRight(int value){
            TreeNode rightChild = new TreeNode(value);
            this.right = rightChild;
        }
    }

    //前中序列构建二叉树
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

    //前序遍历树
    public static void preOrderTravel(TreeNode root){
        if (root == null) {
            return;
        }
        System.out.println(root);
        preOrderTravel(root.left);
        preOrderTravel(root.right);
    }


    public static boolean HasSubtree(TreeNode root1,TreeNode root2) {
        boolean result = false;
        if (root1 != null && root2 != null){
            if (root1.val == root2.val)
                result = DoesTree1HaveTree2(root1,root2);
            if (!result) {
                result = HasSubtree(root1.left, root2);
                if (!result)
                    return true;
                result = HasSubtree(root1.right, root2);
            }
//            if (!result)
//                result = HasSubtree(root1.left,root2);
//            if (!result)
//                result = HasSubtree(root1.right,root2);

        }
        return result;
    }

    public static boolean DoesTree1HaveTree2(TreeNode root1,TreeNode root2){
        if (root2 == null) return true;
        if (root1 == null) return false;
        if (root1.val != root2.val) return false;
        return DoesTree1HaveTree2(root1.left,root2.left)&&DoesTree1HaveTree2(root1.right,root2.right);
    }

}
