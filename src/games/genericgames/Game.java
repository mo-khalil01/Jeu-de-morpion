package games.genericgames;

import games.players.Player;

import java.util.List;

public interface Game {
    // Déclaration des méthodes pour arbitrer une partie
    Player getCurrentPlayer(); // Le joueur courant
    boolean isValid(int move); // Vérifie si un coup est valide
    void execute(int move); // Exécute un coup
    boolean isOver(); // Vérifie si la partie est terminée
    Player getWinner(); // Retourne le joueur gagnant ou null
    List<Integer> validMoves(); // Retourne la liste des coups valides
    String moveToString(int move); // Représentation d’un coup
    String situationToString(); // Représentation de la situation actuelle
    Game copy(); // Retourne une copie de la situation courante
}
