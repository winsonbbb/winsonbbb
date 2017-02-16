package hk.edu.polyu.comp.comp2021.monopoly;

import java.util.Random;


/**
 *
 */
public class Die {
    private Random r;

    /**
     *
     */
    Die(){
        r = new Random();
    }

    /**
     * @return 1-4
     */
    public int roll(){
        return r.nextInt(4 - 1 +1)+1;
    }

}
