package test.NQueen;

import java.util.ArrayList;
import java.util.List;

public class NQueenDriver2 {
    public static List<List<String>> solveNQueens(int n) {

        char board[][] = new char[n][n];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                board[i][j] = '.';
            }
        }
        List<List<String>> result = new ArrayList<>();
        boolean rowCheck[] = new boolean[n];
        boolean downD[] = new boolean[(2*n)-1];
        boolean upD[] = new boolean[(2*n)-1];
        placeNQueen(board,0,result,upD,downD,rowCheck);
        return result;

    }

    public static void  placeNQueen(char[][] board,int col,List<List<String>> result ,boolean upD[],boolean downD[],boolean rowCheck[]){

        if(col==board.length){
            constructResult(board,result);
            return;
        }

        for (int i = 0; i < board.length; i++) {
            if(isSafe(board,i,col,upD,downD,rowCheck)){
                board[i][col]  = 'Q';
                setIandJ(board.length-1,i,col,upD,downD,rowCheck);
                placeNQueen(board,col+1,result,upD,downD,rowCheck);
                board[i][col] = '.';
                setIandJ(board.length-1,i,col,upD,downD,rowCheck);
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


    public static boolean isSafe(char[][] a, int i , int j,boolean upD[],boolean downD[],boolean rowCheck[]){
        if(upD[i+j]){
            return false;
        }
        if(downD[(i-j)+(a.length-1)]){
            return false;
        }
        if (rowCheck[i]){
            return false;
        }
        return true;
    }

    public static void setIandJ(int n,int i,int j,boolean upD[],boolean downD[],boolean rowCheck[]){
        upD[i+j] = !upD[i+j];
        downD[(i-j)+n] = !downD[(i-j)+n];
        rowCheck[i] = !rowCheck[i];
    }
    public static void main(String[] args) {
        System.out.println(solveNQueens(4));
    }
}
