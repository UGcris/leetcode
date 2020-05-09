package TOTO;

import TOIN.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @Author UGcris
 * @date 2020/3/10
 **/
public class BinaryTreeZigzagLevelOrderTraversal {
    /**
     * 每层遍历，奇数层reverse
     * @param root
     * @return
     */
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans=new ArrayList<>();
        if(null!=root){
            List<TreeNode> list= Arrays.asList(root);
            next(list,ans,0);
        }
        return ans;
    }
    private void next(List<TreeNode> rootList, List<List<Integer>> ans, int index) {
        List<Integer> list=new ArrayList<>();
        List<TreeNode> subList=new ArrayList<>();
        for (TreeNode node:rootList) {
            if(null!=node.left)subList.add(node.left);
            if(null!=node.right)subList.add(node.right);
            list.add(node.val);
        }
        if(index%2==1){
            Collections.reverse(list);
        }
        ans.add(list);
        if(subList.size()>0){
            next(subList,ans,++index);
        }
    }
}
