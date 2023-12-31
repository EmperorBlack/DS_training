package fibonanciSeries;

import java.util.Arrays;

public class fibonaciSeriesDriver {
    public static void main(String[] args) {
        System.out.println(new Solutions().fib(6));
    }
}

class Solutions{

    public int fib(int n) {

        int[] da = new int[n+1];
        Arrays.fill(da,-1);
        return findFibTab2(n,da);
    }

    public int findFib(int n,int[] da) {

        if(n <= 1){
            da[n] = n;
            return n;
        }
        if(da[n] != -1){
            return da[n];
        }else{
            int val = fib(n-1)+fib(n-2);
            da[n] = val;
            return val;
        }

    }

//    tabular ways
    public int findFibTab(int n,int[] da) {
//      set up base condition then calculate from this.
        da[0] =0;
        da[1] =1;
        for (int i = 2; i <= n; i++) {
            da[i] = da[i-1] + da[i-2];
        }
        return da[n];
    }

    public int findFibTab2(int n,int[] da) {
//      set up base condition then calculate from this.
        int prv = 0;
        int curr =  1;
        for (int i = 2; i <= n; i++) {
            int temp = prv+curr;
            prv = curr;
            curr = temp;
        }
        return curr;
    }
}

