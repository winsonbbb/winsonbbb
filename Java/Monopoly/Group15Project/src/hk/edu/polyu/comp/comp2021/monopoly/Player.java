package hk.edu.polyu.comp.comp2021.monopoly;


/**
 *
 */
public class Player {
    private int id;
    private String name;
    private int position;
    private int amount;
    private boolean isComp;
    private boolean wasHuman;
    private boolean bankrupt;
    private boolean inJail= false;
    private int jailCount;
    private final static int StartAmount = 1500;

    /**
     * @param id playerID
     * @param name playerName
     * @param isComp player is com?
     */
    Player(int id,String name,boolean isComp){
        this.id = id;
        this.name = name;
        position =0;
        amount=StartAmount;
        this.isComp = isComp;
        wasHuman = false;
        bankrupt = false;
        jailCount = 0;
    }

    /**
     * @param price rent
     */
    public void pay(int price){
        amount = amount - price;
    }

    /**
     * @param price rent
     */
    public void earn(int price){
        amount = amount + price;
    }

    /**
     * @return player id
     */
    public int getId(){
        return id;
    }

    /**
     * @return player name
     */
    public String getName(){
        return name;
    }

    /**
     * @return player amount
     */
    public int getAmount(){
        return amount;
    }

    /**
     * @return player position
     */
    public int getPosition(){
        return position;
    }

    /**
     * @param position set position
     */
    public void setPosition(int position){this.position = position;}

    /**
     *
     */
    public void positionSetToJail() {
        position = 5;
    }

    /**
     * @return is com?
     */
    public boolean getIsComp(){
        return isComp;
    }

    /**
     *  set player to com
     */
    public void setIsComp(){isComp = true;}

    /**
     * @return bankrupt?
     */
    public boolean getBankrupt(){
        return bankrupt;
    }

    /**
     * @return injail?
     */
    public boolean getInJall(){
        return inJail;
    }

    /**
     * @param wasHuman set wasHuman
     */
    public void setWasHuman(boolean wasHuman){
        this.wasHuman = wasHuman;
    }

    /**
     * @return wasHuman
     */
    public boolean getWasHuman(){
        return wasHuman;
    }

    /**
     * @param inJail set injail
     */
    public void setInjall(boolean inJail){
        this.inJail = inJail;
    }

    /**
     * set bankrupt
     */
    public void retire(){
        bankrupt = true;
    }

    /**
     * @return get the count of jail roll
     */
    public int getJailCount() { return jailCount;}

    /**
     *  add jail ocunt
     */
    public void plusJailCount()  {this.jailCount++; }

    /**
     * reset jail count
     */
    public void reIniJailCount() {this.jailCount = 0;}

    /**
     * @return toString
     */
    @Override
    public String toString(){
        return name + " ";
    }

}
