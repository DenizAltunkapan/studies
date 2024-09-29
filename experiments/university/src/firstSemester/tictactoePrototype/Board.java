package firstSemester.tictactoePrototype;

public class Board {
    static void printBoard(char[][] gameBoard) {
        for (char[] i : gameBoard) {
            System.out.println(i);
        }
    }

    static boolean checkFree(char[][] gameBoard,int column, int row) throws Exception {
        if(gameBoard[column][row] == ' ') {
            return true;
        }else {
            throw new Exception();
        }
    }


    static boolean getWinningCondition(char[][] gameBoard) {
        char middle= gameBoard[1][3];
        for(int i=0; i<3; i++) {
            if(gameBoard[i][1] == gameBoard[i][3] &&  gameBoard[i][1]==gameBoard[i][5] && gameBoard[i][1]!=' ') {
                return true;
            }
        }
        int k=1;
        while(k<=5) {
            if(gameBoard[0][k] == gameBoard[1][k] &&  gameBoard[1][k]==gameBoard[2][k]&& gameBoard[1][k]!=' ') {
                return true;
            }
            k+=2;
        }

        if(middle == gameBoard[0][1]&& middle== gameBoard[2][5] && middle !=' ') {
            return true;
        }
        if(middle == gameBoard[2][1]&& middle== gameBoard[0][5] && middle !=' ') {
            return true;
        }
        return false;
    }

}