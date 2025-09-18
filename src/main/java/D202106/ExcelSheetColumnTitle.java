package D202106;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你一个整数 columnNumber ，返回它在 Excel 表中相对应的列名称。
 *
 * 例如：
 *
 * A -> 1
 * B -> 2
 * C -> 3
 * ...
 * Z -> 26
 * AA -> 27
 * AB -> 28
 * ...
 *  
 *
 * 示例 1：
 *
 * 输入：columnNumber = 1
 * 输出："A"
 * 示例 2：
 *
 * 输入：columnNumber = 28
 * 输出："AB"
 * 示例 3：
 *
 * 输入：columnNumber = 701
 * 输出："ZY"
 * 示例 4：
 *
 * 输入：columnNumber = 2147483647
 * 输出："FXSHRXW"
 *  
 *
 * 提示：
 *
 * 1 <= columnNumber <= 231 - 1
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/excel-sheet-column-title
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author UGcris
 * @date 2021/6/29
 **/
public class ExcelSheetColumnTitle {
    private String[] arr={"Z","A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y"};
    public String convertToTitle(int columnNumber) {
       int pre=0,length=1;
       while (pre+Math.pow(26,length)<columnNumber){
           pre+=Math.pow(26,length++);
       }
        int realBegin=columnNumber-pre;
       StringBuffer result=new StringBuffer();
       while (realBegin>0){
           int index=realBegin%26;
           result.append(arr[index]);
           if(realBegin==26) break;
           realBegin=(realBegin-index)/26+1;
       }
        return result.reverse().toString();
    }
}
