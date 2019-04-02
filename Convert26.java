/*
输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。要求不能创建任何新的结点，只能调整树中结点指针的指向。
 */
public class Convert26 {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }

    public TreeNode Convert(TreeNode pRootOfTree) {
//        TreeNode pLastNode = null;
//        ConvertNode(pRootOfTree , pLastNode);
//        TreeNode pHeadOfList = pLastNode;
//        while (pHeadOfList != null && pHeadOfList.left != null)
//            pHeadOfList = pHeadOfList.left;
//        return pHeadOfList;
//    }
//
//    public void ConvertNode(TreeNode pRootOfTree, TreeNode pLastNode){
//        if (pRootOfTree == null) return;
//        TreeNode pCurrent = pRootOfTree;
//        if (pCurrent.left != null) ConvertNode(pCurrent.left, pLastNode);
//        pCurrent.left = pLastNode;
//        if (pLastNode != null) pLastNode.right = pCurrent;
//        pLastNode = pCurrent;
//        if (pCurrent.right != null) ConvertNode(pCurrent.right, pLastNode);
        if(pRootOfTree==null)return null;
        if(pRootOfTree.left==null&&pRootOfTree.right==null)return pRootOfTree;
        TreeNode left=Convert(pRootOfTree.left);
        TreeNode p=left;
        while(p!=null&&p.right!=null)
        {
            p=p.right;
        }
        if(left!=null)
        {
            p.right=pRootOfTree;
            pRootOfTree.left=p;
        }
        TreeNode right=Convert(pRootOfTree.right);
        if(right!=null)
        {
            pRootOfTree.right=right;
            right.left=pRootOfTree;
        }

        return  left!=null?left:pRootOfTree;
    }
}
