package test.Suduko;

public class SudukoDriver {
    public static void main(String[] args) {

        char[][] board= {
                {'9', '5', '7', '.', '1', '3', '.', '8', '4'},
                {'4', '8', '3', '.', '5', '7', '1', '.', '6'},
                {'.', '1', '2', '.', '4', '9', '5', '3', '7'},
                {'1', '7', '.', '3', '.', '4', '9', '.', '2'},
                {'5', '.', '4', '9', '7', '.', '3', '6', '.'},
                {'3', '.', '9', '5', '.', '8', '7', '.', '1'},
                {'8', '4', '5', '7', '9', '.', '6', '1', '3'},
                {'.', '9', '1', '.', '3', '6', '.', '7', '5'},
                {'7', '.', '6', '1', '8', '5', '4', '.', '9'}
        };
        solveSudoku(board);

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++)
                System.out.print(board[i][j] + " ");
            System.out.println();
        }
    }

    public static void solveSudoku(char[][] board) {
        solveSudukoHelper(board);

    }

    public static boolean solveSudukoHelper(char[][] board){
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {

                if(board[i][j] == '.'){
                    for (char k = '1'; k <= '9'; k++) {
                        if(canPlace(board,i,j,k)){
                            board[i][j] = k;
                            if(solveSudukoHelper(board)){
                                return true;
                            }else {
                                board[i][j] = '.';
                            }
                        }

                    }
                    return false;
                }


            }
        }
        return true;
    }

    public static boolean canPlace(char[][] board,int i, int j,char val){
        for (int k = 0; k < board.length; k++) {
            if(board[i][k] == val){
                return false;
            }
            if(board[k][j] == val){
                return false;
            }

            if(board[((i/3)*3)+(k/3)][((j/3)*3)+(k%3)] == val){

             return false;
            }
        }
        return true;
    }
}
