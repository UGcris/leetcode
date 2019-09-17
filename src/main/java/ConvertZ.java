/**
 * 将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。
 *
 * 比如输入字符串为 "LEETCODEISHIRING" 行数为 3 时，排列如下：
 *
 * L   C   I   R
 * E T O E S I I G
 * E   D   H   N
 * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："LCIRETOESIIGEDHN"。
 *
 * 请你实现这个将字符串进行指定行数变换的函数：
 *
 * string convert(string s, int numRows);
 * 示例 1:
 *
 * 输入: s = "LEETCODEISHIRING", numRows = 3
 * 输出: "LCIRETOESIIGEDHN"
 * 示例 2:
 *
 * 输入: s = "LEETCODEISHIRING", numRows = 4
 * 输出: "LDREOEIIECIHNTSG"
 * 解释:
 *
 * L     D     R
 * E   O E   I I
 * E C   I H   N
 * T     S     G
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/zigzag-conversion
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author UGcris
 * @date 2019/9/18
 **/
public class ConvertZ {
    /**
     * 一个二位数组，按顺序在指定的位置存储指定的数据
     * 然后依次按不为空的数据取出拼接结果。
     * @param s
     * @param numRows
     * @return
     */
    public String convert(String s, int numRows) {
        if(s.length()<=numRows||numRows==1){
            return s;
        }
        String result="";
        int colIndex=0;
        int rowIndex=0;
        boolean isDown=true;
        int maxCol=s.length()/2+s.length()%(2*numRows-2)%numRows;
        char[][] arr=new char[numRows][maxCol];
        for(int i=0;i<s.length();i++){
            if(isDown){
                arr[rowIndex++][colIndex]=s.charAt(i);
            }else{
                arr[--rowIndex][++colIndex]=s.charAt(i);
            }
            if(rowIndex==0){
                isDown=true;
                rowIndex++;
            }else if(rowIndex==numRows){
                isDown=false;
                rowIndex--;
            }
        }
        for(int i=0;i<numRows;i++){
            for(int j=0;j<maxCol;j++){
                if('\0'!=arr[i][j]){
                    result+=arr[i][j];
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        ConvertZ convertZ=new ConvertZ();
        System.out.println(convertZ.convert("abc",2));
    }
}
