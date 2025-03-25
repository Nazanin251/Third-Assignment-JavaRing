package main.java.org.project.entity.players;

import org.project.entity.Entity;
import org.project.object.weapons.Weapon; // Import Weapon
import org.project.object.armors.Armor;   // Import Armor

public class Assassin extends Player {
    private boolean isInvisible = false;

    public Assassin(String name, int hp, int mp, Weapon weapon, Armor armor) {
        super(name, hp, mp, weapon, armor);
    }

    public void becomeInvisible() {
        isInvisible = true;
        System.out.println(name + " has become invisible!");
    }

    @Override
    public void attack(Entity target) {
        int damage = weapon.getDamage();
        if (isInvisible) {
            damage *= 2; // Double damage while invisible
            isInvisible = false;
        }
        System.out.println(name + " (" + this.getClass().getSimpleName() + ") attacked " + target.getClass().getSimpleName() + "!");
        target.takeDamage(damage);
    }
}