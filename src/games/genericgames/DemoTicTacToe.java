package games.genericgames;

import games.players.Human;
import games.players.Player;
import games.players.RandomPlayer;

import java.util.Random;
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
        Random random = new Random();
        
        // Saisie des noms des joueurs
        System.out.print("Nom du joueur 1 : ");
        String player1Name = scanner.nextLine();
        Player player1 = configurePlayer(player1Name, scanner, random);

        System.out.print("Nom du joueur 2 : ");
        String player2Name = scanner.nextLine();
        Player player2 = configurePlayer(player2Name, scanner, random);

        TicTacToe ticTacToe = new TicTacToe(player1, player2);

        while (!ticTacToe.isOver()){
            System.out.println(ticTacToe.situationToString());
            System.out.println("C'est à " + ticTacToe.getCurrentPlayer() + " de jouer");

            System.out.print("-range ? ");
            int row = scanner.nextInt();
            System.out.print("-colonne ? ");
            int column = scanner.nextInt();

            int move = 3 * row + column;
            //verification du coup joué
            if(ticTacToe.isValid(move)){
                ticTacToe.execute(move);
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

    /**
     * Configure un joueur en fonction du type choisi : Humain ou Aléatoire.
     */
    private static Player configurePlayer(String playerName, Scanner scanner, Random random) {
        System.out.println(playerName + ", choisissez votre type de joueur :");
        System.out.println("1. Humain");
        System.out.println("2. Aléatoire");
        System.out.print("Votre choix : ");
        int playerType = scanner.nextInt();
        scanner.nextLine(); // Consomme la fin de ligne

        if (playerType == 1) {
            System.out.print("Entrez le nom du joueur : ");
            String name = scanner.nextLine();
            return new Human(name, scanner);
        }
        else if (playerType == 2) {
            System.out.println("Un joueur aléatoire a été créé.");
            return new RandomPlayer(random);
        }
        else{
            System.out.println("Choix invalide, un joueur aléatoire sera utilisé par défaut.");
            return new RandomPlayer(random);
        }
    }
}
