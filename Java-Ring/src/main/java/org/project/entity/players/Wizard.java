package main.java.org.project.entity.players;

import org.project.entity.Entity;
import org.project.object.weapons.Weapon;
import org.project.object.armors.Armor;

public class Wizard extends Player {
    public Wizard(String name, int hp, int mp, Weapon weapon, Armor armor) {
        super(name, hp, mp, weapon, armor);
    }

    public void castSpell(Entity target) {
        if (mp >= 10) {
            mp -= 10;
            int damage = 15;
            int healAmount = 10;
            target.takeDamage(damage);
            this.heal(healAmount);
            System.out.println(name + " cast a spell, healing themselves for " + healAmount + " and dealing " + damage + " damage to " + target.getClass().getSimpleName() + "!");
        } else {
            System.out.println(name + " does not have enough mana to cast a spell!");
        }
    }
}