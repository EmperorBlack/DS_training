public class RomanToInt {
    public static void main(String args[]) {
//        System.out.println(getIntFromRoman("IX"));
//        System.out.println(getIntFromRoman("LVIII"));
        System.out.println(romanToInt("MCMXCIV"));
//        System.out.println(getIntFromRoman("MCMXCIV"));
    }

    public static int getIntFromRoman(String roman) {
        int sum = 0;
        for (int i = 0; i < roman.length(); ) {

            switch (roman.charAt(i)) {
                case 'I':
                    if (i < roman.length() - 1 && roman.charAt(i + 1) == 'V') {
                        sum = sum + 4;
                        i += 2;
                    } else if (i < roman.length() - 1 && roman.charAt(i + 1) == 'X') {
                        sum = sum + 9;
                        i += 2;
                    } else {
                        sum += 1;
                        i++;
                    }
                    break;
                case 'V':
                    sum += 5;
                    i++;
                    break;
                case 'X':
                    if (i < roman.length() - 1 && roman.charAt(i + 1) == 'L') {
                        sum = sum + 40;
                        i += 2;
                    } else if (i < roman.length() - 1 && roman.charAt(i + 1) == 'C') {
                        sum = sum + 90;
                        i += 2;
                    } else {
                        sum += 10;
                        i++;
                    }
                    break;
                case 'L':
                    sum = sum + 50;
                    i++;
                    break;
                case 'C':
                    if (i < roman.length() - 1 && roman.charAt(i + 1) == 'D') {
                        sum = sum + 400;
                        i += 2;
                    } else if (i < roman.length() - 1 && roman.charAt(i + 1) == 'M') {
                        sum = sum + 900;
                        i += 2;
                    } else {
                        sum += 100;
                        i++;
                    }
                    break;
                case 'D':
                    sum = sum + 500;
                    i++;
                    break;
                case 'M':
                    sum = sum + 1000;
                    i++;
                    break;
                default:
                    break;

            }
        }
        return sum;
    }
    public static int romanToInt(String s) {

        int answer = 0,number =0, prev = 0;

        for (int j = s.length() - 1; j >= 0; j--) {
            switch (s.charAt(j)) {
                case 'M' -> number= 1000;
                case 'D' -> number= 500;
                case 'C' -> number= 100;
                case 'L' -> number= 50;
                case 'X' -> number= 10;
                case 'V' -> number= 5;
                case 'I' -> number= 1;
            }
            if (number < prev) {
                answer -= number;
            }
            else {
                answer += number;
            }
            prev = number;
        }
        return answer;
    }
}


//
//
//            if(roman.charAt(i)=='I'){
//                    if(i<roman.length()-1 && roman.charAt(i+1)=='V'){
//        sum = sum+4;
//        i+=2;
//        }else if(i<roman.length()-1 && roman.charAt(i+1)=='X'){
//        sum = sum+9;
//        i+=2;
//        }else{
//        sum+=1;
//        i++;
//        }
//        } else if (roman.charAt(i)=='V') {
//        sum+=5;
//        i++;
//        }else if(roman.charAt(i)=='X'){
//        if(i<roman.length()-1 && roman.charAt(i+1)=='L'){
//        sum = sum+40;
//        i+=2;
//        }else if(i<roman.length()-1 && roman.charAt(i+1)=='C'){
//        sum = sum+90;
//        i+=2;
//        }else {
//        sum+=10;
//        i++;
//        }
//        }else if(roman.charAt(i)=='L'){
//        sum = sum+50;
//        i++;
//        }else if(roman.charAt(i)=='C'){
//        if(i<roman.length()-1 && roman.charAt(i+1)=='D'){
//        sum = sum+400;
//        i+=2;
//        }else if(i<roman.length()-1 && roman.charAt(i+1)=='M'){
//        sum = sum+900;
//        i+=2;
//        }else {
//        sum+=100;
//        i++;
//        }
//        }else  if(roman.charAt(i)=='D'){
//        sum = sum+500;
//        i++;
//        }else if(roman.charAt(i)=='M'){
//        sum = sum+1000;
//        i++;
//        }
