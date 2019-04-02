import sun.reflect.generics.tree.Tree;

/*
请实现一个函数，用来判断一颗二叉树是不是对称的。注意，如果一个二叉树同此二叉树的镜像是同样的，定义其为对称的。
 */
import java.util.ArrayList;
public class IsSymmetrical58 {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }
//
//    public static ArrayList<Integer> arrayList1 = new ArrayList<>();
//    public static ArrayList<Integer> arrayList2 = new ArrayList<>();
//    public static void Preorder(TreeNode pRoot){
//        arrayList1.add(pRoot.val);
//        if (pRoot.left != null) Preorder(pRoot.left);
//        if (pRoot.right != null) Preorder(pRoot.right);
//    }
//
//    public static void Afterorder(TreeNode pRoot){
//        arrayList2.add(pRoot.val);
//        if (pRoot.right != null) Preorder(pRoot.right);
//        if (pRoot.left != null)  Preorder(pRoot.left);
//    }
//
//    boolean isSymmetrical(TreeNode pRoot)
//    {
//        TreeNode p = pRoot;
//        Preorder(pRoot);
//        Afterorder(p);
//        return arrayList1.equals(arrayList2);
//    }

    boolean isSymmetrical(TreeNode pRoot)
    {
        if(pRoot == null){
            return true;
        }
        return comRoot(pRoot.left, pRoot.right);
    }
    private boolean comRoot(TreeNode left, TreeNode right) {
        // TODO Auto-generated method stub
        if(left == null) return right==null;
        if(right == null) return false;
        if(left.val != right.val) return false;
        return comRoot(left.right, right.left) && comRoot(left.left, right.right);
    }
}
