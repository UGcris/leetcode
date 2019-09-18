/**
 * 罗马数字包含以下七种字符： I， V， X， L，C，D 和 M。
 *
 * 字符          数值
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 * 例如， 罗马数字 2 写做 II ，即为两个并列的 1。12 写做 XII ，即为 X + II 。 27 写做  XXVII, 即为 XX + V + II 。
 *
 * 通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做 IIII，而是 IV。数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4 。同样地，数字 9 表示为 IX。这个特殊的规则只适用于以下六种情况：
 *
 * I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
 * X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。 
 * C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
 * 给定一个整数，将其转为罗马数字。输入确保在 1 到 3999 的范围内。
 *
 * 示例 1:
 *
 * 输入: 3
 * 输出: "III"
 * 示例 2:
 *
 * 输入: 4
 * 输出: "IV"
 * 示例 3:
 *
 * 输入: 9
 * 输出: "IX"
 * 示例 4:
 *
 * 输入: 58
 * 输出: "LVIII"
 * 解释: L = 50, V = 5, III = 3.
 * 示例 5:
 *
 * 输入: 1994
 * 输出: "MCMXCIV"
 * 解释: M = 1000, CM = 900, XC = 90, IV = 4.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/integer-to-roman
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author UGcris
 * @date 2019/9/18
 **/
public class IntegerToRoman {
    public String intToRoman(int num) {
        String result="";
        String[] refArray={"M","D","C","L","X","V","I"};
        int[] trArray={1000,500,100,50,10,5,1};
        for(int i=0;i<trArray.length-1&&num>0;i++){
            int system=i%2==0?9*trArray[i+1]/5:4*trArray[i+1];
            int temp1=num/system;
            int temp=0;
            if(temp1>0){
                int everyD=trArray[i]-system;
                int everyIndex=i;
                for(int j=i+1;j<trArray.length;j++){
                    if(trArray[j]==everyD){
                        everyIndex=j;
                        break;
                    }
                }
                 int temp2=num/trArray[i];
                //左边加,右边加
                if(temp2<1){
                    result+=refArray[everyIndex]+refArray[i];
                    temp=system;
                }else if(num%trArray[i]>trArray[i+1]-everyD||num%trArray[i]<trArray[i+1]+4*everyD){
                    result+=refArray[i];
                    temp=trArray[i];
                }else if(num%trArray[i]/everyD%5==1){
                    result+=refArray[i]+refArray[everyIndex];
                    temp=trArray[i]+everyD;
                }else if(num%trArray[i]/everyD%5==2){
                    result+=refArray[i]+refArray[everyIndex]+refArray[everyIndex];
                    temp=trArray[i]+everyD*2;
                }else if(num%trArray[i]/everyD%5==3){
                    result+=refArray[i]+refArray[everyIndex]+refArray[everyIndex]+refArray[everyIndex];
                    temp=trArray[i]+everyD*3;
                }else{
                    result+=refArray[i];
                    temp=trArray[i];
                }
            }
            if(num>=system*2){
                i--;
            }
            num-=temp;
        }
        if(num>0){
            for(int i=0;i<num;i++){
                result+=refArray[6];
            }
        }
        return result;
    }

    /**\
     * 完美体现只要参数分配好，解决一堆问题
     * @param num
     * @return
     */
    public String intToRoman2(int num) {
        int[] number = new int[]{1000,900,500,400,100,90,50,40,10,9,5,4,1};
        String[] numberStr = new String[]{"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < number.length; i++) {
            if(num>=number[i]){
                int count = num/number[i];
                for (int j = 0; j < count; j++) {
                    builder.append(numberStr[i]);
                    num-=number[i];
                }
            }
        }
        return builder.toString();
    }

    /**
     * 投机取巧式
     * @param num
     * @return
     */
    public String intToRoman3(int num) {
        String[] refArray={"M","D","C","L","X","V","I"};
        int[] trArray={1000,500,100,50,10,5,1};
        StringBuffer sb=new StringBuffer();
        for(int index=0;index<trArray.length;index++){
            if(num/trArray[index]>0){
                for(int i=0;i<num/trArray[index];i++){
                    sb.append(refArray[index]);
                }
                num%=trArray[index];
            }
        }

        return sb.toString().replace("DCCCC","CM").replace("CCCC","CD").replace("LXXXX","XC").replace("XXXX","XL").replace("VIIII","IX").replace("IIII","IV");
    }

    public static void main(String[] args) {
        IntegerToRoman integerToRoman=new IntegerToRoman();
        System.out.println(integerToRoman.intToRoman3(1994));
    }
}
