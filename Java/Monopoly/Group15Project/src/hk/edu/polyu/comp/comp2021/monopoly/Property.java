package hk.edu.polyu.comp.comp2021.monopoly;

import java.util.Scanner;


/**
 * Property Class
 */
public class Property extends Position {
    private int price;
    private int rent;
    private final static int BANK_ID = 100;
    private final static double PROBABILITY = 0.5;

    /**
     * constructor
     */
    Property() {
        super("Property");
    }

    /**
     * @param name property name
     * @param price price
     * @param rent rent
     */
    Property(String name, int price, int rent) {
        super(name,true);
        this.price = price;
        this.rent = rent;
        this.owner = new Player(BANK_ID,"Bank",true);

    }

    @Override
    public void arrived(Player player) {

        System.out.println("You Have arrived " + name);
        if (owner.getId() != BANK_ID && owner.getId() != player.getId()) {
            if (player.getAmount() >= rent) {
                System.out.println("You have arrived "+owner.getName()+"'s Property");
                System.out.println("You have to pay $"+rent);
                player.pay(rent);
                System.out.println("Remain: "+player.getAmount());
                owner.earn(rent);
                System.out.println(owner.getName() +" have earn $"+rent);
            } else {
                System.out.println("You have arrived "+owner.getName()+"'s Property");
                System.out.println("You have to pay $"+rent);
                int temp =player.getAmount();
                player.pay(rent);
                System.out.println("Remain: "+player.getAmount());
                System.out.println("Sorry you got bankrupt and lose the game");
                owner.earn(temp);
                player.retire();
            }
        } else {
            if (player.getAmount() < price) {
                System.out.println("You have not enough money to buy.");
            } else {
                if (player.getIsComp()&&player.getWasHuman()==false) {
                    System.out.println("The Price of "+name +" is "+price);
                    System.out.print("Do you want to buy this property?(Y/N)");
                    double ran = Math.random();
                    if (ran < PROBABILITY) {
                        System.out.println("Y");
                        player.pay(price);
                        System.out.println("Remain: "+player.getAmount());
                        owner = player;
                        System.out.println("You now is the owner of " + name);
                    } else {
                        System.out.println("N");
                    }

                } else {
                    if (player.getAmount() > price) {
                        Scanner sc = new Scanner(System.in);
                        while (true) {
                            System.out.println("The Price of "+name +" is "+price);
                            System.out.print("Do you want to buy this property?(Y/N)");
                            String ans = sc.next();
                            if (ans.equals("Y")) {
                                player.pay(price);
                                System.out.println("Remain: "+player.getAmount());
                                owner = player;
                                System.out.println("You now is the owner of " + name);
                                break;
                            } else if (ans.equals("N")) {
                                break;
                            }
                        }
                    }
                }
            }
        }
    }

    @Override
    public String toString() {
        if (owner.getId() != BANK_ID) {
            return name + "'s Owner is " + owner.getName() +"  Price: "+price +" Rent: "+rent;
        }else{
            return name +" have no owner "+"  Price: "+price +" Rent: "+rent;
        }
    }

    @Override
    public void renew() {
        owner = new Player(BANK_ID,"Bank",true);
    }
}
