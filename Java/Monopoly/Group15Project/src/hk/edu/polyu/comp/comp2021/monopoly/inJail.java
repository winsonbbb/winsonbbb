package hk.edu.polyu.comp.comp2021.monopoly;

import java.util.Scanner;
import java.util.Random;

/**
 *
 */
public class inJail extends Position {
    private final static int JailFee = 50;
    /**
     *
     */
    inJail(){
        super("In Jail");
    }
    @Override
    public String toString(){
        return name;
    }

    /**
     * @param toPosition position to go
     * @param player player
     */
    public static void release(int toPosition, Player player) {
        player.setInjall(false);
        player.setPosition(player.getPosition() + toPosition);
        player.reIniJailCount();
    }

    @Override
    public void arrived(Player player) {

        Scanner sc = new Scanner(System.in);
        int option;

        Die die1 = new Die();
        Die die2 = new Die();

        Random r = new Random();

        int rDie1, rDie2, result;


        if(player.getInJall() && player.getJailCount() < 3) {
            if (!player.getIsComp()||player.getWasHuman()) {
                System.out.println("Your term of imprisonment is hasn't expired yet");
                System.out.println("You have two options");
                System.out.println("1. Throwing die. If an even number comes up, you can leave the jail immediately, otherwise cannot leave yet");
                System.out.println("2. Paying $50 to bribe/fine and get out of the jail immediately");
                System.out.println("Your option: ");
                try{
                do {
                    option = sc.nextInt();

                    if (option == 1) {

                        rDie1 = die1.roll();
                        System.out.println("The first die is: " + rDie1);
                        rDie2 = die2.roll();
                        System.out.println("The second die is: " + rDie2);

                        if(rDie1== rDie2) {
                            System.out.println("Congratulation! You are released");
                            result = rDie1 + rDie2;
                            System.out.println("Total step: " + result);
                            release(result ,player);
                            break;
                        }
                        else {
                            System.out.println("Oops Sorry you cannot leave yet");
                            player.plusJailCount();
                            break;
                        }
                    }

                    else if (option == 2) {
                        System.out.println("Thank you for paying $50, you can leave now");
                        player.pay(JailFee);
                        System.out.println("Remain: "+player.getAmount());

                        //roll die immediately
                        rDie1 = die1.roll();
                        System.out.println("The first die is: " + rDie1);

                        rDie2 = die2.roll();
                        System.out.println("The second die is: " + rDie2);

                        result = rDie1 + rDie2;
                        System.out.println("Total step: " + result);
                        release(result, player);
                        break;
                    }

                    else {
                        System.out.println("Please choose between option 1 or 2");
                    }

                } while(option != 1 || option != 2);
                } catch (Exception e) {
                    System.out.println("You must input a number 1 or 2)");
                    sc.next();
                }
            }

            // isComp
            else {
                int choice;
                choice = r.nextInt(2)+1;

                if (choice == 1) {
                    // roll dice
                    int dieRoll1 = die1.roll();
                    System.out.println("Die1 roll : " + dieRoll1 );
                    int dieRoll2 = die2.roll();
                    System.out.println("Die2 roll : " + dieRoll2 );
                    result = die1.roll() + die2.roll();
                    if (dieRoll1 == dieRoll2) {
                        System.out.println(player.getName() + " leaves the jail");
                        release(result, player);
                    }
                    else {
                        System.out.println(player.getName() + " fail to leave the jail");
                        player.plusJailCount();
                    }
                }

                else {
                    // pay $50
                    System.out.println(player.getName() + " pays $50 and leaves the jail");
                    player.pay(JailFee);
                    System.out.println("Remain: "+player.getAmount());

                    result = die1.roll() + die2.roll();
                    release(result, player);
                }
            }

        }

        else if (player.getInJall() && player.getJailCount() == 3) {
            if (!player.getIsComp()) {
                System.out.println("Your term of imprisonment has expired, you have to pay $50 dollar to leave");
                player.pay(JailFee);
                System.out.println("Remain: "+player.getAmount());
                System.out.println("Roll die to decide your first destination after getting out from jail");


                rDie1 = die1.roll();
                System.out.println("The first die is: " + rDie1);

                rDie2 = die2.roll();
                System.out.println("The second die is: " + rDie2);

                result = rDie1 + rDie2;
                System.out.println("Total: " + result);

                release(result, player);
            }

            else {
                System.out.println(player.getName() + " " + "term of imprisonment has expired");
                player.pay(JailFee);
                System.out.println("Remain: "+player.getAmount());
                result = die1.roll() + die2.roll();

                release(result, player);

            }
        }


        else {
            if(!player.getIsComp()){
                System.out.println("You have arrive 'Jail' and visiting the criminals there");
            }
            else{
                System.out.println(player.getName()+" are visiting the criminals");
            }

        }
    }
}

