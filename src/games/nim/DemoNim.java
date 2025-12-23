package games.nim;
import java.util.Scanner;

/**
 * classe executable pour le jeu de nim
 *
 * @author Khalil Mohammad, Omar Aldroubi
 */
public class DemoNim {

    /**
     * lance le demo du classe Nim
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //nom du premier joueur
        System.out.println("Le nom du joueur 1 : ");
        String player1 = scanner.next();

        //nom du deuxieme joueur
        System.out.println("Le nom du joueur 2 : ");
        String player2 = scanner.next();

        // on recupere la taille initiale de tas(n) et le nb max à retirer(k)
        System.out.println("Entrez le nombre initaile d'allumettes: ");
        int n = Integer.parseInt(scanner.next());
        System.out.println("Entrez le nombre maximux qu'un joueur peut retirer: ");
        int k = Integer.parseInt(scanner.next());

        // creer le jeu avec les infos fournies
        Nim nim = new Nim(n, k, player1, player2);

        //boucle du jeu
        while(!nim.isOver()){
            //Afficher le nombre d'allumette restant
            System.out.println(nim.situationToString());

            //on recupere le nombre d'llumette que le joueur veut retirer
            System.out.println(nim.getCurrentPlayer() + ", combien d'allumettes voulez vous retirer : ");
            int retirer = Integer.parseInt(scanner.next());

            //on verifie si le coup est valide ou pas, si oui on retire les allumettes, si non on ressaye
            if(nim.isValid(retirer)){
                nim.removeMatches(retirer);
            }
            else{
                System.out.println("coup invalide ");
            }
        }
        String winner = nim.getWinner();
        System.out.println("Le gagnant est " + winner);

        scanner.close();
    }
}
