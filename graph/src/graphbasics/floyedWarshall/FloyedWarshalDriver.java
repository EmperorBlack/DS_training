package graphbasics.floyedWarshall;

public class FloyedWarshalDriver {
    public static void main(String[] args) {
//new Solution().shortest_distance(new int[][]{{0,1,43},{1,0,6},{-1,-1,0}});

String a = "Java";
String b = "Programming";
String c = "Java"+"Programming";
String d= "JavaProgramming";

        System.out.println(c==d);
        System.out.println(c.equals(d));
    }
}

class Solution
{
    public void shortest_distance(int[][] matrix)
    {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                if(matrix[i][j] ==-1){
                    matrix[i][j] = Integer.MAX_VALUE;
                }
            }
        }

        for (int k = 0; k < matrix.length; k++) {
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix.length; j++) {

                    if (matrix[i][k] != Integer.MAX_VALUE && matrix[k][j] != Integer.MAX_VALUE){

                        if((matrix[i][k] + matrix[k][j]) < matrix[i][j]){
                            matrix[i][j] = matrix[i][k] + matrix[k][j];
                        }
                    }
                }
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                if(matrix[i][j] == Integer.MAX_VALUE){
                    matrix[i][j] = -1;
                }
            }
        }

    }

}