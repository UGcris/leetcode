import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。
 *
 * 注意：答案中不可以包含重复的三元组。
 *
 * 例如, 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 *
 * 满足要求的三元组集合为：
 * [
 *   [-1, 0, 1],
 *   [-1, -1, 2]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/3sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author UGcris
 * @date 2019/9/19
 **/
public class Sum320 {
    /**
     * 暴力超时
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result=new ArrayList<>();
        int maxIndex=nums.length;
        if(maxIndex<3) return result;
        String strResult="";
        for(int i=0;i<maxIndex-2;i++){
            int index2=i+1;
            int value1=nums[i];
            do{
               int index3=index2+1;
               int value2=nums[index2];
               do{
                   int value3=nums[index3];
                   if(value1+value2+value3==0){
                       String signStr1=";"+value1+","+value2+","+value3+";";
                       String signStr4=";"+value1+","+value3+","+value2+";";
                       String signStr2=";"+value2+","+value3+","+value1+";";
                       String signStr5=";"+value2+","+value1+","+value3+";";
                       String signStr3=";"+value3+","+value1+","+value2+";";
                       String signStr6=";"+value3+","+value2+","+value1+";";
                       if(strResult.indexOf(signStr1)<0&&strResult.indexOf(signStr2)<0&&strResult.indexOf(signStr3)<0
                               &&strResult.indexOf(signStr4)<0&&strResult.indexOf(signStr5)<0&&strResult.indexOf(signStr6)<0){
                           strResult+=signStr1+signStr2+signStr3+signStr4+signStr5+signStr6;
                           List<Integer> subResult=new ArrayList<>();
                           subResult.add(nums[i]);
                           subResult.add(nums[index2]);
                           subResult.add(nums[index3]);
                           result.add(subResult);
                       }
                   }
                   index3++;
               }while (index3<maxIndex);
               index2++;
            }while (index2<maxIndex-1);
        }
        return  result;
     }

    /**
     * 标签：数组遍历
     * 首先对数组进行排序，排序后固定一个数 nums[i]nums[i]，再使用左右指针指向 nums[i]nums[i]后面的两端，数字分别为 nums[L]nums[L] 和 nums[R]nums[R]，计算三个数的和 sumsum 判断是否满足为 00，满足则添加进结果集
     * 如果 nums[i]nums[i]大于 00，则三数之和必然无法等于 00，结束循环
     * 如果 nums[i]nums[i] == nums[i-1]nums[i−1]，则说明该数字重复，会导致结果重复，所以应该跳过
     * 当 sumsum == 00 时，nums[L]nums[L] == nums[L+1]nums[L+1] 则会导致结果重复，应该跳过，L++L++
     * 当 sumsum == 00 时，nums[R]nums[R] == nums[R-1]nums[R−1] 则会导致结果重复，应该跳过，R--R−−
     * 时间复杂度：O(n^2)O(n
     * 2
     *  )，nn 为数组长度
     *
     * 作者：guanpengchn
     * 链接：https://leetcode-cn.com/problems/3sum/solution/hua-jie-suan-fa-15-san-shu-zhi-he-by-guanpengchn/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum2(int[] nums) {
        List<List<Integer>> result=new ArrayList<>();
        int len=nums.length;
        //冒泡排序
        Boolean bo=true;//判断是否发生排序
        int tmp=0;
        for(int i=1;i<len&&bo;i++){
            bo=false;
            for(int j=0;j<len-i;j++){
                if(nums[j]>nums[j+1]){
                    tmp=nums[j];
                    nums[j]=nums[j+1];
                    nums[j+1]=tmp;
                    bo=true;
                }
            }
        }
        for(int i=0;i<len-2;i++){
            int value1=nums[i];
            if(value1>0){
                break;
            }
            if(i>0&&value1==nums[i-1]) continue;
            int indexL=i+1;
            int indexR=len-1;
            while (indexL<indexR){
                int valueL=nums[indexL];
                int valueR=nums[indexR];
                int sum=value1+valueL+valueR;
                if(sum==0){
                    result.add(Arrays.asList(value1,valueL,valueR));
                    while (indexL<indexR &&nums[indexL]==nums[indexL+1]) indexL++;
                    while (indexL<indexR &&nums[indexR]==nums[indexR-1]) indexR--;
                    indexL++;
                    indexR--;
                }else if(sum<0){
                    indexL++;
                }else if(sum>0){
                    indexR--;
                }
            }
        }
        return result;
    }
    public static void main(String[] args) {
        Sum320 sum320=new Sum320();
        int[] nums={0,0,0};
        System.out.println(sum320.threeSum2(nums));
    }
}
