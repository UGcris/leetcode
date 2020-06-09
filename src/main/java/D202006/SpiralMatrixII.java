package D202006;

/**
 * 给定一个正整数 n，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的正方形矩阵。
 * <p>
 * 示例:
 * <p>
 * 输入: 3
 * 输出:
 * [
 * [ 1, 2, 3 ],
 * [ 8, 9, 4 ],
 * [ 7, 6, 5 ]
 * ]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/spiral-matrix-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @Author UGcris
 * @date 2020/6/9
 **/
public class SpiralMatrixII {
    public int[][] generateMatrix(int n) {
        int[][] ans = new int[n][n];
        int num = 1;
        String flag = "RIGHT";//初始向右
        int indexX = 0, indexY = 0;
        while (num <= n * n) {
            if (indexX == n || indexY == n || 0 != ans[indexX][indexY]) {
                break;
            }
            if ("LEFT".equals(flag)) {
                ans[indexX][indexY--] = num++;
                if (indexY < 0 || 0 != ans[indexX][indexY]) {
                    flag = "UP";
                    indexX--;
                    indexY++;
                }
            } else if ("UP".equals(flag)) {
                ans[indexX--][indexY] = num++;
                if (indexX < 0 || 0 != ans[indexX][indexY]) {
                    flag = "RIGHT";
                    indexX++;
                    indexY++;
                }
            } else if ("RIGHT".equals(flag)) {
                ans[indexX][indexY++] = num++;
                if (indexY == n || 0 != ans[indexX][indexY]) {
                    flag = "DOWN";
                    indexX++;
                    indexY--;
                }
            } else if ("DOWN".equals(flag)) {
                ans[indexX++][indexY] = num++;
                if (indexX == n || 0 != ans[indexX][indexY]) {
                    flag = "LEFT";
                    indexY--;
                    indexX--;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        SpiralMatrixII c = new SpiralMatrixII();
        c.generateMatrix(3);
    }
}
