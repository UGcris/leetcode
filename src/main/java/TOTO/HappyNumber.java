package TOTO;

import java.util.ArrayList;
import java.util.List;

/**
 * 编写一个算法来判断一个数是不是“快乐数”。
 *
 * 一个“快乐数”定义为：对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和，然后重复这个过程直到这个数变为 1，也可能是无限循环但始终变不到 1。如果可以变为 1，那么这个数就是快乐数。
 *
 * 示例: 
 *
 * 输入: 19
 * 输出: true
 * 解释:
 * 12 + 92 = 82
 * 82 + 22 = 68
 * 62 + 82 = 100
 * 12 + 02 + 02 = 1
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/happy-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author UGcris
 * @date 2020/3/5
 **/
public class HappyNumber {
    private List<Integer> sumList=new ArrayList<>();
    public boolean isHappy(int n) {
        sumList.add(n);
        int sum=0;
        while (n>0){
            sum+=Math.pow(n%10,2);
            n=n/10;
        }
        if(sum==1){
            return true;
        }else if(!sumList.contains(sum)){
            return isHappy(sum);
        }else {
            return false;
        }
    }
}
