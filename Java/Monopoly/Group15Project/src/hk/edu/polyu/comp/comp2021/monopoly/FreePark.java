package hk.edu.polyu.comp.comp2021.monopoly;


/**
 *
 */
public class FreePark extends Position {

    /**
     *
     */
    FreePark(){
        super("Free Parking");
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public void renew() {

    }

    @Override
    public void arrived(Player player) {
        System.out.println(player.getName()+"have arrived Free Park.");
    }
}
