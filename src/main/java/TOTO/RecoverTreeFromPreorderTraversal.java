package TOTO;

import TOIN.TreeNode;

/**
 * 我们从二叉树的根节点 root 开始进行深度优先搜索。
 *
 * 在遍历中的每个节点处，我们输出 D 条短划线（其中 D 是该节点的深度），然后输出该节点的值。（如果节点的深度为 D，则其直接子节点的深度为 D + 1。根节点的深度为 0）。
 *
 * 如果节点只有一个子节点，那么保证该子节点为左子节点。
 *
 * 给出遍历输出 S，还原树并返回其根节点 root。
 *
 *  
 *
 * 示例 1：
 *
 *
 *
 * 输入："1-2--3--4-5--6--7"
 * 输出：[1,2,5,3,4,6,7]
 * 示例 2：
 *
 *
 *
 * 输入："1-2--3---4-5--6---7"
 * 输出：[1,2,5,3,null,6,null,4,null,7]
 * 示例 3：
 *
 *
 *
 * 输入："1-401--349---90--88"
 * 输出：[1,401,null,349,88,90]
 *  
 *
 * 提示：
 *
 * 原始树中的节点数介于 1 和 1000 之间。
 * 每个节点的值介于 1 和 10 ^ 9 之间。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/recover-a-tree-from-preorder-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author UGcris
 * @date 2020/2/29
 **/
public class RecoverTreeFromPreorderTraversal {
    /**
     * 递归遍历
     * @param s
     * @return
     */
    public TreeNode recoverFromPreorder(String s) {
        StringBuffer str=new StringBuffer(s);
        return next(str,"");
    }
    private TreeNode next(StringBuffer s, String prefix) {
        if(s.length()>0&&s.toString().startsWith(prefix)){
            s.delete(0,s.indexOf(prefix)+prefix.length());
            String suffix=prefix+"-";
            if(s.indexOf("-")>0){
                String num=s.substring(0,s.indexOf("-"));
                s.delete(0,s.indexOf("-"));
                TreeNode root=new TreeNode(Integer.valueOf(num));
                System.out.println(s+"/left");
                root.left=next(s,suffix);
                System.out.println(s+"/right");
                root.right=next(s,suffix);
                return root;
            }else{
                TreeNode root=new TreeNode(Integer.valueOf(s.toString()));
                return root;
            }
        }
        return null;
    }

    /**
     * 优化1：全局变量记录index；string转num的方式
     * @param s
     * @return
     */
    public TreeNode recoverFromPreorder2(String s) {
        return next2(s,"");
    }

    int index=0;//遍历节点
    private TreeNode next2(String s,String prefix) {
        if(s.length()<=index){
            return null;
        }
        for (int i = 0; i < prefix.length(); i++) {
            if(s.charAt(index+i)!='-'){
                return null;
            }
        }
        index+=prefix.length();
        int num=0;
        while (s.length()>index&&s.charAt(index)!='-'){
            num=num*10+s.charAt(index++)-'0';
        }
        TreeNode root =new TreeNode(num);
        root.left=next2(s,prefix+"-");
        root.right=next2(s,prefix+"-");
        return root;
    }
}
