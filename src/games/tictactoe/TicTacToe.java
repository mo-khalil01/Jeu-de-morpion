package games.tictactoe;
/**
 * une classe pour le jeu de morpion
 *
 * @author Khalil Mohammad, Omar Aldroubi,
 */
public class TicTacToe {
    /** Le plateau du jeu */
    private String[][] board;
    /** Nom du joueur 1 */
    protected String player1;
    /** Nom du joueur 2 */
    protected String player2;
    /** Le joueur courant */
    private String currentPlayer;

    /**
     * Le constructeur qui permet de creer une jeu de morpion
     *
     * @param player1                 Le nom du joueur 1
     * @param player2                 Le nom du joueur 2
     *
     * initialise le plateau de jeu à un tableau de jeu à une grille [3][3]
     * initiailise aussi le joueur courant au joueur 1
     * initialise un plateau vide
     */
    public TicTacToe(String player1, String player2) {
        this.player1 = player1;
        this.player2 = player2;
        board = new String[3][3]; // initialiser le plateau du jeu
        this.currentPlayer = player1;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = " "; // initialiser un plateau vide.
            }
        }
    }


    /**
     * retourne le nom du joueur courant
     * @return le joueur courant
     */
    public String getCurrentPlayer() {
        return currentPlayer;
    }

    public String[][] getBoard() {
        return board;
    }


    /**
     * verifie si le coup joué est valide , si oui on met à jour le plateau et change le joueur
     *
     * @param row      placement de rangé choisi par le joueur(0,1,2)
     * @param col      placement de colonne choisi par le joueur(0,1,2)
     */
    public void execute(int row, int col){
        //si le coup est valide, on met à jour le plateau et on change le joueur courant
        if(isValid(row, col)) {
            updateBoard(row, col);
            changePlayer();
        }
    }


    /**
     * met à jour le plateau de jeu à l'endroit souhaité. pour le joueur 1 on met 'X', pour le joueur 2 on met 'O'
     */
    public void updateBoard(int row, int col){
        if (currentPlayer.equals(player1)) {
            board[row][col] = "X";
        }
        else if(currentPlayer.equals(player2)) {
            board[row][col] = "O";
        }
    }

    /**
     * change le joueur courant
     */
    public void changePlayer(){
        if (currentPlayer.equals(player1)) {
            currentPlayer = player2;
        }
        else if (currentPlayer.equals(player2)) {
            currentPlayer = player1;
        }
    }


    /**
     * verifie si le coup joué est valide ou pas
     *
     * @param row      placement de rangé choisi par le joueur(0,1,2)
     * @param col      placement de colonne choisi par le joueur(0,1,2)
     *
     * @return true si valide, false sinon
     */
    public boolean isValid(int row, int col){
        return row >= 0 && row < 3 && col >= 0 && col < 3 && board[row][col].equals(" ");
    }


    /**
     * verifie si il y a un alignement gangant sur le plateau ou pas
     *
     * @param player          le joueur concerné
     * @param row             le numero du rangé
     * @param column          le numero du colonne
     * @param deltaRow
     * @param deltaColumn
     *
     * @return true si il existe un alignement gangant , false sinon
     */
    public boolean wins(String player, int row, int column, int deltaRow, int deltaColumn){
        String mark = null;
        if(player.equals(player1)) {
            mark = "X";
        }
        else if(player.equals(player2)) {
            mark = "O";
        }

        int case1Row = row + deltaRow;
        int case1Col = column + deltaColumn;
        int case2Row = row + 2 * deltaRow;
        int case2Col = column + 2 * deltaColumn;

        return board[row][column].equals(mark) && board[case1Row][case1Col].equals(mark) && board[case2Row][case2Col].equals(mark);
    }


    /**
     * reourne le nom du joueur gagnant ou null si match null
     *
     * @return player1 , player2 ou null
     */
    public String getWinner(){
        for (int i = 0; i < 3; i++) {
            // vérifie les lignes et les colonnes
            if (wins(player1, i, 0, 0, 1) || wins(player1, 0, i, 1, 0)) return player1;
            if (wins(player2, i, 0, 0, 1) || wins(player2, 0, i, 1, 0)) return player2;
        }
        // vérifie les diagonales
        if (wins(player1, 0, 0, 1, 1) || wins(player1, 0, 2, 1, -1)) return player1;
        if (wins(player2, 0, 0, 1, 1) || wins(player2, 0, 2, 1, -1)) return player2;

        return null;  // Aucun gagnant
    }


    /**
     * verifie si le jeu est terminé ou pas
     *
     * @return true si le jeu est terminé, false sinon
     */
    public boolean isOver() {
        // Si il y a un gagnant, la partie est terminée
        if (getWinner() != null) {
            return true;
        }

        // Vérifier si il y a des cases vides ou pas
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j].equals(" ")) {  // si il existe une case vide, la partie n'est pas terminée
                    return false;
                }
            }
        }

        // Si aucune case vide et pas de gagnant, la partie est terminée en match nul
        return true;
    }


    /**
     * affiche la situation courant du plateau du jeu
     *
     * @return  situation actuelle du plateau
     */
    public String situationToString() {
        String situation = "  0 1 2" + System.lineSeparator();

        for (int i = 0; i < 3; i++) {
            situation += i + " ";  // ajouter le numéro de la ligne
            for (int j = 0; j < 3; j++) {
                situation += board[i][j];  // ajouter la valeur dans la case
                situation += " ";  // ajouter un espace
            }
            situation += System.lineSeparator();  // retour à la ligne après chaque rangée
        }

        return situation;
    }
}
