package cn.melman.melleet;

import java.util.ArrayList;

public class Q006 {

    public String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        int groupSize = numRows + (numRows - 2);//每组的长度
        ArrayList<String> temp = new ArrayList<>();
        int total = s.length();
        int start = 0;
        while (start < total) {
            int endIndex = total <= (start + groupSize) ? total : (start + groupSize);
            String subString = s.substring(start, endIndex);
            temp.add(subString);
            start = start + groupSize;
        }
        StringBuilder sb = new StringBuilder();
        for (int index = 0; index < numRows; index++) {
            for (int i = 0, length = temp.size(); i < length; i++) {
                int count = temp.get(i).length();
                if (index < count) {
                    sb.append(temp.get(i).charAt(index));
                    if (index != 0 && index != (numRows - 1)) {
                        int point = groupSize - index;
                        if (point < temp.get(i).length()) {
                            sb.append(temp.get(i).charAt(point));
                        }
                    }
                }
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String test = "A";
        String ret = new Q006().convert(test, 2);
        System.out.println(ret);

    }
}
