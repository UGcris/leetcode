package TOTO;

import TOIN.TreeNode;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * 给定一颗根结点为 root 的二叉树，书中的每个结点都有一个从 0 到 25 的值，分别代表字母 'a' 到 'z'：值 0 代表 'a'，值 1 代表 'b'，依此类推。
 *
 * 找出按字典序最小的字符串，该字符串从这棵树的一个叶结点开始，到根结点结束。
 *
 * （小贴士：字符串中任何较短的前缀在字典序上都是较小的：例如，在字典序上 "ab" 比 "aba" 要小。叶结点是指没有子结点的结点。）
 *
 *  
 *
 * 示例 1：
 *
 *
 *
 * 输入：[0,1,2,3,4,3,4]
 * 输出："dba"
 * 示例 2：
 *
 *
 *
 * 输入：[25,1,3,1,3,0,2]
 * 输出："adz"
 * 示例 3：
 *
 *
 *
 * 输入：[2,2,1,null,1,0,null,0]
 * 输出："abc"
 *  
 *
 * 提示：
 *
 * 给定树的结点数介于 1 和 8500 之间。
 * 树中的每个结点都有一个介于 0 和 25 之间的值。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/smallest-string-starting-from-leaf
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author UGcris
 * @date 2020/3/12
 **/
public class SmallestStringStartingFromLeaf {
    /**
     * 比较方式错误
     * @param root
     * @return
     */
    public String smallestFromLeaf1(TreeNode root) {
        StringBuffer ans=new StringBuffer();
        List<Integer> list=new ArrayList<>();
        if(null!=root){
            list.add(root.val);
            if(null!=root.left||null!=root.right){
                list.addAll(next(root));
            }
        }
        for (int i = list.size()-1; i >=0; i++) {
            ans.append((char)(list.get(i)+'a'));
        }
        return ans.toString();
    }

    private List<Integer> next(TreeNode root) {
        List<Integer> leftList=new ArrayList<>(),rightList=new ArrayList<>();
        TreeNode left=root.left,right=root.right;
        if(null!=left){
            leftList.add(left.val);
            if(null!=left.left||null!=left.right){
                leftList.addAll(next(left));
            }
        }
        if(null!=right){
            rightList.add(right.val);
            if(null!=right.left||null!=right.right){
                rightList.addAll(next(right));
            }
        }
        if(leftList.isEmpty()){
            return rightList;
        }else if(rightList.isEmpty()){
            return leftList;
        }else {
            int leftSize=leftList.size(),rightSize=rightList.size();
            for (int i = 1; i <=Math.min(leftSize,rightSize) ; i++) {
                if(leftList.get(leftSize-i)>rightList.get(rightSize-i)){
                    return rightList;
                }else if(leftList.get(leftSize-i)>rightList.get(rightSize-i)){
                    return leftList;
                }
            }
            return leftSize>=rightSize?leftList:rightList;
        }
    }

    /**
     * 官方题解
     */
    String ans = "~";
    public String smallestFromLeaf(TreeNode root) {
        dfs(root, new StringBuilder());
        return ans;
    }

    public void dfs(TreeNode node, StringBuilder sb) {
        if (node == null) return;
        sb.append((char)('a' + node.val));

        if (node.left == null && node.right == null) {
            sb.reverse();
            String S = sb.toString();
            sb.reverse();
            System.out.println(S+"-"+ans);
            if (S.compareTo(ans) < 0)
                ans = S;
        }

        dfs(node.left, sb);
        dfs(node.right, sb);
        sb.deleteCharAt(sb.length() - 1);
    }
}
