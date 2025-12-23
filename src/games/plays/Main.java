package games.plays;

import games.genericgames.Nim;
import games.genericgames.TicTacToe;
import games.genericgames.Game;
import games.players.Human;
import games.players.NegamaxPlayer;
import games.players.Player;
import games.players.RandomPlayer;
// import games.plays.Orchestrator;

import java.util.Random;
import java.util.Scanner;

/**
 * classe principal executable en utilisant toutes les classes et interface ecrites
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.println("Bienvenue dans l'application de jeux !");
        System.out.println("Choisissez un jeu :");
        System.out.println("1. TicTacToe");
        System.out.println("2. Nim");
        System.out.print("Votre choix 1/2 : ");
        int gameChoice = scanner.nextInt();

        Game game = null;

        // Configuration des joueurs
        System.out.println("Configuration des joueurs :");
        Player player1 = configurePlayer("Joueur 1", scanner, random);
        Player player2 = configurePlayer("Joueur 2", scanner, random);

        // Initialisation du jeu
        if (gameChoice == 1) {
            System.out.println("Vous avez choisi le jeu TicTacToe.");
            game = new TicTacToe(player1, player2);
        }

        else if (gameChoice == 2) {
            System.out.println("Vous avez choisi le jeu Nim.");
            System.out.println("Entrez le nombre initaile d'allumettes: ");
            int n = Integer.parseInt(scanner.next());
            System.out.println("Entrez le nombre maximux qu'un joueur peut retirer: ");
            int k = Integer.parseInt(scanner.next());
            game = new Nim(n, k, player1, player2);
        } else{
            System.out.println("Choix invalide !");
        }

        // Lancer la partie
        Orchestrator orchestrator = new Orchestrator(game);
        orchestrator.play();

        scanner.close();
    }

    /**
     * Configure un joueur en fonction de l'entrée utilisateur.
     * permet de choisir le type de joueur parmi : Human, aleatoire ou Negamax
     * 
     * @param playerName  le nom du joueur à configurer
     * @param scanner un instance de scanner pour lire l'entrée utilisateur
     * @param random  une instance de Random utilisé pour generer des joueurs aleatoires
     * 
     * @return une instance de Player representant le joueur configuré
     */
    private static Player configurePlayer(String playerName, Scanner scanner, Random random) {
        System.out.println(playerName + ", choisissez votre type de joueur :");
        System.out.println("1. Humain");
        System.out.println("2. Aléatoire");
        System.out.println("3. Negamax");
        System.out.print("Votre choix, 1/2 : ");
        int playerType = scanner.nextInt();
        scanner.nextLine();

        if (playerType == 1) {
            System.out.print("Entrez le nom du joueur : ");
            String name = scanner.nextLine();
            return new Human(name, scanner);
        }
        else if (playerType == 2) {
            System.out.println("Un joueur aléatoire a été créé.");
            return new RandomPlayer(random);
        }
        else if (playerType == 3) {
            return new NegamaxPlayer();
        }
        else{
            System.out.println("Choix invalide, un joueur aléatoire sera utilisé par défaut.");
            return new RandomPlayer(random);
        }
    }
}
