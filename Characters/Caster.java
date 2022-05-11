package Characters;

import Attacks.Attack;
import Attacks.HealingSpell;
import Attacks.Spell;

import java.awt.*;

/**
 * Base character class for all other subclasses of the Caster class.
 * It creates the foundation for all specialized characters such as Mage and Priest.
 *
 * @author Nilay Das
 */
public abstract class Caster extends RPGCharacter {

    //Initializing the instance variables.
    private int maxMana;
    private int currentMana;

    /**
     * Creates a new Caster character object given a name, intellect, maxHp and position.
     *
     * @param name      is the name of the Caster character.
     * @param intellect is the intellect of the Caster character.
     * @param maxHP     is the maximum HP of the Caster character.
     * @param position  determines the position the Caster character is at.
     * @param maxMana   is the maximum amount of mana the Caster character can have.
     */
    public Caster(String name, int intellect, int maxHP, Point position, int maxMana) {
        super(name, intellect, maxHP, position);
        this.maxMana = maxMana;
        this.currentMana = maxMana;
        strength = 1;
        this.intellect = intellect;
    }

    //Getter for getting maxMana.
    public int getMaxMana() {
        return this.maxMana;
    }

    //Getter for getting currentMana.
    public int getCurrentMana() {
        return this.currentMana;
    }

    /**
     * Implementing the attack method for the Caster class.
     *
     * @param character   is the target RPG character.
     * @param attackIndex represents the type of attack to be selected from the ArrayList.
     * @return negative integers if the attack was not successful and the target's currentHP if the attack was successful.
     */
    @Override
    public int attack(RPGCharacter character, int attackIndex) {

        //Checks if the ArrayList is null.
        if (this.attackList == null) {
            return -1;
        }

        // Checks if attackIndex is not in the range of the ArrayList.
        if (attackIndex > this.attackList.size()) {
            return -1;
        }

        //Referencing the attack found on the ArrayList according to the attackIndex.
        Attack attack = this.attackList.get(attackIndex);

        //Checks if target is out of range
        double xCharacter = character.getPosition().getX();
        double yCharacter = character.getPosition().getY();
        double xCaster = this.getPosition().getX();
        double yCaster = this.getPosition().getY();

        double distance = Math.sqrt((xCharacter - xCaster) * (xCharacter - xCaster)
                + (yCharacter - yCaster) * (yCharacter - yCaster));

        if (distance > attack.getRange()) {
            return -2;
        }

        //Checks if there is enough mana to carry out the attack.
        if (this.currentMana < attack.getCost()) {
            return -3;
        }

        //Attacks inflicted based on the type of attack selected.
        if (attack instanceof HealingSpell) {
            attack.interactWithTarget(this, this.intellect);
        } else if (attack instanceof Spell) {
            attack.interactWithTarget(character, intellect);
            this.currentMana = this.currentMana - attack.getCost();
        } else {
            attack.interactWithTarget(character, 0);
        }
        return character.getCurrentHP();
    }

    //The toString method to print the object to the console.
    public String toString() {
        return super.toString() + "Mana: " + currentMana + "/" + maxMana + "\n";
    }
}


