package games.players;

import games.genericgames.Game;

public class NegamaxPlayer implements Player{
    
    /**
     * constructeur sans argument, ne fait rien
     */
    public NegamaxPlayer() {
    }

    /**
     * imlpement chooseMove de l'interface et retourne le meilleur coup 
     * 
     * @param game la situation courant de type Game
     */
    @Override
    public int chooseMove(Game game){
        int bestMove = -1;
        Integer bestValue = null;

        for (int move : game.validMoves()) {
            Game copy = game.copy();
            copy.execute(move);

            int value = -evaluate(copy);

            if (bestValue == null || value > bestValue) {
                bestValue = value;
                bestMove = move;
            }
        }

        return bestMove;
    }


    /**
     * retourne un entier qui represent la de cette situation
     * 
     * @param game la situation courant de type Game
     */
    public int evaluate(Game game) {
        // Vérifie les conditions terminales
        Player winner = game.getWinner();
        if (winner != null) {
            if (winner.equals(game.getCurrentPlayer())) {
                return 1; // Situation gagnante pour le joueur courant
            } else {
                return -1; // Situation perdante pour le joueur courant
            }
        } else if (game.isOver()) {
            return 0; // Match nul
        }

        // Si la situation n'est pas terminale

        //on utilise Integer au lieu de int pour res car Integer peut etre null
        //donc ça nous permet d'utilserr null comme indice qeu n'a pas enocre ete definie
        Integer res = null;

        for (int move : game.validMoves()) {
            Game copy = game.copy();
            copy.execute(move);
            int value = -evaluate(copy);

            if (res == null || value > res) {
                res = value;
            }
        }

        return res;
    }



    /**
     * redefinition de la mehtode toString pour retourner "NegamaxPlayer"
     */
    @Override
    public String toString() {
        return "NegamaxPlayer";
    }
}
