package hk.edu.polyu.comp.comp2021.monopoly;


/**
 * Tax Class
 */
public class Tax extends Position{
    private final static double taxPrecent = 0.1;
    /**
     * Tax constructor
     */
    Tax() {
        super("Tax");
    }

    @Override
    public String toString() {
        return name;
    }


    @Override
    public void arrived(Player player) {

        int tax = taxable(player);
        player.pay(tax);

        if (player.getIsComp()) {
            System.out.println("You have arrived 'TAX' area and have to pay 10% of your money as income tax");
            System.out.println("You have pay " + "$" + tax);
        }
        else {
            System.out.println(player.getName() + " have arrived 'TAX' area and have to pay 10% of your money as income tax");
            System.out.println(player.getName() + " have to pay" + "$" + tax);
        }
        System.out.println("Remain: "+player.getAmount());
    }

    /**
     * @param player player
     * @return tax
     */
    public int taxable(Player player) {
        double tax = player.getAmount() * taxPrecent;
        if (tax % 10 != 0) {
            tax -= (tax % 10);
        }
        return (int)tax;
    }
}
