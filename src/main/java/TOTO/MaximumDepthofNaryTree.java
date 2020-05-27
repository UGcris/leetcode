package TOTO;

import java.util.List;

/**
 * 给定一个 N 叉树，找到其最大深度。
 *
 * 最大深度是指从根节点到最远叶子节点的最长路径上的节点总数。
 *
 * 例如，给定一个 3叉树 :
 *
 *  
 *
 *
 *
 *  
 *
 * 我们应返回其最大深度，3。
 *
 * 说明:
 *
 * 树的深度不会超过 1000。
 * 树的节点总不会超过 5000。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-depth-of-n-ary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author UGcris
 * @date 2020/4/20
 **/
public class MaximumDepthofNaryTree {
    public int maxDepth(Node root) {
        int ans=0;
        if(null!=root){
            ans++;
            int step=0;
            List<Node> children=root.children;
            if(null!=children&&children.size()>0){
                for (Node child:children) {
                    step=Math.max(step,maxDepth(child));
                }
            }
            ans+=step;
        }
        return ans;
    }
    public int maxDepth2(Node root) {
        if (null == root) {
            return 0;
        }
        if(root.children.isEmpty()) {
            return 1;
        }
        int maxDepth = 0;
        for(Node node : root.children) {
            maxDepth = Math.max(maxDepth, maxDepth(node));
        }
        return maxDepth + 1;
    }
}
