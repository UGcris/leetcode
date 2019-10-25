import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 *
 *
 *
 * 上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。 感谢 Marcos 贡献此图。
 *
 * 示例:
 *
 * 输入: [0,1,0,2,1,0,1,3,2,1,2,1]
 * 输出: 6
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/trapping-rain-water
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author UGcris
 * @date 2019/10/25
 **/
public class TrappingRainWater {

    public int trap(int[] height) {

        int eare=0;
        int maxLength=-1;
        int size=height.length;
        int[] copy=Arrays.copyOf(height,height.length);
        Arrays.sort(copy);
        List<Integer> arr=new ArrayList<>();
        for (int i = size-1; i >=0; i--) {
            arr.add(copy[i]);
        }
        for (int i = 0; i < size-1; i++) {
            arr.remove(arr.indexOf(height[i]));
            if(height[i]==0&&eare==0&&maxLength<0){
                continue;//当在部分段内起始为0时，跳过
            }
            if(arr.get(0)<height[i]){
                maxLength=arr.get(0);
            }else if(maxLength<height[i]){
                maxLength=height[i];
            }else if(maxLength>height[i]){
                eare+=maxLength-height[i];
            }

        }
        return eare;

    }

}
