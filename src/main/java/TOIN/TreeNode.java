package TOIN;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author UGcris
 * @date 2019/11/4
 **/
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode() {
    }

    public TreeNode(int x) {
        val = x;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
    public static TreeNode builder() {
        return new TreeNode();
    }
    public TreeNode preorder(Integer[] nodes) {
        int idx=0;
        TreeNode root=new TreeNode(nodes[idx++]);
        preorder(root,nodes,idx);
        return root;
    }
    private static int preorder(TreeNode root, Integer[] integers, int idx) {
        if(null==root) return idx;
        root.left=build(idx>=integers.length?null:integers[idx++]);
        root.right=build(idx>=integers.length?null:integers[idx++]);
        idx=preorder(root.left,integers,idx);
        idx=preorder(root.right,integers,idx);
        return idx;
    }
    private static TreeNode build(Integer integer) {
        if(null==integer) return null;
        return new TreeNode(integer);
    }
    /**
     * 前序遍历
     *
     * @return
     */
    public List<Integer> preorderTraversal() {
        List<Integer> result = new ArrayList<>();
        preorder(this, result);
        return result;
    }

    private void preorder(TreeNode node, List<Integer> result) {
        if (node == null) return;
        result.add(node.val);         // 访问根节点
        preorder(node.left, result);  // 递归左子树
        preorder(node.right, result); // 递归右子树
    }
}
