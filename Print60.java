/*
从上到下按层打印二叉树，同一层结点从左至右输出。每一层输出一行。
 */

import java.util.ArrayList;
import java.util.ArrayDeque;
public class Print60 {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }
    ArrayList<ArrayList<Integer> > Print(TreeNode pRoot) {
        ArrayDeque<TreeNode> arrayDeque = new ArrayDeque<>();
        ArrayList<ArrayList<Integer>> arrayLists = new ArrayList<>();
        if (pRoot == null) return arrayLists;
        else arrayDeque.addLast(pRoot);
        TreeNode tag = new TreeNode(-1);
        arrayDeque.addLast(tag);
        while (arrayDeque.size() != 0) {
            ArrayList<Integer> arrayList = new ArrayList<>();
            while (arrayDeque.getFirst() != tag && arrayDeque.size() != 0) {
                TreeNode treeNode = arrayDeque.pollFirst();
                if (treeNode.left != null) arrayDeque.addLast(treeNode.left);
                if (treeNode.right != null) arrayDeque.addLast(treeNode.right);
                arrayList.add(treeNode.val);
            }
            arrayLists.add(arrayList);
            if (arrayDeque.size() != 1) {
                arrayDeque.pollFirst();
                arrayDeque.addLast(tag);
            } else break;
        }
        return arrayLists;
    }
}
