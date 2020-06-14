package D202006;

import java.util.Arrays;

/**
 * 给你一个整数数组 arr 和一个目标值 target ，请你返回一个整数 value ，使得将数组中所有大于 value 的值变成 value 后，数组的和最接近  target （最接近表示两者之差的绝对值最小）。
 * <p>
 * 如果有多种使得和最接近 target 的方案，请你返回这些整数中的最小值。
 * <p>
 * 请注意，答案不一定是 arr 中的数字。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：arr = [4,9,3], target = 10
 * 输出：3
 * 解释：当选择 value 为 3 时，数组会变成 [3, 3, 3]，和为 9 ，这是最接近 target 的方案。
 * 示例 2：
 * <p>
 * 输入：arr = [2,3,5], target = 10
 * 输出：5
 * 示例 3：
 * <p>
 * 输入：arr = [60864,25176,27249,21296,20204], target = 56803
 * 输出：11361
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= arr.length <= 10^4
 * 1 <= arr[i], target <= 10^5
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sum-of-mutated-array-closest-to-target
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @Author UGcris
 * @date 2020/6/14
 **/
public class SumOfMutatedArrayClosestToTarget {
    public int findBestValue(int[] arr, int target) {
        Arrays.sort(arr);
        int n = arr.length;
        int[] prefix = new int[n + 1];
        for (int i = 1; i <= n; ++i) {
            prefix[i] = prefix[i - 1] + arr[i - 1];
        }
        int r = arr[n - 1];
        int ans = 0, diff = target;
        for (int i = 1; i <= r; ++i) {
            int index = Arrays.binarySearch(arr, i);
            if (index < 0) {
                index = -index - 1;
            }
            int cur = prefix[index] + (n - index) * i;
            if (Math.abs(cur - target) < diff) {
                ans = i;
                diff = Math.abs(cur - target);
            }
        }
        return ans;
    }

    public int findBestValue3(int[] arr, int target) {
        Arrays.sort(arr);
        int length = arr.length;
        int ans = find(0, target, length);
        int minDiff = Integer.MAX_VALUE;
        int[] sum = new int[length + 1];
        sum[0] = 0;
        for (int i = 0; i < length; i++) {
            sum[i + 1] = sum[i] + arr[i];
            int findAns = find(sum[i], target - sum[i], length - i);
            if (i > 0 && findAns < arr[i - 1]) {
                break;
            }
            int thisDiff = Math.abs(sum[i] + findAns * (length - i) - target);
            if (findAns <= arr[i] && thisDiff < minDiff) {
                ans = findAns;
                minDiff = thisDiff;
            }
        }
        if(sum[length]!=0&&sum[length]<=target){
            return arr[length-1];
        }
        return ans;
    }

    private int find(int preValue, int target, int length) {
        return Math.abs(((target / length + 1) * length + preValue - target)) < Math.abs(target / length * length + preValue - target) ? (target / length + 1) : target / length;
    }

    public int findBestValue2(int[] arr, int target) {
        Arrays.sort(arr);
        int length = arr.length, sum = arr[0];
        int ans = Math.abs(((target / length + 1) * length - target)) < Math.abs(target / length * length - target) ? (target / length + 1) : target / length;
        int preDiff = arr[0] * length - target;
        for (int i = 1; i < length; i++) {
            int nextDiff = sum + arr[i] * (length - i) - target;
            if (nextDiff == 0) {
                return arr[i];
            }
            if (nextDiff < 0) {
                ans = arr[i];
                preDiff = nextDiff;
                sum += arr[i];
            } else if (preDiff >= 0) {
                return ans;
            } else {
                if (arr[i] - arr[i - 1] > 1) {
                    for (int j = (arr[i] + arr[i - 1]) / 2; j <= arr[i] && j > arr[i - 1]; j++) {
                        nextDiff = sum + j * (length - i) - target;

                    }
                    for (int j = arr[i - 1] + 1; j < arr[i]; j++) {
                        nextDiff = sum + j * (length - i) - target;
                        ans = j;
                        if (Math.abs(nextDiff) > Math.abs(preDiff)) {
                            return ans;
                        }
                        preDiff = nextDiff;
                    }
                } else {
                    return arr[i];
                }
            }
        }
        return ans;
    }
}
