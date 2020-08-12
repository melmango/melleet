package cn.melman.melleet;

import java.util.ArrayList;
import java.util.List;

/**
 * 围棋
 */
public class Q130 {

    static class Boundary {
        int x;
        int y;

        public Boundary(int x, int y) {
            this.x = x;
            this.y = y;
        }

        boolean isBeside(int x, int y) {
            if (this.x == x) {
                return Math.abs(this.y - y) == 1;
            } else if (this.y == y) {
                return Math.abs(this.x - x) == 1;
            }
            return false;
        }
    }

    public void solve(char[][] board) {
        if (board.length <= 1 || board[0].length <= 1) {
            return;
        }
        int x = 0, y = 0, left = 0, top = 1, bottom = board.length, right = board[0].length;
        int direction = RIGHT;
        Boundary last = new Boundary(-1, -1);
        List<Boundary> boundaries = new ArrayList<>();
        while (true) {
            if (x < 0 || y < 0) {
                break;
            }
            if (board[x][y] == 'O') {
                if (x == 0 || x == board.length - 1 || y == 0 || y == board[0].length - 1) {
                    boundaries.add(new Boundary(x, y));
                } else {
                    boolean beside = false;
                    for (Boundary boundary : boundaries) {
                        if (boundary.isBeside(x, y)) {
                            boundaries.add(new Boundary(x, y));
                            beside = true;
                            break;
                        }
                    }
                    if (!beside) {
                        if (last.x > 0) {
                            board[last.x][last.y] = 'X';
                        }
                        last.x = x;
                        last.y = y;
                    } else {
                        last.x = -1;
                    }
                }
            } else {
                if (last.x > 0) {
                    board[last.x][last.y] = 'X';
                }
                last.x = -1;

            }
            if (direction == RIGHT) {
                y++;
                if (y == right - 1) {
                    direction = DOWN;
                    right--;
                } else if (y == right) {
                    break;
                }

            } else if (direction == DOWN) {
                x++;
                if (x == bottom - 1) {
                    direction = LEFT;
                    bottom--;
                } else if (x == bottom) {
                    break;
                }

            } else if (direction == LEFT) {
                y--;
                if (y == left) {
                    direction = UP;
                    left++;
                } else if (y < left) {
                    break;
                }

            } else if (direction == UP) {
                x--;
                if (x == top) {
                    direction = RIGHT;
                    top++;
                } else if (x < top) {
                    break;
                }
            }
        }
        if (last.x > 0) {
            board[last.x][last.y] = 'X';
        }
    }

    public static final int RIGHT = 0;
    public static final int DOWN = 1;
    public static final int LEFT = 2;
    public static final int UP = 3;


    public static void main(String[] args) {
        new Q130().solve(new char[][]{{'O', 'X', 'X', 'O', 'X'}, {'X', 'O', 'O', 'X', 'O'}, {'X', 'O', 'X', 'O', 'X'}, {'O', 'X', 'O', 'O', 'O'}, {'X', 'X', 'O', 'X', 'O'}});
    }
}
