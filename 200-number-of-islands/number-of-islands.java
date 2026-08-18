class Solution {
    private int row;
    private int col;
    public int numIslands(char[][] grid) {
        int noOfIsland = 0;
        row = grid.length;
        col = grid[0].length;
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(grid[i][j]=='1'){
                    noOfIsland++;
                    dfs(grid,i,j);
                }
            }
        }
        return noOfIsland;
    }
    private void dfs(char[][] grid,int i, int j){
        if(i<0 || i>=row || j<0 || j>=col || grid[i][j]=='0') return;
        grid[i][j] = '0';
        dfs(grid,i+1,j);
        dfs(grid,i-1,j);
        dfs(grid,i,j+1);
        dfs(grid,i,j-1);
    }
}