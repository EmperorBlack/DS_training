import java.util.HashSet;
import java.util.Set;

public class UnionOfNumber {

    public static void main(String args[]){

    }
    public static int doUnion(int a[], int n, int b[], int m)
    {
        Set<Integer> set = new HashSet<>();
        for(int i=0;i<n;i++){
            set.add(a[i]);
        }
        for (int num:b
             ) {
            set.add(num);
        }
        return set.size();
    }
}
