package games.nim;

/**
 * une classe pour le jeu de Nim
 *
 * @author Khalil Mohammad, Omar Aldroubi
 */
public class Nim {
    /** Taille initiale du tas */
    private int initialNbMatches;
    /** Nombre maximal d’allumettes qu’un joueur peut retirer*/
    private int maxMatchesPerTurn;
    /** Nom du joueur 1 */
    private String player1;
    /** Nom du joueur 1 */
    private String player2;
    /**  Nombre courant d’allumettes*/
    private int currentNbMatches;
    /** Joueur courant */
    private String currentPlayer;

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
    public Nim(int initialNbMatches, int maxMatchesPerTurn, String j1, String j2) {
        this.initialNbMatches = initialNbMatches;
        this.maxMatchesPerTurn = maxMatchesPerTurn;
        this.player1 = j1;
        this.player2 = j2;
        this.currentNbMatches = initialNbMatches;  // Initialisation du tas courant
        this.currentPlayer = j1;  // Le joueur courant est initialisé au premier joueur
    }


    /**
     * reoutrne le nombre initiale des allumettes
     * @return le nombre initiale des allumettes
     */
    public int getInitialNbMatches() {
        return initialNbMatches;
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
     * @return le joueur courant
     */
    public String getCurrentPlayer() {
        return this.currentPlayer;
    }

    /**
     *retourne le nombre restant des allumettes
     * @return le nombre restant des allumettes
     */
    public String situationToString(){
        int nbMatches = this.currentNbMatches;
        return "Il reste " + nbMatches + " allumettes";
    }

    /**
     * soustrait le nombre d'allumettes dans currentNbMatches et change le joueur courant
     * @param nbMatches      le nombre d'allumettes à retirer du tas
     */
    public void removeMatches(int nbMatches){
        currentNbMatches -= nbMatches;

        //on peut faire une fonction pour changePlayer()
        if(currentPlayer.equals(player1)){
            currentPlayer = player2;
        }
        else {
            currentPlayer = player1;
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
        if(nbMatches > 0 && nbMatches <= maxMatchesPerTurn
                && nbMatches <= currentNbMatches){
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
        if(currentNbMatches == 0){
            return true;
        }
        return false;
    }

    /**
     * retourne le joueur gagnant
     *
     * @return player1 ou player2 ou null sel
     */
    public String getWinner(){
        if(isOver()){
            if(currentPlayer.equals(player1)){
                return player1;
            }
            else{
                return player2;
            }
        }
        return null;
    }
}















