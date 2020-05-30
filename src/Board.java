public class Board {
    char  [][] board= new char[6][7];
    int [] moves ;
    int Hscore;  // Heuristic Score

    public Board ()
    {
        for (int width = 0; width < board.length; width++) {
            for (int height = 0; height < board[width].length; height++) {
                board[width][height] = ' ';
            }
        }
        moves = new int[7];
    }

    public void setBoard(char[][] board) {
        this.board = board;
    }

    /**
     ** @param player is a the player's turn
     * @param column represents the column in which the player wishes to play
     * @return
     */
    public  char [][] addX(char player, int column)
    {
        return addX(player,column,board.length-1);
    }

    /**
     *
     * @param player is a the player's turn
     * @param column represents the column in which the player wishes to play
     * @param row row is the corresponding row based on column
     * @return a board with move inserted at board[row][column]
     */
    public char[][] addX( char player, int column, int row) {
        while (row > -1) {
            if (row<0)
                System.out.println("Illegal Move");
            if (board[row][column] == ' ') {
                board[row][column] = player;
                return board;
            } else if (board[row][column] == 'X' || board[row][column] == 'O')
                board = addX(player, column, row - 1);
            return board;
        }
        return board;

    }

    /**
     ** @param player is a the player's turn
     * @param column represents the column in which the player wishes to play
     * @return
     */
    public  char [][] addO(char player, int column)
    {
        return addO(player,column,board.length-1);
    }

    /**
     *
     * @param player is a the player's turn
     * @param column represents the column in which the player wishes to play
     * @param row row is the corresponding row based on column
     * @return a board with move inserted at board[row][column]
     */
    public char[][] addO(char player, int column, int row)
    {

        if(board[row][column] == ' ') {
            board[row][column] = player;
            return board;
        }
        else
        if(board[row][column] =='X' || board[row][column] =='O')

            board = addX(player,column,row-1);

        return  board;
    }

    /**
     *
     * @return the board at current state
     */
    public char[][] getBoard() {
        return board;
    }

    /**
     ** @return an empty board
     */
    public char [][] emptyBoard ()
    {
        for (int width = 0; width <board.length ; width++) {
            for (int height = 0; height <board[width].length ; height++) {

                board[width][height] =' ';
            }

        }
        return board;
    }
    public boolean isEmpty()
    {
        int total = 0;
        for (int width = 0; width <board.length ; width++) {
            for (int height = 0; height <board[width].length ; height++) {
                if(board[width][height] == ' ')
                    total++;
                else
                    continue;
            }
        }
        if(total<= 42)
            return true;
        else
            return false;
    }
    /**
     * This method prints "theBoard" to the Terminal
     * represents the board at each state of the program
     */
    public void printBoard()
    {
        for (int i = 0; i <board.length ; i++) {
            for (int j = 0; j <board[i].length ; j++) {
                System.out.print(board[i][j]+" | ");
            }
            System.out.println();
        }
    }

    public  char checkWin() {
        for (int row = 0; row < board.length; row++) { // iterate rows, bottom to top
            for (int column = 0; column < board[0].length; column++) { // iterate columns, left to right
                char player = board[row][column];
                if (player == ' ')
                    continue; // don't check empty slots

                if (column + 3 < board[0].length &&
                        player == board[row][column+1] && // look right
                        player == board[row][column+2] &&
                        player == board[row][column+3])
                    return player;
                if (row + 3 < board.length) {
                    if (player == board[row+1][column] && // look up
                            player == board[row+2][column] &&
                            player == board[row+3][column])
                        return player;
                    if (column + 3 < board[0].length &&
                            player == board[row+1][column+1] && // look up & right
                            player == board[row+2][column+2] &&
                            player == board[row+3][column+3])
                        return player;
                    if (column - 3 >= 0 &&
                            player == board[row+1][column-1] && // look up & left
                            player == board[row+2][column-2] &&
                            player == board[row+3][column-3])
                        return player;
                }
            }
        }
        return ' '; // no winner found
    }
    public int checkRight(char player, int height, int width)
    {
        if (height + 3 < board[0].length &&
                player <= board[width][height+1] // look right
        )
            Hscore++;
        if (height + 3 <= board[0].length &&
                player == board[width][height+1] &&
                player == board[width][height+2]        // look right
        )
            Hscore++;
        if (height + 3 <= board[0].length &&
                player == board[width][height+1] &&
                player == board[width][height+2] &&
                player == board[width][height+3]// look right
        )
            Hscore++;
        return  Hscore++;
    }
    public int checkRightDiagonal (char player, int height, int width)
    {
        if (height + 3 < board[0].length &&
                player == board[width][height+1] // look right
        )
            Hscore++;
        if (height + 3 < board[0].length &&
                player == board[width][height+1] &&
                player == board[width][height+2]        // look right
        )
            Hscore++;
        if (height + 3 < board[0].length &&
                player == board[width][height+1] &&
                player == board[width][height+2] &&
                player == board[width][height+3]// look right
        )
            Hscore++;
        return  Hscore++;
    }
    public int checkLeftDiagonal (char player, int height, int width)
    {
        if (height + 3 < board[0].length &&
                player == board[width][height+1] // look right
        )
            Hscore++;
        if (height + 3 < board[0].length &&
                player == board[width][height+1] &&
                player == board[width][height+2]        // look right
        )
            Hscore++;
        if (height + 3 < board[0].length &&
                player == board[width][height+1] &&
                player == board[width][height+2] &&
                player == board[width][height+3]// look right
        )
            Hscore++;
        return  Hscore++;
    }
    public int checkUp ( char player, int height, int width)
    {
        if (width + 3 < board.length &&
                player == board[width+1][height] // look right
        )
            Hscore++;
        if (width + 3 < board.length &&
                player == board[width+1][height] &&
                player == board[width+2][height]        // look right
        )
            Hscore++;
        if (width + 3 < board.length &&
                player == board[width+1][height] &&
                player == board[width+2][height] &&
                player == board[width+3][height]// look right
        )
            Hscore++;
        return  Hscore++;
    }
    public int getHscore (){
        Hscore = 0;
        int a=0; int b= 0; int c = 0; int d = 0;
        for (int width = 0; width < board.length; width++) {
            for (int height = 0; height < board[width].length; height++) {
                char player = board[width][height];
                if (player == ' ')
                    if (player == ' ')
                        continue; // don't check empty slots
                a = checkRight(player,height,width);
                b = checkUp(player,height,width);
                c = checkRightDiagonal(player,height,width);
                d = checkLeftDiagonal(player,height,width);
            }
        }
        return a+b+c+d;
    }

    public char[][] swap (char player,int column1, int column2)
    {
        addO(' ',column1);
        addO(player,column2);
        return board;
    }
    public int moves ()
    {
        int column = 0;
        for (int row = 0; row <board.length ; row++) {
            if (board[row][column] == ' ')
                moves[column] = 0;
            else
                moves[column] = 1;
            column++;
        }
        return moves[column];
    }


    public char [][] copy ()
    {
        return board;
    }
}
