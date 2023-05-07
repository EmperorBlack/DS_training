import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PrintStringStreamAPI {

    public static void main(String args[]){
        List<String> list=Arrays.asList("milu","kartik");
       String str= list.stream()
                .collect(Collectors.joining(",","(",")"));

        System.out.println(str);




    }
}
