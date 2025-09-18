package D202507;

import java.util.ArrayList;
import java.util.List;

/**
 * 37. 解数独
 * 已解答
 * 困难
 * 相关标签
 * premium lock icon
 * 相关企业
 * 编写一个程序，通过填充空格来解决数独问题。
 *
 * 数独的解法需 遵循如下规则：
 *
 * 数字 1-9 在每一行只能出现一次。
 * 数字 1-9 在每一列只能出现一次。
 * 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。（请参考示例图）
 * 数独部分空格内已填入了数字，空白格用 '.' 表示。
 * 输入：board = [["5","3",".",".","7",".",".",".","."],["6",".",".","1","9","5",".",".","."],[".","9","8",".",".",".",".","6","."],["8",".",".",".","6",".",".",".","3"],["4",".",".","8",".","3",".",".","1"],["7",".",".",".","2",".",".",".","6"],[".","6",".",".",".",".","2","8","."],[".",".",".","4","1","9",".",".","5"],[".",".",".",".","8",".",".","7","9"]]
 * 输出：[["5","3","4","6","7","8","9","1","2"],["6","7","2","1","9","5","3","4","8"],["1","9","8","3","4","2","5","6","7"],["8","5","9","7","6","1","4","2","3"],["4","2","6","8","5","3","7","9","1"],["7","1","3","9","2","4","8","5","6"],["9","6","1","5","3","7","2","8","4"],["2","8","7","4","1","9","6","3","5"],["3","4","5","2","8","6","1","7","9"]]
 * 解释：输入的数独如上图所示
 * 示：
 *
 * board.length == 9
 * board[i].length == 9
 * board[i][j] 是一位数字或者 '.'
 * 题目数据 保证 输入数独仅有一个解
 * https://leetcode.cn/problems/sudoku-solver/solutions/?envType=problem-list-v2&envId=w8OJJIbl
 * @Author UGcris
 * @date 2025-07-09
 **/
public class SudokuSolver0 {
    boolean[][] rowv=new boolean[9][9];
    boolean[][] colv=new boolean[9][9];
    boolean[][] squv=new boolean[9][9];
    private List<int[]> spaces = new ArrayList<>();

    public void solveSudoku(char[][] board) {

        for(int x=0;x<9;x++){
            for(int y=0;y<9;y++){
                if('.'==board[x][y]){
                    spaces.add(new int[]{x,y});
                    continue;
                }
                int idx=board[x][y]-'1';
                rowv[x][idx]=colv[y][idx]=squv[getsquidx(x,y)][idx]=true;
            }
        }
        //简单的处理
        firstSolve(board);
        //猜想
        guess(board);
    }

    private void guess(char[][] board) {
        if(spaces.isEmpty()){
            return;
        }
        try {
            guess(board,0);
        }catch (Exception e){

        }
    }

    private void guess(char[][] board, int size) throws Exception{
        if(size==spaces.size()){
            throw new Exception("结束");
        }
        int x = spaces.get(size)[0], y = spaces.get(size)[1];
        boolean[] arr1 = rowv[x], arr2 = colv[y], arr3 = squv[getsquidx(x, y)];
        for (int idx = 0; idx < 9; idx++) {
            if (arr1[idx] || arr2[idx] || arr3[idx]) {
            }else {
                arr1[idx] = arr2[idx] = arr3[idx] = true;
                board[x][y] = (char) ('0' + idx+1);
                guess(board,size+1);
                arr1[idx] = arr2[idx] = arr3[idx] = false;
            }
        }
    }

    private void firstSolve(char[][] board) {
        boolean filled=true;
        while (filled){
            filled=false;
            for (int i = 0; i < spaces.size(); i++) {
                int x = spaces.get(i)[0], y = spaces.get(i)[1];
                int value = computer(x,y);
                if(value<0){
                    break;
                }
                if (value > 0) {
                    filled=true;
                    spaces.remove(i--);
                    board[x][y] = (char) ('0' + value);
                }
            }
        }
    }

    private int computer(int x, int y) {
        int value = -1;
        boolean[] arr1 = rowv[x], arr2 = colv[y], arr3 = squv[getsquidx(x, y)];
        for (int idx = 0; idx < 9; idx++) {
            if (arr1[idx] || arr2[idx] || arr3[idx]) {
            }else {
                if (value < 0) {
                    value = idx;
                } else {
                    return 0;
                }
            }
        }
        if (value >= 0) {
            arr1[value] = arr2[value] = arr3[value] = true;
            return value+1;
        }
        return value;
    }

    private int solveSudoku(char[][] board,int[][] rowv,int[][] colv,int[][] squv,int[][] nilv,int nilSize) {
        char[][] boardtemp=new char[9][9];
        while (nilSize > 0) {
            int clearsize = 0;
            for (int i = 0; i < nilSize; i++) {
                int[] idarr = nilv[i];
                if (clearsize > 0) nilv[i - clearsize] = idarr;
                int x = idarr[0], y = idarr[1];
                int value = computer(rowv[x], colv[y], squv[getsquidx(x, y)]);
                if(value<0){
                    return -1;
                }
                if (value > 0) {
                    clearsize++;
                    boardtemp[x][y] = (char) ('0' + value);
                }
            }
            if(clearsize==0){
                break;
            }
            nilSize -= clearsize;
        }
        //猜想
        if(nilSize>0){
            nilSize--;
            int x = nilv[nilSize][0], y = nilv[nilSize][1];
            int value = computer(rowv[x], colv[y], squv[getsquidx(x, y)],0);
            if(nilSize==0){
                return computer(rowv[x], colv[y], squv[getsquidx(x, y)],value);
            }
            while (value>0){
                int temp=solveSudoku(board,copy(rowv),copy(colv),copy(squv),copy(nilv),nilSize);
                if(temp==0){
                    board[x][y]=(char) ('0'+value);
                    nilSize=0;
                    break;
                }
                value=backAndcomputer(rowv[x], colv[y], squv[getsquidx(x, y)],value);
            }
        }
        if(nilSize==0){
            combie(board,boardtemp);
        }
        return nilSize;
    }

    private int[][] copy(int[][] rowv) {
        int[][] newrowv=new int[rowv.length][];
        for(int i=0;i<rowv.length;i++){
            newrowv[i]=rowv[i].clone();
        }
        return newrowv;
    }

    private void combie(char[][] board, char[][] boardtemp) {
        for(int x=0;x<9;x++){
            for(int y=0;y<9;y++){
                if(boardtemp[x][y]!='\0'){
                    board[x][y]=boardtemp[x][y];
                }
            }
        }
    }



    private int backAndcomputer(int[] arr1,int[] arr2,int[] arr3,int idx){
        arr1[idx-1]=0;
        arr2[idx-1]=0;
        arr3[idx-1]=0;
        return computer(arr1,arr2,arr3,idx);
    }
    private int computer(int[] arr1,int[] arr2,int[] arr3,int idx){
        int value=-1;
        for(;idx<9;idx++){
            if(arr1[idx]==0 && arr2[idx]==0 && arr3[idx]==0){
                if(value<0){
                    value=idx;
                    break;
                }
            }
        }
        if(value>=0){
            arr1[value]=1;
            arr2[value]=1;
            arr3[value]=1;
            value++;
        }
        return value;
    }
    private int computer(int[] arr1,int[] arr2,int[] arr3){
        int value=-1;

        for(int idx=0;idx<9;idx++){
            if(arr1[idx]==0 && arr2[idx]==0 && arr3[idx]==0){
                if(value<0){
                    value=idx;
                }else{
                    return 0;
                }
            }
        }
        if(value>=0){
            arr1[value]=1;
            arr2[value]=1;
            arr3[value]=1;
            value++;
        }
        return value;
    }
    private int getsquidx(int x,int y){
        return x/3+y/3*3;
    }
}