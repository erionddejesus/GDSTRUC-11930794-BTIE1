import java.util.Objects;
import java.util.Random;

public class Card {

    private int cardID;
    private String cardName;

    public Card(int cardID, String cardName) {
        this.cardID = cardID;
        this.cardName = cardName;
    }

    public int getCardID() {
        return cardID;
    }

    public void setCardID(int cardID) {
        this.cardID = cardID;
    }

    public String getCardName() {
        return cardName;
    }

    public void setCardName(String cardName) {
        this.cardName = cardName;
    }

    @Override
    public String toString() {
        return "Card {" +
                "cardID = " + cardID +
                ", cardName = " + cardName +
                "}";
    }
}
