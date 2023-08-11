import java.util.function.Function;

public class Test {
    public static void main(){
//        System.out.println(test("hello"));
    }

    public static Function<String,String> test(){
        return Test::newHello;
    }

    public static String newHello(String param){

        return param;
           }
}
