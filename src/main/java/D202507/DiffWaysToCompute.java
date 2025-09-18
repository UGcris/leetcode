package D202507;

import java.util.*;

/**
 * 给你一个由数字和运算符组成的字符串 expression ，按不同优先级组合数字和运算符，计算并返回所有可能组合的结果。你可以 按任意顺序 返回答案。
 *
 * 生成的测试用例满足其对应输出值符合 32 位整数范围，不同结果的数量不超过 104 。
 *
 *
 *
 * 示例 1：
 *
 * 输入：expression = "2-1-1"
 * 输出：[0,2]
 * 解释：
 * ((2-1)-1) = 0
 * (2-(1-1)) = 2
 * 示例 2：
 *
 * 输入：expression = "2*3-4*5"
 * 输出：[-34,-14,-10,-10,10]
 * 解释：
 * (2*(3-(4*5))) = -34
 * ((2*3)-(4*5)) = -14
 * ((2*(3-4))*5) = -10
 * (2*((3-4)*5)) = -10
 * (((2*3)-4)*5) = 10
 *
 *
 * 提示：
 *
 * 1 <= expression.length <= 20
 * expression 由数字和算符 '+'、'-' 和 '*' 组成。
 * 输入表达式中的所有整数值在范围 [0, 99]
 * 输入表达式中的所有整数都没有前导 '-' 或 '+' 表示符号。
 * @Author UGcris
 * @date 2020/8/18
 */
public class DiffWaysToCompute {
    private static String adds="+";
    private static String subs="-";
    private static String muts="*";

    public List<Integer> diffWaysToCompute(String expression) {

        List<Integer> nums=new ArrayList();
        List<String> funcs=new ArrayList();
        int i=0,pre=0;
        while(i<expression.length()){
            if(expression.charAt(i)>='0' && expression.charAt(i) <='9'){
                i++;
            }else {
                String func="";
                if(adds.charAt(0)==expression.charAt(i)) func=adds;
                if(subs.charAt(0)==expression.charAt(i)) func=subs;
                if(muts.charAt(0)==expression.charAt(i)) func=muts;
                funcs.add(func);
                nums.add(Integer.valueOf(expression.substring(pre,i)));
                i++;
                pre=i;
            }
        }
        nums.add(Integer.valueOf(expression.substring(pre,i)));

        return computer(nums,funcs,0,funcs.size());
    }

    private List<Integer> computer(List<Integer> nums, List<String> funcs, int sidex, int eidx){
        List<Integer> result=new ArrayList<>();
        if(eidx==sidex){
            result.add(nums.get(sidex));
            return result;
        }
        if(eidx==sidex+1){
            result.add(computer(nums.get(sidex),nums.get(eidx),funcs.get(sidex)));
            return result;
        }
        for(int idx=sidex;idx<eidx;idx++){
            if(idx==sidex){
                computer(nums.get(idx),computer(nums,funcs,idx+1,eidx),result,funcs.get(idx));
            }else if(idx==eidx-1){
                computer(computer(nums,funcs,sidex,idx),nums.get(idx+1),result,funcs.get(idx));
            }else{
                computer(computer(nums,funcs,sidex,idx),computer(nums,funcs,idx+1,eidx),result,funcs.get(idx));
            }
        }
        return result;
    }

    private void computer(Collection<Integer> left, Collection<Integer> rigth, Collection<Integer> result, String func) {
        for (Integer v : left) {
            computer(v, rigth, result, func);
        }
    }

    private void computer(Collection<Integer> left, int rigth, Collection<Integer> result, String func) {
        for (Integer v : left) {
            result.add(computer(v, rigth, func));
        }
    }
    private void computer(int left, Collection<Integer> rigth, Collection<Integer> result, String func) {
        for (Integer v : rigth) {
            result.add(computer(left, v, func));
        }
    }

    private int computer(int left, int rigth, String func) {
        if (adds.equals(func))
            return left + rigth;
        if (subs.equals(func))
            return left - rigth;
        if (muts.equals(func))
            return left * rigth;
        return 0;
    }

    public static void main(String[] args) {
        System.err.println(new DiffWaysToCompute().diffWaysToCompute("2*3-4*5"));
    }
}
