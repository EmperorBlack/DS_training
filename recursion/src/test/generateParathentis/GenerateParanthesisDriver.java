package test.generateParathentis;

import java.util.ArrayList;
import java.util.List;

public class GenerateParanthesisDriver {
    public static void main(String[] args) {
        System.out.println(new Solution().generateParenthesis(3));
    }
}

class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();

        generateAllParenthesis(n,0,0,"",result);
        return result;
    }

    public void generateAllParenthesis(int max,int open, int close,String par,List<String> result) {

        if(par.length() == max*2){
            result.add(par);
            return;
        }

        if(open < max){
            generateAllParenthesis(max,open+1,close,par+"(",result);
        }
        if(close < open){
            generateAllParenthesis(max,open,close+1,par+")",result);
        }

    }
}
