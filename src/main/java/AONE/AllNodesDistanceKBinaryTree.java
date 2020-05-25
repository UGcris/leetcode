package AONE;

import TOIN.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个二叉树（具有根结点 root）， 一个目标结点 target ，和一个整数值 K 。
 *
 * 返回到目标结点 target 距离为 K 的所有结点的值的列表。 答案可以以任何顺序返回。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：root = [3,5,1,6,2,0,8,null,null,7,4], target = 5, K = 2
 *
 * 输出：[7,4,1]
 *
 * 解释：
 * 所求结点为与目标结点（值为 5）距离为 2 的结点，
 * 值分别为 7，4，以及 1
 *
 *
 *
 * 注意，输入的 "root" 和 "target" 实际上是树上的结点。
 * 上面的输入仅仅是对这些对象进行了序列化描述。
 *  
 *
 * 提示：
 *
 * 给定的树是非空的，且最多有 K 个结点。
 * 树上的每个结点都具有唯一的值 0 <= node.val <= 500 。
 * 目标结点 target 是树上的结点。
 * 0 <= K <= 1000.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/all-nodes-distance-k-in-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author UGcris
 * @date 2020/5/6
 **/
public class AllNodesDistanceKBinaryTree {
    /**
     *找寻唯一节点，节点的距离如何查询距离
     * @param root
     * @param target
     * @param K
     * @return
     */
    List<Integer> ans=new ArrayList<>();
    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        //1.向下寻找到target后没搜索到便无需寻找其他分支
        build(root,target,K);
        return ans;
    }

    private int build(TreeNode root, TreeNode target, int distance) {
        if(null==root){
            return distance+1;
        }
        if(root.val==target.val){
            build(root,distance);
            return 1;
        }
        int left=build(root.left,target,distance);
        int right=build(root.right,target,distance);
        if(left==distance||right==distance){
            ans.add(root.val);
        }else if(left<distance){
            build(root.right,distance-left-1);
        }else if(right<distance){
            build(root.left,distance-right-1);
        }
        return Math.min(left,right)+1;
    }

    private void build(TreeNode root, int distance) {
        if(null!=root){
            if (0==distance){
                ans.add(root.val);
            }else{

                build(root.left,distance-1);
                build(root.right,distance-1);
            }
        }
    }

}
