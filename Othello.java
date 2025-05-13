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
    // private node decision_tree(node root,int player,int[][] board,int k,int limit){
    //     if(k==limit) {
    //         return root;
    //     }
    //     if(root==null){
    //         root=new node();
    //         root.score=getScore(board);
    //     }
    //     ArrayList<int[]> movesindex = getPossibleMovesindex(board, player);
    //     if(movesindex.size()==0 && k!=limit) {
    //         int[][] tempBoard = copyBoard(board);
    //         node nn=new node();
    //         nn.score=getScore(tempBoard);
    //         nn=decision_tree(nn, change(player), tempBoard, k+1, limit);
    //         root.child.add(nn);
    //         root.score=nn.score;
    //         return root;
    //     }
    //     if(movesindex.size()==0) return root;
    //     // ArrayList<Integer> ssss=new ArrayList<>();
    //     // root.score=
    //     int i=0;
    //     for (int[] move : movesindex){
    //         int[][] tempBoard = copyBoard(board);
    //         int o=move[0];
    //         int j=move[1];
    //         tempBoard[o][j] = player;
    //         flipDiscs(tempBoard, o, j, player);
    //         node nn=new node();
    //         nn.score=getScore(tempBoard);
    //         nn.index=move;
    //         nn=decision_tree(nn, change(player), tempBoard,k+1,limit);
    //         root.child.add(nn);
    //         if(i==0) root.score=nn.score;
    //         i++;
    //         root.score=player==BLACK?Math.max(root.score, nn.score):Math.min(root.score, nn.score);
    //         // ssss.add(nn.score);
    //     }
    //     // System.out.println(root.score);
    //     // int t=root.score;
    //     // if(movesindex.size()!=0) {
    //     //     root.score=player==BLACK?findMax(ssss):findMinimum(ssss);
    //     // }
    //     // // System.out.println(root.score);
    //     // if(t!=root.score) System.out.println("kkkkkkkkkkkkkkkkkkkkkkkkkkkkkkk");
    //     return root;
    // }
    // private updated_node decision_tree(updated_node root,int player,int[][] board,int k,int limit){
    //     if(k==limit) {
    //         return root;
    //     }
    //     if(root==null){
    //         // root=new node();
    //         // root.score=getScore(board);
    //         root=new updated_node();
    //         root.value=getScore(board);
    //     }
    //     ArrayList<int[]> movesindex = getPossibleMovesindex(board, player);
    //     if(movesindex.size()==0 && k!=limit) {
    //         int[][] tempBoard = copyBoard(board);
    //         // node nn=new node();
    //         // nn.score=getScore(tempBoard);
    //         updated_node nn=new updated_node();
    //         nn.value=getScore(tempBoard);
    //         nn=decision_tree(nn, change(player), tempBoard, k+1, limit);
    //         // root.childlist
    //         root.childlist.add(nn);
    //         root.value=nn.value;
    //         return root;
    //     }
    //     if(movesindex.size()==0) return root;
    //     // ArrayList<Integer> ssss=new ArrayList<>();
    //     // root.score=
    //     int i=0;
    //     for (int[] move : movesindex){
    //         int[][] tempBoard = copyBoard(board);
    //         int o=move[0];
    //         int j=move[1];
    //         tempBoard[o][j] = player;
    //         flipDiscs(tempBoard, o, j, player);
    //         updated_node nn=new updated_node();
    //         nn.value=getScore(tempBoard);
    //         nn=decision_tree(nn, change(player), tempBoard, k+1, limit);
    //         // root.childlist
    //         root.childlist.add(nn);
    //         // root.value=nn.value;
    //         if(i==0) root.value=nn.value;
    //         i++;
    //         root.value=player==BLACK?Math.max(root.value, nn.value):Math.min(root.value, nn.value);
    //         // ssss.add(nn.score);
    //     }
    //     // System.out.println(root.score);
    //     // int t=root.score;
    //     // if(movesindex.size()!=0) {
    //     //     root.score=player==BLACK?findMax(ssss):findMinimum(ssss);
    //     // }
    //     // // System.out.println(root.score);
    //     // if(t!=root.score) System.out.println("kkkkkkkkkkkkkkkkkkkkkkkkkkkkkkk");
    //     return root;
    // }
    // private updated_node decision_tree(updated_node root,int player,int[][] board,int k,int limit){
    //     if(k==limit) {
    //         return root;
    //     }
    //     if(root==null){
    //         // root=new node();
    //         // root.score=getScore(board);
    //         root=new updated_node();
    //         root.value=getScore(board);
    //     }
    //     ArrayList<int[]> movesindex = getPossibleMovesindex(board, player);
    //     if(movesindex.size()==0 && k!=limit) {
    //         int[][] tempBoard = copyBoard(board);
    //         // node nn=new node();
    //         // nn.score=getScore(tempBoard);
    //         updated_node nn=new updated_node();
    //         nn.value=getScore(tempBoard);
    //         nn=decision_tree(nn, change(player), tempBoard, k+1, limit);
    //         // root.childlist
    //         root.childlist.add(nn);
    //         root.value=nn.value;
    //         return root;
    //     }
    //     if(movesindex.size()==0) return root;
    //     int i=0;
    //     for (int[] move : movesindex){
    //         int[][] tempBoard = copyBoard(board);
    //         int o=move[0];
    //         int j=move[1];
    //         tempBoard[o][j] = player;
    //         flipDiscs(tempBoard, o, j, player);
    //         updated_node nn=new updated_node();
    //         nn.value=getScore(tempBoard);
    //         nn=decision_tree(nn, change(player), tempBoard, k+1, limit);
    //         // root.childlist
    //         root.childlist.add(nn);
    //         // root.value=nn.value;
    //         if(i==0) root.value=nn.value;
    //         i++;
    //         root.value=player==BLACK?Math.max(root.value, nn.value):Math.min(root.value, nn.value);
    //     }
    //     return root;
    // }
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
    
    // private node decision_tree11(node root,int player,int[][] board,int k,int limit,int minimum){
    //     if(k==limit) {
    //         return root;
    //     }
    //     if(root==null){
    //         root=new node(board);
    //         root.score=getScore(board);
    //     }
    //     ArrayList<int[]> movesindex = getPossibleMovesindex(board, player);
    //     if(movesindex.size()==0 && k!=limit) {
    //         int[][] tempBoard = copyBoard(board);
    //         node nn=new node(tempBoard);
    //         nn.score=getScore(tempBoard);
    //         nn=decision_tree11(nn, change(player), tempBoard, k+1, limit);
    //         root.child.add(nn);
    //         root.score=nn.score;
    //         return root;
    //     }
    //     if(movesindex.size()==0) return root;
    //     ArrayList<Integer> ssss=new ArrayList<>();
    //     for (int[] move : movesindex){
    //         int[][] tempBoard = copyBoard(board);
    //         int o=move[0];
    //         int j=move[1];
    //         tempBoard[o][j] = player;
    //         flipDiscs(tempBoard, o, j, player);
    //         node nn=new node(tempBoard);
    //         nn.score=getScore(tempBoard);
    //         nn.index=move;
    //         nn=decision_tree11(nn, change(player), tempBoard,k+1,limit);
    //         root.child.add(nn);
    //         ssss.add(nn.score);
    //     }
    //     if(movesindex.size()!=0) {
    //         root.score=player==BLACK?findMax(ssss):findMinimum(ssss);
    //     }
    //     return root;
    // }
    // private node decision_tree(node root,int player,int[][] board,int k,int limit){
    //     if(k==limit) {
    //         return root;
    //     }
    //     if(root==null){
    //         root=new node(board);
    //         root.score=getScore(board);
    //     }
    //     ArrayList<int[][]> moves = getPossibleMoves(board, player);
    //     ArrayList<int[]> movesindex = getPossibleMovesindex(board, player);
    //     if(moves.size()==0) return root;
    //     ArrayList<Integer> ssss=new ArrayList<>();
    //     int i=0;
    //     // ArrayList<node> uuu=new ArrayList<>();
    //     for (int[][] move : moves){
    //         node nn=new node(move);
    //         nn.score=getScore(move);
    //         nn.index=movesindex.get(i);
    //         nn=decision_tree(nn, change(player), move,k+1,limit);
    //         root.child.add(nn);
    //         i++;
            
    //         ssss.add(nn.score);

    //         // uuu.add(nn);
    //     }
    //     if(moves.size()!=0) {
    //         root.score=player==BLACK?findMax(ssss):findMinimum(ssss);
    //     }
    //     if(moves.size()==0 && k!=limit) {
    //         // ArrayList<int[][]> moves1 = getPossibleMoves(root.value,change(player));
    //         int b=getScore(board);
    //             if(b>0){
    //                 root.score=Integer.MAX_VALUE;
    //             }else{
    //                 root.score=Integer.MIN_VALUE;
    //             }
    //         return root;
    //     }
    //     return root;
    // }
    // private int findMinimum(ArrayList<Integer> list) {
    //     int min = Integer.MAX_VALUE;
    //     for (int i = 0; i < list.size(); i++) {
    //         int num = list.get(i);
    //         if (num < min) {
    //             min = num;
    //         }
    //     }
    //     return min;
    // }
    // private int findMax(ArrayList<Integer> list) {
    //     int max = list.get(0);
    //     for (int i = 1; i < list.size(); i++) {
    //         if (list.get(i) > max) {
    //             max = list.get(i);
    //         }
    //     }
    //     return max;
    // }
    // private ArrayList<int[][]>  getPossibleMoves(int[][] currentBoard, int player) {
    //     ArrayList<int[][]> moves = new ArrayList<int[][]>();
    //     for (int i = 0; i < 8; i++) {
    //         for (int j = 0; j < 8; j++) {
    //             if (currentBoard[i][j] == EMPTY) {
    //                 int[][] tempBoard = copyBoard(currentBoard);
    //                 if (isValidMove(tempBoard, i, j, player)) {
    //                     tempBoard[i][j] = player;
    //                     flipDiscs(tempBoard, i, j, player);
    //                     moves.add(tempBoard);
    //                 }
    //             }
    //         }
    //     }
    //     return moves;
    // }
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

    // public int bestMove(int k) {
    //     /* Complete this function to build a Minimax tree of depth k (current board being at depth 0),
    //      * for the current player (siginified by the variable turn), and propagate scores upward to find
    //      * the best move. If the best move (move with max score at depth 0) is i,j; return i*8+j
    //      * In case of ties, return the smallest integer value representing the tile with best score.
    //      * 
    //      * Note: Do not alter the turn variable in this function, so that the boardScore() is the score
    //      * for the same player throughout the Minimax tree.
    //     */
        
    //     ArrayList<int[]> jjjjjjj=getPossibleMovesindex(board, turn);
    //     // System.out.println("lolll");
    //     int scoree=decision_tree( board,turn, 0, k);
    //     // ArrayList<updated_node> childdd=root.childlist;
    //     int mini=Integer.MAX_VALUE;
    //     for(int i=0;i<jjjjjjj.size();i++){
    //         int[][] tempBoard = copyBoard(board);
    //         int move[]=jjjjjjj.get(i);
    //         int o = move[0];
    //         int j = move[1];
    //         tempBoard[o][j] = turn;
    //         flipDiscs(tempBoard, o, j, turn);
    //         if(getScore(tempBoard)==scoree){
    //             // int[] idx=jjjjjjj.get(i);
    //             mini=Math.min(mini,8*move[0]+move[1]);
    //         }
    //     }
    //     // System.out.println("op");
    //     return mini;
    // }
    // private int bestMovehelper(int k) {
    //     int[][] board111=new int[8][8];
    //     int scoree=decision_tree( board,turn, 0, k);
    //     // System.out.println(scoree+" kkkkk");
    //     ArrayList<int[]> jjjjjjj=getPossibleMovesindex(board, turn);
    //     int mini=Integer.MAX_VALUE;
    //     for(int i=0;i<jjjjjjj.size();i++){
    //         int[][] tempBoard = copyBoard(board);
    //         int move[]=jjjjjjj.get(i);
    //         int o = move[0];
    //         int j = move[1];
    //         tempBoard[o][j] = turn;
    //         // System.out.println("lola");
    //         // printBoard(tempBoard);
    //         flipDiscs(tempBoard, o, j, turn);
    //         // printBoard(tempBoard);
    //         if(getScore(tempBoard)==scoree){
                // int temp=mini;
                // mini=Math.min(mini,8*move[0]+move[1]);
                // if(mini!=temp){
                //     board111=tempBoard;
                // }
    //         }
    //     }
    //     this.board=board111;
    //     return mini;
    // }
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
    // private int decisionTreeHelper(int[][] board, int k, int alpha, int beta, int player) {
    //     if (k == 0 || isTerminalNode(board)) {
    //         return getScore(board);
    //     }
    
    //     ArrayList<int[]> possibleMoves = getPossibleMovesindex(board, player);
    
    //     if (possibleMoves.size() == 0) {
    //         return decisionTreeHelper(board, k-1, alpha, beta, change(player));
    //     }
    
    //     if (player == turn) {
    //         int bestScore = Integer.MIN_VALUE;
    
    //         for (int[] move : possibleMoves) {
    //             int[][] tempBoard = copyBoard(board);
    //             tempBoard[move[0]][move[1]] = player;
    //             flipDiscs(tempBoard, move[0], move[1], player);
    
    //             int score = decisionTreeHelper(tempBoard, k-1, alpha, beta, change(player));
    
    //             bestScore = Math.max(bestScore, score);
    //             alpha = Math.max(alpha, bestScore);
    
    //             if (beta <= alpha) {
    //                 break;
    //             }
    //         }
    
    //         return bestScore;
    //     } else {
    //         int worstScore = Integer.MAX_VALUE;
    
    //         for (int[] move : possibleMoves) {
    //             int[][] tempBoard = copyBoard(board);
    //             tempBoard[move[0]][move[1]] = player;
    //             flipDiscs(tempBoard, move[0], move[1], player);
    
    //             int score = decisionTreeHelper(tempBoard, k-1, alpha, beta, change(player));
    
    //             worstScore = Math.min(worstScore, score);
    //             beta = Math.min(beta, worstScore);
    
    //             if (beta <= alpha) {
    //                 break;
    //             }
    //         }
    
    //         return worstScore;
    //     }
    // }
    
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
