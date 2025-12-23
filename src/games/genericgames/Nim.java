package games.genericgames;

import games.players.Player;

import java.util.ArrayList;
import java.util.List;

/**
 * une classe pour le jeu de Nim
 *
 * @author Khalil Mohammad, Omar Aldroubi
 */
public class Nim extends AbstractGame {
    /** Taille initiale du tas */
    private int initialNbMatches;
    /** Nombre maximal d’allumettes qu’un joueur peut retirer*/
    private int maxMatchesPerTurn;
    /**  Nombre courant d’allumettes*/
    private int currentNbMatches;

    /**
     * Le constructeur qui permet de creer une jeu de nim
     *
     * @param initialNbMatches   nombre initial du tas
     * @param maxMatchesPerTurn  le Nombre maximal d’allumettes qu’un joueur peut retirer à chaque tour
     * @param j1                 Le nom du joueur 1
     * @param j1                 Le nom du joueur 2
     *
     * initialise aussi le nombre courant des allumetes au nombre initiale des allumettes
     * initiailise aussi le joueur courant au joueur 1
     */
    public Nim(int initialNbMatches, int maxMatchesPerTurn, Player j1, Player j2) {
        super(j1, j2); // apeller le constructuer d'AbstractGame
        this.initialNbMatches = initialNbMatches;
        this.maxMatchesPerTurn = maxMatchesPerTurn;
        this.currentNbMatches = initialNbMatches;  // Initialisation du tas courant
        //this.currentPlayer = j1;  // Le joueur courant est initialisé au premier joueur
    }


    /**
     * reoutrne le nombre initiale des allumettes
     * @return le nombre initiale des allumettes
     */
    public int getInitialNbMatches() {
        return this.initialNbMatches;
    }

    /**
     * retourne le nombre courant des allumettes
     * @return le nombre courant des allumettes
     */
    public int getCurrentNbMatches() {
        return this.currentNbMatches;
    }

    /**
     * retourne le nom du joueur courant
     *
     * @return le joueur courant
     */
    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    /**
     *retourne le nombre restant des allumettes
     * @return le nombre restant des allumettes
     */
    public String situationToString(){
        int nbMatches = getCurrentNbMatches();
        return "Il reste " + nbMatches + " allumettes";
    }


    /*public void removeMatches(int nbMatches){
        currentNbMatches -= nbMatches;

        //on peut faire une fonction pour changePlayer()
        if(currentPlayer.equals(player1)){
            currentPlayer = player2;
        }
        else {
            currentPlayer = player1;
        }
    }*/

    @Override
    protected void doExecute(int nbMatches){
        if(isValid(nbMatches)){
            currentNbMatches -= nbMatches;
        }
    }

    /**
     * verifie si le nombre d'allumettes à retirer est valide ou pas
     *
     * @param nbMatches     le nombre d'allumettes à retirer du tas
     *
     * @return true si valide, false sinon
     */
    public boolean isValid(int nbMatches){
        if(nbMatches > 0 && nbMatches <= this.maxMatchesPerTurn
                && nbMatches <= this.currentNbMatches){
            return true;
        }
        return false;
    }


    /**
     * verifie si le jeu est terliné ou pas
     *
     * @return true si le jeu est termine, false sinon
     */
    public boolean isOver() {
        if(this.currentNbMatches == 0){
            return true;
        }
        return false;
    }

    /**
     * retourne le joueur gagnant
     *
     * @return player1 ou player2 ou null sel
     */
    public Player getWinner(){
        if(isOver()){
            if(getCurrentPlayer().equals(player1)){
                return player1;
            }
            else{
                return player2;
            }
        }
        return null;
    }

    @Override
    public List<Integer> validMoves() {
        List<Integer> moves = new ArrayList<>();
        for (int i = 1; i <= maxMatchesPerTurn && i <= currentNbMatches; i++) {
            moves.add(i);
        }
        return moves;
    }

    @Override
    public String moveToString(int move) {
        return "Retirer " + move + " allumettes.";
    }

    @Override
    public Game copy() {
        Nim res = new Nim(this.initialNbMatches, this.maxMatchesPerTurn, this.player1, this.player2);
        res.currentNbMatches = this.currentNbMatches;
        res.currentPlayer = super.currentPlayer;
        return res;
    }
}















