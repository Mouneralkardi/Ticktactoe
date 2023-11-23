public class Board {
        private char[][] board;

        // Konstruktorn för Board-klassen
        public Board() {
            board = new char[3][3];
        }

        // Metod för att återställa spelbrädet
        public void initializeBoard() {
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    board[i][j] = ' ';
                }
            }
        }

        // Metod för att skriva ut spelbrädet
        public void printBoard() {
            System.out.println("  1 2 3");
            for (int i = 0; i < 3; i++) {
                System.out.print((char) ('A' + i) + " ");
                for (int j = 0; j < 3; j++) {
                    System.out.print(board[i][j] + " ");
                }
                System.out.println();
            }
        }

    // Metod för att kontrollera om ett drag är giltigt
    public boolean isValidMove(String move, char currentPlayer) {
        if (move.length() != 2) {
            return false;  // Ogiltigt drag om det inte är två tecken långt.
        }

        int row = move.charAt(0) - 'A';
        int col = move.charAt(1) - '1';

        if (row < 0 || row >= 3 || col < 0 || col >= 3 || board[row][col] != ' ') {
            return false;  // Ogiltigt drag om det är utanför brädet eller om rutan är upptagen.
        }

        return true;
    }

    // Metod för att utföra ett drag på spelbrädet
    public void makeMove(int row, int col, char currentPlayer) {
        board[row][col] = currentPlayer;
    }

    // Metod för att kontrollera om någon har vunnit spelet
    public boolean isGameWon(char currentPlayer) {
        // Kolla rader
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == 'X' && board[i][1] == 'X' && board[i][2] == 'X' ||
                    board[i][0] == 'O' && board[i][1] == 'O' && board[i][2] == 'O') {
                return true; // Om någon har vunnit i en rad.
            }
        }

        // Kolla kolumner
        for (int j = 0; j < 3; j++) {
            if (board[0][j] == 'X' && board[1][j] == 'X' && board[2][j] == 'X' ||
                    board[0][j] == 'O' && board[1][j] == 'O' && board[2][j] == 'O') {
                return true; // Om någon har vunnit i en kolumn.
            }
        }

        // Kolla diagonaler
        if (board[0][0] == 'X' && board[1][1] == 'X' && board[2][2] == 'X' ||
                board[0][0] == 'O' && board[1][1] == 'O' && board[2][2] == 'O') {
            return true; // Om någon har vunnit på diagonalen från övre vänstra till nedre högra.
        }
        if (board[0][2] == 'X' && board[1][1] == 'X' && board[2][0] == 'X' ||
                board[0][2] == 'O' && board[1][1] == 'O' && board[2][0] == 'O') {
            return true; // Om någon har vunnit på diagonalen från övre högra till nedre vänstra.
        }

        return false; // Ingen har vunnit ännu.
    }

    // Metod för att kontrollera om spelbrädet är fullt (oavgjort)
    public boolean isBoardFull() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == ' ') {
                    return false; // Det finns åtminstone ett tomt utrymme på brädet.
                }
            }
        }
        return true; // Brädet är fullt utan tomma utrymmen.
    }

}


