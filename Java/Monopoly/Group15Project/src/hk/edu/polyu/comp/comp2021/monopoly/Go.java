package hk.edu.polyu.comp.comp2021.monopoly;


/**
 *
 */
public class Go extends Position {
    final private static int amount = 1500;

    /**
     *
     */
    Go() {
        super("Go");
    }

    @Override
    public String toString() {
        return name;
    }


    @Override
    public void arrived(Player player) {

        if (!player.getIsComp()) {
            if (player.getPosition() != 0) {
                System.out.println("You have passed through the initial position and get $1500 salary");
            } else {
                System.out.println("You have arrived the initial position and get $1500 salary");
            }
        } else {
            if (player.getPosition() != 0) {
                System.out.println(player.getName()+" have passed through the initial position and get $1500 salary");
            } else {
                System.out.println(player.getName()+" have arrived the initial position and get $1500 salary");
            }
        }
        player.earn(amount);
        System.out.println("You now have "+player.getAmount());
    }
}