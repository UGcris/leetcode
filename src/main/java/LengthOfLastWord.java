/**
 * 给定一个仅包含大小写字母和空格 ' ' 的字符串，返回其最后一个单词的长度。
 *
 * 如果不存在最后一个单词，请返回 0 。
 *
 * 说明：一个单词是指由字母组成，但不包含任何空格的字符串。
 *
 * 示例:
 *
 * 输入: "Hello World"
 * 输出: 5
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/length-of-last-word
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author UGcris
 * @date 2019/10/28
 */

public class LengthOfLastWord {
    /**
     * 每次遇到空格就重新计算
     * @param s
     * @return
     */
    public int lengthOfLastWord(String s) {
        int result=0;
        int temp=0;
        for (int i = 0; i < s.length(); i++) {
            char ch=s.charAt(i);
            if(' '==ch){
                temp=0==result?temp:result;
                result=0;
            }
            if(' '!=ch) result++;
        }
        return result;
    }

    /**
     * 转成数组，获取倒数不为空的
     * @param s
     * @return
     */
    public int lengthOfLastWord2(String s) {
        String[] temp=s.split(" ");
        for (int i = temp.length-1; i >= 0; i++) {
            if(""!=temp[i]){
                return temp[i].length();
            }
        }
        return 0;
    }

    /**
     * 反着从第一个不为空格的字符开始计算，直到下一个为空格的
     * @param s
     * @return
     */
    public int lengthOfLastWord3(String s) {
        int result=0;
        for (int i = s.length(); i >= 0 ; i++) {
            if(' '==s.charAt(i)&&result!=0){
                break;
            }
            if(' '!=s.charAt(i)){
                result++;
            }
        }
        return result;
    }
}
