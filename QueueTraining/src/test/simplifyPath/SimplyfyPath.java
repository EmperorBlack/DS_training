package test.simplifyPath;

import java.util.Arrays;
import java.util.Stack;

public class SimplyfyPath {

    public static void main(String[] args) {

        System.out.println(Arrays.toString("/home//foo/".split("/")));
        simplifyPath("/a/./b/../../c/");

    }
    public static String simplifyPath(String path) {

        Stack<String> stack = new Stack<>();
        Stack<String> resultStack = new Stack<>();
        String pathArray[] = path.split("/");
        for ( String p : pathArray
             ) {
            if(!p.isEmpty()){
                if(!stack.isEmpty() && p.equals("..")){
                    stack.pop();
                    continue;
                }

                if(stack.isEmpty() && p.equals("..")){
                    continue;
                }


                if(p.equals(".")){
                    continue;
                }
                stack.push(p);
            }

        }
        while (!stack.isEmpty()){
            resultStack.push(stack.pop());
        }

        StringBuilder result = new StringBuilder();
        while(!resultStack.isEmpty()){
            result.append("/"+resultStack.pop());
        }

        if(result.isEmpty()){
            return "/";
        }

        System.out.println(result.toString());
        return  result.toString();
    }

}
