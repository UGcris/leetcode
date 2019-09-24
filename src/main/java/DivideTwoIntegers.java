/**
 * 给定两个整数，被除数 dividend 和除数 divisor。将两数相除，要求不使用乘法、除法和 mod 运算符。
 *
 * 返回被除数 dividend 除以除数 divisor 得到的商。
 *
 * 示例 1:
 *
 * 输入: dividend = 10, divisor = 3
 * 输出: 3
 * 示例 2:
 *
 * 输入: dividend = 7, divisor = -3
 * 输出: -2
 * 说明:
 *
 * 被除数和除数均为 32 位有符号整数。
 * 除数不为 0。
 * 假设我们的环境只能存储 32 位有符号整数，其数值范围是 [−231,  231 − 1]。本题中，如果除法结果溢出，则返回 231 − 1。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/divide-two-integers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author UGcris
 * @date 2019/9/24
 **/
public class DivideTwoIntegers {
    /**
     * 不能乘除取余，便只有加法了
     * @param dividend
     * @param divisor
     * @return
     */
    public int divide(int dividend, int divisor) {
        if(dividend==divisor) return 1;
        if(dividend==-divisor) return -1;
        if(divisor==Integer.MIN_VALUE) return 0;
        boolean positive=((divisor>0&&dividend<0)||(divisor<0&&dividend>0))?false:true;//符号
        if(divisor==1||divisor==-1){
            if ((dividend>0&&positive) || (dividend< 0&&!positive)) return dividend;
            if(positive&&dividend<0) if (-dividend<0) return dividend-1;//越界
            return -dividend;
        }
        int temp=dividend>0?divisor>0?divisor:-divisor:divisor>0?-divisor:divisor,beginTemp=temp;
        int result=count(dividend,temp);
        return positive?result:-result;
    }

    private int count(int dividend, int temp) {
        if(dividend>0?temp>dividend:(temp<dividend)){
            return 0;
        }
        int sum=temp;
        int result=1;
        while (dividend>0?sum<=dividend:(sum>=dividend)){
            //溢出 有余 在未翻倍和翻倍中间
            int subSum=sum+sum;
            if((sum>0&&subSum<=0)||(sum<0&&subSum>=0)
                    ||(dividend>0?(sum+temp)>dividend:((sum+temp)<dividend))
                    || (dividend>0?subSum>dividend:(subSum<dividend))) {
                break;
            }
            if(sum+temp==dividend){
                sum+=temp;
                result++;
            }
            sum=subSum;
            result*=2;
        }
        if(dividend>0?dividend-sum>temp:dividend-sum<temp){
            result+=count(dividend-sum,temp);
        }
        return result;
    }

    public static void main(String[] args) {
        DivideTwoIntegers divideTwoIntegers=new DivideTwoIntegers();
//        System.out.println(divideTwoIntegers.divide(7,-3));
        System.out.println(divideTwoIntegers.divide(1010369383,-2147483648));
    }
}
