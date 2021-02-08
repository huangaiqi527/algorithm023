/**
解题思路：
走到grid[rowid][colid]只能从其左边相邻的格grid[rowid][colid-1]或者上边相邻的格grid[rowid-1][colid]走过来，
所以到格子的最小路径为grid[rowid][colid] + min(grid[rowid][colid-1],grid[rowid-1][colid]);
需要特别注意的地方：
    a.grid[0][0]的最小路径为其本身
    b.grid[0][colid]的最小路径为其本身加上grid[0][colid-1]
    c.grid[rowid][0]的最小路径为其本身加上grid[rowid-1][0]
*/
class Solution {
    public int minPathSum(int[][] grid) {
        int rnum = grid.length;
        int cnum = grid[0].length;
        for(int rowid = 0; rowid < rnum; rowid++){
            for(int colid = 0 ; colid < cnum; colid++){
                if(rowid == 0 && colid == 0 ){
                    continue;
                }
                if(rowid == 0){
                    grid[rowid][colid] = grid[rowid][colid-1] + grid[rowid][colid];
                    continue;
                }
                if(colid == 0){
                    grid[rowid][colid] = grid[rowid-1][colid] + grid[rowid][colid];
                    continue;
                }
                grid[rowid][colid] = grid[rowid][colid] + Math.min(grid[rowid-1][colid], grid[rowid][colid-1]);
            }
        }
        return grid[rnum -1][cnum-1];
    }
    /*
    int minSum = 0;
    public int minPathSum(int[][] grid) {
        pathSum(0 ,0, 0, grid);
        return minSum;
    }

    public void pathSum(int rowid, int colid, int sum, int[][] grid) {
        if(rowid >=  grid.length || colid >= grid[0].length){
            return;
        }
        if(rowid == grid.length -1 && colid == grid[0].length -1 ){
            sum += grid[rowid][colid];
            minSum = minSum == 0 ? sum : Math.min(minSum, sum);
            return;
        }
        pathSum(rowid, colid +1, sum + grid[rowid][colid],  grid);
        pathSum(rowid +1, colid, sum + grid[rowid][colid],  grid);
        return;
    }*/
}