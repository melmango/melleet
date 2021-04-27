package cn.melman.melleet;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int count = in.nextInt();
        while (count > 0) {
            String s = in.next();
            System.out.println(checkString(s));
            count--;
        }
    }

    public static String checkString(String input) {
        StringBuilder sb = new StringBuilder();
        boolean[] removed = new boolean[input.length()];
        char lastChar = '0';
        int count = 1;
        //去掉三个的
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (input.charAt(i) == lastChar) {
                if (count == 2) {
                    removed[i] = true;
                } else {
                    count++;
                }
            } else {
                lastChar = c;
                count = 1;
            }
        }
        lastChar = '0';
        boolean foundAA = false;
        for (int i = 0; i < input.length(); i++) {
            if (removed[i]) {
                continue;
            }
            char c = input.charAt(i);
            if (input.charAt(i) == lastChar) {
                if (count == 1) {
                    if (foundAA) {
                        removed[i] = true;
                    } else {
                        foundAA = true;
                        lastChar = '0';
                    }
                } else {
                    count++;
                }
            } else {
                if (lastChar != '0') {
                    foundAA = false;
                }
                lastChar = c;
                count = 1;
            }
        }
        for (int i = 0; i < input.length(); i++) {
            if (removed[i]) {
                continue;
            }
            sb.append(input.charAt(i));
        }
        return sb.toString();
    }
}