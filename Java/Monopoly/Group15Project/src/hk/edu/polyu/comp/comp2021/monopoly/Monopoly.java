package hk.edu.polyu.comp.comp2021.monopoly;

import java.util.Scanner;


/**
 *  Monopoly class
 */
public class Monopoly {
    /**
     * Main Function
     * @param arg java string
     */
    public static void main(String[] arg) {
        final int squareNum = 20;
        Position[] pos = new Position[squareNum];
        int posCount =0;
        int priceRentCount = 0;
        final int[][] priceRent = { {800,90},{700,65} ,{600,60},{400,10},{500,40},{400,15},
                {700,75},{400,20},{500,25},{400,10},{400,25},{600,25}};

        pos[posCount++] = new Go();
        pos[posCount++] = new Property("Central", priceRent[priceRentCount][0], priceRent[priceRentCount++][1]);
        pos[posCount++] = new Property("Wan Chai", priceRent[priceRentCount][0], priceRent[priceRentCount++][1]);
        pos[posCount++] = new Tax();
        pos[posCount++] = new Property("Stanley", priceRent[priceRentCount][0], priceRent[priceRentCount++][1]);
        pos[posCount++] = new inJail();
        pos[posCount++] = new Property("Shek O", priceRent[priceRentCount][0], priceRent[priceRentCount++][1]);
        pos[posCount++] = new Property("Mong Kok", priceRent[priceRentCount][0], priceRent[priceRentCount++][1]);
        pos[posCount++] = new Chance();
        pos[posCount++] = new Property("Tsing Yi", priceRent[priceRentCount][0], priceRent[priceRentCount++][1]);
        pos[posCount++] = new FreePark();
        pos[posCount++] = new Property("Shatin", priceRent[priceRentCount][0], priceRent[priceRentCount++][1]);
        pos[posCount++] = new Chance();
        pos[posCount++] = new Property("Tuen Mun", priceRent[priceRentCount][0], priceRent[priceRentCount++][1]);
        pos[posCount++] = new Property("Tai Po", priceRent[priceRentCount][0], priceRent[priceRentCount++][1]);
        pos[posCount++] = new GoToJail();
        pos[posCount++] = new Property("Sai Kung", priceRent[priceRentCount][0], priceRent[priceRentCount++][1]);
        pos[posCount++] = new Property("Yuen Long", priceRent[priceRentCount][0], priceRent[priceRentCount++][1]);
        pos[posCount++] = new Chance();
        pos[posCount++] = new Property("Tai O", priceRent[priceRentCount][0], priceRent[priceRentCount++][1]);

        System.out.println("=========Welcome to Monopoly=========");
        System.out.println("=========Let have some setup=========");
        Player[] players;
        int playernum ;
        Scanner sc = new Scanner(System.in);
        while (true){
            try {
                System.out.print("How many players do you want? (2-6) : ");
                playernum = sc.nextInt();
                if(playernum>6||playernum<2){
                    throw new Exception();
                }
                break;
            }catch(Exception e){
                System.out.println("You must input a number within 2-6!");
                sc.next();
                continue;
            }
        }
        int human;
        while (true){
            try {
                System.out.print("How many players is user? (0-"+playernum+") : ");
                human = sc.nextInt();
                if(human>playernum||human<0){
                    throw new Exception();
                }
                break;
            }catch(Exception e){
                System.out.println("You must input a number within (0-"+playernum+")");
                sc.next();
                continue;
            }
        }




        players = new Player[playernum];
        for(int i =0;i<human;i++){
            System.out.print("please input the name of "+(i+1)+"'s human player: ");
            String name= sc.next();
            players[i] = new Player(i,name,false);
        }
        int compcount = 1;
        for(int j=human;j<playernum;j++){
            players[j] = new Player(j,"Com"+compcount,true);
            System.out.println("Player Com"+compcount+" is created.");
            compcount+=1;
        }


        System.out.println("============================");
        System.out.println("=========Start Game=========");
        System.out.println("============================");
        Die dieDraw = new Die() ;
        int die1 =0;
        int die2 =0;
        while(true) {
            for(int i = 0;i<playernum;i++) {
                if (players[i].getBankrupt() == true) {
                    System.out.println(players[i].getName() + " is Bankrupted. ");
                    continue;
                }
                System.out.println("===========Now is " + players[i].getName() + "'s Turn===========");

                int option;
                while (true) {
                    try {
                        System.out.println("==================================");
                        System.out.println("Player " + players[i].getName() + ": You can select the option to do:");
                        System.out.println("0 : Draw dice");
                        System.out.println("1 : Print current information");
                        System.out.println("2 : Let computer take over");
                        System.out.println("3 : Surrender");
                        System.out.print("Your option : ");
                        if (players[i].getIsComp()) {
                            System.out.println("0");
                            option = 0;
                        } else {
                            option = sc.nextInt();
                        }
                        if (option < 0 || option > 3) {
                            throw new Exception();
                        }
                        if (option == 0) {
                            if (players[i].getInJall()) {
                                pos[5].arrived(players[i]);
                                if(players[i].getInJall()==false){
                                    pos[players[i].getPosition()].arrived(players[i]);
                                }
                                System.out.println("==============End of Turn==============");
                                break;
                            }

                            die1 = dieDraw.roll();
                            die2 = dieDraw.roll();
                            System.out.println("The first die roll  :" + die1);
                            System.out.println("The second die roll :" + die2);
                            int step = die1 + die2;
                            System.out.println("The You now go " + step + " step.");
                            int newPos = players[i].getPosition() + step;
                            if (newPos > squareNum-1) {
                                pos[0].arrived(players[i]);
                                newPos = newPos - (squareNum-1)-1;
                            }

                            players[i].setPosition(newPos);
                            pos[players[i].getPosition()].arrived(players[i]);
                            System.out.println("==============End of Turn==============");

                            break;
                        } else if (option == 1) {
                            for (int n = 0; n < pos.length; n++) {
                                System.out.println("Squares "+ n +" : "+pos[n].toString());
                            }
                            for (int n = 0; n < playernum; n++) {
                                System.out.println(players[n].toString() + " is on "
                                        + (players[n].getPosition() + 1) + "-----" + pos[players[n].getPosition()].getName());
                            }
                        } else if (option == 2) {
                            while (true) {
                                System.out.print("Are You sure to let computer take over?(Y/N) : ");
                                String ans = sc.next();
                                if (ans.equals("Y")) {
                                    System.out.println("Okay. Computer will take over.");
                                    players[i].setIsComp();
                                    players[i].setWasHuman(true);
                                    break;
                                } else if (ans.equals("N")) {
                                    break;
                                }
                            }
                        } else {
                            boolean retire = false;
                            while (true) {
                                System.out.print("Are You sure to leave game? (Y/N) : ");
                                String ans = sc.next();
                                if (ans.equals("Y")) {
                                    System.out.println("Bye Bye " + players[i].getName());
                                    players[i].retire();
                                    retire = true;
                                    break;
                                } else if (ans.equals("N")) {
                                    break;
                                }
                            }
                            if (retire) {
                                break;
                            }

                        }


                    } catch (Exception e) {
                        System.out.println("You must input a number within (0-3)");
                        sc.next();
                        continue;
                    }
                }

                if (players[i].getBankrupt() == true) {
                    for (int j = 0; j < pos.length; j++) {
                        if (pos[j].getIsProperty()) {
                            if (pos[j].getOwner().getId() == players[i].getId())
                                pos[j].renew();
                        }
                    }
                }
            }
            int checkWinner=0;
            int winner = 0;
            for(int k=0;k<playernum;k++){
                if(players[k].getBankrupt()){
                    checkWinner +=1;
                }else{
                    winner=k;
                }
            }
            if(checkWinner==(playernum-1)){
                System.out.println("Winner is "+ players[winner]+"!!!!!");
                break;
            }
        }
    }
}
