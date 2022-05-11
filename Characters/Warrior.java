package Characters;

import Attacks.Attack;
import Attacks.MeleeAttack;

import java.awt.*;

/**
 * This is the Warrior class which is the subclass of the Melee class.
 *
 * @author Nilay Das
 */
public class Warrior extends Melee {

    /**
     * Creates a new Warrior character object given a name, strength, maxHp, position and maxEnergy.
     *
     * @param name      is the name of the Warrior character.
     * @param strength  is the strength of the Warrior character.
     * @param maxHp     is the maximum HP of the Warrior character.
     * @param position  determines the position the Warrior character is at.
     * @param maxEnergy is the maximum amount of energy the Warrior character can have.
     */
    public Warrior(String name, int strength, int maxHp, Point position, int maxEnergy) {
        super(name, strength, maxHp, position, maxEnergy);

        //Creating Warrior attack objects.
        MeleeAttack attack1 = new MeleeAttack(0, "Punch", 5, 3);
        MeleeAttack attack2 = new MeleeAttack(3, "Slam", 5, 3);
        MeleeAttack attack3 = new MeleeAttack(20, "Charge", 30, 15);

        //Storing Warrior attacks into the ArrayList.
        this.attackList.add(attack1);
        this.attackList.add(attack2);
        this.attackList.add(attack3);
    }
}




