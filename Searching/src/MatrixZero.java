import java.util.Arrays;

public class MatrixZero {

    public static void main(String args[]){

        int matrix[][] = new int[][]{{1,1,1},{1,0,1},{1,1,1}};

        makeZero(matrix);


    }

    public static void makeZero(int matrix[][]){

//        boolean row[] = new boolean[matrix.length];
//        boolean col[] = new boolean[matrix[0].length];
//
//        for(int i=0;i<matrix.length;i++){
//            for(int j =0;j<matrix[0].length;j++){
//                if(matrix[i][j] ==0){
//                    row[i] = true;
//                    col[j] = true;
//                }
//
//            }
//        }
//        System.out.println(Arrays.toString(row)+Arrays.toString(col));

//        for(int i=0;i<matrix.length;i++){
//            for(int j =0;j<matrix[0].length;j++){
//                if(row[i] || col[j]){
//                    matrix[i][j] = 0;
//                }
//                System.out.print(matrix[i][j]+"  ");
//
//            }
//            System.out.println();
//        }

        int col0 = 1, rows = matrix.length, cols = matrix[0].length;

        for (int i = 0; i < rows; i++) {
            if (matrix[i][0] == 0) col0 = 0;
            for (int j = 1; j < cols; j++)
                if (matrix[i][j] == 0)
                    matrix[i][0] = matrix[0][j] = 0;
        }

        for (int i = rows - 1; i >= 0; i--) {
            for (int j = cols - 1; j >= 1; j--)
                if (matrix[i][0] == 0 || matrix[0][j] == 0)
                    matrix[i][j] = 0;
            if (col0 == 0) matrix[i][0] = 0;
        }

        for(int i=0;i<matrix.length;i++){
            for(int j =0;j<matrix[0].length;j++){
                System.out.print(matrix[i][j]+"  ");
            }
            System.out.println();
        }

    }
}
