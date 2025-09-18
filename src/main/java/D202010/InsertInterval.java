package D202010;

import java.util.ArrayList;
import java.util.List;

/**
 * 给出一个无重叠的 ，按照区间起始端点排序的区间列表。
 * <p>
 * 在列表中插入一个新的区间，你需要确保列表中的区间仍然有序且不重叠（如果有必要的话，可以合并区间）。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：intervals = [[1,3],[6,9]], newInterval = [2,5]
 * 输出：[[1,5],[6,9]]
 * 示例 2：
 * <p>
 * 输入：intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
 * 输出：[[1,2],[3,10],[12,16]]
 * 解释：这是因为新的区间 [4,8] 与 [3,5],[6,7],[8,10] 重叠。
 *  
 * <p>
 * 注意：输入类型已在 2019 年 4 月 15 日更改。请重置为默认代码定义以获取新的方法签名。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/insert-interval
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @Author UGcris
 * @date 2020/11/4
 **/
public class InsertInterval {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int[][] result = new int[intervals.length + newInterval.length][2];
        int index = 0, indexN = 0, indexR = 0;
        while (indexR < result.length) {
            if (index < intervals.length && indexN < newInterval.length) {
                if(newInterval[indexN]<intervals[index][0]+1){
//                    result[indexR][0]=
                }
            }
        }
        int left=intervals[0][0],right=intervals[0][1];
        List<List<Integer>> more=new ArrayList<>();
        int index1=0,index2=0;
        for (int i = 0; i < newInterval.length; i++) {
            int num=newInterval[i];
//            if(num>intervals[index1][0])
        }
        return result;
    }
}
