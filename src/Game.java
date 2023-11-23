import java.util.Scanner;

public class Game {

        private Board board;
        private Player playerX;
        private Player playerO;
        private char currentPlayer;

        // Konstruktorn för Game-klassen
        public Game() {
            board = new Board();
            playerX = new Player();
            playerO = new Player();
            currentPlayer = 'X';
            initializeGame();
            getPlayersNames();  // Lägg till denna rad för att fråga om spelarnas namn vid start.
        }

        // Metod för att starta och spela spelet
        public void playGame() {
            Scanner scanner = new Scanner(System.in);

            while (true) {
                board.printBoard();
                System.out.println("Det är " + (currentPlayer == 'X' ? playerX.getName() : playerO.getName()) + "s tur.");

                System.out.println("Ange ditt drag: ");
                String move = scanner.nextLine();

                if (board.isValidMove(move, currentPlayer)) {
                    int row = move.charAt(0) - 'A';
                    int col = move.charAt(1) - '1';
                    board.makeMove(row, col, currentPlayer);

                    if (board.isGameWon(currentPlayer)) {
                        board.printBoard();
                        System.out.println((currentPlayer == 'X' ? playerX.getName() : playerO.getName()) + " vinner!");
                        if (playAgain(scanner)) {
                            initializeGame();
                            continue;
                        } else {
                            break;
                        }
                    } else if (board.isBoardFull()) {
                        board.printBoard();
                        System.out.println("Oavgjort!");
                        if (playAgain(scanner)) {
                            initializeGame();
                            continue;
                        } else {
                            break;
                        }
                    }

                    currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
                } else {
                    System.out.println("Ogiltigt drag. Försök igen.");
                }
            }

            scanner.close();
        }

        // Metod för att ställa in spelarnas namn
        private void getPlayersNames() {
            Scanner scanner = new Scanner(System.in);

            System.out.print("Namn på spelare X: ");
            playerX.setName(scanner.nextLine());

            System.out.print("Namn på spelare O: ");
            playerO.setName(scanner.nextLine());


        }

        // Metod för att återställa spelet
        private void initializeGame() {
            board.initializeBoard();
            currentPlayer = 'X';
        }

        // Metod för att fråga om spelaren vill spela igen
        private boolean playAgain(Scanner scanner) {
            System.out.println("Spela igen? (Ja/Nej): ");
            String choice = scanner.nextLine().trim().toLowerCase();
            return choice.equals("ja");
        }

        public static void main(String[] args) {
            Game game = new Game();
            game.playGame();

        }
    }




