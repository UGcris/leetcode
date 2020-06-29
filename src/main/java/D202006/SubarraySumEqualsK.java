package D202006;

import java.util.HashMap;

/**
 * 给定一个整数数组和一个整数 k，你需要找到该数组中和为 k 的连续的子数组的个数。
 * <p>
 * 示例 1 :
 * <p>
 * 输入:nums = [1,1,1], k = 2
 * 输出: 2 , [1,1] 与 [1,1] 为两种不同的情况。
 * 说明 :
 * <p>
 * 数组的长度为 [1, 20,000]。
 * 数组中元素的范围是 [-1000, 1000] ，且整数 k 的范围是 [-1e7, 1e7]。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/subarray-sum-equals-k
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @Author UGcris
 * @date 2020/6/29
 **/
public class SubarraySumEqualsK {
    public int subarraySum(int[] nums, int k) {
        int ans = 0, length = nums.length;
        if (length > 0) {
            int maxValue = 0, minValue = 0;
            int[] arr = new int[length + 1];
            arr[0] = 0;
            for (int i = 0; i < nums.length; i++) {
                arr[i + 1] = nums[i] + arr[i];
                if (arr[i + 1] - minValue >= k && arr[i + 1] - maxValue <= k) {
                    for (int j = 0; j <= i; j++) {
                        if (arr[i + 1] - arr[j] == k) {
                            ans++;
                        }
                    }
                }
                minValue = Math.min(minValue, arr[i + 1]);
                maxValue = Math.max(maxValue, arr[i + 1]);
            }
        }
        return ans;
    }

    /**
     * 例子
     * @param nums
     * @param k
     * @return
     */
    public int subarraySum2(int[] nums, int k) {
        int[] sums = new int[nums.length];
        int sum=0;
        for(int i=0;i<nums.length;i++){
            sums[i]=sum;
            sum+=nums[i];
        }
        HashMap<Integer,Integer> cntMap = new HashMap<>();
        int totalcnt=0;
        for(int i=0;i<nums.length;i++){
            // cntMap.put(sums[i],cntMap.getOrDefault(sums[i],0)+1);
            cntMap.merge(sums[i],1,Integer::sum);
            // cntMap.putIfAbsent(sums[i],0);
            // cntMap.put(sums[i],cntMap.get(sums[i])+1);

            // sum[i]-sum[k]+nums[i]=k
            int target = sums[i]+nums[i]-k;
            Integer cnt=cntMap.get(target);
//            System.out.println(i+" "+cnt);
            if(cnt!=null) totalcnt+=cnt;
            //更新映射项
        }
        return totalcnt;
    }
}
