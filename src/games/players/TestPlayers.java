package games.players;
import gamestests.players.HumanTests;
import gamestests.players.RandomPlayerTests;
import gamestests.players.NegamaxPlayerTests;
import gamestests.players.NegamaxPlayerWithCacheTests;
public class TestPlayers {
    public static void main(String[] args){
        boolean ok = true;
        //HumanTests humanTester = new HumanTests();
        // Change argument to true in next call to reactivate printing
        //ok = ok && humanTester.testChooseMove(false);
        RandomPlayerTests randomTester = new RandomPlayerTests();
        ok = ok && randomTester.testChooseMove();

        NegamaxPlayerTests negamaxTester = new NegamaxPlayerTests();
        ok = ok && negamaxTester.testEvaluate();
        ok = ok && negamaxTester.testChooseMove();
        //System.out.println(ok ? "All tests OK" : "At least one test KO");
        System.out.println(ok ? "All tests OK" : "At least one test KO");
    }
}
