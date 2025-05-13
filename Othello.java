import java.io.*;
import java.util.*;
class node{
    // int[][] value;
    int score;
    ArrayList<node> child;
    int[] index;
    // int iiiii;
    node(){
        // // iiiii=0;
        // this.value=k;
        child=new ArrayList<>();
        score=0;
        index=new int[]{0,0};
    }
}
class updated_node{
    int value;
    ArrayList<updated_node> childlist;
    updated_node(){
        value=0;
        childlist=new ArrayList<>();
    }
}
public class Othello {
    int turn;
    int winner;
    int board[][];
    int x;
    //add required class variables here
    private static final int EMPTY = -1;
    private static final int BLACK = 0;
    private static final int WHITE = 1;
    private static final int[][] DIRECTIONS = {{-1,-1},{-1,0},{-1,1},{0,-1},{0,1},{1,-1},{1,0},{1,1}};
    
    public Othello(String filename) throws Exception {
        x=0;
        File file = new File(filename);
        Scanner sc = new Scanner(file);
        turn = sc.nextInt();
        board = new int[8][8];
        for(int i = 0; i < 8; ++i) {
            for(int j = 0; j < 8; ++j){
                board[i][j] = sc.nextInt();
            }
        }
        winner = -1;
        // printBoard(board);
        // board[2][3]=BLACK;
        // flipDiscs(board,2 ,3 , BLACK);
        // printBoard(board);
        // Student can choose to add preprocessing here
    }

    //add required helper functions here
    private int change(int n){
        return n==0?1:0;
    }
    
    private int decision_tree(int[][] board, int player, int k, int limit, ArrayList<Integer> scoreeeee) {
        if (k == limit) {
            return getScore(board);
        }
        ArrayList<int[]> movesindex = getPossibleMovesindex(board, player);
        // if(k==0){
        //     System.out.println("nfadnvvv: "+movesindex.size());
        // }
        if (movesindex.size() == 0 && k != limit) {
            int[][] tempBoard = copyBoard(board);
            int nn = getScore(tempBoard);
            nn = decision_tree(tempBoard, change(player), k + 1, limit,scoreeeee);
            return nn;
        }
        // if (movesindex.size() == 0) {
        //     return getScore(board);
        // }
        int i = 0;
        int rootValue = 0;
        for (int[] move : movesindex) {
            int[][] tempBoard = copyBoard(board);
            int o = move[0];
            int j = move[1];
            tempBoard[o][j] = player;
            flipDiscs(tempBoard, o, j, player);
            int nn = decision_tree(tempBoard, change(player), k + 1, limit,scoreeeee);
            if (i == 0) {
                rootValue = nn;
            }
            i++;
            if(k==0) {
                scoreeeee.add(nn);
            }
            rootValue = player == BLACK ? Math.max(rootValue, nn) : Math.min(rootValue, nn);
        }
        return rootValue;
    }
 
    private ArrayList<int[]>  getPossibleMovesindex(int[][] currentBoard, int player) {
        ArrayList<int[]> moves = new ArrayList<int[]>();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (currentBoard[i][j] == EMPTY) {
                    int[][] tempBoard = copyBoard(currentBoard);
                    if (isValidMove(tempBoard, i, j, player)) {
                        moves.add(new int[]{i,j});
                    }
                }
            }
        }
        return moves;
    }
    private int[][] copyBoard(int[][] board) {
        int[][] copy = new int[8][8];
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                copy[i][j] = board[i][j];
            }
        }
        return copy;
    }
    private   boolean isValidMove(int[][] board, int row, int col, int player) {
        if (board[row][col] != EMPTY) {
            return false;
        }
        for (int[] direction : DIRECTIONS) {
            int r = row + direction[0];
            int c = col + direction[1];
            boolean valid = false;
    
            while (r >= 0 && r < 8 && c >= 0 && c < 8) {
                if (board[r][c] == EMPTY) {
                    break;
                }
    
                if (board[r][c] == player) {
                    if (valid) {
                        return true;
                    } else {
                        break;
                    }
                }
    
                valid = true;
                r += direction[0];
                c += direction[1];
            }
        }
    
        return false;
    }
    public static boolean isEquivalentBySymmetry(int[][] board1, int[][] board2) {
        for (int i = 0; i < 4; i++) {
            // Rotate and mirror board1
            int[][] rotatedBoard1 = rotateBoard(board1, i);
            int[][] mirroredBoard1 = mirrorBoard(rotatedBoard1);
    
            // Check if board2 matches any of the rotated/mirrored versions of board1
            if (areBoardsEqual(mirroredBoard1, board2)) {
                return true;
            }
            if(areBoardsEqual(rotatedBoard1, board2)) return true;
        }
        return false;
    }
    
    public static int[][] rotateBoard(int[][] board, int numOfRotations) {
        int size = board.length;
        int[][] rotatedBoard = new int[size][size];
        for (int i = 0; i < numOfRotations; i++) {
            for (int j = 0; j < size; j++) {
                for (int k = 0; k < size; k++) {
                    rotatedBoard[k][size-j-1] = board[j][k];
                }
            }
            board = rotatedBoard;
        }
        return rotatedBoard;
    }
    
    public static int[][] mirrorBoard(int[][] board) {
        int size = board.length;
        int[][] mirroredBoard = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                mirroredBoard[i][j] = board[i][size-j-1];
            }
        }
        return mirroredBoard;
    }
    
    public static boolean areBoardsEqual(int[][] board1, int[][] board2) {
        int size = board1.length;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (board1[i][j] != board2[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }
    private void flipDiscs(int[][] board, int row, int col, int player) {
        for (int[] direction : DIRECTIONS) {
            int r = row + direction[0];
            int c = col + direction[1];
            boolean flip = false;
            while (r >= 0 && r < 8 && c >= 0 && c < 8) {
                if (board[r][c] == EMPTY) {
                    break;
                }
                if (board[r][c] == player) {
                    flip = true;
                    break;
                }
                r += direction[0];
                c += direction[1];
            }
            if (flip) {
                r = row + direction[0];
                c = col + direction[1];
                while (board[r][c] != player) {
                    board[r][c] = player;
                    r += direction[0];
                    c += direction[1];
                }
            }
        }
    }
    private int getScore(int[][] board) {
        int blackScore = 0;
        int whiteScore = 0;
    
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (board[i][j] == BLACK) {
                    blackScore++;
                } else if (board[i][j] == WHITE) {
                    whiteScore++;
                }
            }
        }
    
        return blackScore - whiteScore;
    }
    public int boardScore() {
        /* Complete this function to return num_black_tiles - num_white_tiles if turn = 0, 
         * and num_white_tiles-num_black_tiles otherwise. 
        */
        int t=getScore(board);
        return  turn==BLACK?t:-t;
    }

  
    private int bestMovehelper(int k) {
        ArrayList<Integer> scoree=new ArrayList<>();
        int bestScore = decision_tree(board, turn, 0, k,scoree);
        ArrayList<int[]> possibleMoves = getPossibleMovesindex(board, turn);
        int ans=0;
        for(;ans<scoree.size();ans++) if(scoree.get(ans)==bestScore) break;
        int bestMove = 8*possibleMoves.get(ans)[0]+possibleMoves.get(ans)[1];
        int i=0;
        for (int[] move : possibleMoves) {
            if (bestScore == scoree.get(i)) {
                int temp=bestMove;
                bestMove=Math.min(bestMove,8*move[0]+move[1]);
                if(bestMove!=temp){
                    bestMove=8*move[0] + move[1];
                }
            }
            i++;
        }
        int[][] tempBoard = copyBoard(board);
        int row = bestMove / 8;
        int col = bestMove % 8;
        tempBoard[row][col] = turn;
        flipDiscs(tempBoard, row, col, turn);
        board = tempBoard;
        return bestMove;
    }
    public int bestMove(int k) {
        ArrayList<Integer> scoree=new ArrayList<>();
        int bestScore = decision_tree(board, turn, 0, k,scoree);
        ArrayList<int[]> possibleMoves = getPossibleMovesindex(board, turn);
        int ans=0;
        for(;ans<scoree.size();ans++) if(scoree.get(ans)==bestScore) break;
        int bestMove = 8*possibleMoves.get(ans)[0]+possibleMoves.get(ans)[1];
        int i=0;
        for (int[] move : possibleMoves) {
            if (bestScore == scoree.get(i)) {
                int temp=bestMove;
                bestMove=Math.min(bestMove,8*move[0]+move[1]);
                if(bestMove!=temp){
                    bestMove=8*move[0] + move[1];
                }
            }
            i++;
        }
        return bestMove;
    }
    
    
    public ArrayList<Integer> fullGame(int k) {
        System.out.println("full game: and k= "+k);
        printBoard(board);
        System.out.println();
        /* Complete this function to compute and execute the best move for each player starting from
         * the current turn using k-step look-ahead. Accordingly modify the board and the turn
         * at each step. In the end, modify the winner variable as required.
         */
        // getPossibleMovesindex(board, turn).size()!=0
        ArrayList<Integer> ans=new ArrayList<>();
        int i=0;
        while(true){
            if(i==2) break;
            if(getPossibleMovesindex(board, turn).size()!=0){
                i=0;
                ans.add(bestMovehelper(k));
                turn=change(turn);
            }else{
                i++;
                turn=change(turn);
            }
            
        }
        winner=getScore(board)>0?BLACK:WHITE;
        return ans;
    }

    public int[][] getBoardCopy() {
        int copy[][] = new int[8][8];
        for(int i = 0; i < 8; ++i)
            System.arraycopy(board[i], 0, copy[i], 0, 8);
        return copy;
    }

    public int getWinner() {
        return winner;
    }

    public int getTurn() {
        return turn;
    }
    private void printBoard(int[][] board) {
        System.out.println("  0 1 2 3 4 5 6 7");
        for (int i = 0; i < 8; i++) {
            System.out.print(i + " ");
            for (int j = 0; j < 8; j++) {
                if (board[i][j] == BLACK) {
                    System.out.print("B ");
                } else if (board[i][j] == WHITE) {
                    System.out.print("W ");
                } else {
                    System.out.print("- ");
                }
            }
            System.out.println();
        }
    }
//     public static void main(String[] args) {
//         try {
//             long startTime = System.nanoTime();

// // code to measure the running time


//             Othello o1=new Othello("ipp.txt");
//             o1.printBoard(o1.board);

//             System.out.println(o1.fullGame(3));
//             // System.out.println(o1.winner);
//             // System.out.println(o1.bestMovehelper(8));
//             long endTime = System.nanoTime();
// long elapsedTime = endTime - startTime;
// System.out.println("Elapsed time: " + elapsedTime/1e9 + " s");
//             // System.out.println(o1.x+"  pppp");
//         } catch (Exception e) {
//             e.printStackTrace();
//             System.out.println();
//         }
//     }
}
