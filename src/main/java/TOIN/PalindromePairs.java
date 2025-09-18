package TOIN;

import java.util.*;

/**
 * 给定一组唯一的单词， 找出所有不同 的索引对(i, j)，使得列表中的两个单词， words[i] + words[j] ，可拼接成回文串。
 *
 * 示例 1:
 *
 * 输入: ["abcd","dcba","lls","s","sssll"]
 * 输出: [[0,1],[1,0],[3,2],[2,4]]
 * 解释: 可拼接成的回文串为 ["dcbaabcd","abcddcba","slls","llssssll"]
 * 示例 2:
 *
 * 输入: ["bat","tab","cat"]
 * 输出: [[0,1],[1,0]]
 * 解释: 可拼接成的回文串为 ["battab","tabbat"]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/palindrome-pairs
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author UGcris
 * @date 2019/9/30
 */

public class PalindromePairs {
    /**
     * 循环寻找
     * 超出时间限制
     * @param words
     * @return
     */
    public List<List<Integer>> palindromePairs1(String[] words) {
        int size=words.length;
        List<List<Integer>> result=new ArrayList<>();
        for(int i=0;i<size;i++){
            String str1=words[i];
            String reverseStr1=new StringBuffer(str1).reverse().toString();
            for(int j=i+1;j<size;j++){
                String str2=words[j];
                String reverseStr2=new StringBuffer(str2).reverse().toString();

                if((reverseStr2+reverseStr1).equals(str1+str2)){
                    result.add(Arrays.asList(i,j));
                }
                if((reverseStr1+reverseStr2).equals(str2+str1)){
                    result.add(Arrays.asList(j,i));
                }
            }
        }
        return result;
    }

    /**
     * 一个字符串，分别从左边和右边找回文
     * @param words
     * @return
     */
    public List<List<Integer>> palindromePairs2(String[] words) {
        int size=words.length;
        List<List<Integer>> result=new ArrayList<>();
        if(size<1) return result;
        List<String> strList=new ArrayList<>();
        Map<String,Integer> dicMap=new HashMap<>();//存储字段对应index
        for (int i = 0; i < size; i++) {
            dicMap.put(words[i],i);
        }
        //遍历数组
        for(int i=0;i<size;i++){
            String str1=words[i];
            if(str1.length()<1) continue;
            int length=str1.length();
            String reverseStr1=new StringBuffer(str1).reverse().toString();
            //1.若当前为回文，需要寻找一个空串
            if(str1.equals(reverseStr1)&&!strList.contains(str1)&&dicMap.containsKey("")){
                strList.add(str1);
                result.add(Arrays.asList(i,dicMap.get("")));
                result.add(Arrays.asList(dicMap.get(""),i));
                strList.add(i+","+dicMap.get(""));
                strList.add(dicMap.get("")+","+i);
            }
            int index=length;
            while (index>0){
                String temp1=reverseStr1.substring(length-index,length);
                String temp2=reverseStr1.substring(0,length-index);
                //3.对称点在str1中
                if(!str1.equals(temp1)&&dicMap.containsKey(temp1)){
                    if(!strList.contains(i+","+dicMap.get(temp1))&&checkPa(str1+temp1)) {
                        result.add(Arrays.asList(i,dicMap.get(temp1)));
                        strList.add(i+","+dicMap.get(temp1));
                    }
                }
                if(!str1.equals(temp2)&&dicMap.containsKey(temp2)){
                    if(!strList.contains(dicMap.get(temp2)+","+i)&&checkPa(temp2+str1)) {
                        result.add(Arrays.asList(dicMap.get(temp2),i));
                        strList.add(dicMap.get(temp2)+","+i);
                    }
                }
                index--;
            }
        }
        return result;
    }

    /**
     * 优化及时停下来,虽然并没有很快。。。
     * @param words
     * @return
     */
    public List<List<Integer>> palindromePairs(String[] words) {
        int size=words.length;
        List<List<Integer>> result=new ArrayList<>();
        if(size<1) return result;
        List<String> strList=new ArrayList<>();
        Map<String,Integer> dicMap=new HashMap<>();//存储字段对应index
        for (int i = 0; i < size; i++) {
            dicMap.put(words[i],i);
        }
        //遍历数组
        for(int i=0;i<size;i++){
            String str1=words[i];
            if(str1.length()<1) continue;
            int length=str1.length();
            String reverseStr1=new StringBuffer(str1).reverse().toString();
            //1.若当前为回文，需要寻找一个空串
            if(str1.equals(reverseStr1)&&!strList.contains(str1)&&dicMap.containsKey("")){
                strList.add(str1);
                result.add(Arrays.asList(i,dicMap.get("")));
                result.add(Arrays.asList(dicMap.get(""),i));
                strList.add(i+","+dicMap.get(""));
                strList.add(dicMap.get("")+","+i);
            }
            int index=length;
            boolean isContinueRight=true;
            boolean isContinueLeft=true;
            while (index>0){
                String temp1=reverseStr1.substring(length-index,length);
                String temp2=reverseStr1.substring(0,length-index);
                if(index<length&&str1.charAt(index)!=reverseStr1.charAt(length-index-1)){
                    isContinueRight=false;
                }
                if(index<length&&str1.charAt(length-index-1)!=reverseStr1.charAt(index)){
                    isContinueLeft=false;
                }
                //3.对称点在str1中
                if(isContinueRight&&!str1.equals(temp1)&&dicMap.containsKey(temp1)){
                    if(!strList.contains(i+","+dicMap.get(temp1))&&checkPa(str1+temp1)) {
                        result.add(Arrays.asList(i,dicMap.get(temp1)));
                        strList.add(i+","+dicMap.get(temp1));
                    }
                }
                if(isContinueLeft&&!str1.equals(temp2)&&dicMap.containsKey(temp2)){
                    if(!strList.contains(dicMap.get(temp2)+","+i)&&checkPa(temp2+str1)) {
                        result.add(Arrays.asList(dicMap.get(temp2),i));
                        strList.add(dicMap.get(temp2)+","+i);
                    }
                }
                index--;
            }
        }
        return result;
    }
    private boolean checkPa(String str) {
        int i = 0, j = str.length() - 1;

        while(i < j){
            if(str.charAt(i) != str.charAt(j))  return false;
            i++;
            j--;
        }

        return true;
    }


    public static void main(String[] args) {
        PalindromePairs palindromePairs=new PalindromePairs();
        String[] strs={"a","b","c","abb","ac","aa"};
        System.out.println(palindromePairs.palindromePairs(strs));
    }
}
