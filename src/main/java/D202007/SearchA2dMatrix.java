package D202007;

/**
 * 编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性：
 * <p>
 * 每行中的整数从左到右按升序排列。
 * 每行的第一个整数大于前一行的最后一个整数。
 * 示例 1:
 * <p>
 * 输入:
 * matrix = [
 * [1,   3,  5,  7],
 * [10, 11, 16, 20],
 * [23, 30, 34, 50]
 * ]
 * target = 3
 * 输出: true
 * 示例 2:
 * <p>
 * 输入:
 * matrix = [
 * [1,   3,  5,  7],
 * [10, 11, 16, 20],
 * [23, 30, 34, 50]
 * ]
 * target = 13
 * 输出: false
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/search-a-2d-matrix
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @Author UGcris
 * @date 2020/7/22
 **/
public class SearchA2dMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length > 0 && matrix[0].length > 0) {
            int x = matrix[0].length - 1;
            for (int i = 0; i < matrix.length; i++) {
                if (matrix[i][0] == target || matrix[i][x] == target) return true;
                if (matrix[i][0] > target) return false;
                if (matrix[i][x] > target) {
                    for (int j = 1; j < x; j++) {
                        if (matrix[i][j] == target) return true;
                        if (matrix[i][j] > target) return false;
                    }
                }
            }
        }
        return false;
    }
}
