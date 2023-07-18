public class Main {
    public static void main(String[] args) {

        //array string of random names
        Player stellar = new Player(1, "StellarPolaris");
        Player viper = new Player (2, "sssevipr");
        Player saku = new Player (3, "sssakuuu");
        Player tosh = new Player (4, "Tosh");
        Player blaire = new Player (5, "Blaire");
        Player jared = new Player (6, "Jared");
        Player ollie = new Player (7, "ollihuan");

        Hashtable hashtable = new Hashtable();

        hashtable.put(stellar.getPlayerName(), stellar);
        hashtable.put(viper.getPlayerName(), viper);
        hashtable.put(saku.getPlayerName(), saku);
        hashtable.put(tosh.getPlayerName(), tosh);
        hashtable.put(blaire.getPlayerName(), blaire);
        hashtable.put(jared.getPlayerName(), jared);
        hashtable.put(ollie.getPlayerName(), ollie);

        //print
        System.out.println("All players in hashtable: " + "\n");
        hashtable.printHashtable();

        //get
        System.out.println("\n");
        System.out.println("Look for sssevipr: ");
        System.out.println(hashtable.get("sssevipr"));

        //remove
        System.out.println("\n");
        System.out.println("Remove sssevipr: ");
        hashtable.remove("sssevipr");
        System.out.println("New list of players in hashtable: " + "\n");
        hashtable.printHashtable();
    }
}