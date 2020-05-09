package TOTO;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个无重复元素的有序整数数组，返回数组区间范围的汇总。
 *
 * 示例 1:
 *
 * 输入: [0,1,2,4,5,7]
 * 输出: ["0->2","4->5","7"]
 * 解释: 0,1,2 可组成一个连续的区间; 4,5 可组成一个连续的区间。
 * 示例 2:
 *
 * 输入: [0,2,3,4,6,8,9]
 * 输出: ["0","2->4","6","8->9"]
 * 解释: 2,3,4 可组成一个连续的区间; 8,9 可组成一个连续的区间。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/summary-ranges
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author UGcris
 * @date 2020/2/14
 **/
public class SummaryRanges {
    /**
     * 三指针
     * @param nums
     * @return
     */
    public List<String> summaryRanges(int[] nums) {
        List<String> ans=new ArrayList<>();
        int left=0,right=0,cur=0;
        while (right<nums.length){
            if(cur<nums.length&&nums[cur]-nums[right]>=0&&nums[cur]-nums[right]<=1){
                right=cur;
                cur++;
            }else {
                if(right-left>0) {
                    ans.add(nums[left]+"->"+nums[right]);
                }else {
                    ans.add(nums[left]+"");
                }
                right=cur;
                left=cur;
            }
        }
        return ans;
    }

    /**
     * 双指针
     * 1.String.valueOf
     * 2.StringBuffer
     * @param nums
     * @return
     */
    public List<String> summaryRanges2(int[] nums) {
        List<String> ans=new ArrayList<>();
        int start=0,end=0;
        while (end<nums.length){
            if(end<nums.length-1&&nums[end+1]-nums[end]==1){
                end++;
            }else {
                if(end-start==0) ans.add(String.valueOf(nums[start]));
                else {
                    StringBuffer temp = new StringBuffer();
                    temp.append(nums[start]);
                    temp.append("->");
                    temp.append(nums[end]);
                    ans.add(temp.toString());
                }
                end++;
                start=end;
            }
        }
        return ans;
    }
}
