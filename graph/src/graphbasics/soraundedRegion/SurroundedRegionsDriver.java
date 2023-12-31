package graphbasics.soraundedRegion;

public class SurroundedRegionsDriver {

    public static void main(String[] args) {
        new Solution().solve(new char[][]{{'X','X','X','X'},{'X','O','O','X'},{'X','X','O','X'},{'X','O','X','X'}});
    }
}



class Solution {
    public void solve(char[][] board) {

        boolean visited[][] = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            if(board[i][0] == 'O' && !visited[i][0]){
                dfs(board,visited,i,0);
            }

            if(board[i][board[0].length-1] == 'O' && !visited[i][board[0].length-1]){
                dfs(board,visited,i,board[0].length-1);
            }
        }

        for (int i = 0; i < board[0].length; i++) {
            if(board[0][i] == 'O' && !visited[0][i]){
                dfs(board,visited,0,i);
            }

            if(board[board.length-1][i] == 'O' && !visited[board.length-1][i]){
                dfs(board,visited,board.length-1,i);
            }
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {

                if(!visited[i][j] && board[i][j] == 'O'){
                    board[i][j] = 'X';
                }
            }
        }

    }

    public void dfs(char[][] board, boolean[][] visited, int i, int j){

        if(i >=0 && i < board.length && j >=0 && j< board[0].length && !visited[i][j] && board[i][j] == 'O'){

            visited[i][j] = true;
            dfs(board, visited,i+1,j);
            dfs(board, visited,i-1,j);
            dfs(board, visited,i,j+1);
            dfs(board, visited,i,j-1);
        }

    }
}