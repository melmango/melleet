package cn.melman.melleet;

import java.util.ArrayList;
import java.util.List;

public class Q068 {

    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> res = new ArrayList<>();
        int lastIndex = 0;
        int tempSum = 0;
        StringBuilder sb;
        int len = words.length;
        for (int i = 0; i < len; i++) {
            int size = words[i].length();
            if (tempSum + size + (i - lastIndex) > maxWidth) {
                //拼去
                sb = new StringBuilder(maxWidth);
                //TODO 算间距
                if ((i - lastIndex - 1) == 0) {
                    int distance = maxWidth - tempSum;
                    sb.append(words[lastIndex]);
                    for (int k = 0; k < distance; k++) {
                        sb.append(' ');
                    }
                    lastIndex++;
                } else {
                    int wordCount = i - lastIndex;
                    int writed = 0;
                    int distance = (maxWidth - tempSum) / (wordCount - 1);
                    int disLeft = (maxWidth - tempSum - (wordCount - 1)) % (wordCount - 1);//剩下的空间也均一下子
                    while (lastIndex < i) {
                        sb.append(words[lastIndex]);
                        if (lastIndex < i - 1) {
                            for (int k = 0; k < distance; k++) {
                                sb.append(' ');
                            }
                            if (disLeft > 0 && writed < disLeft) {
                                sb.append(' ');
                            }
                        }
                        System.out.println(words[lastIndex]);
                        System.out.printf("%d-%d-%d\n", lastIndex, i, disLeft);
                        writed++;
                        lastIndex++;
                    }
                }
                res.add(sb.toString());
                lastIndex = i;
                tempSum = 0;
            }
            tempSum = tempSum + size;
        }
        if (lastIndex < len) {
            sb = new StringBuilder(maxWidth);
            while (lastIndex < len) {
                sb.append(words[lastIndex]);
                if (sb.length() < maxWidth) {
                    sb.append(' ');
                }
                lastIndex++;
            }
            for (int l = 0, count = maxWidth - sb.length(); l < count; l++) {
                sb.append(' ');
            }
            res.add(sb.toString());
        }
        return res;
    }

    public static final void main(String[] args) {
//        System.out.println(new Q068().fullJustify(new String[]{"This", "is", "an", "example", "of", "text", "justification."}, 16));
//        System.out.println(new Q068().fullJustify(new String[]{"Science", "is", "what", "we", "understand", "well", "enough", "to", "explain", "to", "a", "computer.", "Art", "is", "everything", "else", "we", "do"}, 20));
        System.out.println(new Q068().fullJustify(new String[]{"a"}, 1));
    }

//    ["Science  is what we","understand      well","enough to explain to","a  computer. Art is","everything  else  we","do                  "]

//    ["Science  is  what we","understand      well","enough to explain to","a  computer.  Art is","everything  else  we","do                  "]

}
