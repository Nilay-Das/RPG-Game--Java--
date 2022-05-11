package Characters;

import Attacks.*;
import Attacks.Attack;

import java.awt.*;
import java.util.ArrayList;

/**
 * This is the Mage class which is the subclass of the Caster class.
 *
 * @author Nilay Das
 */
public class Mage extends Caster {

    /**
     * Creates a new Mage character object given a name, intellect, maxHp and position.
     *
     * @param name      is the name of the Mage character.
     * @param intellect is the intellect of the Mage character.
     * @param maxHP     is the maximum HP of the Mage character.
     * @param position  determines the position the Mage character is at.
     * @param maxMana   is the maximum amount of mana the Mage character can have.
     */
    public Mage(String name, int intellect, int maxHP, Point position, int maxMana) {
        super(name, intellect, maxHP, position, maxMana);

        //Creating Mage attack objects.
        MeleeAttack damage1 = new MeleeAttack(0, "Staff", 3, 3);
        DamageSpell damage2 = new DamageSpell(20, "Fire Ball", 10, 20);
        DamageSpell damage3 = new DamageSpell(15, "Frost Ball", 7, 15);
        DamageSpell damage4 = new DamageSpell(30, "Lightning", 15, 20);

        //Storing Mage attacks into the ArrayList.
        this.attackList.add(damage1);
        this.attackList.add(damage2);
        this.attackList.add(damage3);
        this.attackList.add(damage4);
    }
}



















