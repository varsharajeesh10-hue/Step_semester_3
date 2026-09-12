import java.util.Arrays;

class Player implements Comparable<Player> {

    private String name;
    private int matchesPlayed;
    private double battingAverage;
    private boolean injured;

    // Constructor
    public Player(String name, int matchesPlayed,
                  double battingAverage, boolean injured) {

        this.name = name;
        this.matchesPlayed = matchesPlayed;
        this.battingAverage = battingAverage;
        this.injured = injured;
    }

    // Experience-only rule
    static boolean isDraftable(int matchesPlayed) {

        return matchesPlayed >= 10;
    }

    // Matches + fitness rule
    static boolean isDraftable(int matchesPlayed,
                               boolean injured) {

        return matchesPlayed >= 5 && !injured;
    }

    // Compare fantasy points
    public int compareTo(Player other) {

        return Double.compare(
            other.battingAverage,
            this.battingAverage
        );
    }

    public String getName() {
        return name;
    }
}

public class FantasyLeagueAutoDraft {

    static String draftAndRank(Player[] players) {

        Player[] draftable = new Player[players.length];

        int count = 0;

        // Find draftable players
        for (int i = 0; i < players.length; i++) {

            if (Player.isDraftable(players[i].matchesPlayed) ||
                Player.isDraftable(
                    players[i].matchesPlayed,
                    players[i].injured
                )) {

                draftable[count] = players[i];
                count++;
            }
        }

        // Create smaller array
        Player[] finalList = new Player[count];

        for (int i = 0; i < count; i++) {
            finalList[i] = draftable[i];
        }

        // Sort using compareTo()
        Arrays.sort(finalList);

        // Create result
        String result = "";

        for (int i = 0; i < finalList.length; i++) {

            result = result
                    + (i + 1)
                    + ". "
                    + finalList[i].getName();

            if (i < finalList.length - 1) {
                result = result + " | ";
            }
        }

        return result;
    }

    public static void main(String[] args) {

        Player[] players = {

            new Player("Virat", 15, 48.0, false),
            new Player("Rahul", 7, 55.0, false),
            new Player("Sameer", 3, 60.0, false),
            new Player("Dev", 12, 20.0, true)
        };

        System.out.println(
            draftAndRank(players)
        );
    }
}