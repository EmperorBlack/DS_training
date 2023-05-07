import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ParathensisMatch {
    public static void main(String[] args) {
        System.out.println(isValidString("()"));
        System.out.println(isValidStringUsingSwitch("()"));
    }

    public static boolean isValidStringUsingSwitch(String s){
        if(s==null || s.isEmpty() || s.length()%2 != 0){
            return false;
        }
        Stack<Character> stack = new Stack<>();
        for (char c: s.toCharArray()
             ) {

            switch (c){
                case '(':
                case '{':
                case '[':
                    stack.push(c);
                    break;
                case '}':
                    if (stack.isEmpty() || stack.peek() != '{')
                        return false;
                    stack.pop();
                    break;
                case ']':
                    if (stack.isEmpty() || stack.peek() != '[')
                        return false;
                    stack.pop();
                    break;
                case ')':
                    if (stack.isEmpty() || stack.peek() != '(')
                        return false;
                    stack.pop();
                    break;
            }

        }
        if(stack.isEmpty()){
            return true;
        }
        return false;
    }
    public static boolean isValidString(String s){

        if(s==null || s.isEmpty() || s.length()%2 != 0){
            return false;
        }
        Map<Character,Character> presets = new HashMap<>();
        presets.put(')','(');
        presets.put('}','{');
        presets.put(']','[');

        Stack<Character> stack = new Stack<>();

        for (char c:s.toCharArray()
             ) {
            if(!presets.containsKey(c)){
                stack.push(c);
            }else {
                if(stack.isEmpty() || stack.peek() != presets.get(c)){
                    return false;
                }
                stack.pop();
            }

        }
        if(stack.isEmpty()){
            return true;
        }
        return false;

    }
}
