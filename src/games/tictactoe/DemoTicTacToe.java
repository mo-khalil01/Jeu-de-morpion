package games.tictactoe;
import java.util.Scanner;


/**
 * classe executable pour le jeu de morpion
 *
 * @author Khalil Mohammad, Omar Aldroubi
 */
public class DemoTicTacToe {

    /**
     * lance le demo du classe TicTacToe
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //demander si ils veulent jouer avec ou sans indices
        System.out.println("Voulez vous jouer avec des indices ? (o/n)");
        String choice = scanner.nextLine().trim().toLowerCase();
        
        // Saisie des noms des joueurs
        System.out.print("Nom du joueur 1 : ");
        String player1 = scanner.nextLine();
        System.out.print("Nom du joueur 2 : ");
        String player2 = scanner.nextLine();

        TicTacToe ticTacToe = null;
        if (choice.equals("o")) {
            ticTacToe = new TicTacToeWithHints(player1, player2);
        }else if (choice.equals("n")) {
            ticTacToe = new TicTacToe(player1, player2);
        }
        while (!ticTacToe.isOver()){
            System.out.println(ticTacToe.situationToString());
            System.out.println("C'est à " + ticTacToe.getCurrentPlayer() + " de jouer");

            System.out.print("-range ? ");
            int row = scanner.nextInt();
            System.out.print("-colonne ? ");
            int column = scanner.nextInt();

            //verification du coup joué
            if(ticTacToe.isValid(row, column)){
                ticTacToe.execute(row, column);
            }
            else {
                System.out.println("Coup invalide, veuillez reesayer. ");
            }
        }
        System.out.println(ticTacToe.situationToString());
        if (ticTacToe.getWinner() != null) {
            System.out.println("Le gagnant est : " + ticTacToe.getWinner());
        } else {
            System.out.println("Match nul ");
        }
    }
}
