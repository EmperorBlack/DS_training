import java.util.Arrays;

public class RotateMatrixInplace {

    public static void main(String args[]){

        int[][] matrix = new int[][]{{1,2,3},{4,5,6},{7,8,9}};
        doRotationPrintAt90(matrix);
    }

    public static void doRotationPrintAt90(int[][] matrix){

//        int[][] result = new int[matrix[0].length][matrix.length];
//        for(int i=0;i<matrix[0].length;i++){
//            int k = 0;
//            for(int j= matrix.length-1;j>=0;j--){
//                System.out.print(matrix[j][i] + " ");
//                result[i][k] = matrix[j][i];
//                k=k+1;
//
//            }
//            System.out.println();
//        }

        for(int i=0;i<matrix[0].length;i++){
            for(int j=i;j<matrix.length;j++){
               int temp = matrix[i][j];
               matrix[i][j] = matrix[j][i];
               matrix[j][i] = temp;
            }
        }
        int col = matrix[0].length;
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<col/2;j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][col-(j+1)];
                matrix[i][col-j-1] = temp;
            }
        }

        for (int mat[]:matrix){
            System.out.print(Arrays.toString(mat));
        }

    }


}
