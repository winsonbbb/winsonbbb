package hk.edu.polyu.comp.comp2021.monopoly;


/**
 *
 */
public abstract class Position {
    /**
     *
     */
    protected boolean isProperty;
    /**
     *
     */
    protected Player owner;
    /**
     *
     */
    protected String name;

    /**
     *
     */
    Position(){
        isProperty=false;
    }

    /**
     * @param name square name
     */
    Position(String name){
        this.name = name;
        isProperty = false;
    }

    /**
     * @param name sqare name
     * @param isProperty isProperty
     */
    Position(String name,boolean isProperty){
        this.name = name;
        this.isProperty = isProperty;
    }

    /**
     * @return owner
     */
    public Player getOwner(){
        return owner;
    }

    /**
     * @param owner Set owner
     */
    public void setOwner(Player owner){
        this.owner = owner;
    }

    /**
     * @return isProperty
     */
    public boolean getIsProperty(){
        return isProperty;
    }

    /**
     * @return square name
     */
    public String getName(){
        return name;
    }

    /**
     * @param player player arrived
     */
    public abstract void arrived(Player player);

    /**
     * @return square string
     */
    public abstract String toString();

    /**
     *
     */
    public void renew(){}
}