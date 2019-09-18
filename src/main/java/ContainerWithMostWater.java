/**
 * 给定 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 *
 * 说明：你不能倾斜容器，且 n 的值至少为 2。
 *示例:
 *
 * 输入: [1,8,6,2,5,4,8,3,7]
 * 输出: 49
 * @Author UGcris
 * @date 2019/9/18
 **/
public class ContainerWithMostWater {
    /**
     * 暴力解法
     * @param height
     * @return
     */
    public int maxArea(int[] height) {
        int result=0;
        for(int i=0;i<height.length-1;i++){
            for(int j=i+1;j<height.length;j++){
                int temp=(j-i)*(height[i]>height[j]?height[j]:height[i]);
                if(temp>result) result=temp;
            }
        }
        return result;
    }

    /**
     * 双指针法
     * 农村包围城市，从外围往里缩，找最大的值
     * @param height
     * @return
     */
    public int maxArea2(int[] height) {
        int result=0;
        int beginIndex=0;
        int endIndex=height.length-1;
        while (endIndex-beginIndex>0){
            int temp=0;
            if(height[endIndex]>height[beginIndex]){
                temp=(endIndex-beginIndex)*height[beginIndex];
                beginIndex++;
            }else{
                temp=(endIndex-beginIndex)*height[endIndex];
                endIndex--;
            }
            if(temp>result) result=temp;
        }
        return result;
    }
}
