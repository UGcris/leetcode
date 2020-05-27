package TOTO;

/**
 * 统计所有小于非负整数 n 的质数的数量。
 *
 * 示例:
 *
 * 输入: 10
 * 输出: 4
 * 解释: 小于 10 的质数一共有 4 个, 它们是 2, 3, 5, 7 。
 * @Author UGcris
 * @date 2020/4/26
 **/
public class CountPrimes {
    public int countPrimes(int n) {
        int ans=0;
        int[] arr=new int[n+1];
        for (int i = 2; i < n+1; i++) {
            if(1==arr[i]) continue;
            int mutl=i;
            for (int j = i; j < n/2+1; j++) {

            }
            while (i*mutl<n&&i*mutl>0){
                arr[i*mutl]=1;
                mutl++;
            }
            ans++;
        }
        return ans;
    }

    public int countPrimes2(int n) {
        int ans=0;
        int[] arr=new int[n+1];
        for (int i = 2; i < n+1; i++) {
            if(1==arr[i]) continue;
            int mutl=i;
            while (i*mutl<n&&i*mutl>0){
                arr[i*mutl]=1;
                mutl++;
            }
            ans++;
        }
        return ans;
    }
}
