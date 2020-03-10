package TOTO;

import TOIN.TreeNode;

/**
 * 返回与给定先序遍历 preorder 相匹配的二叉搜索树（binary search tree）的根结点。
 *
 * (回想一下，二叉搜索树是二叉树的一种，其每个节点都满足以下规则，对于 node.left 的任何后代，值总 < node.val，而 node.right 的任何后代，值总 > node.val。此外，先序遍历首先显示节点的值，然后遍历 node.left，接着遍历 node.right。）
 *
 *  
 *
 * 示例：
 *
 * 输入：[8,5,1,7,10,12]
 * 输出：[8,5,10,1,7,null,12]
 *
 *  
 *
 * 提示：
 *
 * 1 <= preorder.length <= 100
 * 先序 preorder 中的值是不同的
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/construct-binary-search-tree-from-preorder-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author UGcris
 * @date 2020/3/6
 **/
public class ConstructBinarySearchTreeFromPreorderTraversal {
    int index=0;

    /**
     * 在题目给的规则上再加一个，右节点不可大于父节点的父节点值，据此递归
     * @param preorder
     * @return
     */
    public TreeNode bstFromPreorder(int[] preorder) {
        TreeNode root=new TreeNode(preorder[index++]);
        build(root,preorder,Integer.MAX_VALUE);
        return root;
    }

    private void build(TreeNode root,int[] preorder,int maxNum) {
        if(index<preorder.length&&preorder[index]<root.val){
            TreeNode left=new TreeNode(preorder[index++]);
            root.left=left;
            build(left,preorder,root.val);
        }
        if(index<preorder.length&&preorder[index]>root.val&&preorder[index]<maxNum){
            TreeNode right=new TreeNode(preorder[index++]);
            root.right=right;
            build(right,preorder,maxNum);
        }
    }
}
