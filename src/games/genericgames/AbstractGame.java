package games.genericgames;

import games.players.Player;

import java.util.List;

/**
 * cette classe abstraite reprensente un jeu  à deux joueurs.
 * cette classe implemente l'interface Game 
 */
public abstract class AbstractGame implements Game{

    /**
     * le premier joueur du jeu
     */
    protected Player player1;
    /**
     * le secionde joueur du jeu
     */
    protected Player player2;

    /**
     * le joueur courant 
     */
    protected Player currentPlayer;

    /**
     * constructeur de la classe AbstractGame
     * initialise kles deux joueurs et defuinit le premier joueur comme joueur courant
     * 
     * @param player1 le premier joueur
     * @param player1 le seconde joueur
     */
    public AbstractGame(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
        this.currentPlayer = player1;
    }

    /**
     *cette  méthode abstraite permet d'executer un coup sans changer le joueur courant.
     *
     * @param move le coup à exécuter, représenté par un entier.
     */
    protected abstract void doExecute(int move);


    /**
     * cette methode concrète qui exécute un coup et changer le joueur.
     * Elle appelle la méthode doExecute()
     *
     *
     * @param move le coup à exécuter, représenté par un entier.
     */
    @Override
    public void execute(int move){
        doExecute(move);
        if(currentPlayer.equals(player1)){
            currentPlayer = player2;
        }else {
            currentPlayer = player1;
        }
    }


    /**
     * retourne le joueur courant
     * @return le joueur à qui est le tour
     */
    @Override
    public Player getCurrentPlayer() {
        return this.currentPlayer;
    }

    /**
     * verifie si un coup est valide 
     * 
     * @param move le coup ç verifier 
     * @return true si le coup est valide false sinon
     */
    @Override
    public abstract boolean isValid(int move);


    /**
     * verifie si le jeu est terminé 
     * @return true si le jeu est terminé false sinon
     */
    @Override
    public abstract boolean isOver();

    /**
     * retourne le gagnant de la partie ou null si le jeu est encore en cours
     * ou si la partie est nulle
     * 
     * 
     * @return le joueur gagnant, ou null si le n'a pas de gagnant
     */
    @Override
    public abstract Player getWinner();

    /**
     * retourne la liste dse coups valides dans la situation cournte
     * @return une liste d'entier representant les coups valides
     */
    @Override
    public abstract List<Integer> validMoves();


    /**
     * retourne une representation textuelle d'uncoup
     * @param move le coup à representer
     * @return une chaine de caratere 
     */
    @Override
    public abstract String moveToString(int move);


    /**
     * retourne une representation de la situation actuelle
     *@return une chaine de caractere representant la situation courant
     */
    @Override
    public abstract String situationToString();


    /**
     * retourne une copie de l'etat actuel du jeu
     */
    @Override
    public abstract Game copy();
}
