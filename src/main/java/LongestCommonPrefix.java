/**
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 *
 * 如果不存在公共前缀，返回空字符串 ""。
 *
 * 示例 1:
 *
 * 输入: ["flower","flow","flight"]
 * 输出: "fl"
 * 示例 2:
 *
 * 输入: ["dog","racecar","car"]
 * 输出: ""
 * 解释: 输入不存在公共前缀。
 * 说明:
 *
 * 所有输入只包含小写字母 a-z 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-common-prefix
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author UGcris
 * @date 2019/9/19
 **/
public class LongestCommonPrefix {
    /**
     * 这算暴力法吗。。。简单的循环
     * @param strs
     * @return
     */
    public String longestCommonPrefix(String[] strs) {
        String result="";
        int index=0;
        boolean isContinue=strs.length>0;
        if(strs.length==1) return strs[0];
        while (isContinue){
            for(int i=0;i<strs.length;i++){
                if(i==0){
                    if(strs[i].length()>index){
                        result+=strs[i].charAt(index);
                    }else{
                        isContinue=false;
                        break;
                    }
                }else if(!strs[i].startsWith(result)||strs[i].length()<=index){
                    isContinue=false;
                    result=result.substring(0,result.length()-1);
                    break;
                }
            }
            index++;
        }
        return result;
    }

    public static void main(String[] args) {
        LongestCommonPrefix longestCommonPrefix=new LongestCommonPrefix();
        String[] arr={"aaa","aa","aaa"};
        System.out.println(longestCommonPrefix.longestCommonPrefix(arr));
    }
}
