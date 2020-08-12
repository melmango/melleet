package cn.melman.melleet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q017 {


    List<String> output = new ArrayList<String>();

    public void backtrack(String combination, String next_digits) {
        // if there is no more digits to check
        if (next_digits.length() == 0) {
            // the combination is done
            output.add(combination);
        }
        // if there are still digits to check
        else {
            // iterate over all letters which map
            // the next available digit
//            String digit = next_digits.substring(0, 1);
            char c = next_digits.charAt(0);
            String letters = getChars(c);
            for (int i = 0; i < letters.length(); i++) {
                String letter = getChars(c).substring(i, i + 1);
                // append the current letter to the combination
                // and proceed to the next digits
                backtrack(combination + letter, next_digits.substring(1));
            }
        }
    }

    public List<String> letterCombinations(String digits) {
        if (digits.length() != 0)
            backtrack("", digits);
        return output;
    }


    //贼慢！！
    public List<String> letterCombinations1(String digits) {
        List<String> res = new ArrayList<>();
        if (digits == null || digits.isEmpty()) {
            return res;
        }
        char[] cArray = digits.toCharArray();
//        Arrays.sort(cArray);
        for (int i = 0, len = cArray.length; i < len; i++) {
            char c = cArray[i];
            if (c > '9' || c < '2') {
                continue;
            }
//            if (i > 0 && c == cArray[i - 1]) {//排重
//                continue;
//            }
            String arr = getChars(c);
            if (i == 0) {
                for (int j = 0, clen = arr.length(); j < clen; j++) {
                    res.add(String.valueOf(arr.charAt(j)));
                }
            } else {
                List<String> temp = new ArrayList<>();
                for (int j = 0, clen = arr.length(); j < clen; j++) {
                    for (String s : res) {
                        temp.add(s + arr.charAt(j));
                    }
                }
                res = temp;
            }
        }
        return res;
    }

    private String getChars(char c) {
        switch (c) {
            case '2':
                return "abc";
            case '3':
                return "def";
            case '4':
                return "ghi";
            case '5':
                return "jkl";
            case '6':
                return "mno";
            case '7':
                return "pqrs";
            case '8':
                return "tuv";
            case '9':
                return "wxyz";
        }
        return null;
    }

    public static void main(String[] args) {
        System.out.println(new Q017().letterCombinations("23"));
    }

}
