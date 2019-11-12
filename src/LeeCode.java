public class LeeCode {
    /**
     *  将1-n*n螺旋放入二维数组中
     * @param n 最大的数字
     * @return  二维数组
     */
    public int[][] generateMatrix(int n) {
        int [][]mat = new int[n][n];
        //限定边界
        int l = 0 ,t=  0, r = n-1, b = n-1;
        int num = 1;
        while(num<=n*n){
            //左上 右上
            for(int i = l ; i<= r ; i++){
                mat[t][i] = num++;
            }
            t++;
            //右上 右下
            for(int i = t ; i<=b ; i++){
                mat[i][r] = num++;
            }
            r--;
            //右下 左下
            for(int i = r ; i>= l ; i--){
                mat[b][i] = num++;
            }
            b--;
            //左下 右上
            for(int i = b ; i >= t ; i--){
                mat[i][l] = num++;
            }
            l++;
        }
        return mat;
    }
    /**
     *  不同路径
     *  从左上到右下有多少不同的路径 只能向左或者向下走
     *  使用一个二维数组每个元素存放从左上到当前位置的路径
     * @param m 行
     * @param n 列
     * @return 不同路径的个数
     */
    public int uniquePaths(int m, int n) {
        int [][]res = new int[m][n];
        for(int i = 0 ; i < m ; i++){
            for(int j =  0 ; j < n ; j++){
                if(i== 0 || j ==0){
                    res[i][j] = 1;
                }else{
                    res[i][j] = res[i-1][j] + res[i][j-1];
                }
            }
        }
        return res[m-1][n-1];
    }
    /**
     * 二维数组的最小 从左上 角到右下角的距离
     * 从左上角开始遍历二维数组，因为只能从左边或者上边进入下一个方格，所以第一行必定是来自左边
     * 第一列必定是来自右边，其余的是上边或者左边的较小值，
     * 最后返回最后一个元素
     * @param grid 二位数组
     * @return 最小距离
     */
    public int minPathSum(int[][] grid) {
        for(int i = 0 ; i < grid.length;i++){
            for(int j = 0 ; j <grid[0].length ; j++){
                if(i == 0 && j == 0 ){
                }else if(i==0){
                    grid[i][j] = grid[i][j-1]+grid[i][j];
                }else if(j==0){
                    grid[i][j] = grid[i-1][j] + grid[i][j];
                }else{
                    grid[i][j] = Math.min(grid[i-1][j],grid[i][j-1])+grid[i][j];
                }
            }
        }
        return grid[grid.length-1][grid[0].length-1];
    }
}
