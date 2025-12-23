package games.factoredgames;

/**
 * cette classe abstraite reprensente un jeu  à deux joueurs.,
 */
public abstract class AbstractGame {
    /**
     * Le nom du premier joueur.
     */
    protected String player1;
    /**
     * Le nom du seconde joueur.
     */
    protected String player2;

    /**
     * le nom du joueur courant
     */
    protected String currentPlayer;

    /**
     * Constructeur qui initialise un nouveau jeu avec les deux joueurs.
     * Par défaut, le premier joueur commence la partie.
     *
     * @param player1 le nom ou identifiant du premier joueur.
     * @param player2 le nom ou identifiant du deuxième joueur.
     */
    public AbstractGame(String player1, String player2) {
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
    public void execute(int move){
        doExecute(move);
        if(currentPlayer.equals(player1)){
            currentPlayer = player2;
        }else {
            currentPlayer = player1;
        }
    }

    /**
     * Retourne le joueur dont c'est actuellement le tour.
     *
     * @return le nom du joueur actuel.
     */
    public String getCurrentPlayer() {
        return this.currentPlayer;
    }
}
