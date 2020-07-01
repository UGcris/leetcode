package D202007;

import javafx.util.Pair;

import java.util.*;

/**
 * 我们有一个项的集合，其中第 i 项的值为 values[i]，标签为 labels[i]。
 * <p>
 * 我们从这些项中选出一个子集 S，这样一来：
 * <p>
 * |S| <= num_wanted
 * 对于任意的标签 L，子集 S 中标签为 L 的项的数目总满足 <= use_limit。
 * 返回子集 S 的最大可能的 和。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：values = [5,4,3,2,1], labels = [1,1,2,2,3], num_wanted = 3, use_limit = 1
 * 输出：9
 * 解释：选出的子集是第一项，第三项和第五项。
 * 示例 2：
 * <p>
 * 输入：values = [5,4,3,2,1], labels = [1,3,3,3,2], num_wanted = 3, use_limit = 2
 * 输出：12
 * 解释：选出的子集是第一项，第二项和第三项。
 * 示例 3：
 * <p>
 * 输入：values = [9,8,8,7,6], labels = [0,0,0,1,1], num_wanted = 3, use_limit = 1
 * 输出：16
 * 解释：选出的子集是第一项和第四项。
 * 示例 4：
 * <p>
 * 输入：values = [9,8,8,7,6], labels = [0,0,0,1,1], num_wanted = 3, use_limit = 2
 * 输出：24
 * 解释：选出的子集是第一项，第二项和第四项。
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= values.length == labels.length <= 20000
 * 0 <= values[i], labels[i] <= 20000
 * 1 <= num_wanted, use_limit <= values.length
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/largest-values-from-labels
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @Author UGcris
 * @date 2020/7/1
 **/
public class LargestValuesFromLabels {
    int ans = 0;

    /**
     * 贪心
     *
     * @param values
     * @param labels
     * @param num_wanted
     * @param use_limit
     * @return
     */
    public int largestValsFromLabels(int[] values, int[] labels, int num_wanted, int use_limit) {
        find(values, labels, num_wanted, use_limit, 0, 0, new HashMap<>());
        return ans;
    }

    private void find(int[] values, int[] labels, int num_wanted, int use_limit, int index, int preValue, Map<Integer, Integer> map) {
        if (num_wanted < 0) {
            return;
        }
        ans = Math.max(ans, preValue);
        if (num_wanted == 0) {
            return;
        }
        for (int i = index; i < values.length; i++) {
            if (map.getOrDefault(labels[i], 0) >= use_limit) {
                continue;
            }
            System.out.println(preValue + values[i]);
            map.put(labels[i], map.getOrDefault(labels[i], 0) + 1);
            find(values, labels, num_wanted - 1, use_limit, i + 1, preValue + values[i], map);
            map.put(labels[i], map.get(labels[i]) - 1);
        }
    }

    /**
     * pair 超时
     *
     * @param values
     * @param labels
     * @param num_wanted
     * @param use_limit
     * @return
     */
    public int largestValsFromLabels2(int[] values, int[] labels, int num_wanted, int use_limit) {
        int ans = 0;
        List<Pair<Integer, Integer>> list = new ArrayList<>();
        for (int i = 0; i < values.length; i++) {
            Pair<Integer, Integer> pair = new Pair<>(values[i], labels[i]);
            list.add(pair);
        }
        Collections.sort(list, new Comparator<Pair<Integer, Integer>>() {
            @Override
            public int compare(Pair<Integer, Integer> o1, Pair<Integer, Integer> o2) {
                return o2.getKey().compareTo(o1.getKey());
            }
        });
        int[] label_count = new int[20001];
        for (Pair<Integer, Integer> pair : list) {
            int value = pair.getKey();
            int label = pair.getValue();
            if (label_count[label] < use_limit) {
                ans += value;
                if (--num_wanted == 0) {
                    break;
                }
                ++label_count[label];
            }
        }
        return ans;
    }


    /**
     * 解题
     *
     * @param values
     * @param labels
     * @param num_wanted
     * @param use_limit
     * @return
     */
    public int largestValsFromLabels3(int[] values, int[] labels, int num_wanted, int use_limit) {
        int len = values.length;
        int[][] items = new int[len][2];
        for (int i = 0; i < len; ++i) {
            items[i][0] = values[i];
            items[i][1] = labels[i];
        }
        Arrays.sort(items, Comparator.comparingInt(i -> -i[0]));
        int[] label_count = new int[20001];
        int res = 0;
        for (int[] item : items) {
            if (label_count[item[1]] < use_limit) {
                res += item[0];
                if (--num_wanted == 0)
                    break;
                ++label_count[item[1]];
            }
        }
        return res;
    }
}
