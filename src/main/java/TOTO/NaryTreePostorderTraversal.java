package TOTO;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个 N 叉树，返回其节点值的后序遍历。
 *
 * 例如，给定一个 3叉树 :
 *
 *  
 *
 *
 *
 *  
 *
 * 返回其后序遍历: [5,6,3,2,4,1].
 *
 *  
 *
 * 说明: 递归法很简单，你可以使用迭代法完成此题吗?
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/n-ary-tree-postorder-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author UGcris
 * @date 2020/4/26
 **/
public class NaryTreePostorderTraversal {
    public List<Integer> postorder(Node root) {
        List<Integer> ans=new ArrayList<>();
        if(null!=root){
            if(null!=root.children){
                root.children.forEach(node->ans.addAll(postorder(node)));
            }
            ans.add(root.val);
        }
        return ans;
    }


    private List<Integer> answer=new ArrayList<>();
    public List<Integer> postorder2(Node root) {
        find(root);
        return answer;
    }
    private void find(Node root) {
        if(null==root) return;
        root.children.forEach(node->find(node));
        answer.add(root.val);
    }
}
