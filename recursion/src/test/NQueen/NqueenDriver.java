package test.NQueen;

import java.util.ArrayList;
import java.util.List;

public class NqueenDriver {

    public static List<List<String>> solveNQueens(int n) {

        char board[][] = new char[n][n];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                board[i][j] = '.';
            }
        }
        List<List<String>> result = new ArrayList<>();
        placeNQueen(board,0,result);
        return result;

    }

    public static void  placeNQueen(char[][] board,int col,List<List<String>> result ){

        if(col==board.length){
            constructResult(board,result);
            return;
        }

        for (int i = 0; i < board.length; i++) {
            if(isSafe(board,i,col)){
                board[i][col]  = 'Q';
                placeNQueen(board,col+1,result);
                board[i][col] = '.';
            }
        }

    }

    public static void constructResult(char[][] board,List<List<String>> result){
        ArrayList<String> temp= new ArrayList<>();
        for (int i = 0; i < board.length; i++) {

            String s = new String(board[i]);
            temp.add(s);
        }
        result.add(temp);
    }


    public static boolean isSafe(char[][] a, int i , int j){
        int tempI = i-1;
        int tempJ = j-1;

        while (tempI>=0 && tempJ>=0 ){
            if(a[tempI][tempJ] == 'Q'){
                return false;
            }
            tempI--; tempJ--;
        }

        tempI = i;
        tempJ = j-1;

        while ( tempJ>=0){
            if(a[tempI][tempJ] == 'Q'){
                return false;
            }
            tempJ--;
        }

        tempI = i+1;
        tempJ = j-1;

        while ( tempJ>=0 && tempI< a.length){
            if(a[tempI][tempJ] == 'Q'){
                return false;
            }
            tempI++; tempJ--;
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(solveNQueens(4));

    }
}
