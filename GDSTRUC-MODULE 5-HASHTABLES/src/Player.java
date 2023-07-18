import java.util.Objects;
import java.util.Random;

public class Player {

    private int playerID;
    private String playerName;

    public Player(int playerID, String playerName) {
        this.playerID = playerID;
        this.playerName = playerName;
    }

    public int getPlayerID() {
        return playerID;
    }

    public void setPlayerID(int playerID) {
        this.playerID = playerID;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setCardName(String playerName) {
        this.playerName = playerName;
    }

    @Override
    public String toString() {
        return "Player {" +
                "playerID = " + playerID +
                ", playerName = " + playerName +
                "}";
    }
}
