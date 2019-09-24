import java.util.*;

/**
 * 给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。
 *
 * 例如，给出 n = 3，生成结果为：
 *
 * [
 *   "((()))",
 *   "(()())",
 *   "(())()",
 *   "()(())",
 *   "()()()"
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/generate-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author UGcris
 * @date 2019/9/23
 **/
public class GenerateParentheses {
    /**
     * 从0到N个括号的排列组合
     * 以及第一个右括号右边的可能性
     * @param n
     * @return
     */
    public List<String> generateParentis(int n) {
        List<String> result=new ArrayList<>();
        if(n>0){
            Map<Integer,List<String>> combinMap=new HashMap<>();
            combinMap.put(0, new ArrayList<>());
            combinMap.put(1, Arrays.asList("()"));
            result=combin(n,combinMap);
        }else {
            result.add("");
        }
        return result;
    }

    private List<String> combin(int n, Map<Integer, List<String>> combinMap) {
        List<String> result=new ArrayList<>();
        if(n>0){
            for (int i = 1; i <= n ; i++) {
                List<String> subList=combinMap.containsKey(i-1)?combinMap.get(i-1):combin(i-1,combinMap);
                List<String> rightList=combinMap.containsKey(n-i)?combinMap.get(n-i):combin(n-i,combinMap);
                combinMap.put(i-1,subList);
                combinMap.put(n-i,rightList);
                List<String> temp=new ArrayList<>();
                if(!subList.isEmpty()){
                    for (String subString:subList) {
                        temp.add("("+subString+")");
                    }
                }
                if(!rightList.isEmpty()){
                    List<String> temp2=new ArrayList<>(temp);
                    temp.clear();
                    for (String rightString:rightList){
                        if(!temp2.isEmpty()){
                            for (String preString:temp2) {
                                temp.add(preString+rightString);
                            }
                        }else {
                            temp.add("("+")"+rightString);
                        }
                    }
                }
                if(subList.isEmpty()&&rightList.isEmpty()){
                    temp=combinMap.get(1);
                }
                result.addAll(temp);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        GenerateParentheses generateParentheses=new GenerateParentheses();
        System.out.println(generateParentheses.generateParentis(4));
    }
}
