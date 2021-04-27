package cn.melman.melleet;

/**
 * @author Melman
 * @date 2021/4/13 2:36 PM
 */
public class Q1189 {


    public int maxNumberOfBalloons(String text) {
        int[] charArr = new int[5];
//        balon
        for (int i = 0; i < text.length(); i++) {
            switch (text.charAt(i)) {
                case 'b':
                    charArr[0]++;
                    break;
                case 'a':
                    charArr[1]++;
                    break;
                case 'l':
                    charArr[2]++;
                    break;
                case 'o':
                    charArr[3]++;
                    break;
                case 'n':
                    charArr[4]++;
                    break;
                default:
                    break;
            }
        }
        //l和o有两个
        charArr[2] = charArr[2] / 2;
        charArr[3] = charArr[3] / 2;
        int min = 0;
        for (int i : charArr) {
            if (min > i) {
                min = i;
            }
        }
        return min;
    }

}
