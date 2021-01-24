class Solution {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int rowNums = grid.length;
        int colNums = grid[0].length;
        int nums = 0;
        for (int rowid = 0; rowid < rowNums; rowid++) {//遍历每一个格子
            for (int colid = 0; colid < colNums; colid++) {
                if (grid[rowid][colid] == '1') {//如果该格子为“1”，则表示找到一个岛屿
                    nums++;
                    dfsScan(rowid, colid, grid);//遍历所有其相邻且为“1”的格子，并置为“2”
                }
            }
        }
        //如果要计算岛屿的面积之和，只需遍历统计值不等于'0'的格数
        return nums;
    }

    public void dfsScan(int rowid, int colid, char[][] grid) {
        if(rowid < 0 || rowid >= grid.length || colid < 0 || colid >= grid[0].length){
            return;
        }
        if(grid[rowid][colid] != '1'){
            return;
        }
        grid[rowid][colid] = '2';
        dfsScan(rowid, colid + 1, grid);
        dfsScan(rowid, colid - 1, grid);
        dfsScan(rowid + 1, colid, grid);
        dfsScan(rowid - 1, colid, grid);
    }
}