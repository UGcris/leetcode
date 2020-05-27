package TOIN;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你一份工作时间表 hours，上面记录着某一位员工每天的工作小时数。
 *
 * 我们认为当员工一天中的工作小时数大于 8 小时的时候，那么这一天就是「劳累的一天」。
 *
 * 所谓「表现良好的时间段」，意味在这段时间内，「劳累的天数」是严格 大于「不劳累的天数」。
 *
 * 请你返回「表现良好时间段」的最大长度。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：hours = [9,9,6,0,6,6,9]
 * 输出：3
 * 解释：最长的表现良好时间段是 [9,9,6]。
 *  
 *
 * 提示：
 *
 * 1 <= hours.length <= 10000
 * 0 <= hours[i] <= 16
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-well-performing-interval
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author UGcris
 * @date 2019/9/28
 **/
public class LongestWellPerformingInterval {
    /**
     * 第一个版本，超时
     * @param hours
     * @return
     */
    public int longestWPI(int[] hours) {
        int size=hours.length;
        int count=0;
        for (int i = 0; i <size-count ; i++) {
            int index=i;
            List<Integer> up=new ArrayList<>();
            List<Integer> down=new ArrayList<>();
            while (index<size){
                if(hours[index]>8){
                    up.add(hours[index]);
                }else {
                    down.add(hours[index]);
                }
                index++;
                if (up.size()>down.size()&&count<index-i) {
                    count=index-i;
                }
            }
        }
        return count;
    }

    public int longestWPI2(int[] hours) {
        int size=hours.length;
        int count=0;
        int[] sum=new int[size];
        int temp=0;
        for (int i = 0; i <size ; i++) {
            temp=hours[i]>8?1:-1;
            for (int j = 0; j <= i; j++) {
                sum[j]=sum[j]+temp;
                if(sum[j]>0&&count<i-j+1){
                    count=i-j+1;
                }
            }
        }
        return count;
    }
    public static void main(String[] args) {
        LongestWellPerformingInterval longestWellPerformingInterval=new LongestWellPerformingInterval();
        int[] nums={9,9,6,0,6,6,9,9,9,6,0,6,6,9,9,9,6,0,6,6,9};
        System.out.println(longestWellPerformingInterval.longestWPI2(nums));
    }
}
