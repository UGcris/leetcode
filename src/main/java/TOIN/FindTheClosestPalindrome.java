package TOIN;

/**
 * 给定一个整数 n ，你需要找到与它最近的回文数（不包括自身）。
 *
 * “最近的”定义为两个整数差的绝对值最小。
 *
 * 示例 1:
 *
 * 输入: "123"
 * 输出: "121"
 * 注意:
 *
 * n 是由字符串表示的正整数，其长度不超过18。
 * 如果有多个结果，返回最小的那个。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-the-closest-palindrome
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author UGcris
 * @date 2019/10/28
 */

public class FindTheClosestPalindrome {
    public String mirroring(String s) {
        String x = s.substring(0, (s.length()) / 2);
        return x + (s.length() % 2 == 1 ? s.charAt(s.length() / 2) : "") + new StringBuilder(x).reverse().toString();
    }
    public String nearestPalindromic(String n) {
        if (n.equals("1"))
            return "0";

        String a = mirroring(n);
        long diff1 = Long.MAX_VALUE;
        diff1 = Math.abs(Long.parseLong(n) - Long.parseLong(a));
        if (diff1 == 0)
            diff1 = Long.MAX_VALUE;

        int i = (n.length() - n.length()%2) / 2;
        String b = mirroring((Long.valueOf(n.substring(0,i))-1L)+n.substring(i));
        long diff2 = Math.abs(Long.parseLong(n) - Long.parseLong(b));

        String c = mirroring((Long.valueOf(n.substring(0,i))+1L)+n.substring(i));
        long diff3 = Math.abs(Long.parseLong(n) - Long.parseLong(c));

        if (diff2 <= diff1 && diff2 <= diff3)
            return b;
        if (diff1 <= diff3 && diff1 <= diff2)
            return a;
        else
            return c;
    }

    /**
     * 方法二 数学方法[通过]
     * 算法
     *
     * 要理解这种方法，让我们从一个简单的例子开始。假设给我们的数字是 “abcxy”。将此数字转换为回文的一种方法是将字符串的一半复制到另一半。如果我们尝试将后半部分复制到上半部分，获得的新回文将是 “yxcxy”，它位于原始数字的绝对值 \ left | 10000（a-y）+ 1000（b-x）\ right | left∣10000（a−y）+1000（b−x） right∣。但是，如果我们将前半部分复制到字符串的后半部分，我们获 “abcba”，它位于 \ left | 10（x-b）+（y-a）\ right | left∣10（x−b）+（y−a） right∣ 的绝对差值。在任何一种情况下，试图更改 cc 将在绝对差异中产生至少 100 的额外值。
     *
     * 从上面的插图中，我们可以得出结论，如果使用复制来生成回文数，我们应该始终将前半部分复制到后半部分。在这个实现中，我们已经将这样的数字存储在 aa 中，差额为 diff1diff1 来自 nn。
     *
     * 但是，还存在另一种情况，其中中间索引处的数字递增或递减。在这种情况下，仅对中心数字进行更改可能是有用的，因为这种变化可能导致回文形成更接近原始数字。例如使用上述标准，得到的回文将是 10901，与 11011 相比与 11011 的差异更大。如果在中间数字处出现 0，则会出现类似的情况。但是，如前所述，我们只需考虑前半位数来获得新的回文数据。这种特殊效果在中间数字处出现 0 或 9，因为只有递减 0 并且在该数字位置递增 9 可以导致其余数字向左移动。在任何其他情况下，情况归结为第一段中讨论的情况。
     *
     * 现在，每当我们在中间指数附近找到0时，为了考虑小于 nn 的回文，我们从数字的前半部分减 1，以获得新的回文一半，例如如果给定的数字nn是 20001，我们从 200 减去 1，创建一个 199xx 的数字。为了获得新的回文，我们复制前半部分以获得 19991。另一个例子是10000，（MSB为1），我们从 100 减去 1 创建 099xx 作为新的数字转换为 9999 作为新的回文。这个数字存储在 bb 中，与 nn 相差 diff2diff2。
     *
     * 类似的处理需要用中间数字 9 来完成，除了这次我们需要考虑大于当前数字的数字。为此，我们在上半部分添加 1。例如取数字 10987，我们添加 1 到 109，创建一个 110xx 的形式（11011 是新的回文）。这个回文存储在 cc 中，与 nn 相差 diff3diff3。
     *
     * 在这三个回文中，我们可以选择与 nn 最小差异的那个。此外，在平局的情况下，我们需要返回获得的最小回文。我们可以观察到，只有当一个数字大于 nn 且另一个数字小于 nn 时才可能出现平局。此外，我们知道 bb 是通过减少 nn 获得的。因此，如果 bb 和任何其他数字之间发生冲突，我们需要选择 bb。同样，cc 是通过增加 nn 获得的。因此，如果 cc 和任何其他数字之间存在平局，我们需要选择 cc 以外的数字。
     *
     * 作者：LeetCode
     * 链接：https://leetcode-cn.com/problems/find-the-closest-palindrome/solution/xun-zhao-zui-jin-de-hui-wen-shu-by-leetcode/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     * @param n
     * @return
     */
    public String nearestPalindromic2(String n) {
        if (n.equals("1"))
            return "0";

        String a = mirroring(n);
        long diff1 = Long.MAX_VALUE;
        diff1 = Math.abs(Long.parseLong(n) - Long.parseLong(a));
        if (diff1 == 0)
            diff1 = Long.MAX_VALUE;

        StringBuilder s = new StringBuilder(n);
        int i = (s.length() - 1) / 2;
        while (i >= 0 && s.charAt(i) == '0') {
            s.replace(i, i + 1, "9");
            i--;
        }
        if (i == 0 && s.charAt(i) == '1') {
            s.delete(0, 1);
            int mid = (s.length() - 1) / 2;
            s.replace(mid, mid + 1, "9  ");
        } else
            s.replace(i, i + 1, "" + (char)(s.charAt(i) - 1));
        String b = mirroring(s.toString());
        long diff2 = Math.abs(Long.parseLong(n) - Long.parseLong(b));


        s = new StringBuilder(n);
        i = (s.length() - 1) / 2;
        while (i >= 0 && s.charAt(i) == '9') {
            s.replace(i, i + 1, "0");
            i--;
        }
        if (i < 0) {
            s.insert(0, "1");
        } else
            s.replace(i, i + 1, "" + (char)(s.charAt(i) + 1));
        String c = mirroring(s.toString());
        long diff3 = Math.abs(Long.parseLong(n) - Long.parseLong(c));

        if (diff2 <= diff1 && diff2 <= diff3)
            return b;
        if (diff1 <= diff3 && diff1 <= diff2)
            return a;
        else
            return c;
    }
    public static void main(String[] args) {
        FindTheClosestPalindrome f=new FindTheClosestPalindrome();
        System.out.println(f.nearestPalindromic("1001"));
        System.out.println(f.nearestPalindromic("999"));
    }
}
