package Characters;

import Attacks.Attack;
import Attacks.MeleeAttack;

import java.awt.*;

/**
 * Base character class for all other subclasses of the Melee class.
 * It creates the foundation for all specialized characters such as Warrior.
 *
 * @author Nilay Das
 */
public abstract class Melee extends RPGCharacter {

    //Initializing the instance variables.
    private int maxEnergy;
    private int currentEnergy;

    /**
     * Creates a new Melee character object given a name, strength, maxHp, position and maxEnergy.
     *
     * @param name      is the name of the Melee character.
     * @param strength  is the strength of the Melee character.
     * @param maxHp     is the maximum HP of the Melee character.
     * @param position  determines the position the Melee character is at.
     * @param maxEnergy is the maximum amount of energy the Melee character can have.
     */
    public Melee(String name, int strength, int maxHp, Point position, int maxEnergy) {
        super(name, strength, maxHp, position);
        currentEnergy = maxEnergy;
        this.intellect = 1;
        this.strength = strength;
    }

    //Getter for getting currentEnergy.
    public int getCurrentEnergy() {
        return this.currentEnergy;
    }

    //Getter for getting maxEnergy.
    public int getMaxEnergy() {
        return this.maxEnergy;
    }

    /**
     * Implementing the attack method for the Melee class.
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
        if (attackIndex > attackList.size()) {
            return -1;
        }

        //Referencing the attack found on the ArrayList according to the attackIndex.
        Attack attack = this.attackList.get(attackIndex);

        //Checks if target is out of range
        double xCharacter = character.getPosition().getX();
        double yCharacter = character.getPosition().getY();
        double xCaster = this.getPosition().getX();
        double yCaster = this.getPosition().getY();

        double distance = Math.sqrt((xCharacter - xCaster) * (xCharacter - xCaster) + (yCharacter - yCaster) * (yCharacter - yCaster));

        if (distance > attack.getRange()) {
            return -2;
        }

        //Checks if there is enough energy to carry out the attack.
        if (this.currentEnergy < attack.getCost()) {
            return -3;
        }

        //Deducting energy from the character to inflict the damage.
        this.currentEnergy = currentEnergy - attack.getCost();

        //Inflicting damage on the target.
        if (attack instanceof MeleeAttack) {
            attack.interactWithTarget(character, this.strength);
        }
        return character.getCurrentHP();
    }

    //The toString method to print the object to the console.
    public String toString() {
        return super.toString() + "Energy " + currentEnergy + "/" + maxEnergy + "\n";
    }
}
