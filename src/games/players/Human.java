package games.players;

import games.genericgames.Game;

import java.util.List;
import java.util.Scanner;

public class Human implements Player {
    private String name;
    private Scanner scanner;

    /**
     * Constructeur de la classe Human.
     *
     * @param name    Le nom du joueur.
     * @param scanner Une instance de Scanner pour la saisie utilisateur.
     */
    public Human(String name, Scanner scanner) {
        this.name = name;
        this.scanner = scanner;
    }


    /**
     * Permet au joueur humain de choisir un coup valide.
     *
     * @param game Le jeu en cours, implémentant l'interface Game.
     * @return Le coup choisi par le joueur.
     */
    @Override
    public int chooseMove(Game game) {
        List<Integer> validMoves = game.validMoves(); // Récupère la liste des coups valides.
        int chosenMove;

        while (true) {
            System.out.println("Coups valides : " + validMoves);
            System.out.print(this.name + ", entrez votre coup : ");
            // Utilisation d'un try-catch pour gérer les cas où l'entrée utilisateur n'est pas un nombre valide.
            try {
                chosenMove = Integer.parseInt(scanner.nextLine()); // Lecture de l'entrée utilisateur.

                // Vérifie si le coup est valide.
                if (validMoves.contains(chosenMove)) {
                    break; // Sort de la boucle si le coup est valide.
                } else {
                    System.out.println("Coup invalide. Veuillez réessayer.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Entrée invalide. Veuillez entrer un nombre.");
            }
        }

        return chosenMove; // Retourne le coup choisi.
    }


    /**
     * Redéfinition de la méthode toString pour retourner le nom du joueur.
     *
     * @return Le nom du joueur.
     */
    @Override
    public String toString() {
        return this.name;
    }
}











