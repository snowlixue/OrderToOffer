/*
输入一颗二叉树的跟节点和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。
路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。(注意: 在返
回值的list中，数组长度大的数组靠前)
 */

import java.util.ArrayList;

public class FindPath24 {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }
//    private ArrayList<ArrayList<Integer>> listAll = new ArrayList<ArrayList<Integer>>();
//    private ArrayList<Integer> list = new ArrayList<Integer>();
//    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root,int target) {
//        if(root == null) return listAll;
//        list.add(root.val);
//        target -= root.val;
//        if(target == 0 && root.left == null && root.right == null)
//            listAll.add(new ArrayList<Integer>(list));
//        FindPath(root.left, target);
//        FindPath(root.right, target);
//        list.remove(list.size()-1);
//        return listAll;
//    }

    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root,int target) {
        ArrayList<ArrayList<Integer>> arr=new ArrayList<ArrayList<Integer>>();
        if(root==null)
            return arr;
        ArrayList<Integer> a1=new ArrayList<Integer>();
        int sum=0;
        pa(root,target,arr,a1,sum);
        return arr;
    }
    public void pa(TreeNode root,int target,ArrayList<ArrayList<Integer>> arr, ArrayList<Integer> a1,int sum){
        if(root==null)
            return ;
        sum+=root.val;

        if(root.left==null&&root.right==null){
            if(sum==target)
            { a1.add(root.val);
                arr.add(new ArrayList<Integer>(a1));
                a1.remove(a1.size()-1);
            }
            return ;
        }
        a1.add(root.val);
        pa(root.left,target,arr,a1,sum);
        pa(root.right,target,arr,a1,sum);
        a1.remove(a1.size()-1);
    }
}
