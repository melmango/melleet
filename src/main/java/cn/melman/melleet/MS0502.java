package cn.melman.melleet;

/**
 * @author Melman
 * @date 2021/4/13 5:12 PM
 */
public class MS0502 {

    public String printBin(double num) {
        StringBuilder sb = new StringBuilder("0.");

        while (num != 0) {
            num *= 2;
            if (num >= 1) {
                sb.append("1");
                num -= 1;
            } else {
                sb.append("0");
            }
            if (sb.length() > 32) {
                return "ERROR";
            }
        }
        return sb.toString();

    }


    public static void main(String[] args) {
        String res = new MS0502().printBin(0.625);
        System.out.println(res);
    }

}
