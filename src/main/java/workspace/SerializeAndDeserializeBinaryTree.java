package workspace;

import TOIN.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 序列化是将一个数据结构或者对象转换为连续的比特位的操作，进而可以将转换后的数据存储在一个文件或者内存中，同时也可以通过网络传输到另一个计算机环境，采取相反方式重构得到原数据。
 *
 * 请设计一个算法来实现二叉树的序列化与反序列化。这里不限定你的序列 / 反序列化算法执行逻辑，你只需要保证一个二叉树可以被序列化为一个字符串并且将这个字符串反序列化为原始的树结构。
 *
 * 示例: 
 *
 * 你可以将以下二叉树：
 *
 *     1
 *    / \
 *   2   3
 *      / \
 *     4   5
 *
 * 序列化为 "[1,2,3,null,null,4,5]"
 * 提示: 这与 LeetCode 目前使用的方式一致，详情请参阅 LeetCode 序列化二叉树的格式。你并非必须采取这种方式，你也可以采用其他的方法解决这个问题。
 *
 * 说明: 不要使用类的成员 / 全局 / 静态变量来存储状态，你的序列化和反序列化算法应该是无状态的。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/serialize-and-deserialize-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author UGcris
 * @date 2020/6/16
 */

public class SerializeAndDeserializeBinaryTree {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(null==root) return "[]";
        List<TreeNode> list=new ArrayList<>();
        list.add(root);
        return new StringBuffer("[").append(find(list).substring(1)).append("]").toString();
    }

    private String find(List<TreeNode> list) {
        if(list.isEmpty()) return "";
        StringBuffer ans=new StringBuffer();
        List<TreeNode> subList=new ArrayList<>();
        for (TreeNode node:list) {
            if(null==node){
                ans.append(",null");
            }else {
                ans.append(",").append(node.val);
                subList.add(node.left);
                subList.add(node.right);
            }
        }
        ans.append(find(subList));
        return ans.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.length()<3) return null;
        String[] split=data.substring(1,data.length()-1).split(",");
        TreeNode root=new TreeNode(Integer.valueOf(split[0]));
        List<TreeNode> list=new ArrayList<>();
        list.add(root);
        build(list,split,1);
        return root;
    }

    private void build(List<TreeNode> list, String[] split, int index) {
        if(list.isEmpty()||index>=split.length) return;
        List<TreeNode> subList=new ArrayList<>();
        for (TreeNode root:list) {
            if(!"null".equals(split[index])){
                TreeNode left=new TreeNode(Integer.valueOf(split[index]));
                root.left=left;
                subList.add(left);
            }
            index++;
            if(!"null".equals(split[index])){
                TreeNode right=new TreeNode(Integer.valueOf(split[index]));
                root.right=right;
                subList.add(right);
            }
            index++;
        }
        build(subList,split,index);
    }
}

