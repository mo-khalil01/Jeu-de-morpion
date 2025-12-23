package games.players;

import games.genericgames.Game;

import java.util.List;
import java.util.Random;

public class RandomPlayer implements Player {
    private Random random;

    public RandomPlayer(Random random) {
        this.random = random;
    }


    /**
     * Redéfinition de la méthode chooseMove pour retourner un coup valide
     * tiré aléatoirement parmi les coups valides.
     *
     * @param game Instance de Game représente le jeu en cours.
     * @return Un coup valide tiré aléatoirement.
     */
    @Override
    public int chooseMove(Game game) {
        List<Integer> validMoves = game.validMoves(); // Récupère les coups valides.

        if (validMoves.isEmpty()) {
            return -1; // Retourne une valeur spéciale car pas de coup valide.
        }

        // Tire un indice aléatoire dans l'intervalle [0, validMoves.size()[.
        int randomIndex = random.nextInt(validMoves.size());
        return validMoves.get(randomIndex); // Retourne le coup correspondant.
    }

    /**
     * Redéfinition de toString pour identifier le joueur.
     *
     * @return "Joueur Aléatoire" + hashCode().
     */
    @Override
    public String toString() {
        return "Joueur aléatoire n° " + this.hashCode();
    }
}
