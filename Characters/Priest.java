package Characters;

import Attacks.*;

import java.awt.*;

/**
 * This is the Priest class which is the subclass of the Caster class.
 *
 * @author Nilay Das
 */
public class Priest extends Caster {

    /**
     * Creates a new Priest character object given a name, intellect, maxHp and position.
     *
     * @param name      is the name of the Priest character.
     * @param intellect is the intellect of the Priest character.
     * @param maxHP     is the maximum HP of the Priest character.
     * @param position  determines the position the Priest character is at.
     * @param maxMana   is the maximum amount of mana the Priest character can have.
     */
    public Priest(String name, int intellect, int maxHP, Point position, int maxMana) {
        super(name, intellect, maxHP, position, maxMana);

        //Creating Priest attack objects.
        MeleeAttack attack = new MeleeAttack(0, "Wand", 3, 3);
        DamageSpell damageSpell = new DamageSpell(10, "Smite", 10, 7);
        HealingSpell healingSpell = new HealingSpell(20, "Flash Heal", 15, 15);
        Resurrection resurrection = new Resurrection();

        //Storing Mage attacks into the ArrayList.
        this.attackList.add(attack);
        this.attackList.add(damageSpell);
        this.attackList.add(healingSpell);
        this.attackList.add(resurrection);
    }
}


