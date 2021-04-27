package cn.melman.melleet;

/**
 * @author Melman
 * @date 2021/4/13 5:28 PM
 */
public class MS1604 {


    public String tictactoe(String[] board) {
        int i, j, size = board.length, txtSize = board[0].length();
        if (size == 1) {
            if (board[0].charAt(0) == ' ') {
                return "Pending";
            }
            return board[0];
        }
        boolean hasEmpty = false, same;
        char pre, c;
        //横着
        for (i = 0; i < size; i++) {
            pre = board[i].charAt(0);
            same = true;
            for (j = 1; j < txtSize; j++) {
                c = board[i].charAt(j);
                if (c == ' ') {
                    hasEmpty = true;
                    same = false;
                    break;
                } else if (c != pre) {
                    same = false;
                    break;
                }
            }
            if (same) {
                return String.valueOf(pre);
            }
        }

        for (i = 0; i < txtSize; i++) {
            pre = board[0].charAt(i);
            same = true;
            for (j = 1; j < size; j++) {
                c = board[j].charAt(i);
                if (c == ' ') {
                    hasEmpty = true;
                    same = false;
                    break;
                } else if (c != pre) {
                    same = false;
                    break;
                }
            }
            if (same) {
                return String.valueOf(pre);
            }
        }
        if (txtSize == size) {
            same = true;
            pre = board[0].charAt(0);
            for (i = 1; i < size; i++) {
                c = board[i].charAt(i);
                if (c == ' ') {
                    hasEmpty = true;
                    same = false;
                    break;
                } else if (c != pre) {
                    same = false;
                    break;
                }
            }
            if (same) {
                return String.valueOf(pre);
            }

            same = true;
            pre = board[0].charAt(txtSize - 1);
            for (i = 1; i < size; i++) {
                c = board[i].charAt(txtSize - 1 - i);
                if (c == ' ') {
                    same = false;
                    hasEmpty = true;
                    break;
                } else if (c != pre) {
                    same = false;
                    break;
                }
            }
            if (same) {
                return String.valueOf(pre);
            }
        }
        //如果最后没找到，看有没有空格
        return hasEmpty ? "Pending" : "Draw";
    }


    public static void main(String[] args) {
        String res = new MS1604().tictactoe(new String[]{"O X", " XO", "X O"});
        System.out.println(res);
    }
}
