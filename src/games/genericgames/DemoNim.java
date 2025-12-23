package games.genericgames;

import games.players.Human;
import games.players.Player;
import games.players.RandomPlayer;

import java.util.Random;
import java.util.Scanner;

/**
 * classe executable pour le jeu de nim
 *
 * @author Khalil Mohammad, Omar Aldroubi
 */
public class DemoNim {

    /**
     * lance le demo du classe Nim
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        //nom du premier joueur
        System.out.print("Nom du joueur 1 : ");
        String player1Name = scanner.nextLine();
        Player player1 = configurePlayer(player1Name, scanner, random);

        System.out.print("Nom du joueur 2 : ");
        String player2Name = scanner.nextLine();
        Player player2 = configurePlayer(player2Name, scanner, random);

        // on recupere la taille initiale de tas(n) et le nb max à retirer(k)
        System.out.println("Entrez le nombre initaile d'allumettes: ");
        int n = Integer.parseInt(scanner.next());
        System.out.println("Entrez le nombre maximux qu'un joueur peut retirer: ");
        int k = Integer.parseInt(scanner.next());

        // creer le jeu avec les infos fournies
        Nim nim = new Nim(n, k, player1, player2);

        //boucle du jeu
        while(!nim.isOver()){
            //Afficher le nombre d'allumette restant
            System.out.println(nim.situationToString());

            //on recupere le nombre d'llumette que le joueur veut retirer
            System.out.println(nim.getCurrentPlayer() + ", combien d'allumettes voulez vous retirer : ");
            int retirer = Integer.parseInt(scanner.next());

            //on verifie si le coup est valide ou pas, si oui on retire les allumettes, si non on ressaye
            if(nim.isValid(retirer)){
                nim.execute(retirer);
            }
            else{
                System.out.println("coup invalide ");
            }
        }
        Player winner = nim.getWinner();
        System.out.println("Le gagnant est " + winner);

        scanner.close();
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
