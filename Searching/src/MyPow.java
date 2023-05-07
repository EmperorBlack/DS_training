public class MyPow {

    public static void main(String args[]){
        System.out.println(myPow(-1.00000,-2147483648));
    }
    public static double myPow(double x, long n) {
        // return Math.pow(x,n);
        if(x == 1d ){
            return 1d;
        }
        if(x == -1d ){
            return -1d;
        }
        if(n <= Integer.MIN_VALUE){
            return 0.0d;
        }
        double result = 1d;
//        x = Math.abs(x);
//        int powNum= Math.abs(n);
        long powNum= n * -1;
        for(int i=1;i<powNum;i=i+2){
            result = result * (x*x);
        }
        if(powNum%2 != 0)
            result = result*x;
        System.out.println(Integer.MIN_VALUE);
        if(n>=0){
            return result;
        }else{
            return 1/result;
        }



    }

}

//    double result = 1d;
//        if(n>=0){
//                for(int i=1;i<=n;i++){
//                result = result * x;
//                }
//                }else{
//                n = Math.abs(n);
//                for(int i=1;i<=n;i++){
//                result = result * x;
//                }
//                result = 1/result;
//                }
//                return result;
