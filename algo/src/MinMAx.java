public class MinMAx {

    public static void main(String args[]){
        System.out.println(getMinMax(new long[]{10 ,5 ,3 ,9 ,8, 3},6));
    }
    static pair getMinMax(long a[], long n)
    {
        if(a.length ==0){
            return null;
        }

        long min =Long.MAX_VALUE;
        long max = Long.MIN_VALUE;

        for(int i =0;i<n;i++){
            if(a[i]<min){
                min = a[i];
            }
            if(a[i]>max){
                max = a[i];
            }
        }

        return new pair(min,max);
    }
}


class pair
{
    long first, second;
    public pair(long first, long second)
    {
        this.first = first;
        this.second = second;
    }

    public String toString(){
        return this.first + " "+ this.second;
    }
}