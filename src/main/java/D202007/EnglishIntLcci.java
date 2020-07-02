package D202007;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 给定一个整数，打印该整数的英文描述。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 123
 * 输出: "One Hundred Twenty Three"
 * 示例 2:
 * <p>
 * 输入: 12345
 * 输出: "Twelve Thousand Three Hundred Forty Five"
 * 示例 3:
 * <p>
 * 输入: 1234567
 * 输出: "One Million Two Hundred Thirty Four Thousand Five Hundred Sixty Seven"
 * 示例 4:
 * <p>
 * 输入: 1234567891
 * 输出: "One Billion Two Hundred Thirty Four Million Five Hundred Sixty Seven Thousand Eight Hundred Ninety One"
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/english-int-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @Author UGcris
 * @date 2020/7/2
 **/
public class EnglishIntLcci {

    public String numberToWords(int num) {
        if(num==0) return map.get(num);
        StringBuffer ans = new StringBuffer();
        for (int i = 1000000000; i >= 1 && num > 0; i /= 1000) {
            int pre = num / i;
            if (pre < 1) continue;
            for (int j = 1000; j >= 1 && pre > 0; j /= 10) {
                int val = pre / j;
                if (val < 1) continue;
                //十位/个位
                if (j >= 100) {
                    ans.append(" ").append(map.get(val)).append(" ").append(map.get(j));
                } else if (pre >= 20) {
                    ans.append(" ").append(map.get(val * j));
                } else {
                    ans.append(" ").append(map.get(pre));
                    break;
                }
                pre %= j;
            }
            num %= i;
            if (i < 1000) continue;
            ans.append(" ").append(map.get(i));
        }
        return ans.length() > 0 ? ans.substring(1) : "";
    }

    private static Map<Integer, String> map = new HashMap<Integer, String>() {{
        put(0, "Zero");
        put(1, "One");
        put(2, "Two");
        put(3, "Three");
        put(4, "Four");
        put(5, "Five");
        put(6, "Six");
        put(7, "Seven");
        put(8, "Eight");
        put(9, "Nine");
        put(10, "Ten");
        put(11, "Eleven");
        put(12, "Twelve");
        put(13, "Thirteen");
        put(14, "Fourteen");
        put(15, "Fifteen");
        put(16, "Sixteen");
        put(17, "Seventeen");
        put(18, "Eighteen");
        put(19, "Nineteen");
        put(20, "Twenty");
        put(30, "Thirty");
        put(40, "Forty");
        put(50, "Fifty");
        put(60, "Sixty");
        put(70, "Seventy");
        put(80, "Eighty");
        put(90, "Ninety");
        put(100, "Hundred");
        put(1000, "Thousand");
        put(1000000, "Million");
        put(1000000000, "Billion");
    }};
}
