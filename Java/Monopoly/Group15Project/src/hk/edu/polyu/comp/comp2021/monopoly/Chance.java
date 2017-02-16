package hk.edu.polyu.comp.comp2021.monopoly;
import java.util.Random;

/**
 * Class chance
 */
public class Chance extends Position {
    private final static int High = 20;
    private final static int Low = -30;

    /**
     * Chance default constructor
     */
    Chance(){
        super("Chance");
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public void arrived(Player player) {

        if (!player.getIsComp()) {
            System.out.println("You have arrive 'CHANCE' and you may earn or lose money.");
        }
        else {
            System.out.println(player.getName()+" have arrive 'CHANCE'");
        }

        int result;
        do {
            Random r = new Random();
            result = r.nextInt(High - (Low)) + (Low);
        } while(result == 0);

        result *= 10;

        if (result > 0) {
            if (!player.getIsComp()) {
                System.out.println("Congratulation You have earn" + " " + "$" + result);
            }
            else {
                System.out.println(player.getName()+" earns"+" "+"$"+result);
            }
            player.earn(result);
        }
        else {
            if (!player.getIsComp()) {
                System.out.println("Oops... Sorry You have to pay" + " " + "$" + result*-1);
            }
            else {
                System.out.println(player.getName() + " " + "pays"+" "+"$"+result*-1);
            }
            player.pay(result);
            System.out.println("Remain: "+player.getAmount());
        }

    }
}
