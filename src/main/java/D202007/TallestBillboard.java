package D202007;

import java.util.Arrays;

/**
 * 你正在安装一个广告牌，并希望它高度最大。这块广告牌将有两个钢制支架，两边各一个。每个钢支架的高度必须相等。
 * <p>
 * 你有一堆可以焊接在一起的钢筋 rods。举个例子，如果钢筋的长度为 1、2 和 3，则可以将它们焊接在一起形成长度为 6 的支架。
 * <p>
 * 返回广告牌的最大可能安装高度。如果没法安装广告牌，请返回 0。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：[1,2,3,6]
 * 输出：6
 * 解释：我们有两个不相交的子集 {1,2,3} 和 {6}，它们具有相同的和 sum = 6。
 * 示例 2：
 * <p>
 * 输入：[1,2,3,4,5,6]
 * 输出：10
 * 解释：我们有两个不相交的子集 {2,3,5} 和 {4,6}，它们具有相同的和 sum = 10。
 * 示例 3：
 * <p>
 * 输入：[1,2]
 * 输出：0
 * 解释：没法安装广告牌，所以返回 0。
 *  
 * <p>
 * 提示：
 * <p>
 * 0 <= rods.length <= 20
 * 1 <= rods[i] <= 1000
 * 钢筋的长度总和最多为 5000
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/tallest-billboard
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @Author UGcris
 * @date 2020/7/13
 **/
public class TallestBillboard {

    public int tallestBillboard(int[] rods) {
        int ans = 0;
        if (rods.length > 1) {
            Arrays.sort(rods);
            int[][] dp=new int[rods.length][rods.length];
        }
        return ans;
    }
}
