package games.genericgames;

import games.players.Player;

import java.util.ArrayList;
import java.util.List;

/**
 * une classe pour le jeu de morpion
 *
 * @author Khalil Mohammad, Omar Aldroubi,
 */
public class TicTacToe extends AbstractGame {
    /** Le plateau du jeu */
    private final String[][] board;

    /**
     * Le constructeur qui permet de creer une jeu de morpion
     *
     * @param player1  une instance de Player representant le joueur 1
     * @param player2  une instance de Player representant le joueur 2
     *
     * initialise le plateau de jeu à un tableau de jeu à une grille [3][3]
     * initiailise aussi le joueur courant au joueur 1
     * initialise un plateau vide
     */
    public TicTacToe(Player player1, Player player2) {
        super(player1, player2);
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
     *
     * @return le joueur courant
     */
    public Player getCurrentPlayer() {
        return this.currentPlayer;
    }

    /**
     * retourne le plateau du jeu
     */
    public String[][] getBoard() {
        return this.board;
    }

    /**
     * prend le coup à executer en parametre et appelle la methode
     * updateBoard() pour mettre à jour le plateau du jeu
     * @param move le coup à exécuter, représenté par un entier.
     */
    @Override
    public void doExecute(int move){
        int row = move / 3;
        int col = move % 3;
        updateBoard(row, col);
    }

    /**
     * verifie si le coup joué est valide , si oui on met à jour le plateau et change le joueur
     *
     * @param move placement de
     */
    /*public void execute(int move){
        int row = move / 3;
        int col = move % 3;
        //si le coup est valide, on met à jour le plateau et on change le joueur courant
        if(isValid(move)) {
            updateBoard(row, col);
            changePlayer();
        }
    }*/


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
     * @param move  placement de colonne choisi par le joueur(0,1,2)
     *
     * @return true si valide, false sinon
     */
    @Override
    public boolean isValid(int move){
        int row = move / 3;
        int col = move % 3;
        if(move >= 0 && move < 9 && board[row][col].equals(" ")){
            return true;
        }else {
            return false;
        }
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
    public boolean wins(Player player, int row, int column, int deltaRow, int deltaColumn){
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
     * Détermine le gagnant de la partie.
     *
     * @return Le joueur gagnant, ou null si la partie est encore en cours ou si elle s'est terminée par un match nul
     */
    @Override
    public Player getWinner(){
        for (int i = 0; i < 3; i++) {
            // vérifie les lignes et les colonnes
            if (wins(player1, i, 0, 0, 1) || wins(player1, 0, i, 1, 0)) return player1;
            if (wins(player2, i, 0, 0, 1) || wins(player2, 0, i, 1, 0)) return player2;
        }
        // vérifie les diagonales
        if (wins(player1, 0, 0, 1, 1) || wins(player1, 0, 2, 1, -1)) return player1;
        if (wins(player2, 0, 0, 1, 1) || wins(player2, 0, 2, 1, -1)) return player2;

        return null;  // Match nul ou partie en cours
    }


    /**
     * verifie si le jeu est terminé ou pas
     *
     * @return true si le jeu est terminé, false sinon
     */
    @Override
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

    
    @Override
    public List<Integer> validMoves(){
        List<Integer> moves = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j].equals(" ")) {
                    moves.add(3 * i + j);
                }
            }
        }
        return moves;
    }


    @Override
    public String moveToString(int move){
        int row = move / 3;
        int col = move % 3;
        return "(" + row + "," + col + ")";
    }

    /**
     * affiche la situation courant du plateau du jeu
     *
     * @return  situation actuelle du plateau
     */
    @Override
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

    @Override
    public Game copy(){
        // crer une nouvelle instantce de TicTacToe
        TicTacToe copy = new TicTacToe(player1, player2);

        for (int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++){
                copy.board[i][j] = this.board[i][j];
            }
        }
        copy.currentPlayer = this.currentPlayer;
        return copy;
    }
}
