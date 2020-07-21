package D202007;

import TOIN.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个整数 n，生成所有由 1 ... n 为节点所组成的 二叉搜索树 。
 * <p>
 *  
 * <p>
 * 示例：
 * <p>
 * 输入：3
 * 输出：
 * [
 *   [1,null,3,2],
 *   [3,2,null,1],
 *   [3,1,null,null,2],
 *   [2,1,3],
 *   [1,null,2,null,3]
 * ]
 * 解释：
 * 以上的输出对应以下 5 种不同结构的二叉搜索树：
 * <p>
 * 1         3     3      2      1
 * \       /     /      / \      \
 * 3     2     1      1   3      2
 * /     /       \                 \
 * 2     1         2                 3
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/unique-binary-search-trees-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @Author UGcris
 * @date 2020/7/21
 **/
public class UniqueBinarySearchTreesII {
    public List<TreeNode> generateTrees(int n) {
        List<TreeNode> list = new ArrayList<>();
        if(n==0) return list;
        int index = 1;
        list.add(new TreeNode(index));
        while (index < n) {
            index++;
            List<TreeNode> preList = new ArrayList<>();
            for (TreeNode node : list) {
                List<TreeNode> rightNodeList=find(node,index);
                preList.addAll(rightNodeList);
            }
            list = preList;
        }
        return list;
    }

    private List<TreeNode> find(TreeNode root, int index) {
        List<TreeNode> ans = new ArrayList<>();
        if (null != root.right) {
            List<TreeNode> rightNodeList = find(root.right, index);
            for (TreeNode node : rightNodeList) {
                ans.add(new TreeNode(root.val, root.left, node));
            }
        }else {
            ans.add(new TreeNode(root.val, root.left, new TreeNode(index)));
        }
        ans.add(new TreeNode(index, root, null));
        return ans;
    }
}
