package games.plays;
import games.genericgames.Game;
import games.players.Player;

public class Orchestrator {
    private Game game;

    /**
     * Constructeur de la classe Orchestrator.
     *
     * @param game Instance du jeu à arbitrer.
     */
    public Orchestrator(Game game) {
        this.game = game;
    }

    /**
     * Méthode play qui gère une partie.
     */
    public void play() {
        System.out.println("Début de la partie !");

        // Boucle  du jeu
        while (!game.isOver()) {
            // Affiche la situation actuelle
            System.out.println(game.situationToString());

            // Récupère le joueur courant
            Player currentPlayer = game.getCurrentPlayer();
            System.out.println("C'est au tour de " + currentPlayer);

            // Demande un coup au joueur
            int move = currentPlayer.chooseMove(game);

            // Exécute le coup
            game.execute(move);
        }

        // Partie terminée, affichage des résultats
        System.out.println(game.situationToString());
        Player winner = game.getWinner();

        if (winner == null) {
            System.out.println("Match nul !");
        } else {
            System.out.println("Le gagnant est : " + winner);
        }
    }
}
