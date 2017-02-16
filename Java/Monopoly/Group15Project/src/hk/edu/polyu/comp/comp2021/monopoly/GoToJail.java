package hk.edu.polyu.comp.comp2021.monopoly;

/**
 * GoToJail CLass
 */
public class GoToJail extends Position {

    /**
     *
     */
    GoToJail(){
        super("Go To Jail");
    }

    @Override
    public String toString(){
        return name;
    }

    @Override
    public void arrived(Player player) {

        if(!player.getIsComp()) {
            System.out.println("You are put in jail due to commitment in crime");
        }
        else {
            System.out.println(player.getName()+" is put in jail");
        }

        player.positionSetToJail();
        player.setInjall(true);
    }
}
