package TOTO;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个 N 叉树，返回其节点值的层序遍历。 (即从左到右，逐层遍历)。
 *
 * 例如，给定一个 3叉树 :
 *
 *  
 *
 *
 *
 *  
 *
 * 返回其层序遍历:
 *
 * [
 *      [1],
 *      [3,2,4],
 *      [5,6]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/n-ary-tree-level-order-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author UGcris
 * @date 2020/3/11
 **/
public class NaryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrder1(Node root) {
        List<List<Integer>> ans=new ArrayList<>();
        if(null!=root){
            List<Node> nodes=new ArrayList<>();
            nodes.add(root);
            scan(nodes,ans);
        }
        return ans;
    }

    private void scan(List<Node> nodes, List<List<Integer>> ans) {
        List<Node> subList=new ArrayList<>();
        List<Integer> subAns=new ArrayList<>();
        nodes.forEach(node -> {
            subAns.add(node.val);
            if(null!=node.children) subList.addAll(node.children);
        });
        ans.add(subAns);
        if(!subList.isEmpty()){
            scan(subList,ans);
        }
    }

    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> ans=new ArrayList<>();
        if (null!=root){
            scan(root,ans,0);
        }
        return ans;
    }

    private void scan(Node root, List<List<Integer>> ans, int index) {
        if(ans.size()<=index){
            ans.add(new ArrayList<>());
        }
        ans.get(index).add(root.val);
        List<Node> children=root.children;
        if(null!=children&&children.size()>0){
            for (int i = 0; i < children.size(); i++) {
                Node node=children.get(i);
                if(null!=node){
                    scan(node,ans,index);
                }
            }
        }
    }
}
