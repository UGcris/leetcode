package AONE;

import TOTO.Node;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个 N 叉树，返回其节点值的前序遍历。
 *
 * 例如，给定一个 3叉树 :
 *
 *
 *
 *
 *
 *
 *
 * 返回其前序遍历: [1,3,5,6,2,4]。
 * @Author UGcris
 * @date 2020/6/2
 **/
public class NAryTreePreorderTraversal {
    public List<Integer> preorder(Node root) {
        List<Integer> ans=new ArrayList<>();
        if(null!=root){
            ans.add(root.val);
            if(null!=root.children){
                for (Node child:root.children) {
                    ans.addAll(preorder(child));
                }
            }
        }
        return ans;
    }
}
