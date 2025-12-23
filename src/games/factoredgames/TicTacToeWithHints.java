package games.factoredgames;

import java.util.ArrayList;

public class TicTacToeWithHints extends TicTacToe{

    public TicTacToeWithHints(String player1, String player2) {
        super(player1, player2);
    }



    String[][] board = getBoard();
    public ArrayList<Integer> hints() {
        ArrayList<Integer> hintList = new ArrayList<>();

        String adversaire = null;
        if(getCurrentPlayer().equals(player1)){
            adversaire = player2;
        }else {
            adversaire = player1;
        }
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                //String[][] board = new String[3][3];
                if(board[row][col].equals(" ")){
                    board[row][col] = adversaire;
                    if(getWinner() != null && getWinner().equals(adversaire)){
                        hintList.add(3 * row+ col);
                    }
                    board[row][col] = " ";
                }
            }
        }
        return hintList;
    }


    @Override
    public String situationToString(){
        String situation = "  0 1 2" + System.lineSeparator();
        ArrayList<Integer> hintList = hints();
        for (int i = 0; i < 3; i++) {
            situation += i + " ";  // ajouter le numéro de la ligne
            for (int j = 0; j < 3; j++) {
                String symbol = board[i][j];
                if(symbol.equals(" ") && hintList.contains(i * 3 + j)){
                    symbol = "!"; // indiquer un indice par "!"
                }
                situation += symbol + " ";
            }
            situation += System.lineSeparator();  // retour à la ligne après chaque rangée
        }
        // Ajouter les indices (cases menacées) sous forme de coordonnées
        situation += "Indices pour " + getCurrentPlayer() + " : " + hintList + System.lineSeparator();
        return situation;
    }
}
