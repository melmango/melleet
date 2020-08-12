package cn.melman.melleet;

import java.util.HashMap;

public class Q013 {
    static HashMap<Character, Integer> NUM_MAP = new HashMap<Character, Integer>() {
        {
            put('M', 1000);
            put('D', 500);
            put('C', 100);
            put('L', 50);
            put('X', 10);
            put('V', 5);
            put('I', 1);

        }
    };

    public int romanToInt(String s) {
        int res = 0;
        int lastValue = 0;
        char lastChar = '0';
        for (int i = 0; i < s.length(); i++) {
            int value = lastChar == s.charAt(i) ? lastValue : getValue(s.charAt(i));
            if (lastValue < value) {
                res = res - (lastValue * 2) + value;
            } else {
                res = res + value;
            }
            lastValue = value;
            lastChar = s.charAt(i);
        }
        return res;
    }

    //粘过来的
    private int getValue(char ch) {
        switch(ch) {
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
            default: return 0;
        }
    }


    public static void main(String[] args) {
        System.out.println(new Q013().romanToInt("IV"));
    }
}
