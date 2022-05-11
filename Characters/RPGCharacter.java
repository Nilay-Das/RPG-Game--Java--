package Characters;

import Attacks.Attack;

import java.awt.*;
import java.util.ArrayList;

/***
 * Base RPG character class for all other subclasses. It creates the foundation for all specialized characters such as
 * Mage, Priest, Warrior.
 *
 * @author Nilay Das
 */

public abstract class RPGCharacter implements Comparable<RPGCharacter> {

    //Initializing the instance variables.
    private String name;
    private int maxHP;
    private Point position;
    protected int currentHP;
    protected int intellect;
    protected int strength;
    protected ArrayList<Attack> attackList = new ArrayList<>();

    /**
     * Creates a new RPG character object given a name, intellect, strength, maxHp and position.
     *
     * @param name      is the name of the RPG character.
     * @param intellect is the intellect of the RPG character.
     * @param strength  is the strength of the RPG character.
     * @param maxHP     is the maximum HP of the RPG character.
     * @param position  determines the position the RPG character is at.
     */
    public RPGCharacter(String name, int intellect, int strength, int maxHP, Point position) {
        this.name = name;
        this.intellect = intellect;
        this.strength = strength;
        this.maxHP = maxHP;
        this.position = position;
        this.currentHP = maxHP;
    }

    /**
     * Overloaded constructor for the RPG class.
     * Creates a new RPG character object given a name, intellect, maxHp and position.
     *
     * @param name      is the name of the RPG character.
     * @param intellect is the intellect of the RPG character.
     * @param maxHP     is the maximum HP of the RPG character.
     * @param position  determines the position the RPG character is at.
     */
    public RPGCharacter(String name, int intellect, int maxHP, Point position) {
        this.name = name;
        this.intellect = intellect;
        this.maxHP = maxHP;
        this.position = position;
        this.currentHP = maxHP;
    }

    //Getter for getting currentHP.
    public int getCurrentHP() {
        return currentHP;
    }

    //Getter for getting position.
    public Point getPosition() {
        return position;
    }

    //Getter for getting maxHP.
    public int getMaxHP() {
        return maxHP;
    }

    //Getter for getting name.
    public String getName() {
        return name;
    }

    /**
     * This method moves the RPG character.
     *
     * @param x is the co-ordinate along the x-axis.
     * @param y is the co-ordinate along the y-axis.
     */
    public void move(int x, int y) {
        position.translate(x, y);
    }

    /**
     * This method inflicts damage on a target RPG character.
     *
     * @param damageCount is the amount of damage to be inflicted on the target.
     * @return true if the currentHP is greater than zero and false otherwise.
     */
    public boolean takeDamage(int damageCount) {

        currentHP = currentHP - damageCount;

        if (currentHP <= 0) {
            currentHP = 0;
            return false;
        } else {
            return true;
        }
    }

    /**
     * This method heals a target character by increasing the HP.
     *
     * @param healCount is amount of healing to be done on the target.
     * @return false if the currentHP is greater than the maxHP and true otherwise.
     */
    public boolean heal(int healCount) {
        if (currentHP > maxHP) {
            return false;
        } else if (currentHP < maxHP) {
            if ((currentHP + healCount) > maxHP) {
                return false;
            } else {
                currentHP = currentHP + healCount;
                return true;
            }
        } else return true;
    }

    /**
     * Method for attacking a target RPG character.
     *
     * @param character   is the target RPG character.
     * @param attackIndex represents the type of attack to be selected from the ArrayList.
     * @return negative integers if the attack was not successful and the target's currentHP if the attack was successful.
     */
    public abstract int attack(RPGCharacter character, int attackIndex);

    /**
     * This method compares two RPG characters.
     *
     * @param character is the character that is to be compared with the current RPG character.
     * @return 0 if the two characters' currentHP are equal, -1 if the currentHP of current character is greater than
     * the character compared with and 1 if the currentHP of current character is less than the character compared with.
     */
    public int compareTo(RPGCharacter character) {
        if (this.getCurrentHP() > character.getCurrentHP()) {
            return -1;
        } else if (this.getCurrentHP() < character.getCurrentHP()) {
            return 1;
        } else {
            return 0;
        }

    }

    /**
     * This method retrieves the attacks stored in the ArrayList according to its type.
     *
     * @return a string containing the detailed information of a certain type of attack.
     */
    public String getAttacks() {
        String result = "";

        if (attackList == null) {
            return result;
        }

        for (int i = 0; i < attackList.size(); i++) {

            if (attackList.get(i).getClass().getSuperclass().getSimpleName().equals("Attack")) {
                result += i + " - " + this.attackList.get(i).getClass().getSuperclass().getSimpleName() + " - "
                        + attackList.get(i).getName() + " (" + attackList.get(i).getCost() + ") " + " - " + "Damage: "
                        + attackList.get(i).getDamage() + "\n";
            } else if (attackList.get(i).getClass().getSimpleName().equals("Resurrection")) {
                result += i + " - " + this.attackList.get(i).getClass().getSimpleName() + " - "
                        + attackList.get(i).getName() + " (" + attackList.get(i).getCost() + ")" + "\n";

            } else if (attackList.get(i).getClass().getSimpleName().equals("HealingSpell")) {
                result += i + " - " + this.attackList.get(i).getClass().getSimpleName() + " - "
                        + attackList.get(i).getName() + " (" + attackList.get(i).getCost() + ") " + " - " + "Heal: "
                        + attackList.get(i).getDamage() + "\n";
            } else {
                result += i + " - " + this.attackList.get(i).getClass().getSimpleName() + " - "
                        + attackList.get(i).getName() + " (" + attackList.get(i).getCost() + ") " + " - " + "Damage: "
                        + attackList.get(i).getDamage() + "\n";
            }

        }


        return result;
    }

    //The toString method to print the object to the console.
    public String toString() {
        return getName() + " " + "(" + this.getClass().getSimpleName() + ")" + " - " + getCurrentHP() + "/" + getMaxHP();
    }

}


